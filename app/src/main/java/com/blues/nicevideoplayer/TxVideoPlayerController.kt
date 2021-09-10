package com.blues.nicevideoplayer

import android.widget.SeekBar.OnSeekBarChangeListener
import android.os.CountDownTimer
import android.view.LayoutInflater
import androidx.annotation.DrawableRes
import android.content.IntentFilter
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import android.os.BatteryManager
import android.view.View
import android.widget.*
import com.blues.R
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by XiaoJianjun on 2017/6/21.
 * 仿腾讯视频热点列表页播放器控制器.
 */
class TxVideoPlayerController(private val mContext: Context) : NiceVideoPlayerController(mContext),
    View.OnClickListener, OnSeekBarChangeListener, ChangeClarityDialog.OnClarityChangedListener {

    init {
        init()
    }

    private lateinit var mImage: ImageView
    private lateinit var mCenterStart: ImageView
    private lateinit var mTop: LinearLayout
    private lateinit var mBack: ImageView
    private lateinit var mTitle: TextView
    private lateinit var mBatteryTime: LinearLayout
    private lateinit var mBattery: ImageView
    private lateinit var mTime: TextView
    private lateinit var mBottom: LinearLayout
    private lateinit var mRestartPause: ImageView
    private lateinit var mPosition: TextView
    private lateinit var mDuration: TextView
    private lateinit var mSeek: SeekBar
    private lateinit var mClarity: TextView
    private lateinit var mFullScreen: ImageView
    private lateinit var mLength: TextView
    private lateinit var mLoading: LinearLayout
    private lateinit var mLoadText: TextView
    private lateinit var mChangePosition: LinearLayout
    private lateinit var mChangePositionCurrent: TextView
    private lateinit var mChangePositionProgress: ProgressBar
    private lateinit var mChangeBrightness: LinearLayout
    private lateinit var mChangeBrightnessProgress: ProgressBar
    private lateinit var mChangeVolume: LinearLayout
    private lateinit var mChangeVolumeProgress: ProgressBar
    private lateinit var mError: LinearLayout
    private lateinit var mRetry: TextView
    private lateinit var mCompleted: LinearLayout
    private lateinit var mReplay: TextView
    private lateinit var mShare: TextView

    private var topBottomVisible = false
    private var mDismissTopBottomCountDownTimer: CountDownTimer? = null
    private var clarities: List<Clarity>? = null
    private var defaultClarityIndex = 0
    private var mClarityDialog: ChangeClarityDialog? = null
    private var hasRegisterBatteryReceiver = false // 是否已经注册了电池广播

    private var shouldShowLength = true //默认显示

    private fun init() {
        LayoutInflater.from(mContext).inflate(R.layout.tx_video_palyer_controller, this, true)

        mCenterStart = findViewById(R.id.center_start)
        mImage = findViewById(R.id.image)
        mTop = findViewById(R.id.top)
        mBack = findViewById(R.id.back)
        mTitle = findViewById(R.id.title)
        mBatteryTime = findViewById(R.id.battery_time)
        mBattery = findViewById(R.id.battery)
        mTime = findViewById(R.id.time)
        mBottom = findViewById(R.id.bottom)
        mRestartPause = findViewById(R.id.restart_or_pause)
        mPosition = findViewById(R.id.position)
        mDuration = findViewById(R.id.duration)
        mSeek = findViewById(R.id.seek)
        mFullScreen = findViewById(R.id.full_screen)
        mClarity = findViewById(R.id.clarity)
        mLength = findViewById(R.id.length)
        mLoading = findViewById(R.id.loading)
        mLoadText = findViewById(R.id.load_text)
        mChangePosition = findViewById(R.id.change_position)
        mChangePositionCurrent = findViewById(R.id.change_position_current)
        mChangePositionProgress = findViewById(R.id.change_position_progress)
        mChangeBrightness = findViewById(R.id.change_brightness)
        mChangeBrightnessProgress = findViewById(R.id.change_brightness_progress)
        mChangeVolume = findViewById(R.id.change_volume)
        mChangeVolumeProgress = findViewById(R.id.change_volume_progress)
        mError = findViewById(R.id.error)
        mRetry = findViewById(R.id.retry)
        mCompleted = findViewById(R.id.completed)
        mReplay = findViewById(R.id.replay)
        mShare = findViewById(R.id.share)

        mCenterStart.setOnClickListener(this)
        mBack.setOnClickListener(this)
        mRestartPause.setOnClickListener(this)
        mFullScreen.setOnClickListener(this)
        mClarity.setOnClickListener(this)
        mRetry.setOnClickListener(this)
        mReplay.setOnClickListener(this)
        mShare.setOnClickListener(this)
        mSeek.setOnSeekBarChangeListener(this)

        setOnClickListener(this)
    }

    override fun setTitle(title: String?) {
        mTitle.text = title
    }

    override fun imageView(): ImageView {
        return mImage
    }

    override fun setImage(@DrawableRes resId: Int) {
        mImage.setImageResource(resId)
    }

    override fun setLength(length: Long) {
        if (shouldShowLength) {
            mLength.text = NiceUtil.formatTime(length)
            mLength.visibility = VISIBLE
        } else {
            mLength.visibility = GONE
        }
    }

    override fun setShouldShowLength(shouldShowLength: Boolean) {
        this.shouldShowLength = shouldShowLength
    }

    override fun setNiceVideoPlayer(niceVideoPlayer: INiceVideoPlayer) {
        super.setNiceVideoPlayer(niceVideoPlayer)
        // 给播放器配置视频链接地址
        if (clarities != null && clarities!!.size > 1) {
            mNiceVideoPlayer.setUp(clarities!![defaultClarityIndex].videoUrl, null)
        }
    }

    /**
     * 设置清晰度
     *
     * @param clarities 清晰度及链接
     */
    fun setClarity(clarities: List<Clarity>?, defaultClarityIndex: Int) {
        if (clarities != null && clarities.size > 1) {
            this.clarities = clarities
            this.defaultClarityIndex = defaultClarityIndex
            val clarityGrades: MutableList<String?> = ArrayList()
            for ((grade, p) in clarities) {
                clarityGrades.add("$grade $p")
            }
            mClarity.text = clarities[defaultClarityIndex].grade
            // 初始化切换清晰度对话框
            mClarityDialog = ChangeClarityDialog(mContext).also {
                it.setClarityGrade(clarityGrades, defaultClarityIndex)
                it.setOnClarityCheckedListener(this)
            }

            // 给播放器配置视频链接地址
            mNiceVideoPlayer.setUp(clarities[defaultClarityIndex].videoUrl, null)
        }
    }

    override fun onPlayStateChanged(playState: Int) {
        when (playState) {
            NiceVideoPlayer.STATE_IDLE -> {
            }
            NiceVideoPlayer.STATE_PREPARING -> {
                mImage.visibility = GONE
                mLoading.visibility = VISIBLE
                mLoadText.text = "正在准备..."
                mError.visibility = GONE
                mCompleted.visibility = GONE
                mTop.visibility = GONE
                mBottom.visibility = GONE
                mCenterStart.visibility = GONE
                mLength.visibility = GONE
            }
            NiceVideoPlayer.STATE_PREPARED -> startUpdateProgressTimer()
            NiceVideoPlayer.STATE_PLAYING -> {
                mLoading.visibility = GONE
                mRestartPause.setImageResource(R.drawable.ic_player_pause)
                startDismissTopBottomTimer()
            }
            NiceVideoPlayer.STATE_PAUSED -> {
                mLoading.visibility = GONE
                mRestartPause.setImageResource(R.drawable.ic_player_start)
                cancelDismissTopBottomTimer()
            }
            NiceVideoPlayer.STATE_BUFFERING_PLAYING -> {
                mLoading.visibility = VISIBLE
                mRestartPause.setImageResource(R.drawable.ic_player_pause)
                mLoadText.text = "正在缓冲..."
                startDismissTopBottomTimer()
            }
            NiceVideoPlayer.STATE_BUFFERING_PAUSED -> {
                mLoading.visibility = VISIBLE
                mRestartPause.setImageResource(R.drawable.ic_player_start)
                mLoadText.text = "正在缓冲..."
                cancelDismissTopBottomTimer()
            }
            NiceVideoPlayer.STATE_ERROR -> {
                cancelUpdateProgressTimer()
                setTopBottomVisible(false)
                mTop.visibility = VISIBLE
                mError.visibility = VISIBLE
            }
            NiceVideoPlayer.STATE_COMPLETED -> {
                cancelUpdateProgressTimer()
                setTopBottomVisible(false)
                mImage.visibility = VISIBLE
                mCompleted.visibility = VISIBLE
            }
        }
    }

    override fun onPlayModeChanged(playMode: Int) {
        when (playMode) {
            NiceVideoPlayer.MODE_NORMAL -> {
                mBack.visibility = GONE
                mFullScreen.setImageResource(R.drawable.ic_player_enlarge)
                mFullScreen.visibility = VISIBLE
                mClarity.visibility = GONE
                mBatteryTime.visibility = GONE
                if (hasRegisterBatteryReceiver) {
                    mContext.unregisterReceiver(mBatterReceiver)
                    hasRegisterBatteryReceiver = false
                }
            }
            NiceVideoPlayer.MODE_FULL_SCREEN -> {
                mBack.visibility = VISIBLE
                mFullScreen.visibility = GONE
                mFullScreen.setImageResource(R.drawable.ic_player_shrink)
                if (clarities != null && clarities!!.size > 1) {
                    mClarity.visibility = VISIBLE
                }
                mBatteryTime.visibility = VISIBLE
                if (!hasRegisterBatteryReceiver) {
                    mContext.registerReceiver(mBatterReceiver,
                            IntentFilter(Intent.ACTION_BATTERY_CHANGED))
                    hasRegisterBatteryReceiver = true
                }
            }
            NiceVideoPlayer.MODE_TINY_WINDOW -> {
                mBack.visibility = VISIBLE
                mClarity.visibility = GONE
            }
        }
    }

    /**
     * 电池状态即电量变化广播接收器
     */
    private val mBatterReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val status = intent.getIntExtra(BatteryManager.EXTRA_STATUS,
                    BatteryManager.BATTERY_STATUS_UNKNOWN)
            when (status) {
                BatteryManager.BATTERY_STATUS_CHARGING -> {
                    // 充电中
                    mBattery.setImageResource(R.drawable.battery_charging)
                }
                BatteryManager.BATTERY_STATUS_FULL -> {
                    // 充电完成
                    mBattery.setImageResource(R.drawable.battery_full)
                }
                else -> {
                    val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)
                    val scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 0)
                    val percentage = (level.toFloat() / scale * 100).toInt()
                    when {
                        percentage <= 10 -> {
                            mBattery.setImageResource(R.drawable.battery_10)
                        }
                        percentage <= 20 -> {
                            mBattery.setImageResource(R.drawable.battery_20)
                        }
                        percentage <= 50 -> {
                            mBattery.setImageResource(R.drawable.battery_50)
                        }
                        percentage <= 80 -> {
                            mBattery.setImageResource(R.drawable.battery_80)
                        }
                        percentage <= 100 -> {
                            mBattery.setImageResource(R.drawable.battery_100)
                        }
                    }
                }
            }
        }
    }

    override fun reset() {
        topBottomVisible = false
        cancelUpdateProgressTimer()
        cancelDismissTopBottomTimer()
        mSeek.progress = 0
        mSeek.secondaryProgress = 0
        mCenterStart.visibility = VISIBLE
        mImage.visibility = VISIBLE
        mBottom.visibility = GONE
        mFullScreen.setImageResource(R.drawable.ic_player_enlarge)
        mLength.visibility = if (shouldShowLength) VISIBLE else GONE
        mTop.visibility = VISIBLE
        mBack.visibility = GONE
        mLoading.visibility = GONE
        mError.visibility = GONE
        mCompleted.visibility = GONE
    }

    /**
     * 尽量不要在onClick中直接处理控件的隐藏、显示及各种UI逻辑。
     * UI相关的逻辑都尽量到[.onPlayStateChanged]和[.onPlayModeChanged]中处理.
     */
    override fun onClick(v: View) {
        when (v) {
            mCenterStart -> {
                if (mNiceVideoPlayer.isIdle) {
                    mNiceVideoPlayer.start()
                }
            }
            mBack -> {
                if (mNiceVideoPlayer.isFullScreen) {
                    mNiceVideoPlayer.exitFullScreen()
                } else if (mNiceVideoPlayer.isTinyWindow) {
                    mNiceVideoPlayer.exitTinyWindow()
                }
            }
            mRestartPause -> {
                if (mNiceVideoPlayer.isPlaying || mNiceVideoPlayer.isBufferingPlaying) {
                    mNiceVideoPlayer.pause()
                } else if (mNiceVideoPlayer.isPaused || mNiceVideoPlayer.isBufferingPaused) {
                    mNiceVideoPlayer.restart()
                }
            }

            mFullScreen -> {
                if (mNiceVideoPlayer.isNormal || mNiceVideoPlayer.isTinyWindow) {
                    mNiceVideoPlayer.enterFullScreen()
                } else if (mNiceVideoPlayer.isFullScreen) {
                    mNiceVideoPlayer.exitFullScreen()
                }
            }

            mClarity -> {
                setTopBottomVisible(false) // 隐藏top、bottom
                mClarityDialog!!.show() // 显示清晰度对话框
            }

            mRetry -> mNiceVideoPlayer.restart()

            mReplay -> mRetry.performClick()
            mShare -> Toast.makeText(mContext, "分享", Toast.LENGTH_SHORT).show()
            this -> if (mNiceVideoPlayer.isPlaying || mNiceVideoPlayer.isPaused || mNiceVideoPlayer.isBufferingPlaying || mNiceVideoPlayer.isBufferingPaused) {
                setTopBottomVisible(!topBottomVisible)
            }
        }
    }

    override fun onClarityChanged(clarityIndex: Int) {
        // 根据切换后的清晰度索引值，设置对应的视频链接地址，并从当前播放位置接着播放
        val (grade, _, videoUrl) = clarities!![clarityIndex]
        mClarity.text = grade

        with(mNiceVideoPlayer) {
            val currentPosition = currentPosition
            releasePlayer()
            setUp(videoUrl, null)
            start(currentPosition)
        }
    }

    override fun onClarityNotChanged() {
        // 清晰度没有变化，对话框消失后，需要重新显示出top、bottom
        setTopBottomVisible(true)
    }

    /**
     * 设置top、bottom的显示和隐藏
     *
     * @param visible true显示，false隐藏.
     */
    private fun setTopBottomVisible(visible: Boolean) {
        mTop.visibility = if (visible) VISIBLE else GONE
        mBottom.visibility = if (visible) VISIBLE else GONE
        topBottomVisible = visible
        if (visible) {
            if (!mNiceVideoPlayer.isPaused && !mNiceVideoPlayer.isBufferingPaused) {
                startDismissTopBottomTimer()
            }
        } else {
            cancelDismissTopBottomTimer()
        }
    }

    /**
     * 开启top、bottom自动消失的timer
     */
    private fun startDismissTopBottomTimer() {
        cancelDismissTopBottomTimer()
        if (mDismissTopBottomCountDownTimer == null) {
            mDismissTopBottomCountDownTimer = object : CountDownTimer(8000, 8000) {
                override fun onTick(millisUntilFinished: Long) {}
                override fun onFinish() {
                    setTopBottomVisible(false)
                }
            }
        }
        mDismissTopBottomCountDownTimer?.start()
    }

    /**
     * 取消top、bottom自动消失的timer
     */
    private fun cancelDismissTopBottomTimer() {
        mDismissTopBottomCountDownTimer?.cancel()
    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {}
    override fun onStartTrackingTouch(seekBar: SeekBar) {}
    override fun onStopTrackingTouch(seekBar: SeekBar) {
        if (mNiceVideoPlayer.isBufferingPaused || mNiceVideoPlayer.isPaused) {
            mNiceVideoPlayer.restart()
        }
        val position = (mNiceVideoPlayer.duration * seekBar.progress / 100f).toLong()
        mNiceVideoPlayer.seekTo(position)
        startDismissTopBottomTimer()
    }

    override fun updateProgress() {
        val position = mNiceVideoPlayer.currentPosition
        val duration = mNiceVideoPlayer.duration
        val bufferPercentage = mNiceVideoPlayer.bufferPercentage
        mSeek.secondaryProgress = bufferPercentage
        val progress = (100f * position / duration).toInt()
        mSeek.progress = progress
        mPosition.text = NiceUtil.formatTime(position)
        mDuration.text = NiceUtil.formatTime(duration)
        // 更新时间
        mTime.text = SimpleDateFormat("HH:mm", Locale.CHINA).format(Date())
    }

    override fun showChangePosition(duration: Long, newPositionProgress: Int) {
        mChangePosition.visibility = VISIBLE
        val newPosition = (duration * newPositionProgress / 100f).toLong()
        mChangePositionCurrent.text = NiceUtil.formatTime(newPosition)
        mChangePositionProgress.progress = newPositionProgress
        mSeek.progress = newPositionProgress
        mPosition.text = NiceUtil.formatTime(newPosition)
    }

    override fun hideChangePosition() {
        mChangePosition.visibility = GONE
    }

    override fun showChangeVolume(newVolumeProgress: Int) {
        mChangeVolume.visibility = VISIBLE
        mChangeVolumeProgress.progress = newVolumeProgress
    }

    override fun hideChangeVolume() {
        mChangeVolume.visibility = GONE
    }

    override fun showChangeBrightness(newBrightnessProgress: Int) {
        mChangeBrightness.visibility = VISIBLE
        mChangeBrightnessProgress.progress = newBrightnessProgress
    }

    override fun hideChangeBrightness() {
        mChangeBrightness.visibility = GONE
    }

}