package com.blues.framework.network

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.WindowManager
import com.blues.R

/**
 * File: com.blues.framework.network.NetworkDialog.kt
 * Description: 网络错误弹窗
 *
 * @author: lanhuajian
 * @time: 2022/1/24
 **/

class NetworkDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)

        window?.apply { //初始化窗口属性
            //替换掉默认主题的背景，默认主题背景有一个16dp的padding
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            //外边距
            decorView.setPadding(0, 0, 0, 0)

            //设置重力位置
            setGravity(Gravity.CENTER)

            //设置弹窗的宽高
            setLayout(-1, -1)

            setType(WindowManager.LayoutParams.TYPE_SYSTEM_DIALOG)
        }

        //设置视图
        setContentView(R.layout.dialog_network_error)

        //设置是否可撤销
        setCancelable(false)

        //设置触摸外部是否可撤销
        setCanceledOnTouchOutside(false)
    }
}