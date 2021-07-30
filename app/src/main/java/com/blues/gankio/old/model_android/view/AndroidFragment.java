package com.blues.gankio.old.model_android.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;

import com.blues.LoadingDialog;
import com.blues.R;
import com.blues.framework.base.BaseFragment;
import com.blues.gankio.old.model_android.AndroidContract;
import com.blues.gankio.old.model_android.model.AndroidEntity;
import com.blues.gankio.old.model_android.presenter.AndroidPresenter;
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

public class AndroidFragment extends BaseFragment implements AndroidContract.iContractView, OnRefreshListener {

    private SmartRefreshLayout androidSr;
    private ViewStub networkVS;
    private View v;
    private AndroidContract.iContractPresenter iPresenter;
    private RecyclerArrayAdapter<AndroidEntity.ResultsBean> mAdapter;
    private LoadingDialog mLoading;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_android;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        EasyRecyclerView androidErv = rootView.findViewById(R.id.rv_android);
        androidSr = rootView.findViewById(R.id.sr_android);
        networkVS = rootView.findViewById(R.id.view_stub_network);
        //设置 Header 为 经典 样式 带最后刷新时间
        androidSr.setRefreshHeader(new ClassicsHeader(getmContext()).setEnableLastTime(true));
        androidSr.setEnableHeaderTranslationContent(true);

        mPresenter = new AndroidPresenter(this);

        //初始化数据
        iPresenter.initData();
        androidErv.setLayoutManager(new LinearLayoutManager(getmContext()));
        androidErv.setAdapter(mAdapter = new RecyclerArrayAdapter<AndroidEntity.ResultsBean>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new AndroidViewHolder(parent);
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
        androidSr.setEnableRefresh(true);
        androidSr.setOnRefreshListener(this);
    }

    @Override
    public void setData(List<AndroidEntity.ResultsBean> result) {
        if (v != null) {
            v.setVisibility(View.GONE);
        }
        for (AndroidEntity.ResultsBean data : result) {
            mAdapter.add(data);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(AndroidContract.iContractPresenter presenter) {
        this.iPresenter = presenter;
    }

    @Override
    public void showLoading() {
        mLoading = new LoadingDialog(getmContext());
        mLoading.show();
    }

    @Override
    public void showFinished() {
        if (mLoading != null) {
            mLoading.dismiss();
        }
        androidSr.finishRefresh();
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
        if (mLoading != null) {
            mLoading.dismiss();
        }
    }

    @Override
    public void showEmpty() {
        if (mLoading != null) {
            mLoading.dismiss();
        }
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mAdapter.clear();
        iPresenter.initData();
    }
}
