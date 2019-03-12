package com.example.lanhuajian.blues;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class WebViewDialog extends Dialog {

    private WebView showWv;
    private ProgressBar webViewPb;
    private ImageView backIv;
    private String url;

    public WebViewDialog(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //初始化窗口属性
        initWindowAttribute();

        //设置视图
        setContentView(R.layout.dialog_webview);


        //设置是否可撤销
        setCancelable(true);

        //设置触摸外部是否可撤销
        setCanceledOnTouchOutside(true);

        initView();
    }

    private void initView() {
        showWv = findViewById(R.id.wv_show);
        webViewPb = findViewById(R.id.pb_webview);
        backIv = findViewById(R.id.iv_back);


        WebSettings webSettings = showWv.getSettings();
        webSettings.setLoadWithOverviewMode(true);// 缩放至屏幕的大小
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setBuiltInZoomControls(true);//设置支持缩放
        webSettings.supportZoom();
        webSettings.setUseWideViewPort(true);

        showWv.setWebViewClient(new WebViewClient());
        showWv.setWebChromeClient(new WebChromeClient());

        showWv.loadUrl(url);

        backIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebViewDialog.this.dismiss();
            }
        });

    }

    private void initWindowAttribute() {
        //替换掉默认主题的背景，默认主题背景有一个16dp的padding
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //外边距
        getWindow().getDecorView().setPadding(0, 0, 0, 0);

        //设置重力位置
        getWindow().setGravity(Gravity.CENTER);

        //设置弹窗的宽高
        getWindow().setLayout(-1, -1);
    }
}
