package com.blues.module_gank.old.model_web.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;

import com.blues.R;
import com.blues.framework.base.BaseFragment;
import com.blues.module_gank.old.model_web.WebContract;
import com.blues.module_gank.old.model_web.model.WebEntity;
import com.blues.module_gank.old.model_web.presenter.WebPresenter;
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

public class WebFragment extends BaseFragment implements WebContract.iContractView, OnRefreshListener {

    private SmartRefreshLayout webSr;
    private ViewStub networkVS;
    private View v;
    private WebContract.iContractPresenter iPresenter;
    private RecyclerArrayAdapter<WebEntity.ResultsBean> mAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_web;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        EasyRecyclerView iOSErv = rootView.findViewById(R.id.rv_web);
        networkVS = rootView.findViewById(R.id.view_stub_network);
        webSr = rootView.findViewById(R.id.sr_web);
        //设置 Header 为 经典 样式 带最后刷新时间
        webSr.setRefreshHeader(new ClassicsHeader(getmContext()).setEnableLastTime(true));
        webSr.setEnableHeaderTranslationContent(true);
        
        mPresenter = new WebPresenter(this);

        iPresenter.initData();

        iOSErv.setLayoutManager(new LinearLayoutManager(getmContext()));
        iOSErv.setAdapter(mAdapter = new RecyclerArrayAdapter<WebEntity.ResultsBean>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new WebViewHolder(parent);
            }
        });
        mAdapter.setMore(R.layout.view_loading_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                iPresenter.loadMore();
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
    public void setListener() {
        webSr.setEnableRefresh(true);
        webSr.setOnRefreshListener(this);
    }

    @Override
    public void setData(List<WebEntity.ResultsBean> result) {

        if (v != null) {
            v.setVisibility(View.GONE);
        }

        if (result != null) {
            for (WebEntity.ResultsBean ios : result) {

                mAdapter.add(ios);
            }

        }
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void setPresenter(WebContract.iContractPresenter presenter) {
        this.iPresenter = presenter;
    }

    @Override
    public void showFinished() {
        webSr.finishRefresh();
    }

    @Override
    public void showError() {
        try {
            v = networkVS.inflate();
            LinearLayout blankLl = v.findViewById(R.id.error_blank);
            blankLl.setOnClickListener(v1 -> {
                mAdapter.clear();
                iPresenter.initData();
            });
        } catch (Exception e) {
            v.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mAdapter.clear();
        iPresenter.initData();
    }
}
