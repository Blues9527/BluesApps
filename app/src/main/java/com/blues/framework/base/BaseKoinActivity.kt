package com.blues.framework.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * File: com.blues.framework.base.BaseVmActivity
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-16
 **/

abstract class BaseKoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData(savedInstanceState)
        observe()
    }

    abstract fun getLayoutId(): Int

    abstract fun initData(savedInstanceState: Bundle?)

    open fun observe() {

    }

    inline fun <reified T> startActivity() {
        startActivity(Intent(this, T::class.java))
    }
}