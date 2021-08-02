package com.blues

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.graphics.drawable.ColorDrawable
import android.view.Gravity

class LoadingDialog(context: Context) : Dialog(context, R.style.Theme_LoadingDialog) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //初始化窗口属性
        initWindowAttribute()

        //设置视图
        setContentView(R.layout.dialog_loading)

        //设置是否可撤销
        setCancelable(true)

        //设置触摸外部是否可撤销
        setCanceledOnTouchOutside(true)
    }

    private fun initWindowAttribute() {

        window?.apply { //替换掉默认主题的背景，默认主题背景有一个16dp的padding
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            //外边距
            decorView.setPadding(0, 0, 0, 0)

            //设置重力位置
            setGravity(Gravity.CENTER)

            //设置弹窗的宽高
            setLayout(-1, -1)
        }
    }
}