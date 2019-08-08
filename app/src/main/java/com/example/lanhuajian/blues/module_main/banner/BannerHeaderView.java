package com.example.lanhuajian.blues.module_main.banner;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.framework.widget.endlessbannerview.BannerAdapter;
import com.example.lanhuajian.blues.framework.widget.endlessbannerview.BannerView;
import com.example.lanhuajian.blues.mock.CourseEntryConstant;
import com.example.lanhuajian.blues.mock.VideoUrlConstant;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Blues
 * Date : 2019/8/1
 * Time : 11:24
 */

public class BannerHeaderView extends LinearLayout implements RecyclerArrayAdapter.ItemView {

    private BannerView bannerView;
    private EasyRecyclerView ervEntry;
    private RecyclerArrayAdapter mEntryAdapter;
    private List<CourseEntry> courseEntries = new ArrayList<>();

    public BannerHeaderView(Context context) {
        this(context, null);
    }

    public BannerHeaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BannerHeaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context ctx) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.header_banner, this);
        bannerView = view.findViewById(R.id.bv_header);
        ervEntry = view.findViewById(R.id.erv_entry);

        initEntry();
    }

    private void initEntry() {

        final GridLayoutManager goodsLayoutManager = new GridLayoutManager(getContext(), 4);
        ervEntry.setLayoutManager(goodsLayoutManager);
        ervEntry.setAdapter(mEntryAdapter = new RecyclerArrayAdapter<CourseEntry>(getContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new CourseEntryHolder(parent);
            }
        });

        for (int i = 0; i < CourseEntryConstant.iconsUrl.length; i++) {
            courseEntries.add(new CourseEntry(CourseEntryConstant.iconsUrl[i], CourseEntryConstant.entryTitles[i]));
        }
        mEntryAdapter.addAll(courseEntries);
        mEntryAdapter.notifyDataSetChanged();
    }

    public void initBanner(Context ctx, BannerEntity bannerEntity) {
        List<String> bannerUrls = new ArrayList<>();
        for (BannerEntity.DataBean data : bannerEntity.getData()) {
            bannerUrls.add(data.getImagePath());
        }

        new Handler(Looper.getMainLooper()).post(() -> {
            bannerView.setPlayDelay(3000);
            //启用progressbar形式hintview
//            bannerView.setHintView(new ProgressHintView(ctx, 0xffffffff, 0xff505050, 3000));
            bannerView.setHintPadding(bannerView.dp2px(10), 0, bannerView.dp2px(10), bannerView.dp2px(10));
            bannerView.setAnimationDuration(1000);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, bannerView.dp2px(185));
//            layoutParams.setMargins(bannerView.dp2px(15f), bannerView.dp2px(10f), bannerView.dp2px(15f), 0);
            bannerView.setLayoutParams(layoutParams);
            //开启轮播
            bannerView.setAdapter(new BannerAdapter(ctx, bannerUrls, bannerView));
        });

    }

    @Override
    public View onCreateView(ViewGroup parent) {
        return this;
    }

    @Override
    public void onBindView(View headerView) {

    }

    public void bannerOnPause() {
        if (bannerView != null) {
            bannerView.pause();
        }
    }

    public void bannerOnResume() {
        if (bannerView != null) {
            bannerView.resume();
        }
    }
}
