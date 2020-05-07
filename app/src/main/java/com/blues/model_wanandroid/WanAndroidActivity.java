package com.blues.model_wanandroid;

import android.os.Bundle;
import android.view.ViewGroup;

import com.blues.R;
import com.blues.framework.base.BaseActivity;
import com.blues.model_wanandroid.netease.CategoryCourseEntity;
import com.blues.model_wanandroid.netease.CategoryEntity;
import com.blues.model_wanandroid.netease.MicroSpecEntity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;

public class WanAndroidActivity extends BaseActivity implements WanAndroidContract.iWanAndroidView {

    private WanAndroidContract.iWanAndroidPresenter iPresenter;
    private RecyclerArrayAdapter<WanAndroidEntity.DataBean.DatasBean> mAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_wanandroid;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mPresenter = new WanAndroidPresenter(this);
        iPresenter.initData();
        EasyRecyclerView ervMain = findViewById(R.id.erv_wanandroid);
        ervMain.setLayoutManager(new LinearLayoutManager(mContext));
        ervMain.setAdapter(mAdapter = new RecyclerArrayAdapter<WanAndroidEntity.DataBean.DatasBean>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new WanAndroidViewHolder(parent);
            }
        });
        mAdapter.setMore(R.layout.view_loading_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                iPresenter.onLoadMore();
            }

            @Override
            public void onMoreClick() {

            }
        });

        mAdapter.setNoMore(R.layout.view_load_no_more);
    }

    @Override
    public void setListener() {

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

    }

    @Override
    public void onBannerReqFailure(String result) {

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
}
