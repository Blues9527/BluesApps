package com.blues.nicevideoplayer

import android.os.CountDownTimer

/**
 * File: com.blues.nicevideoplayer.CountDownTimerImpl.kt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2022/1/22
 **/

class CountDownTimerImpl(
    millis: Long,
    interval: Long,
    private val tickBlock: ((millis: Long) -> Unit)? = null,
    private val finishBlock: (() -> Unit)? = null,
) :
    CountDownTimer(millis, interval) {
    override fun onTick(millisUntilFinished: Long) {
        tickBlock?.invoke(millisUntilFinished)
    }

    override fun onFinish() {
        finishBlock?.invoke()
    }
}