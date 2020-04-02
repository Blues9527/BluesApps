package com.blues.framework.network;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;

import com.blues.R;

import androidx.annotation.NonNull;

public class NetworkDialog extends Dialog {

    public NetworkDialog(@NonNull Context context) {
        super(context);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //初始化窗口属性
        //替换掉默认主题的背景，默认主题背景有一个16dp的padding
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //外边距
        getWindow().getDecorView().setPadding(0, 0, 0, 0);

        //设置重力位置
        getWindow().setGravity(Gravity.CENTER);

        //设置弹窗的宽高
        getWindow().setLayout(-1, -1);

        //设置视图
        setContentView(R.layout.dialog_network_error);


        //设置是否可撤销
        setCancelable(true);

        //设置触摸外部是否可撤销
        setCanceledOnTouchOutside(true);

    }
}
