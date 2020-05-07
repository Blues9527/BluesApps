package com.blues.module_gank._new.girl;

import android.os.Bundle;
import android.view.ViewGroup;

import com.blues.R;
import com.blues.framework.base.BaseActivity;
import com.blues.module_gank._new.detail.GankPostComments;
import com.blues.module_gank._new.detail.GankPostDetail;
import com.blues.module_gank._new.hot.GankHotEntity;
import com.blues.module_gank._new.mvp.GankConstant;
import com.blues.module_gank._new.mvp.GankContract;
import com.blues.module_gank._new.mvp.model.GankBannerEntity;
import com.blues.module_gank._new.mvp.model.GankCategory;
import com.blues.module_gank._new.mvp.model.GankUniversalEntity;
import com.blues.module_gank._new.mvp.presenter.GankPresenter;
import com.blues.module_gank._new.random.GankRandomEntity;
import com.blues.module_gank._new.search.GankSearchResult;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;

public class GankGirlActivity extends BaseActivity implements GankContract.iGankView, OnRefreshListener {

    private GankContract.iGankPresenter iPresenter;
    private RecyclerArrayAdapter<GankUniversalEntity.DataBean> mAdapter;
    private SmartRefreshLayout srGirl;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_gank_girl;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        mPresenter = new GankPresenter(this);
        iPresenter.getCategoryPostList(GankConstant.GIRL, GankConstant.GIRL);

        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        EasyRecyclerView ervGirl = findViewById(R.id.erv_gank_girls);
        pagerSnapHelper.attachToRecyclerView(ervGirl.getRecyclerView());
        srGirl = findViewById(R.id.sr_gank_girl);
        //设置 Header 为 经典 样式 带最后刷新时间
        srGirl.setRefreshHeader(new ClassicsHeader(mContext).setEnableLastTime(true));
        srGirl.setEnableHeaderTranslationContent(true);
        ervGirl.setLayoutManager(new LinearLayoutManager(mContext));
        ervGirl.setAdapter(mAdapter = new RecyclerArrayAdapter<GankUniversalEntity.DataBean>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new GankGirlsViewHolder(parent);
            }
        });
        mAdapter.setMore(R.layout.view_loading_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                iPresenter.loadCategoryPostListMore(GankConstant.GIRL, GankConstant.GIRL);
            }

            @Override
            public void onMoreClick() {

            }
        });

        mAdapter.setNoMore(R.layout.view_load_no_more);
    }

    @Override
    public void setListener() {
        srGirl.setEnableRefresh(true);
        srGirl.setOnRefreshListener(this);
    }

    @Override
    public void setBanner(List<GankBannerEntity.DataBean> banner) {

    }

    @Override
    public void setCategory(List<GankCategory.DataBean> category) {

    }

    @Override
    public void setPostList(List<GankUniversalEntity.DataBean> postList) {
        mAdapter.addAll(postList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setRandomPostList(List<GankRandomEntity.DataBean> randomPostList) {

    }

    @Override
    public void setPostDetail(GankPostDetail.DataBean postDetail) {

    }

    @Override
    public void setPostHotList(List<GankHotEntity.DataBean> hotList) {

    }

    @Override
    public void setPostComments(GankPostComments comments) {

    }

    @Override
    public void setSearchContents(List<GankSearchResult.DataBean> searchContents) {

    }

    @Override
    public void setPresenter(GankContract.iGankPresenter presenter) {
        iPresenter = presenter;
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    public void showFinished() {
        srGirl.finishRefresh();
    }
}
