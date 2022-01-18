package com.blues.framework.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.blues.framework.dialog.LoadingDialog

/**
 * File: com.blues.framework.base.BaseKoinFragment
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-21
 **/

abstract class BaseKoinFragment : Fragment() {

    protected lateinit var rootView: View

    private val mLoading: LoadingDialog by lazy {
        LoadingDialog(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return inflater.inflate(getLayoutId(), container, false).also {
            rootView = it
            initData(inflater, container, savedInstanceState)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        collect()
    }

    abstract fun getLayoutId(): Int

    abstract fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?)

    open fun collect() {}

    protected fun showLoading() {
        if (!mLoading.isShowing) {
            mLoading.show()
        }
    }

    protected fun hideLoading() {
        if (mLoading.isShowing) {
            mLoading.dismiss()
        }
    }
}