package com.blues.module_gank._new.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blues.R;
import com.blues.WebViewDialog;
import com.blues.framework.base.BaseActivity;
import com.blues.framework.base.BaseViewPagerAdapter;
import com.blues.framework.widget.endlessbannerview.BannerAdapter;
import com.blues.framework.widget.endlessbannerview.BannerView;
import com.blues.module_gank._new.mvp.model.GankBannerEntity;
import com.blues.module_gank._new.mvp.model.GankCategory;
import com.blues.module_gank._new.mvp.GankContract;
import com.blues.module_gank._new.mvp.model.GankUniversalEntity;
import com.blues.module_gank._new.detail.GankPostComments;
import com.blues.module_gank._new.detail.GankPostDetail;
import com.blues.module_gank._new.hot.GankHotEntity;
import com.blues.module_gank._new.mvp.presenter.GankPresenter;
import com.blues.module_gank._new.random.GankRandomEntity;
import com.blues.module_gank._new.search.GankSearchResult;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class GankActivity extends BaseActivity implements GankContract.iGankView {

    private GankContract.iGankPresenter iGankPresenter;
    private BannerView mBanner;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    //    private String[] tabs = {"Video", "Android", "iOS", "Web", "Blues"};
    private List<String> mTabs = new ArrayList<>();

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_gank;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        mPresenter = new GankPresenter(this);

        iGankPresenter.initData();

        mTabLayout = findViewById(R.id.tl_gank_top);
        mBanner = findViewById(R.id.bv_header);
        mViewPager = findViewById(R.id.vp_show);
    }

    private View getTabView(Context context, String text) {
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        return textView;
    }

    @Override
    public void setBanner(List<GankBannerEntity.DataBean> banner) {
        List<String> bannerUrls = new ArrayList<>();
        List<String> pathUrls = new ArrayList<>();
        for (GankBannerEntity.DataBean data : banner) {
            bannerUrls.add(data.getImage());
            pathUrls.add(data.getUrl());
        }
        startBannerLoop(bannerUrls, pathUrls);
    }

    @Override
    public void setCategory(List<GankCategory.DataBean> category) {
        for (GankCategory.DataBean data : category) {
            mTabs.add(data.getTitle());
        }

        BaseViewPagerAdapter mFragmentAdapter = new BaseViewPagerAdapter(mContext.getSupportFragmentManager(), mTabs);
        for (GankCategory.DataBean data : category) {
            mFragmentAdapter.addFragment(new GankUniversalFragment(data.getType()));
        }
        mViewPager.setAdapter(mFragmentAdapter);
        mViewPager.setOffscreenPageLimit(1);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {
            @Override
            public void onTabSelected(@NonNull TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());

                View view = tab.getCustomView();
                if (view instanceof TextView) {
                    ((TextView) view).setTextColor(view.getResources().getColor(R.color.color_light_blue));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (view instanceof TextView) {
                    ((TextView) view).setTextColor(view.getResources().getColor(R.color.color_black));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mTabLayout.setSelectedTabIndicatorColor(mTabLayout.getResources().getColor(R.color.color_light_blue));
        //因为fragment不销毁，所以添加新tabs前最好把旧的都移除掉先，否则就会出现重复的
        mTabLayout.removeAllTabs();

        for (int i = 0; i < mTabs.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(getTabView(mContext, mTabs.get(i))), i == 0);
        }
    }

    @Override
    public void setPostList(List<GankUniversalEntity.DataBean> postList) {

    }

    @Override
    public void setRandomPostList(List<GankRandomEntity.DataBean> randomPostList) {

    }

    @Override
    public void setPostDetail(GankPostDetail.DataBean postDetail) {

    }

    @Override
    public void setPostHotList(List<GankHotEntity.DataBean> hotList) {

    }

    @Override
    public void setPostComments(GankPostComments comments) {

    }

    @Override
    public void setSearchContents(List<GankSearchResult.DataBean> searchContents) {

    }

    @Override
    public void setPresenter(GankContract.iGankPresenter presenter) {
        iGankPresenter = presenter;
    }

    private void startBannerLoop(List<String> images, List<String> urls) {
        new Handler(Looper.getMainLooper()).post(() -> {
            mBanner.setPlayDelay(3000);
            //启用progressbar形式hintview
//            bannerView.setHintView(new ProgressHintView(ctx, 0xffffffff, 0xff505050, 3000));
            mBanner.setHintPadding(mBanner.dp2px(10), 0, mBanner.dp2px(10), mBanner.dp2px(10));
            mBanner.setAnimationDuration(1000);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, mBanner.dp2px(185));
//            layoutParams.setMargins(bannerView.dp2px(15f), bannerView.dp2px(10f), bannerView.dp2px(15f), 0);
            mBanner.setLayoutParams(layoutParams);
            BannerAdapter adapter = new BannerAdapter(mContext, images, mBanner);
            adapter.setItemClickListener(realPosition -> new WebViewDialog(mContext, urls.get(realPosition)).show());
            //开启轮播
            mBanner.setAdapter(adapter);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mBanner != null) {
            mBanner.resume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mBanner != null) {
            mBanner.pause();
        }
    }
}
