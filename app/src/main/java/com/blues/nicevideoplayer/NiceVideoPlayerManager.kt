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
        if (currentNiceVideoPlayer != null && (currentNiceVideoPlayer!!.isPlaying || currentNiceVideoPlayer!!.isBufferingPlaying)) {
            currentNiceVideoPlayer!!.pause()
        }
    }

    fun resumeNiceVideoPlayer() {
        if (currentNiceVideoPlayer != null && (currentNiceVideoPlayer!!.isPaused || currentNiceVideoPlayer!!.isBufferingPaused)) {
            currentNiceVideoPlayer!!.restart()
        }
    }

    fun releaseNiceVideoPlayer() {
        if (currentNiceVideoPlayer != null) {
            currentNiceVideoPlayer!!.release()
            currentNiceVideoPlayer = null
        }
    }

    fun onBackPressd(): Boolean {
        if (currentNiceVideoPlayer != null) {
            if (currentNiceVideoPlayer!!.isFullScreen) {
                return currentNiceVideoPlayer!!.exitFullScreen()
            } else if (currentNiceVideoPlayer!!.isTinyWindow) {
                return currentNiceVideoPlayer!!.exitTinyWindow()
            }
        }
        return false
    }

    companion object {

        internal var instance: NiceVideoPlayerManager = NiceVideoPlayerManager()
    }
}