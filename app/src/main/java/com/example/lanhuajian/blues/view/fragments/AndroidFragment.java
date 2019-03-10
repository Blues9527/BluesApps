package com.example.lanhuajian.blues.view.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.framework.base.BaseFragment;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.contract.Contract;
import com.example.lanhuajian.blues.model.Entity;
import com.example.lanhuajian.blues.presenter.CPresenter;
import com.example.lanhuajian.blues.view.CViewHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.List;

public class AndroidFragment extends BaseFragment implements Contract.iContractView {

    private EasyRecyclerView androidErv;
    private Contract.iContractPresenter iPresenter;
    private RecyclerArrayAdapter<Entity.ResultsBean> mAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_android;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        androidErv = rootView.findViewById(R.id.rv_android);

        mPresenter = new CPresenter(this);
        iPresenter.initData();

        //初始化数据
        iPresenter.initData();

        androidErv.addItemDecoration(new DividerDecoration(getResources().getColor(R.color.color_light_gray), 1));
        androidErv.setLayoutManager(new LinearLayoutManager(getmContext()));
        androidErv.setAdapter(mAdapter = new RecyclerArrayAdapter<Entity.ResultsBean>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new CViewHolder(parent);
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

    }

    @Override
    public void setData(List<Entity.ResultsBean> result) {
        for (Entity.ResultsBean data : result) {

            mAdapter.add(data);

        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setPresenter(Contract.iContractPresenter presenter) {
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

    }

    @Override
    public void showEmpty() {

    }
}
