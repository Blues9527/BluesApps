package com.example.lanhuajian.blues.module_main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.lanhuajian.blues.framework.base.BaseFragment;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.mock.VideoUrlConstant;
import com.example.lanhuajian.blues.module_main.banner.BannerContract;
import com.example.lanhuajian.blues.module_main.banner.BannerEntity;
import com.example.lanhuajian.blues.module_main.banner.BannerHeaderView;
import com.example.lanhuajian.blues.module_main.banner.BannerPresenter;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:27
 */

public class MainPageFragment extends BaseFragment implements BannerContract.iBannerContractView {

    private List<VideoInfoEntity> videos = new ArrayList<>();
    private BannerContract.iBannerContractPresenter iPresenter;
    private BannerHeaderView mHeader;
    private RecyclerArrayAdapter<VideoInfoEntity> mAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_mainpage;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        EasyRecyclerView mainErv = rootView.findViewById(R.id.ev_main);

        mPresenter = new BannerPresenter(this);

        iPresenter.getBanner();

        mainErv.setLayoutManager(new LinearLayoutManager(getmContext()));
        mainErv.setAdapter(mAdapter = new RecyclerArrayAdapter<VideoInfoEntity>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new VideoHolder(parent);
            }
        });
//        mainErv.setVerticalScrollBarEnabled(false);
        mAdapter.addHeader(mHeader = new BannerHeaderView(getmContext()));
        for (int i = 0; i < VideoUrlConstant.urls.length; i++) {
            videos.add(new VideoInfoEntity(VideoUrlConstant.urls[i], VideoUrlConstant.titles[i]));
        }
        mAdapter.addAll(videos);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void onSuccess(BannerEntity banner) {
        if (banner != null) {
            mHeader.initBanner(getmContext(), banner);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(String result) {

    }

    @Override
    public void setPresenter(BannerContract.iBannerContractPresenter presenter) {
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
    public void onPause() {
        super.onPause();
        mHeader.bannerOnPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mHeader.bannerOnResume();
    }
}
