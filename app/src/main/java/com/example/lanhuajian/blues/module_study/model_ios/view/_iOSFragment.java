package com.example.lanhuajian.blues.module_study.model_ios.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;

import com.example.lanhuajian.blues.framework.base.BaseFragment;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.module_study.model_ios.IOSContract;
import com.example.lanhuajian.blues.module_study.model_ios.model.IOSEntity;
import com.example.lanhuajian.blues.module_study.model_ios.presenter.IOSPresenter;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

public class _iOSFragment extends BaseFragment implements IOSContract.iContractView, OnRefreshListener {

    private SmartRefreshLayout iOSSr;
    private ViewStub networkVS;
    private IOSContract.iContractPresenter iPresenter;
    private RecyclerArrayAdapter<IOSEntity.ResultsBean> mAdapter;
    private View v;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_ios;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        EasyRecyclerView iOSErv = rootView.findViewById(R.id.rv_ios);
        networkVS = rootView.findViewById(R.id.view_stub_network);
        iOSSr = rootView.findViewById(R.id.sr_ios);
        //设置 Header 为 经典 样式 带最后刷新时间
        iOSSr.setRefreshHeader(new ClassicsHeader(getmContext()).setEnableLastTime(true));
        iOSSr.setEnableHeaderTranslationContent(true);
        mPresenter = new IOSPresenter(this);

        iPresenter.initData();

        iOSErv.setLayoutManager(new LinearLayoutManager(getmContext()));
        iOSErv.setAdapter(mAdapter = new RecyclerArrayAdapter<IOSEntity.ResultsBean>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new IOSViewHolder(parent);
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
        iOSSr.setEnableRefresh(true);
        iOSSr.setOnRefreshListener(this);
    }

    @Override
    public void setData(List<IOSEntity.ResultsBean> result) {

        if (v != null) {
            v.setVisibility(View.GONE);
        }

        if (result != null) {
            for (IOSEntity.ResultsBean ios : result) {

                mAdapter.add(ios);
            }

        }
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void setPresenter(IOSContract.iContractPresenter presenter) {
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
        iOSSr.finishRefresh();
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
