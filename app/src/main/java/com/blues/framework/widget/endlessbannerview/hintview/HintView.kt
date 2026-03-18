package com.blues.framework.widget.endlessbannerview.hintview

/**
 * Created by Administrator on 2018/2/28.
 */
interface HintView {

    fun initView(length: Int, gravity: Int, duration: Int)
    fun setCurrent(current: Int, duration: Int)
}