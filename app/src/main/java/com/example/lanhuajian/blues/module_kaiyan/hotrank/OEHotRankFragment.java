package com.example.lanhuajian.blues.module_kaiyan.hotrank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.framework.base.BaseFragment;
import com.example.lanhuajian.blues.framework.utils.HelperUtil;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyeContract;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyeEntity;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyePresenter;
import com.example.lanhuajian.blues.module_kaiyan.detail.OEDetailActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.List;


/**
 * User : Blues
 * Date : 2019/8/26
 * Time : 11:18
 */

public class OEHotRankFragment extends BaseFragment implements OpenEyeContract.iOpenEyeView, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout hotRankSr;
    private View v;
    private ViewStub networkVS;
    private OpenEyeContract.iOpenEyePresenter iPresenter;
    private RecyclerArrayAdapter<OpenEyeEntity.ItemListBean> mAdapter;
    private List<OpenEyeEntity.ItemListBean> itemListBeans;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_oe_hot_rank;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EasyRecyclerView hotRankErv = rootView.findViewById(R.id.rv_hotrank);
        hotRankSr = rootView.findViewById(R.id.sr_hotrank);
        networkVS = rootView.findViewById(R.id.view_stub_network);

        mPresenter = new OpenEyePresenter(this);

        iPresenter.getRankList();

        DividerDecoration decoration = new DividerDecoration(R.color.color_gray, 1);
        hotRankErv.addItemDecoration(decoration);
        hotRankErv.setLayoutManager(new LinearLayoutManager(getmContext()));
        hotRankErv.setAdapter(mAdapter = new RecyclerArrayAdapter<OpenEyeEntity.ItemListBean>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new OEHotRankViewHolder(parent);
            }
        });
        mAdapter.setNoMore(R.layout.view_load_no_more);
    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {
        hotRankSr.setOnRefreshListener(this);
    }

    @Override
    public void setPresenter(OpenEyeContract.iOpenEyePresenter presenter) {
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
    public void onRefresh() {
        mAdapter.clear();
        iPresenter.getRankList();
    }

    @Override
    public void showRankList(List<OpenEyeEntity.ItemListBean> openEyeList) {
        itemListBeans = openEyeList;
        mAdapter.setOnItemClickListener(position -> {
            if (itemListBeans != null) {
                Intent intent = new Intent();
                intent.putExtra("itemDetail", itemListBeans.get(position));
                intent.setClass(mContext, OEDetailActivity.class);
                startActivity(intent);
            }
        });
        if (hotRankSr.isRefreshing()) {
            mAdapter.clear();
        }
        mAdapter.addAll(openEyeList);
        mAdapter.notifyDataSetChanged();
        hotRankSr.setRefreshing(false);
    }

    @Override
    public void showRequestError(String msg) {
        if (hotRankSr.isRefreshing()) {
            hotRankSr.setRefreshing(false);
        }
        HelperUtil.showToastShort(msg);
    }

    @Override
    public void showHotSearch(List<String> searches) {

    }

    @Override
    public void showSearchResult(List<OpenEyeEntity.ItemListBean> openEyeList) {

    }
}
