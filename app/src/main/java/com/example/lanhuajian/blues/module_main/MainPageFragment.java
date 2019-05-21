package com.example.lanhuajian.blues.module_main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.lanhuajian.blues.framework.base.BaseFragment;
import com.example.lanhuajian.blues.R;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:27
 */

public class MainPageFragment extends BaseFragment implements MainPageContract.iMainPageView {

    private MainPageContract.iMainPagePresenter iPresenter;

    private EasyRecyclerView mainErv;
    private RecyclerArrayAdapter mAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_mainpage;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mainErv = rootView.findViewById(R.id.ev_main);

        mPresenter = new MainPagePresenter(this);
        iPresenter.getVideos();

        mainErv.setLayoutManager(new LinearLayoutManager(getmContext()));
        mainErv.setAdapter(mAdapter = new RecyclerArrayAdapter<VideoEntity.DataBean>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new VideoHolder(parent);
            }
        });
    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void getVideoSuccess(List<VideoEntity.DataBean> bean) {
        if (null != bean) {
            mAdapter.addAll(bean);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void getVideoFailure(String msg) {

    }

    @Override
    public void setPresenter(MainPageContract.iMainPagePresenter presenter) {
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
}
