package com.blues.module_main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.blues.R;
import com.blues.framework.base.BaseFragment;
import com.blues.model_wanandroid.WanAndroidBannerEntity;
import com.blues.model_wanandroid.WanAndroidEntity;
import com.blues.model_wanandroid.WanAndroidViewHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:27
 */

public class MainPageFragment extends BaseFragment implements BannerContract.iBannerView {

    private MainPageHeaderView mHeader;
    private BannerContract.iBannerPresenter iPresenter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_mainpage;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mPresenter = new BannerPresenter(this);

        iPresenter.getBanner();

        EasyRecyclerView ervMain = rootView.findViewById(R.id.erv_main);
        ervMain.setLayoutManager(new LinearLayoutManager(mContext));
        RecyclerArrayAdapter<WanAndroidEntity.DataBean.DatasBean> mAdapter;
        ervMain.setAdapter(mAdapter = new RecyclerArrayAdapter<WanAndroidEntity.DataBean.DatasBean>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new WanAndroidViewHolder(parent);
            }
        });
        mAdapter.addHeader(mHeader = new MainPageHeaderView(mContext));
    }


    @Override
    public void lazyFetchData() {
    }

    @Override
    public void onPause() {
        super.onPause();
        mHeader.onBannerPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mHeader.onBannerResume();
    }

    @Override
    public void showRequestError(String msg) {

    }

    @Override
    public void onBannerReqSuccess(WanAndroidBannerEntity banner) {
        if (banner != null) {
            mHeader.initBanner(mContext, banner);
        }
    }

    @Override
    public void onBannerReqFailure(String result) {

    }

    @Override
    public void setPresenter(BannerContract.iBannerPresenter presenter) {
        iPresenter = presenter;
    }
}
