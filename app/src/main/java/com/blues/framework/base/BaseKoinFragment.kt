package com.blues.framework.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * File: com.blues.framework.base.BaseKoinFragment
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-21 10:28
 **/

abstract class BaseKoinFragment : Fragment() {

    protected var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return rootView ?: inflater.inflate(getLayoutId(), container, false)
            .also {
                rootView = it
                initData(inflater, container, savedInstanceState)
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
    }

    abstract fun getLayoutId(): Int

    abstract fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?)

    open fun observe() {}
}