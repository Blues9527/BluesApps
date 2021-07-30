package com.blues.module_kaiyan.hotrank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;

import com.blues.R;
import com.blues.framework.base.BaseFragment;
import com.blues.framework.utils.HelperUtil;
import com.blues.module_kaiyan.OpenEyeContract;
import com.blues.module_kaiyan.OpenEyeEntity;
import com.blues.module_kaiyan.OpenEyePresenter;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;


/**
 * User : Blues
 * Date : 2019/8/26
 * Time : 11:18
 */

public class OEHotRankFragment extends BaseFragment implements OpenEyeContract.iOpenEyeView, OnRefreshListener {

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
        //设置 Header 为 经典 样式 带最后刷新时间
        hotRankSr.setRefreshHeader(new ClassicsHeader(getmContext()).setEnableLastTime(true));
        hotRankSr.setEnableHeaderTranslationContent(true);

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
        hotRankSr.setEnableRefresh(true);
        hotRankSr.setOnRefreshListener(this);
    }

    @Override
    public void setPresenter(OpenEyeContract.iOpenEyePresenter presenter) {
        iPresenter = presenter;
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
    public void showRankList(List<OpenEyeEntity.ItemListBean> openEyeList) {
        mAdapter.addAll(openEyeList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showRequestError(String msg) {
        HelperUtil.showToast(msg);
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
