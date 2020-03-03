package com.blues.module_study.model_fuli.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;

import com.blues.framework.base.BaseFragment;
import com.blues.R;
import com.blues.module_study.model_fuli.FuliContract;
import com.blues.module_study.model_fuli.model.FuliEntity;
import com.blues.module_study.model_fuli.presenter.FuliPresenter;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

public class FuliFragment extends BaseFragment implements FuliContract.iContractView, OnRefreshListener {

    private SmartRefreshLayout fuliSr;
    private ViewStub networkVS;
    private View v;
    private FuliContract.iContractPresenter iPresenter;
    private RecyclerArrayAdapter<FuliEntity.ResultsBean> mAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_fuli;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        EasyRecyclerView fuliErv = rootView.findViewById(R.id.rv_fuli);
        fuliSr = rootView.findViewById(R.id.sr_fuli);
        networkVS = rootView.findViewById(R.id.view_stub_network);
        //设置 Header 为 经典 样式 带最后刷新时间
        fuliSr.setRefreshHeader(new ClassicsHeader(getmContext()).setEnableLastTime(true));
        fuliSr.setEnableHeaderTranslationContent(true);

        mPresenter = new FuliPresenter(this);

        iPresenter.initData();

        fuliErv.setLayoutManager(new LinearLayoutManager(getmContext()));
        fuliErv.setAdapter(mAdapter = new RecyclerArrayAdapter<FuliEntity.ResultsBean>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new FuliViewHolder(parent);
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
        fuliSr.setEnableRefresh(true);
        fuliSr.setOnRefreshListener(this);
    }

    @Override
    public void setData(List<FuliEntity.ResultsBean> result) {

        if (v != null) {
            v.setVisibility(View.GONE);
        }

        if (result != null) {
            for (FuliEntity.ResultsBean ios : result) {

                mAdapter.add(ios);
            }

        }
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void setPresenter(FuliContract.iContractPresenter presenter) {
        this.iPresenter = presenter;
    }

    @Override
    public void showBegin() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showFinished() {
        fuliSr.finishRefresh();
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
            e.printStackTrace();
            v.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mAdapter.clear();
        iPresenter.initData();
    }
}
