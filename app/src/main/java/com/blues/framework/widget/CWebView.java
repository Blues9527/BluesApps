package com.blues.framework.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.HttpAuthHandler;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;

@SuppressWarnings("deprecation")
public class CWebView extends WebView {

    public interface Listener {
        void onPageStarted(String url, Bitmap favicon);

        void onPageLoading(int progress);

        void onPageFinished(String url);

        void onPageError(int errorCode, String description, String failingUrl);

        void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent);

        void onExternalPageRequest(String url);
    }

    protected static final int REQUEST_CODE_FILE_PICKER = 51426;
    protected static final String DATABASES_SUB_FOLDER = "/databases";
    protected static final String LANGUAGE_DEFAULT_ISO3 = "eng";
    protected static final String CHARSET_DEFAULT = "UTF-8";
    protected WeakReference<Activity> mActivity;
    protected WeakReference<Fragment> mFragment;
    protected Listener mListener;
    protected final List<String> mPermittedHostnames = new LinkedList<>();
    protected ValueCallback<Uri> mFileUploadCallbackFirst;
    protected ValueCallback<Uri[]> mFileUploadCallbackSecond;
    protected long mLastError;
    protected String mLanguageIso3;
    protected int mRequestCodeFilePicker = REQUEST_CODE_FILE_PICKER;
    protected WebViewClient mCustomWebViewClient;
    protected WebChromeClient mCustomWebChromeClient;
    protected boolean mGeolocationEnabled;
    protected String mUploadableFileTypes = "*/*";
    protected final Map<String, String> mHttpHeaders = new HashMap<String, String>();

    public CWebView(Context context) {
        super(context);
        init(context);
    }

    public CWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }


    @Override
    public void setWebViewClient(final WebViewClient client) {
        mCustomWebViewClient = client;
    }

    @Override
    public void setWebChromeClient(final WebChromeClient client) {
        mCustomWebChromeClient = client;
    }


    @SuppressLint("NewApi")
    @SuppressWarnings("all")
    public void onResume() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.onResume();
        }
        resumeTimers();
    }

    /**
     * 通知内核尝试停止所有处理，如动画和地理位置，但是不能停止Js，如果想全局停止Js，
     * 可以调用pauseTimers()全局停止Js，调用onResume()恢复。
     */
    @SuppressLint("NewApi")
    @SuppressWarnings("all")
    public void onPause() {
        pauseTimers();
        if (Build.VERSION.SDK_INT >= 11) {
            super.onPause();
        }
    }

    @SuppressLint("NewApi")
    protected static void setAllowAccessFromFileUrls(final WebSettings webSettings, final boolean allowed) {
        if (Build.VERSION.SDK_INT >= 16) {
            webSettings.setAllowFileAccessFromFileURLs(allowed);
            webSettings.setAllowUniversalAccessFromFileURLs(allowed);
        }
    }

    @SuppressWarnings("static-method")
    public void setCookiesEnabled(final boolean enabled) {
        CookieManager.getInstance().setAcceptCookie(enabled);
    }

    @SuppressLint("NewApi")
    public void setThirdPartyCookiesEnabled(final boolean enabled) {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(this, enabled);
        }
    }

    @SuppressWarnings("static-method")
    @SuppressLint("NewApi")
    protected void setMixedContentAllowed(final WebSettings webSettings, final boolean allowed) {
        if (Build.VERSION.SDK_INT >= 21) {
            webSettings.setMixedContentMode(allowed ? WebSettings.MIXED_CONTENT_ALWAYS_ALLOW : WebSettings.MIXED_CONTENT_NEVER_ALLOW);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected void init(Context context) {
        // in IDE's preview mode
        if (isInEditMode()) {
            // do not run the code from this method
            return;
        }

        if (context instanceof Activity) {
            mActivity = new WeakReference<>((Activity) context);
        }

        mLanguageIso3 = getLanguageIso3();

        setFocusable(true);
        setFocusableInTouchMode(true);

        setSaveEnabled(true);

        final String filesDir = context.getFilesDir().getPath();
        final String databaseDir = filesDir.substring(0, filesDir.lastIndexOf("/")) + DATABASES_SUB_FOLDER;

        final WebSettings webSettings = getSettings();
        webSettings.setAllowFileAccess(false);
        setAllowAccessFromFileUrls(webSettings, false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setJavaScriptEnabled(true);
        //设置 缓存模式
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        //开启 DOM storage API 功能
        webSettings.setDomStorageEnabled(true);

        if (Build.VERSION.SDK_INT < 18) {
            webSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        }
        webSettings.setDatabaseEnabled(true);
        if (Build.VERSION.SDK_INT < 19) {
            webSettings.setDatabasePath(databaseDir);
        }
        setMixedContentAllowed(webSettings, true);

        setCookiesEnabled(true);

        setThirdPartyCookiesEnabled(true);

        //加快HTML网页加载完成的速度，等页面finish再加载图片
        webSettings.setLoadsImagesAutomatically(Build.VERSION.SDK_INT >= 19);

        String userAgentString = webSettings.getUserAgentString().replace("Mobile", "RSMobile").replace("Android", "RSClient");
        webSettings.setUserAgentString(userAgentString);

        //电脑网页适应手机屏幕
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        super.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                if (!hasError()) {
                    if (mListener != null) {
                        mListener.onPageStarted(url, favicon);
                    }
                }

                if (mCustomWebViewClient != null) {
                    mCustomWebViewClient.onPageStarted(view, url, favicon);
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if (!hasError()) {
                    if (!getSettings().getLoadsImagesAutomatically()) {
                        getSettings().setLoadsImagesAutomatically(true);
                    }
                    if (mListener != null) {
                        mListener.onPageFinished(url);
                    }
                }

                if (mCustomWebViewClient != null) {
                    mCustomWebViewClient.onPageFinished(view, url);
                }
            }

            /**
             * 处理网页加载失败
             */
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                //6.0以下执行
                setLastError();

                //清除掉默认错误页内容
                loadDataWithBaseURL(null, "", "text/html", "utf-8", null);

                if (mListener != null) {
                    mListener.onPageError(errorCode, description, failingUrl);
                }

                if (mCustomWebViewClient != null) {
                    mCustomWebViewClient.onReceivedError(view, errorCode, description, failingUrl);
                }
            }

            /**
             * 处理网页加载失败
             */
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                //6.0以上执行
                setLastError();

                if (mListener != null) {
                    mListener.onPageError(error.getErrorCode(), error.getDescription().toString(), request.getUrl().toString());
                }

                if (mCustomWebViewClient != null) {
                    mCustomWebViewClient.onReceivedError(view, error.getErrorCode(), error.getDescription().toString(), request.getUrl().toString());
                }
            }

            @Override
            public boolean shouldOverrideUrlLoading(final WebView view, final String url) {
                // if the hostname may not be accessed
                if (!isHostnameAllowed(url)) {
                    // if a listener is available
                    if (mListener != null) {
                        // inform the listener about the request
                        mListener.onExternalPageRequest(url);
                    }

                    // cancel the original request
                    return true;
                }

                // if there is a user-specified handler available
                if (mCustomWebViewClient != null) {
                    // if the user-specified handler asks to override the request
                    if (mCustomWebViewClient.shouldOverrideUrlLoading(view, url)) {
                        // cancel the original request
                        return true;
                    }
                }

                // route the request through the custom URL loading method
                view.loadUrl(url);

                // cancel the original request
                return true;
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                if (mCustomWebViewClient != null) {
                    mCustomWebViewClient.onLoadResource(view, url);
                } else {
                    super.onLoadResource(view, url);
                }
            }

            @SuppressLint("NewApi")
            @SuppressWarnings("all")
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                if (Build.VERSION.SDK_INT >= 11) {
                    if (mCustomWebViewClient != null) {
                        return mCustomWebViewClient.shouldInterceptRequest(view, url);
                    } else {
                        return super.shouldInterceptRequest(view, url);
                    }
                } else {
                    return null;
                }
            }

            @SuppressLint("NewApi")
            @SuppressWarnings("all")
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (mCustomWebViewClient != null) {
                        return mCustomWebViewClient.shouldInterceptRequest(view, request);
                    } else {
                        return super.shouldInterceptRequest(view, request);
                    }
                } else {
                    return null;
                }
            }

            @Override
            public void onFormResubmission(WebView view, Message dontResend, Message resend) {
                if (mCustomWebViewClient != null) {
                    mCustomWebViewClient.onFormResubmission(view, dontResend, resend);
                } else {
                    super.onFormResubmission(view, dontResend, resend);
                }
            }

            @Override
            public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
                if (mCustomWebViewClient != null) {
                    mCustomWebViewClient.doUpdateVisitedHistory(view, url, isReload);
                } else {
                    super.doUpdateVisitedHistory(view, url, isReload);
                }
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                //super.onReceivedSslError(view, handler, error);注意一定要去除这行代码，否则设置无效。
                //handler.cancel();// Android默认的处理方式
                handler.proceed();// 接受所有网站的证书
                //handleMessage(Message msg);// 进行其他处理
                if (mCustomWebViewClient != null) {
                    mCustomWebViewClient.onReceivedSslError(view, handler, error);
                }
            }

            @SuppressLint("NewApi")
            @SuppressWarnings("all")
            public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (mCustomWebViewClient != null) {
                        mCustomWebViewClient.onReceivedClientCertRequest(view, request);
                    } else {
                        super.onReceivedClientCertRequest(view, request);
                    }
                }
            }

            @Override
            public void onReceivedHttpAuthRequest(WebView view, HttpAuthHandler handler, String host, String realm) {
                if (mCustomWebViewClient != null) {
                    mCustomWebViewClient.onReceivedHttpAuthRequest(view, handler, host, realm);
                } else {
                    super.onReceivedHttpAuthRequest(view, handler, host, realm);
                }
            }

            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                if (mCustomWebViewClient != null) {
                    return mCustomWebViewClient.shouldOverrideKeyEvent(view, event);
                } else {
                    return super.shouldOverrideKeyEvent(view, event);
                }
            }

            @Override
            public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
                if (mCustomWebViewClient != null) {
                    mCustomWebViewClient.onUnhandledKeyEvent(view, event);
                } else {
                    super.onUnhandledKeyEvent(view, event);
                }
            }

            @SuppressLint("NewApi")
            @SuppressWarnings("all")
            public void onUnhandledInputEvent(WebView view, InputEvent event) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (mCustomWebViewClient != null) {
                        //						mCustomWebViewClient.onUnhandledInputEvent(view, event);
                    } else {
                        //						super.onUnhandledInputEvent(view, event);
                    }
                }
            }

            @Override
            public void onScaleChanged(WebView view, float oldScale, float newScale) {
                if (mCustomWebViewClient != null) {
                    mCustomWebViewClient.onScaleChanged(view, oldScale, newScale);
                } else {
                    super.onScaleChanged(view, oldScale, newScale);
                }
            }

            @SuppressLint("NewApi")
            @SuppressWarnings("all")
            public void onReceivedLoginRequest(WebView view, String realm, String account, String args) {
                if (Build.VERSION.SDK_INT >= 12) {
                    if (mCustomWebViewClient != null) {
                        mCustomWebViewClient.onReceivedLoginRequest(view, realm, account, args);
                    } else {
                        super.onReceivedLoginRequest(view, realm, account, args);
                    }
                }
            }

        });

        super.setWebChromeClient(new WebChromeClient() {

            // file upload callback (Android 2.2 (API level 8) -- Android 2.3 (API level 10)) (hidden method)
            @SuppressWarnings("unused")
            public void openFileChooser(ValueCallback<Uri> uploadMsg) {
                openFileChooser(uploadMsg, null);
            }

            // file upload callback (Android 3.0 (API level 11) -- Android 4.0 (API level 15)) (hidden method)
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
                openFileChooser(uploadMsg, acceptType, null);
            }

            // file upload callback (Android 4.1 (API level 16) -- Android 4.3 (API level 18)) (hidden method)
            @SuppressWarnings("unused")
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
                openFileInput(uploadMsg, null, false);
            }

            // file upload callback (Android 5.0 (API level 21) -- current) (public method)
            @SuppressWarnings("all")
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
                if (Build.VERSION.SDK_INT >= 21) {
                    final boolean allowMultiple = fileChooserParams.getMode() == FileChooserParams.MODE_OPEN_MULTIPLE;

                    openFileInput(null, filePathCallback, allowMultiple);

                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (mListener != null) {
                    mListener.onPageLoading(newProgress);
                }
                if (mCustomWebChromeClient != null) {
                    mCustomWebChromeClient.onProgressChanged(view, newProgress);
                } else {
                    super.onProgressChanged(view, newProgress);
                }
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                if (mCustomWebChromeClient != null) {
                    mCustomWebChromeClient.onReceivedTitle(view, title);
                } else {
                    super.onReceivedTitle(view, title);
                }
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                if (mCustomWebChromeClient != null) {
                    mCustomWebChromeClient.onReceivedIcon(view, icon);
                } else {
                    super.onReceivedIcon(view, icon);
                }
            }

            @Override
            public void onReceivedTouchIconUrl(WebView view, String url, boolean precomposed) {
                if (mCustomWebChromeClient != null) {
                    mCustomWebChromeClient.onReceivedTouchIconUrl(view, url, precomposed);
                } else {
                    super.onReceivedTouchIconUrl(view, url, precomposed);
                }
            }

            @Override
            public void onShowCustomView(View view, CustomViewCallback callback) {
                if (mCustomWebChromeClient != null) {
                    mCustomWebChromeClient.onShowCustomView(view, callback);
                } else {
                    super.onShowCustomView(view, callback);
                }
            }

            @SuppressLint("NewApi")
            @SuppressWarnings("all")
            public void onShowCustomView(View view, int requestedOrientation, CustomViewCallback callback) {
                if (Build.VERSION.SDK_INT >= 14) {
                    if (mCustomWebChromeClient != null) {
                        mCustomWebChromeClient.onShowCustomView(view, requestedOrientation, callback);
                    } else {
                        super.onShowCustomView(view, requestedOrientation, callback);
                    }
                }
            }

            @Override
            public void onHideCustomView() {
                if (mCustomWebChromeClient != null) {
                    mCustomWebChromeClient.onHideCustomView();
                } else {
                    super.onHideCustomView();
                }
            }

            @Override
            public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
                if (mCustomWebChromeClient != null) {
                    return mCustomWebChromeClient.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
                } else {
                    return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
                }
            }

            @Override
            public void onRequestFocus(WebView view) {
                if (mCustomWebChromeClient != null) {
                    mCustomWebChromeClient.onRequestFocus(view);
                } else {
                    super.onRequestFocus(view);
                }
            }

            @Override
            public void onCloseWindow(WebView window) {
                if (mCustomWebChromeClient != null) {
                    mCustomWebChromeClient.onCloseWindow(window);
                } else {
                    super.onCloseWindow(window);
                }
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                if (mCustomWebChromeClient != null) {
                    return mCustomWebChromeClient.onJsAlert(view, url, message, result);
                } else {
                    return super.onJsAlert(view, url, message, result);
                }
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                if (mCustomWebChromeClient != null) {
                    return mCustomWebChromeClient.onJsConfirm(view, url, message, result);
                } else {
                    return super.onJsConfirm(view, url, message, result);
                }
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                if (mCustomWebChromeClient != null) {
                    return mCustomWebChromeClient.onJsPrompt(view, url, message, defaultValue, result);
                } else {
                    return super.onJsPrompt(view, url, message, defaultValue, result);
                }
            }

            @Override
            public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
                if (mCustomWebChromeClient != null) {
                    return mCustomWebChromeClient.onJsBeforeUnload(view, url, message, result);
                } else {
                    return super.onJsBeforeUnload(view, url, message, result);
                }
            }

            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, Callback callback) {
                if (mGeolocationEnabled) {
                    callback.invoke(origin, true, false);
                } else {
                    if (mCustomWebChromeClient != null) {
                        mCustomWebChromeClient.onGeolocationPermissionsShowPrompt(origin, callback);
                    } else {
                        super.onGeolocationPermissionsShowPrompt(origin, callback);
                    }
                }
            }

            @Override
            public void onGeolocationPermissionsHidePrompt() {
                if (mCustomWebChromeClient != null) {
                    mCustomWebChromeClient.onGeolocationPermissionsHidePrompt();
                } else {
                    super.onGeolocationPermissionsHidePrompt();
                }
            }

            @SuppressLint("NewApi")
            @SuppressWarnings("all")
            public void onPermissionRequest(PermissionRequest request) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (mCustomWebChromeClient != null) {
                        mCustomWebChromeClient.onPermissionRequest(request);
                    } else {
                        super.onPermissionRequest(request);
                    }
                }
            }

            @SuppressLint("NewApi")
            @SuppressWarnings("all")
            public void onPermissionRequestCanceled(PermissionRequest request) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (mCustomWebChromeClient != null) {
                        mCustomWebChromeClient.onPermissionRequestCanceled(request);
                    } else {
                        super.onPermissionRequestCanceled(request);
                    }
                }
            }

            @Override
            public boolean onJsTimeout() {
                if (mCustomWebChromeClient != null) {
                    return mCustomWebChromeClient.onJsTimeout();
                } else {
                    return super.onJsTimeout();
                }
            }

            @Override
            public void onConsoleMessage(String message, int lineNumber, String sourceID) {
                if (mCustomWebChromeClient != null) {
                    mCustomWebChromeClient.onConsoleMessage(message, lineNumber, sourceID);
                } else {
                    super.onConsoleMessage(message, lineNumber, sourceID);
                }
            }

            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                if (mCustomWebChromeClient != null) {
                    return mCustomWebChromeClient.onConsoleMessage(consoleMessage);
                } else {
                    return super.onConsoleMessage(consoleMessage);
                }
            }

            @Override
            public Bitmap getDefaultVideoPoster() {
                if (mCustomWebChromeClient != null) {
                    return mCustomWebChromeClient.getDefaultVideoPoster();
                } else {
                    return super.getDefaultVideoPoster();
                }
            }

            @Override
            public View getVideoLoadingProgressView() {
                if (mCustomWebChromeClient != null) {
                    return mCustomWebChromeClient.getVideoLoadingProgressView();
                } else {
                    return super.getVideoLoadingProgressView();
                }
            }

            @Override
            public void getVisitedHistory(ValueCallback<String[]> callback) {
                if (mCustomWebChromeClient != null) {
                    mCustomWebChromeClient.getVisitedHistory(callback);
                } else {
                    super.getVisitedHistory(callback);
                }
            }

            @Override
            public void onExceededDatabaseQuota(String url, String databaseIdentifier, long quota, long estimatedDatabaseSize, long totalQuota, QuotaUpdater quotaUpdater) {
                if (mCustomWebChromeClient != null) {
                    mCustomWebChromeClient.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize, totalQuota, quotaUpdater);
                } else {
                    super.onExceededDatabaseQuota(url, databaseIdentifier, quota, estimatedDatabaseSize, totalQuota, quotaUpdater);
                }
            }

            @Override
            public void onReachedMaxAppCacheSize(long requiredStorage, long quota, QuotaUpdater quotaUpdater) {
                if (mCustomWebChromeClient != null) {
                    mCustomWebChromeClient.onReachedMaxAppCacheSize(requiredStorage, quota, quotaUpdater);
                } else {
                    super.onReachedMaxAppCacheSize(requiredStorage, quota, quotaUpdater);
                }
            }

        });

        setDownloadListener((url, userAgent, contentDisposition, mimeType, contentLength) -> {
            final String suggestedFilename = URLUtil.guessFileName(url, contentDisposition, mimeType);

            if (mListener != null) {
                mListener.onDownloadRequested(url, suggestedFilename, mimeType, contentLength, contentDisposition, userAgent);
            }
        });
    }

    @Override
    public void loadUrl(final String url, Map<String, String> additionalHttpHeaders) {
        if (additionalHttpHeaders == null) {
            additionalHttpHeaders = mHttpHeaders;
        } else if (mHttpHeaders.size() > 0) {
            additionalHttpHeaders.putAll(mHttpHeaders);
        }

        super.loadUrl(url, additionalHttpHeaders);
    }

    @Override
    public void loadUrl(final String url) {
        if (mHttpHeaders.size() > 0) {
            super.loadUrl(url, mHttpHeaders);
        } else {
            super.loadUrl(url);
        }
    }

    protected boolean isHostnameAllowed(final String url) {
        // if the permitted hostnames have not been restricted to a specific set
        if (mPermittedHostnames.size() == 0) {
            // all hostnames are allowed
            return true;
        }

        // get the actual hostname of the URL that is to be checked
        final String actualHost = Uri.parse(url).getHost();

        // for every hostname in the set of permitted hosts
        for (String expectedHost : mPermittedHostnames) {
            // if the two hostnames match or if the actual host is a subdomain of the expected host
            if (actualHost.equals(expectedHost) || actualHost.endsWith("." + expectedHost)) {
                // the actual hostname of the URL to be checked is allowed
                return true;
            }
        }

        // the actual hostname of the URL to be checked is not allowed since there were no matches
        return false;
    }

    protected void setLastError() {
        mLastError = System.currentTimeMillis();
    }

    protected boolean hasError() {
        return (mLastError + 500) >= System.currentTimeMillis();
    }

    protected static String getLanguageIso3() {
        try {
            return Locale.getDefault().getISO3Language().toLowerCase(Locale.US);
        } catch (MissingResourceException e) {
            return LANGUAGE_DEFAULT_ISO3;
        }
    }

    /**
     * Provides localizations for the 25 most widely spoken languages that have a ISO 639-2/T code
     *
     * @return the label for the file upload prompts as a string
     */
    protected String getFileUploadPromptLabel() {
        try {
            if (mLanguageIso3.equals("zho")) return decodeBase64("6YCJ5oup5LiA5Liq5paH5Lu2");
            else if (mLanguageIso3.equals("spa")) return decodeBase64("RWxpamEgdW4gYXJjaGl2bw==");
            else if (mLanguageIso3.equals("hin"))
                return decodeBase64("4KSP4KSVIOCkq+CkvOCkvuCkh+CksiDgpJrgpYHgpKjgpYfgpII=");
            else if (mLanguageIso3.equals("ben"))
                return decodeBase64("4KaP4KaV4Kaf4Ka/IOCmq+CmvuCmh+CmsiDgpqjgpr/gprDgp43gpqzgpr7gpprgpqg=");
            else if (mLanguageIso3.equals("ara"))
                return decodeBase64("2KfYrtiq2YrYp9ixINmF2YTZgSDZiNin2K3Yrw==");
            else if (mLanguageIso3.equals("por")) return decodeBase64("RXNjb2xoYSB1bSBhcnF1aXZv");
            else if (mLanguageIso3.equals("rus"))
                return decodeBase64("0JLRi9Cx0LXRgNC40YLQtSDQvtC00LjQvSDRhNCw0LnQuw==");
            else if (mLanguageIso3.equals("jpn"))
                return decodeBase64("MeODleOCoeOCpOODq+OCkumBuOaKnuOBl+OBpuOBj+OBoOOBleOBhA==");
            else if (mLanguageIso3.equals("pan"))
                return decodeBase64("4KiH4Kmx4KiVIOCoq+CovuCoh+CosiDgqJrgqYHgqKPgqYs=");
            else if (mLanguageIso3.equals("deu")) return decodeBase64("V8OkaGxlIGVpbmUgRGF0ZWk=");
            else if (mLanguageIso3.equals("jav")) return decodeBase64("UGlsaWggc2lqaSBiZXJrYXM=");
            else if (mLanguageIso3.equals("msa")) return decodeBase64("UGlsaWggc2F0dSBmYWls");
            else if (mLanguageIso3.equals("tel"))
                return decodeBase64("4LCS4LCVIOCwq+CxhuCxluCwsuCxjeCwqOCxgSDgsI7gsILgsJrgsYHgsJXgsYvgsILgsKHgsL8=");
            else if (mLanguageIso3.equals("vie"))
                return decodeBase64("Q2jhu41uIG3hu5l0IHThuq1wIHRpbg==");
            else if (mLanguageIso3.equals("kor"))
                return decodeBase64("7ZWY64KY7J2YIO2MjOydvOydhCDshKDtg50=");
            else if (mLanguageIso3.equals("fra"))
                return decodeBase64("Q2hvaXNpc3NleiB1biBmaWNoaWVy");
            else if (mLanguageIso3.equals("mar"))
                return decodeBase64("4KSr4KS+4KSH4KSyIOCkqOCkv+CkteCkoeCkvg==");
            else if (mLanguageIso3.equals("tam"))
                return decodeBase64("4K6S4K6w4K+BIOCuleCvh+CuvuCuquCvjeCuquCviCDgrqTgr4fgrrDgr43grrXgr4E=");
            else if (mLanguageIso3.equals("urd"))
                return decodeBase64("2KfbjNqpINmB2KfYptmEINmF24zauiDYs9uSINin2YbYqtiu2KfYqCDaqdix24zaug==");
            else if (mLanguageIso3.equals("fas"))
                return decodeBase64("2LHYpyDYp9mG2KrYrtin2Kgg2qnZhtuM2K8g24zaqSDZgdin24zZhA==");
            else if (mLanguageIso3.equals("tur")) return decodeBase64("QmlyIGRvc3lhIHNlw6dpbg==");
            else if (mLanguageIso3.equals("ita")) return decodeBase64("U2NlZ2xpIHVuIGZpbGU=");
            else if (mLanguageIso3.equals("tha"))
                return decodeBase64("4LmA4Lil4Li34Lit4LiB4LmE4Lif4Lil4LmM4Lir4LiZ4Li24LmI4LiH");
            else if (mLanguageIso3.equals("guj"))
                return decodeBase64("4KqP4KqVIOCqq+CqvuCqh+CqsuCqqOCrhyDgqqrgqrjgqoLgqqY=");
        } catch (Exception ignored) {
        }

        // return English translation by default
        return "Choose a file";
    }

    protected static String decodeBase64(final String base64) throws IllegalArgumentException, UnsupportedEncodingException {
        final byte[] bytes = Base64.decode(base64, Base64.DEFAULT);
        return new String(bytes, CHARSET_DEFAULT);
    }

    @SuppressLint("NewApi")
    protected void openFileInput(final ValueCallback<Uri> fileUploadCallbackFirst, final ValueCallback<Uri[]> fileUploadCallbackSecond, final boolean allowMultiple) {
        if (mFileUploadCallbackFirst != null) {
            mFileUploadCallbackFirst.onReceiveValue(null);
        }
        mFileUploadCallbackFirst = fileUploadCallbackFirst;

        if (mFileUploadCallbackSecond != null) {
            mFileUploadCallbackSecond.onReceiveValue(null);
        }
        mFileUploadCallbackSecond = fileUploadCallbackSecond;

        Intent i = new Intent(Intent.ACTION_GET_CONTENT);
        i.addCategory(Intent.CATEGORY_OPENABLE);

        if (allowMultiple) {
            if (Build.VERSION.SDK_INT >= 18) {
                i.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            }
        }

        i.setType(mUploadableFileTypes);

        if (mFragment != null && mFragment.get() != null && Build.VERSION.SDK_INT >= 11) {
            mFragment.get().startActivityForResult(Intent.createChooser(i, getFileUploadPromptLabel()), mRequestCodeFilePicker);
        } else if (mActivity != null && mActivity.get() != null) {
            mActivity.get().startActivityForResult(Intent.createChooser(i, getFileUploadPromptLabel()), mRequestCodeFilePicker);
        }
    }

    /**
     * 解决ViewPager里非首屏WebView点击事件不响应
     */
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            onScrollChanged(getScrollX(), getScrollY(), getScrollX(), getScrollY());
        }
        return super.onTouchEvent(ev);
    }

    private float startX;
    private float startY;
    private float mTouchSlop = 10;

    /**
     * 解决WebView嵌套横向控件所引起的滑动冲突问题
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                startY = ev.getY();
                startX = ev.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                float endY = ev.getY();
                float endX = ev.getX();
                float distanceX = Math.abs(endX - startX);
                float distanceY = Math.abs(endY - startY);
                if (distanceX > mTouchSlop && distanceX > distanceY) {
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

}
