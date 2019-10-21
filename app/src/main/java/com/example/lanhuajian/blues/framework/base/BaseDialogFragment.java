package com.example.lanhuajian.blues.framework.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * User : Blues
 * Date : 2019/10/21
 * Time : 17:22
 */

public abstract class BaseDialogFragment<P extends BasePresenter> extends DialogFragment {

    public BaseActivity mContext;
    public P mPresenter;
    public View rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(setLayoutResourceId(), container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
        setListener();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.unSubscribe();
            mPresenter = null;
        }
        super.onDestroy();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (mContext != null) {
            this.mContext = (BaseActivity) context;
        } else {
            this.mContext = (BaseActivity) getActivity();
        }
    }


    public abstract void setListener();

    public abstract void initView();

    public abstract int setLayoutResourceId();
}
