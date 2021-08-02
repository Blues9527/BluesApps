package com.blues.framework.widget.endlessbannerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.blues.R;
import com.blues.framework.widget.endlessbannerview.hintview.LoopPagerAdapter;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * User : Blues
 * Date : 2019/7/9
 * Time : 15:00
 */

public class BannerAdapter extends LoopPagerAdapter {

    private List<String> mBannerUrls;
    private Context mContext;
    private ItemClickListener mListener;
    private BannerView mBannerView;

    public BannerAdapter(Context context, List<String> bannerUrls, BannerView bannerView) {
        super(bannerView);
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
    protected int getRealCount() {
        return mBannerUrls.size();
    }

    @Override
    public View getView(ViewGroup container, int position) {
        int realPosition = position % mBannerUrls.size();
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_banner, container, false);

        ImageView iv = itemView.findViewById(R.id.iv_banner);
        Glide.with(mContext).load(mBannerUrls.get(realPosition)).placeholder(R.mipmap.ic_img_error).into(iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onClick(realPosition);
                }
            }
        });
        container.addView(itemView);
        return itemView;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.mListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onClick(int realPosition);
    }

}
