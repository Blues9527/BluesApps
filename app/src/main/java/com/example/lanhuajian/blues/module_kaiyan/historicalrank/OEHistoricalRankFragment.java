package com.example.lanhuajian.blues.module_kaiyan.historicalrank;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;

import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.constant.RequestUrl;
import com.example.lanhuajian.blues.framework.base.BaseFragment;
import com.example.lanhuajian.blues.framework.utils.HelperUtil;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyeContract;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyeEntity;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyePresenter;
import com.example.lanhuajian.blues.module_kaiyan.hotrank.OEHotRankViewHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;


/**
 * User : Blues
 * Date : 2019/8/26
 * Time : 11:18
 */

public class OEHistoricalRankFragment extends BaseFragment implements OpenEyeContract.iOpenEyeView, OnRefreshListener {

    private SmartRefreshLayout hotRankSr;
    private View v;
    private ViewStub networkVS;
    private OpenEyeContract.iOpenEyePresenter iPresenter;
    private RecyclerArrayAdapter<OpenEyeEntity.ItemListBean> mAdapter;

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

        iPresenter.getRankList(RequestUrl.KaiYanType.HISTORICAL);

        DividerDecoration decoration = new DividerDecoration(R.color.color_gray, 1);
        hotRankErv.addItemDecoration(decoration);
        hotRankErv.setLayoutManager(new LinearLayoutManager(getmContext()));
        hotRankErv.setAdapter(mAdapter = new RecyclerArrayAdapter<OpenEyeEntity.ItemListBean>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new OEHistoricalRankViewHolder(parent);
            }
        });

        mAdapter.setNoMore(R.layout.view_load_no_more);
    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {
        hotRankSr.setEnableRefresh(true);
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
        hotRankSr.finishRefresh();
    }

    @Override
    public void showError() {
        try {
            v = networkVS.inflate();
            LinearLayout blankLl = v.findViewById(R.id.error_blank);
            blankLl.setOnClickListener(v1 -> {
                mAdapter.clear();
                iPresenter.getRankList();
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
    public void showRankList(List<OpenEyeEntity.ItemListBean> openEyeList) {
        mAdapter.addAll(openEyeList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showRequestError(String msg) {
        HelperUtil.showToastShort(msg);
    }

    @Override
    public void showHotSearch(List<String> searches) {

    }

    @Override
    public void showSearchResult(List<OpenEyeEntity.ItemListBean> openEyeList) {

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mAdapter.clear();
        iPresenter.getRankList();
    }
}
