package com.blues.nicevideoplayer

/**
 * Created by XiaoJianjun on 2017/5/5.
 * 视频播放器管理器.
 */
class NiceVideoPlayerManager private constructor() {

    var currentNiceVideoPlayer: NiceVideoPlayer? = null
        private set

    fun setCurrentNiceVideoPlayer(videoPlayer: NiceVideoPlayer) {
        if (currentNiceVideoPlayer !== videoPlayer) {
            releaseNiceVideoPlayer()
            currentNiceVideoPlayer = videoPlayer
        }
    }

    fun suspendNiceVideoPlayer() {
        check(currentNiceVideoPlayer != null)
        currentNiceVideoPlayer?.let {
            if ((it.isPlaying || it.isBufferingPlaying)) {
                it.pause()
            }
        }
    }

    fun resumeNiceVideoPlayer() {
        check(currentNiceVideoPlayer != null)
        currentNiceVideoPlayer?.let {
            if (it.isPaused || it.isBufferingPaused) {
                it.restart()
            }
        }
    }

    fun releaseNiceVideoPlayer() {
        currentNiceVideoPlayer = currentNiceVideoPlayer?.run {
            release()
            null
        }
    }

    fun onBackPressd(): Boolean {
        check(currentNiceVideoPlayer != null)
        currentNiceVideoPlayer?.let {
            if (it.isFullScreen) {
                return it.exitFullScreen()
            } else if (it.isTinyWindow) {
                return it.exitTinyWindow()
            }
        }
        return false
    }

    companion object {

        internal var instance: NiceVideoPlayerManager = NiceVideoPlayerManager()
    }
}