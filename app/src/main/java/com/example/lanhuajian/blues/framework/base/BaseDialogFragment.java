package com.example.lanhuajian.blues.framework.base;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/**
 * User : Blues
 * Date : 2019/10/21
 * Time : 17:22
 */

public abstract class BaseDialogFragment<P extends BasePresenter> extends DialogFragment {

    public BaseActivity mContext;
    public P mPresenter;
    public View rootView;
    private Window window;

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

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        window = dialog.getWindow();

        if (getDisplayMetrics() != null) {
            setLayout(getDisplayMetrics().widthPixels, getDisplayMetrics().heightPixels / 2);
        }
        setGravity(Gravity.CENTER);
    }

    public DisplayMetrics getDisplayMetrics() {
        DisplayMetrics dm = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (getActivity() != null) {
                dm = new DisplayMetrics();
                getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(dm);
            }
        } else {
            dm = getResources().getDisplayMetrics();
        }
        return dm;
    }

    public void setLayout(int width, int height) {
        window.setLayout(width, height);
    }

    public void setGravity(int gravity) {
        window.setGravity(gravity);
    }

    public abstract void setListener();

    public abstract void initView();

    public abstract int setLayoutResourceId();
}
