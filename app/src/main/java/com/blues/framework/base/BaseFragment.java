package com.blues.framework.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment {

    public BaseActivity mContext;
    public P mPresenter;
    private boolean hasFetchData;
    private boolean isViewPrepared;
    public View rootView;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if ((isVisibleToUser && isResumed())) {
            onResume();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {

            rootView = inflater.inflate(setLayoutResourceId(), container, false);
        }

        initLayout(inflater, container, savedInstanceState);

        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (mContext != null) {
            this.mContext = (BaseActivity) context;
        } else {
            this.mContext = (BaseActivity) getActivity();
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListener();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewPrepared = true;
        // 用户可见fragment && 没有加载过数据 && 视图已经准备完毕
        if (getUserVisibleHint() && !hasFetchData && isViewPrepared) {
            hasFetchData = true;
            lazyFetchData();
        }
    }

    @Override
    public void onDestroyView() {
        // view被销毁后，将可以重新触发数据懒加载，因为在viewpager下，fragment不会再次新建并走onCreate的生命周期流程，将从onCreateView开始
        hasFetchData = false;
        isViewPrepared = false;
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        if (mPresenter != null) {
            mPresenter.unSubscribe();
            mPresenter = null;
        }
        super.onDestroy();

        //启用leak canary
//        BluesApplication.getRefWatcher(getmContext()).watch(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    public BaseActivity getmContext() {
        return mContext;
    }

    public abstract int setLayoutResourceId();

    public abstract void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    public abstract void lazyFetchData();

    public void setListener() {
    }
}
