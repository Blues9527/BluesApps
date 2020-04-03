package com.blues.framework.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.blues.R;
import com.blues.framework.widget.immersionbar.ImmersionBar;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 * Desc: 所有activity类都需要去继承此基类
 */

// TODO: 2019/3/5  全局绑定butterknife、注册Eventbus等操作

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P mPresenter;
    public BaseActivity mContext;
    private static final String TAG = "Blues";
    private Toast mToast;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme(R.style.Theme_Custom);
        super.onCreate(savedInstanceState);

        mContext = this;

        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }

        //设置布局id
        setContentView(setLayoutResourceId());

        //加载视图控件
        initView(savedInstanceState);
        //设置监听
        setListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        immersionInit();
    }

    @Override
    protected void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //启用leak canary
//        BluesApplication.getRefWatcher(this).watch(this);

        //当视图被销毁时presenter不为空，手动解除订阅
        if (mPresenter != null) {
            mPresenter.unSubscribe();
            mPresenter = null;
        }
    }

    @Override
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }

    public void immersionInit() {
        //安卓系统低于6.0,不进行换色
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }
        ImmersionBar.with(mContext)
                .transparentBar()
                .fitsSystemWindows(true)
                .statusBarColorRes(R.color.color_transparent)
                .statusBarColorTransformRes(R.color.color_transparent)
                .statusBarDarkFont(true)
                .init();
    }


    /**
     * 方便父类打印日志
     *
     * @param msg
     */
    protected void showLog(String msg) {
        Log.i(getTag(), msg);
    }

    /**
     * 方便父类toast消息
     *
     * @param msg
     */
    protected void showToast(String msg) {
        if (mToast == null) {
            mToast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(msg);
        }
        mToast.show();
    }

    /**
     * 默认打印tag为blues，可重写此方法去修改tag
     *
     * @return
     */
    protected String getTag() {
        return TAG;
    }


    public abstract int setLayoutResourceId();

    public abstract void initView(Bundle savedInstanceState);

    public abstract void setListener();
}
