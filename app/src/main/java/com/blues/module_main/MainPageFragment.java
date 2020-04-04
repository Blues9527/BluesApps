package com.blues.module_main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.blues.R;
import com.blues.framework.base.BaseFragment;
import com.blues.model_wanandroid.WanAndroidBannerEntity;
import com.blues.model_wanandroid.WanAndroidContract;
import com.blues.model_wanandroid.WanAndroidEntity;
import com.blues.model_wanandroid.WanAndroidPresenter;
import com.blues.model_wanandroid.WanAndroidViewHolder;
import com.blues.model_wanandroid.netease.CategoryCourseEntity;
import com.blues.model_wanandroid.netease.CategoryEntity;
import com.blues.model_wanandroid.netease.MicroSpecEntity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:27
 */

public class MainPageFragment extends BaseFragment implements WanAndroidContract.iWanAndroidView {

    private WanAndroidContract.iWanAndroidPresenter iPresenter;
    private MainPageHeaderView mHeader;
    private RecyclerArrayAdapter<WanAndroidEntity.DataBean.DatasBean> mAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_mainpage;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPresenter = new WanAndroidPresenter(this);

        iPresenter.initData();

        EasyRecyclerView ervMain = rootView.findViewById(R.id.erv_main);
        ervMain.setLayoutManager(new LinearLayoutManager(mContext));
        ervMain.setAdapter(mAdapter = new RecyclerArrayAdapter<WanAndroidEntity.DataBean.DatasBean>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new WanAndroidViewHolder(parent);
            }
        });
        mAdapter.addHeader(mHeader = new MainPageHeaderView(mContext));
    }


    @Override
    public void lazyFetchData() {
    }

    @Override
    public void setListener() {
    }

    @Override
    public void onFetchMicroSuccess(MicroSpecEntity microSpec) {

    }

    @Override
    public void onFetchMicroFailed(String msg) {

    }

    @Override
    public void onFetchCategorySuccess(CategoryEntity category) {

    }

    @Override
    public void onFetchCategoryFailed(String msg) {

    }

    @Override
    public void onFetchCategoryCourseSuccess(CategoryCourseEntity categoryCourse) {

    }

    @Override
    public void onFetchCategoryCourseFailed(String msg) {

    }

    @Override
    public void setPresenter(WanAndroidContract.iWanAndroidPresenter presenter) {
        iPresenter = presenter;
    }

    @Override
    public void showBegin() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showFinished() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void onPause() {
        super.onPause();
        mHeader.onBannerPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mHeader.onBannerResume();
    }


    @Override
    public void showWanAndroidPostList(List<WanAndroidEntity.DataBean.DatasBean> wanAndroidList) {
        if (wanAndroidList != null) {
            mAdapter.addAll(wanAndroidList);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showRequestError(String msg) {

    }

    @Override
    public void onBannerReqSuccess(WanAndroidBannerEntity banner) {
        if (banner != null) {
            mHeader.initBanner(mContext, banner);
        }
    }

    @Override
    public void onBannerReqFailure(String result) {

    }
}
