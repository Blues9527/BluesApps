package com.blues.framework.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

abstract class BaseVmFragment<VM : BaseViewModel> : Fragment() {

    lateinit var viewModel: VM

    lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(setLayoutResId(), container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState) //设置ViewModel

        viewModel = ViewModelProvider(this).get(setViewModelClass())

        //初始化控件相关
        initData(savedInstanceState)

        observe()
    }

    abstract fun setLayoutResId(): Int

    abstract fun initData(savedInstanceState: Bundle?)

    open fun observe() {

    }

    abstract fun setViewModelClass(): Class<VM>

}