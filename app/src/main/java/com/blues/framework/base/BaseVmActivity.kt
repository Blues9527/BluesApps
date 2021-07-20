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

abstract class BaseVmActivity<VM : BaseViewModel> : AppCompatActivity() {

    lateinit var viewModel: VM

    private var loadingDialog: ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        viewModel = getVm()
        viewModel.loadingEvent.observe(this) {
            if (it) {
                showLoading()
            } else {
                dismissLoading()
            }

        }
        initData(savedInstanceState)
    }

    abstract fun getLayoutId(): Int

    abstract fun initData(savedInstanceState: Bundle?)

    private fun getVm(): VM {
        val viewModelClass: Class<BaseViewModel>
        val type = javaClass.genericSuperclass
        viewModelClass = if (type is ParameterizedType) {
            type.actualTypeArguments[1] as Class<BaseViewModel> //获取第1个注解即VM的注解类型
        } else { //使用父类的类型
            BaseViewModel::class.java
        }
        return ViewModelProvider(this).get(viewModelClass) as VM;
    }

    protected fun showLoading() {
        if (loadingDialog == null) {
            loadingDialog = ProgressDialog(this).apply {
                setMessage("加载中。。。")
            };
        }
        if (!loadingDialog!!.isShowing) {
            loadingDialog!!.show()
        }
    }

    protected fun dismissLoading() {
        loadingDialog?.dismiss()
    }
}