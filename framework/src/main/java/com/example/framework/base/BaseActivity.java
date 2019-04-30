package com.example.framework.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;

        //设置布局id
        setContentView(setLayoutResourceId());

        //加载视图控件
        initView(savedInstanceState);
        //设置监听
        setListener();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //当视图被销毁时presenter不为空，手动解除订阅
        if (mPresenter != null) {
            mPresenter.unSubscribe();
            mPresenter = null;
        }
    }

    public abstract int setLayoutResourceId();

    public abstract void initView(Bundle savedInstanceState);

    public abstract void setListener();
}
