package com.blues.framework.base

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

/**
 * File: com.blues.framework.base.BaseVmActivity
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-16 22:01
 **/

abstract class BaseKoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData(savedInstanceState)
    }

    abstract fun getLayoutId(): Int

    abstract fun initData(savedInstanceState: Bundle?)
}