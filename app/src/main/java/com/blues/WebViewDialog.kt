package com.blues

import android.app.Dialog
import android.content.Context
import com.blues.framework.utils.NetWorkUtil.isConnected
import com.blues.framework.widget.CWebView
import android.view.ViewStub
import android.os.Bundle
import android.webkit.WebViewClient
import android.graphics.Bitmap
import android.graphics.Color
import android.webkit.WebChromeClient
import android.widget.LinearLayout
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.webkit.WebView
import android.widget.ImageView
import android.widget.ProgressBar
import java.lang.Exception

class WebViewDialog(context: Context, private val url: String) : Dialog(context) {

    private lateinit var showWv: WebView
    private lateinit var webViewPb: ProgressBar
    private lateinit var backIv: ImageView
    private lateinit var mDialog: LoadingDialog
    private lateinit var vsNetworkError: ViewStub

    private var v: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //初始化窗口属性
        initWindowAttribute()

        //设置视图
        setContentView(R.layout.dialog_webview)

        //设置是否可撤销
        setCancelable(true)

        //设置触摸外部是否可撤销
        setCanceledOnTouchOutside(true)

        initView()
    }

    private fun initView() {

        showWv = findViewById(R.id.wv_show)
        vsNetworkError = findViewById(R.id.vs_network)
        mDialog = LoadingDialog(context)
        backIv = findViewById(R.id.iv_back)
        webViewPb = findViewById(R.id.pb_webview)


        showWv.settings.apply {
            loadWithOverviewMode = true // 缩放至屏幕的大小
            loadsImagesAutomatically = true //支持自动加载图片
            builtInZoomControls = true //设置支持缩放
            supportZoom()
            useWideViewPort = true
            domStorageEnabled = true
        }


        showWv.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                webViewPb.visibility = View.VISIBLE
                mDialog.show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                webViewPb.visibility = View.GONE
                mDialog.dismiss()
            }
        }
        showWv.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                webViewPb.progress = newProgress
            }
        }

        //如果有网状态就加载 url
        if (isConnected) {
            v?.visibility = View.GONE
            showWv.loadUrl(url)
        } else {
            try {
                v = vsNetworkError.inflate()
                val blankLl = v?.findViewById<LinearLayout>(R.id.error_blank)
                blankLl?.setOnClickListener { showWv.reload() }
            } catch (e: Exception) {
                e.printStackTrace()
                v?.visibility = View.VISIBLE
            }
        }
        backIv.setOnClickListener { dismiss() }
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