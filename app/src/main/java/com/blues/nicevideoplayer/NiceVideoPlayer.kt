package com.blues.nicevideoplayer

import com.blues.nicevideoplayer.LogUtil.d
import com.blues.nicevideoplayer.LogUtil.e
import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.view.TextureView.SurfaceTextureListener
import android.media.AudioManager
import tv.danmaku.ijk.media.player.IMediaPlayer
import android.graphics.SurfaceTexture
import android.view.Surface
import android.view.ViewGroup
import tv.danmaku.ijk.media.player.IjkMediaPlayer
import tv.danmaku.ijk.media.player.AndroidMediaPlayer
import android.view.Gravity
import android.net.Uri
import java.io.IOException
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.view.View
import com.blues.R
import com.blues.framework.utils.dp

/**
 * Created by XiaoJianjun on 2017/4/28.
 * 播放器
 */
class NiceVideoPlayer @JvmOverloads constructor(private val mContext: Context,
    attrs: AttributeSet? = null) : FrameLayout(mContext, attrs), INiceVideoPlayer,
    SurfaceTextureListener {

    private var mPlayerType = TYPE_IJK
    private var mCurrentState = STATE_IDLE
    private var mCurrentMode = MODE_NORMAL

    private lateinit var mAudioManager: AudioManager
    private lateinit var mMediaPlayer: IMediaPlayer
    private lateinit var mContainer: FrameLayout

    private var mTextureView: NiceTextureView? = null
    private var mController: NiceVideoPlayerController? = null
    private var mSurfaceTexture: SurfaceTexture? = null
    private var mSurface: Surface? = null
    private var mUrl: String? = null
    private var mHeaders: Map<String?, String?>? = null

    override var bufferPercentage = 0
        private set
    private var continueFromLastPosition = true
    private var skipToPosition: Long = 0

    private fun init() {
        mContainer = FrameLayout(mContext)
        mContainer.setBackgroundColor(Color.BLACK)
        val params = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        this.addView(mContainer, params)
    }

    override fun setUp(url: String?, headers: Map<String?, String?>?) {
        mUrl = url
        mHeaders = headers
    }

    fun setController(controller: NiceVideoPlayerController) {
        mContainer.removeView(mController)
        mController = controller.apply {
            reset()
            setNiceVideoPlayer(this@NiceVideoPlayer)
        }

        val params = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        mContainer.addView(mController, params)
    }

    /**
     * 设置播放器类型
     *
     * @param playerType IjkPlayer or MediaPlayer.
     */
    fun setPlayerType(playerType: Int) {
        mPlayerType = playerType
    }

    /**
     * 是否从上一次的位置继续播放
     *
     * @param continueFromLastPosition true从上一次的位置继续播放
     */
    override fun continueFromLastPosition(continueFromLastPosition: Boolean) {
        this.continueFromLastPosition = continueFromLastPosition
    }

    override fun setSpeed(speed: Float) {
        if (mMediaPlayer is IjkMediaPlayer) {
            (mMediaPlayer as IjkMediaPlayer).setSpeed(speed)
        } else {
            d("只有IjkPlayer才能设置播放速度")
        }
    }

    override fun start() {
        if (mCurrentState == STATE_IDLE) {
            NiceVideoPlayerManager.instance.setCurrentNiceVideoPlayer(this)
            initAudioManager()
            initMediaPlayer()
            initTextureView()
            addTextureView()
        } else {
            d("NiceVideoPlayer只有在mCurrentState == STATE_IDLE时才能调用start方法.")
        }
    }

    override fun start(position: Long) {
        skipToPosition = position
        start()
    }

    override fun restart() {
        if (mCurrentState == STATE_PAUSED) {
            mMediaPlayer.start()
            mCurrentState = STATE_PLAYING
            mController?.onPlayStateChanged(mCurrentState)
            d("STATE_PLAYING")
        } else if (mCurrentState == STATE_BUFFERING_PAUSED) {
            mMediaPlayer.start()
            mCurrentState = STATE_BUFFERING_PLAYING
            mController?.onPlayStateChanged(mCurrentState)
            d("STATE_BUFFERING_PLAYING")
        } else if (mCurrentState == STATE_COMPLETED || mCurrentState == STATE_ERROR) {
            mMediaPlayer.reset()
            openMediaPlayer()
        } else {
            d("NiceVideoPlayer在mCurrentState == " + mCurrentState + "时不能调用restart()方法.")
        }
    }

    override fun pause() {
        if (mCurrentState == STATE_PLAYING) {
            mMediaPlayer.pause()
            mCurrentState = STATE_PAUSED
            mController?.onPlayStateChanged(mCurrentState)
            d("STATE_PAUSED")
        }
        if (mCurrentState == STATE_BUFFERING_PLAYING) {
            mMediaPlayer.pause()
            mCurrentState = STATE_BUFFERING_PAUSED
            mController?.onPlayStateChanged(mCurrentState)
            d("STATE_BUFFERING_PAUSED")
        }
    }

    override fun seekTo(pos: Long) {
        mMediaPlayer.seekTo(pos)
    }

    override val isIdle: Boolean
        get() = mCurrentState == STATE_IDLE

    override val isPreparing: Boolean
        get() = mCurrentState == STATE_PREPARING

    override val isPrepared: Boolean
        get() = mCurrentState == STATE_PREPARED

    override val isBufferingPlaying: Boolean
        get() = mCurrentState == STATE_BUFFERING_PLAYING

    override val isBufferingPaused: Boolean
        get() = mCurrentState == STATE_BUFFERING_PAUSED

    override val isPlaying: Boolean
        get() = mCurrentState == STATE_PLAYING

    override val isPaused: Boolean
        get() = mCurrentState == STATE_PAUSED

    override val isError: Boolean
        get() = mCurrentState == STATE_ERROR

    override val isCompleted: Boolean
        get() = mCurrentState == STATE_COMPLETED

    override val isFullScreen: Boolean
        get() = mCurrentMode == MODE_FULL_SCREEN

    override val isTinyWindow: Boolean
        get() = mCurrentMode == MODE_TINY_WINDOW

    override val isNormal: Boolean
        get() = mCurrentMode == MODE_NORMAL

    override val maxVolume: Int
        get() = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)

    override var volume: Int
        get() = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
        set(volume) {
            mAudioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0)
        }

    override val duration: Long
        get() = mMediaPlayer.duration

    override val currentPosition: Long
        get() = mMediaPlayer.currentPosition

    override fun getSpeed(speed: Float): Float {
        return if (mMediaPlayer is IjkMediaPlayer) {
            (mMediaPlayer as IjkMediaPlayer).getSpeed(speed)
        } else 0f
    }

    override val tcpSpeed: Long
        get() = if (mMediaPlayer is IjkMediaPlayer) {
            (mMediaPlayer as IjkMediaPlayer).tcpSpeed
        } else 0L

    private fun initAudioManager() {
        mAudioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
        mAudioManager.requestAudioFocus(null, AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN)
    }

    private fun initMediaPlayer() {
        mMediaPlayer = when (mPlayerType) {
            TYPE_NATIVE -> AndroidMediaPlayer()
            TYPE_IJK -> IjkMediaPlayer()
            else -> IjkMediaPlayer()
        }
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
    }

    private fun initTextureView() {
        if (mTextureView == null) {
            mTextureView = NiceTextureView(mContext).also {
                it.surfaceTextureListener = this
            }
        }
    }

    private fun addTextureView() {
        mContainer.removeView(mTextureView)
        val params = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, Gravity.CENTER)
        mContainer.addView(mTextureView, 0, params)
    }

    override fun onSurfaceTextureAvailable(surfaceTexture: SurfaceTexture, width: Int,
        height: Int) {
        if (mSurfaceTexture == null) {
            mSurfaceTexture = surfaceTexture
            openMediaPlayer()
        } else {
            mTextureView?.setSurfaceTexture(mSurfaceTexture!!)
        }
    }

    private fun openMediaPlayer() {
        // 屏幕常亮
        mContainer.keepScreenOn = true
        // 设置监听
        mMediaPlayer.setOnPreparedListener(mOnPreparedListener)
        mMediaPlayer.setOnVideoSizeChangedListener(mOnVideoSizeChangedListener)
        mMediaPlayer.setOnCompletionListener(mOnCompletionListener)
        mMediaPlayer.setOnErrorListener(mOnErrorListener)
        mMediaPlayer.setOnInfoListener(mOnInfoListener)
        mMediaPlayer.setOnBufferingUpdateListener(mOnBufferingUpdateListener)
        // 设置dataSource
        try {
            mMediaPlayer.setDataSource(mContext.applicationContext, Uri.parse(mUrl), mHeaders)
            if (mSurface == null) {
                mSurface = Surface(mSurfaceTexture)
            }
            mMediaPlayer.setSurface(mSurface)
            mMediaPlayer.prepareAsync()
            mCurrentState = STATE_PREPARING
            mController?.onPlayStateChanged(mCurrentState)
            d("STATE_PREPARING")
        } catch (e: IOException) {
            e.printStackTrace()
            e("打开播放器发生错误", e)
        }
    }

    override fun onSurfaceTextureSizeChanged(surface: SurfaceTexture, width: Int, height: Int) {}
    override fun onSurfaceTextureDestroyed(surface: SurfaceTexture): Boolean {
        return mSurfaceTexture == null
    }

    override fun onSurfaceTextureUpdated(surface: SurfaceTexture) {}
    private val mOnPreparedListener = IMediaPlayer.OnPreparedListener { mp ->
        mCurrentState = STATE_PREPARED
        mController?.onPlayStateChanged(mCurrentState)
        d("onPrepared ——> STATE_PREPARED")
        mp.start()
        // 从上次的保存位置播放
        if (continueFromLastPosition) {
            val savedPlayPosition = NiceUtil.getSavedPlayPosition(mContext, mUrl)
            mp.seekTo(savedPlayPosition)
        }
        // 跳到指定位置播放
        if (skipToPosition != 0L) {
            mp.seekTo(skipToPosition)
        }
    }
    private val mOnVideoSizeChangedListener = IMediaPlayer.OnVideoSizeChangedListener { _, width, height, _, _ ->
        mTextureView?.adaptVideoSize(width, height)
        d("onVideoSizeChanged ——> width：$width， height：$height")
    }
    private val mOnCompletionListener = IMediaPlayer.OnCompletionListener {
        mCurrentState = STATE_COMPLETED
        mController?.onPlayStateChanged(mCurrentState)
        d("onCompletion ——> STATE_COMPLETED")
        // 清除屏幕常亮
        mContainer.keepScreenOn = false
    }
    private val mOnErrorListener = IMediaPlayer.OnErrorListener { _, what, extra -> // 直播流播放时去调用mediaPlayer.getDuration会导致-38和-2147483648错误，忽略该错误
        if (what != -38 && what != -2147483648 && extra != -38 && extra != -2147483648) {
            mCurrentState = STATE_ERROR
            mController?.onPlayStateChanged(mCurrentState)
            d("onError ——> STATE_ERROR ———— what：$what, extra: $extra")
        }
        true
    }
    private val mOnInfoListener = IMediaPlayer.OnInfoListener { _, what, extra ->
        if (what == IMediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {
            // 播放器开始渲染
            mCurrentState = STATE_PLAYING
            mController?.onPlayStateChanged(mCurrentState)
            d("onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING")
        } else if (what == IMediaPlayer.MEDIA_INFO_BUFFERING_START) {
            // MediaPlayer暂时不播放，以缓冲更多的数据
            if (mCurrentState == STATE_PAUSED || mCurrentState == STATE_BUFFERING_PAUSED) {
                mCurrentState = STATE_BUFFERING_PAUSED
                d("onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED")
            } else {
                mCurrentState = STATE_BUFFERING_PLAYING
                d("onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING")
            }
            mController?.onPlayStateChanged(mCurrentState)
        } else if (what == IMediaPlayer.MEDIA_INFO_BUFFERING_END) {
            // 填充缓冲区后，MediaPlayer恢复播放/暂停
            if (mCurrentState == STATE_BUFFERING_PLAYING) {
                mCurrentState = STATE_PLAYING
                mController?.onPlayStateChanged(mCurrentState)
                d("onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING")
            }
            if (mCurrentState == STATE_BUFFERING_PAUSED) {
                mCurrentState = STATE_PAUSED
                mController?.onPlayStateChanged(mCurrentState)
                d("onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED")
            }
        } else if (what == IMediaPlayer.MEDIA_INFO_VIDEO_ROTATION_CHANGED) {
            // 视频旋转了extra度，需要恢复
            mTextureView?.rotation = extra.toFloat()
            d("视频旋转角度：$extra")
        } else if (what == IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE) {
            d("视频不能seekTo，为直播视频")
        } else {
            d("onInfo ——> what：$what")
        }
        true
    }
    private val mOnBufferingUpdateListener: IMediaPlayer.OnBufferingUpdateListener = IMediaPlayer.OnBufferingUpdateListener { _, percent -> bufferPercentage = percent }

    /**
     * 全屏，将mContainer(内部包含mTextureView和mController)从当前容器中移除，并添加到android.R.content中.
     * 切换横屏时需要在manifest的activity标签下添加android:configChanges="orientation|keyboardHidden|screenSize"配置，
     * 以避免Activity重新走生命周期
     */
    override fun enterFullScreen() {
        if (mCurrentMode == MODE_FULL_SCREEN) return

        // 隐藏ActionBar、状态栏，并横屏
        NiceUtil.hideActionBar(mContext)
        NiceUtil.scanForActivity(
                mContext)!!.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        val contentView = NiceUtil.scanForActivity(mContext)!!
                .findViewById<View>(R.id.content) as ViewGroup
        if (mCurrentMode == MODE_TINY_WINDOW) {
            contentView.removeView(mContainer)
        } else {
            removeView(mContainer)
        }
        val params = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        contentView.addView(mContainer, params)
        mCurrentMode = MODE_FULL_SCREEN
        mController?.onPlayModeChanged(mCurrentMode)
        d("MODE_FULL_SCREEN")
    }

    /**
     * 退出全屏，移除mTextureView和mController，并添加到非全屏的容器中。
     * 切换竖屏时需要在manifest的activity标签下添加android:configChanges="orientation|keyboardHidden|screenSize"配置，
     * 以避免Activity重新走生命周期.
     *
     * @return true退出全屏.
     */
    override fun exitFullScreen(): Boolean {
        if (mCurrentMode == MODE_FULL_SCREEN) {
            NiceUtil.showActionBar(mContext)
            NiceUtil.scanForActivity(
                    mContext)!!.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            val contentView = NiceUtil.scanForActivity(mContext)!!
                    .findViewById<View>(R.id.content) as ViewGroup
            contentView.removeView(mContainer)
            val params = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT)
            this.addView(mContainer, params)
            mCurrentMode = MODE_NORMAL
            mController?.onPlayModeChanged(mCurrentMode)
            d("MODE_NORMAL")
            return true
        }
        return false
    }

    /**
     * 进入小窗口播放，小窗口播放的实现原理与全屏播放类似。
     */
    override fun enterTinyWindow() {
        if (mCurrentMode == MODE_TINY_WINDOW) return
        removeView(mContainer)
        val contentView = NiceUtil.scanForActivity(mContext)!!
                .findViewById<View>(R.id.content) as ViewGroup

        // 小窗口的宽度为屏幕宽度的60%，长宽比默认为16:9，右边距、下边距为8dp。
        val params = LayoutParams((NiceUtil.getScreenWidth(mContext) * 0.6f).toInt(),
                (NiceUtil.getScreenWidth(mContext) * 0.6f * 9f / 16f).toInt())
        params.gravity = Gravity.BOTTOM or Gravity.END
        params.rightMargin = 8f.dp.toInt()
        params.bottomMargin = 8f.dp.toInt()
        contentView.addView(mContainer, params)
        mCurrentMode = MODE_TINY_WINDOW
        mController?.onPlayModeChanged(mCurrentMode)
        d("MODE_TINY_WINDOW")
    }

    /**
     * 退出小窗口播放
     */
    override fun exitTinyWindow(): Boolean {
        if (mCurrentMode == MODE_TINY_WINDOW) {
            val contentView = NiceUtil.scanForActivity(mContext)!!
                    .findViewById<View>(R.id.content) as ViewGroup
            contentView.removeView(mContainer)
            val params = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT)
            this.addView(mContainer, params)
            mCurrentMode = MODE_NORMAL
            mController?.onPlayModeChanged(mCurrentMode)
            d("MODE_NORMAL")
            return true
        }
        return false
    }

    override fun releasePlayer() {
        mAudioManager.abandonAudioFocus(null)
        mMediaPlayer.release()
        mContainer.removeView(mTextureView)
        mSurface?.let {
            it.release()
            mSurface = null
        }
        mSurfaceTexture?.let {
            it.release()
            mSurfaceTexture = null
        }
        mCurrentState = STATE_IDLE
    }

    override fun release() {
        // 保存播放位置
        if (isPlaying || isBufferingPlaying || isBufferingPaused || isPaused) {
            NiceUtil.savePlayPosition(mContext, mUrl, currentPosition)
        } else if (isCompleted) {
            NiceUtil.savePlayPosition(mContext, mUrl, 0)
        }
        // 退出全屏或小窗口
        if (isFullScreen) {
            exitFullScreen()
        }
        if (isTinyWindow) {
            exitTinyWindow()
        }
        mCurrentMode = MODE_NORMAL

        // 释放播放器
        releasePlayer()

        // 恢复控制器
        mController?.reset()
        Runtime.getRuntime().gc()
    }

    companion object {

        /**
         * 播放错误
         */
        const val STATE_ERROR = -1

        /**
         * 播放未开始
         */
        const val STATE_IDLE = 0

        /**
         * 播放准备中
         */
        const val STATE_PREPARING = 1

        /**
         * 播放准备就绪
         */
        const val STATE_PREPARED = 2

        /**
         * 正在播放
         */
        const val STATE_PLAYING = 3

        /**
         * 暂停播放
         */
        const val STATE_PAUSED = 4

        /**
         * 正在缓冲(播放器正在播放时，缓冲区数据不足，进行缓冲，缓冲区数据足够后恢复播放)
         */
        const val STATE_BUFFERING_PLAYING = 5

        /**
         * 正在缓冲(播放器正在播放时，缓冲区数据不足，进行缓冲，此时暂停播放器，继续缓冲，缓冲区数据足够后恢复暂停
         */
        const val STATE_BUFFERING_PAUSED = 6

        /**
         * 播放完成
         */
        const val STATE_COMPLETED = 7

        /**
         * 普通模式
         */
        const val MODE_NORMAL = 10

        /**
         * 全屏模式
         */
        const val MODE_FULL_SCREEN = 11

        /**
         * 小窗口模式
         */
        const val MODE_TINY_WINDOW = 12

        /**
         * IjkPlayer
         */
        const val TYPE_IJK = 111

        /**
         * MediaPlayer
         */
        const val TYPE_NATIVE = 222
    }

    init {
        init()
    }
}