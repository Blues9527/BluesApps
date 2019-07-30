package com.example.lanhuajian.blues.framework.widget.endlessbannerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.lanhuajian.blues.R;

import java.util.List;

/**
 * User : Blues
 * Date : 2019/7/9
 * Time : 15:00
 */

public class BannerAdapter extends PagerAdapter {

    private List<String> mBannerUrls;
    private Context mContext;
    private BannerView mBannerView;

    public BannerAdapter(Context context, List<String> bannerUrls, BannerView bannerView) {
        this.mBannerUrls = bannerUrls;
        mContext = context;
        mBannerView = bannerView;
    }

    @Override
    public void notifyDataSetChanged() {
        mBannerUrls.clear();
        mBannerView.getViewPager().setAdapter(this);
        initPosition();
        super.notifyDataSetChanged();
    }

    private void initPosition() {
        if (getCount() <= 1)
            return;
        int half = Integer.MAX_VALUE / 2;
        int start = half - half / mBannerUrls.size();
        mBannerView.getViewPager().setCurrentItem(start, false);
    }

    @Override
    public int getCount() {
        return mBannerUrls.size() <= 1 ? mBannerUrls.size() : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        int realPosition = position % mBannerUrls.size();
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_banner, container, false);

        ImageView iv = itemView.findViewById(R.id.iv_banner);
        Glide.with(mContext).load(mBannerUrls.get(realPosition)).into(iv);

        container.addView(itemView);
        return itemView;
    }
}
