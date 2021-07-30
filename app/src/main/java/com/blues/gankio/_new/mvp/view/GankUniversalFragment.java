package com.blues.gankio._new.mvp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.blues.R;
import com.blues.framework.base.BaseFragment;
import com.blues.gankio._new.mvp.model.GankCategory;
import com.blues.gankio._new.mvp.GankContract;
import com.blues.gankio._new.detail.GankPostComments;
import com.blues.gankio._new.detail.GankPostDetail;
import com.blues.gankio._new.hot.GankHotEntity;
import com.blues.gankio._new.mvp.model.GankBannerEntity;
import com.blues.gankio._new.mvp.model.GankUniversalEntity;
import com.blues.gankio._new.mvp.presenter.GankPresenter;
import com.blues.gankio._new.random.GankRandomEntity;
import com.blues.gankio._new.search.GankSearchResult;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;

public class GankUniversalFragment extends BaseFragment implements GankContract.iGankView {

    private SmartRefreshLayout srGank;
    private ViewStub networkVS;
    private View v;
    private GankContract.iGankPresenter iPresenter;
    private RecyclerArrayAdapter<GankUniversalEntity.DataBean> mAdapter;
    private String type;

    public GankUniversalFragment(String type) {
        this.type = type;
    }

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_gank_universal;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EasyRecyclerView ervGank = rootView.findViewById(R.id.rv_gank);
        srGank = rootView.findViewById(R.id.sr_gank);
        networkVS = rootView.findViewById(R.id.view_stub_network);
        //设置 Header 为 经典 样式 带最后刷新时间
        srGank.setRefreshHeader(new ClassicsHeader(getmContext()).setEnableLastTime(true));
        srGank.setEnableHeaderTranslationContent(true);

        mPresenter = new GankPresenter(this);

        //传入对应的type进行请求
        iPresenter.getCategoryPostList(type);

        ervGank.setLayoutManager(new LinearLayoutManager(getmContext()));
        ervGank.setAdapter(mAdapter = new RecyclerArrayAdapter<GankUniversalEntity.DataBean>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new GankViewHolder(parent);
            }
        });
        mAdapter.setMore(R.layout.view_loading_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                iPresenter.loadCategoryPostListMore(type);
            }

            @Override
            public void onMoreClick() {

            }
        });
        mAdapter.setNoMore(R.layout.view_load_no_more);
    }

    @Override
    public void lazyFetchData() {

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
}
