package com.example.lanhuajian.blues.module_study.model_android.view;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;

import com.example.lanhuajian.blues.framework.base.BaseFragment;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.module_study.model_android.AndroidContract;
import com.example.lanhuajian.blues.module_study.model_android.model.AndroidEntity;
import com.example.lanhuajian.blues.module_study.model_android.presenter.AndroidPresenter;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

public class AndroidFragment extends BaseFragment implements AndroidContract.iContractView, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout androidSr;
    private ViewStub networkVS;
    private View v;
    private AndroidContract.iContractPresenter iPresenter;
    private RecyclerArrayAdapter<AndroidEntity.ResultsBean> mAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_android;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        EasyRecyclerView androidErv = rootView.findViewById(R.id.rv_android);
        androidSr = rootView.findViewById(R.id.sr_android);
        networkVS = rootView.findViewById(R.id.view_stub_network);

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
        androidSr.setOnRefreshListener(this);
    }

    @Override
    public void setData(List<AndroidEntity.ResultsBean> result) {
        if (androidSr.isRefreshing()) {
            mAdapter.clear();
        }

        if (v != null) {
            v.setVisibility(View.GONE);
        }
        for (AndroidEntity.ResultsBean data : result) {
            mAdapter.add(data);
        }
        mAdapter.notifyDataSetChanged();
        androidSr.setRefreshing(false);
    }

    @Override
    public void setPresenter(AndroidContract.iContractPresenter presenter) {
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

    }

    @Override
    public void showError() {
        if (androidSr.isRefreshing()) {
            androidSr.setRefreshing(false);
        }
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
    public void onRefresh() {
        mAdapter.clear();
        iPresenter.initData();
    }
}
