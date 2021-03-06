package com.blues.module_gank.old;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blues.R;
import com.blues.framework.base.BaseFragment;
import com.blues.framework.base.BaseViewPagerAdapter;
import com.blues.module_gank.old.model_android.view.AndroidFragment;
import com.blues.module_gank.old.model_article.ArticleFragment;
import com.blues.module_gank.old.model_ios.view._iOSFragment;
import com.blues.module_gank.old.model_video.VideoFragment;
import com.blues.module_gank.old.model_web.view.WebFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;


/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:32
 */

public class StudyPageFragment extends BaseFragment {

    private String[] tabs = {"Video", "Android", "iOS", "Web", "Blues"};

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_studypage;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        TabLayout mTab = rootView.findViewById(R.id.tl_fragment_bottom);
        ViewPager mViewPager = rootView.findViewById(R.id.vp_show);

        BaseViewPagerAdapter mFragmentAdapter = new BaseViewPagerAdapter(getChildFragmentManager(), Arrays.asList(tabs));
        mFragmentAdapter.addFragment(new VideoFragment());
        mFragmentAdapter.addFragment(new AndroidFragment());
        mFragmentAdapter.addFragment(new _iOSFragment());
        mFragmentAdapter.addFragment(new WebFragment());
        mFragmentAdapter.addFragment(new ArticleFragment());

        mViewPager.setAdapter(mFragmentAdapter);
        mViewPager.setOffscreenPageLimit(1);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTab));

        mTab.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {
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

        mTab.setSelectedTabIndicatorColor(mTab.getResources().getColor(R.color.color_light_blue));
        //因为fragment不销毁，所以添加新tabs前最好把旧的都移除掉先，否则就会出现重复的
        mTab.removeAllTabs();

        for (int i = 0; i < tabs.length; i++) {
            mTab.addTab(mTab.newTab().setCustomView(getTabView(getmContext(), tabs[i])), i == 0);
        }
    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {

    }

    private View getTabView(Context context, String text) {
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        return textView;
    }
}
