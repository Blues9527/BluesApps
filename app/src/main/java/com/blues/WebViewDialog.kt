package com.blues;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewStub;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.blues.framework.utils.NetWorkUtil;
import com.blues.framework.widget.CWebView;

public class WebViewDialog extends Dialog {

    private CWebView showWv;
    private ProgressBar webViewPb;
    private ImageView backIv;
    private String url;
    private LoadingDialog mDialog;
    private ViewStub vsNetworkError;
    private View v;

    public WebViewDialog(Context context, String url) {
        super(context);
        this.url = url;
        mDialog = new LoadingDialog(getContext());
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
        vsNetworkError = findViewById(R.id.vs_network);


        WebSettings webSettings = showWv.getSettings();
        webSettings.setLoadWithOverviewMode(true);// 缩放至屏幕的大小
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setBuiltInZoomControls(true);//设置支持缩放
        webSettings.supportZoom();
        webSettings.setUseWideViewPort(true);
        webSettings.setDomStorageEnabled(true);

        showWv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                webViewPb.setVisibility(View.VISIBLE);
                mDialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webViewPb.setVisibility(View.GONE);
                mDialog.dismiss();
            }
        });
        showWv.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                webViewPb.setProgress(newProgress);
            }
        });

        //如果有网状态就加载 url

        if (NetWorkUtil.INSTANCE.isConnected()){
            if (v != null) {
                v.setVisibility(View.GONE);
            }
            showWv.loadUrl(url);
        }else {
            try {
                v = vsNetworkError.inflate();
                LinearLayout blankLl = v.findViewById(R.id.error_blank);
                blankLl.setOnClickListener(v1 -> {
                    showWv.reload();
                });
            } catch (Exception e) {
                e.printStackTrace();
                v.setVisibility(View.VISIBLE);
            }
        }

        backIv.setOnClickListener(v -> WebViewDialog.this.dismiss());

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
