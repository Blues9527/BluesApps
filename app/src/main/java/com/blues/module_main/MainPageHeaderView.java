package com.blues.module_main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.blues.R;
import com.blues.WebViewDialog;
import com.blues.bean.CourseEntity;
import com.blues.framework.utils.ActivityManagerUtil;
import com.blues.framework.utils.FileUtil;
import com.blues.framework.widget.DrawableTextView;
import com.blues.framework.widget.endlessbannerview.BannerAdapter;
import com.blues.framework.widget.endlessbannerview.BannerView;
import com.blues.model_wanandroid.WanAndroidActivity;
import com.blues.model_wanandroid.WanAndroidBannerEntity;
import com.blues.model_wanandroid.netease.CourseEntryHolder;
import com.blues.module_game.GameActivity;
import com.blues.module_gank._new.girl.GankGirlActivity;
import com.blues.module_gank._new.mvp.view.GankActivity;
import com.blues.module_kaiyan.OpenEyeActivity;
import com.blues.module_kaiyan.OpenEyeEntity;
import com.blues.module_kaiyan.search.OpenEyeSearchActivity;
import com.google.gson.Gson;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;

/**
 * User : Blues
 * Date : 2019/9/4
 * Time : 15:32
 */

public class MainPageHeaderView extends RelativeLayout implements RecyclerArrayAdapter.ItemView {

    private EasyRecyclerView ervEntry;
    private BannerView bannerView;
    private DrawableTextView tvSearch;

    public MainPageHeaderView(Context context) {
        this(context, null);
    }

    public MainPageHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MainPageHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context ctx) {
        View rootView = LayoutInflater.from(ctx).inflate(R.layout.header_main, this);
        bannerView = rootView.findViewById(R.id.bv_header);
        ervEntry = rootView.findViewById(R.id.erv_entry);
        tvSearch = rootView.findViewById(R.id.tv_search);
        initEntry(ctx);

        tvSearch.setOnClickListener(v -> {
            Intent intent = new Intent(ctx, OpenEyeSearchActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) ctx, tvSearch, "transitionSearch");
            ctx.startActivity(intent, options.toBundle());
        });

    }

    public void initDefault(Context ctx, OpenEyeEntity.ItemListBean data) {

    }

    private void initEntry(Context context) {

        final GridLayoutManager goodsLayoutManager = new GridLayoutManager(getContext(), 4);
        ervEntry.setLayoutManager(goodsLayoutManager);
        RecyclerArrayAdapter mEntryAdapter;
        ervEntry.setAdapter(mEntryAdapter = new RecyclerArrayAdapter<CourseEntity>(getContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new CourseEntryHolder(parent);
            }
        });
        mEntryAdapter.addAll(getAllCourse(context));
        mEntryAdapter.notifyDataSetChanged();

        mEntryAdapter.setOnItemClickListener(position -> {
            if (getContext() instanceof FragmentActivity) {
                switch (position) {
                    case 0:
                        ActivityManagerUtil.start(GankGirlActivity.class, null);
                        break;
                    case 1:
                    case 2:
                    case 3:
                        //商城
                        Toast.makeText(getContext(), "敬请期待", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        //干货
                        ActivityManagerUtil.start(GankActivity.class, null);
                        break;
                    case 5:
                        //开眼
                        ActivityManagerUtil.start(OpenEyeActivity.class, null);
                        break;
                    case 6:
                        //玩 Android
                        ActivityManagerUtil.start(WanAndroidActivity.class, null);
//                        getContext().startActivity(new Intent(getContext(), WanAndroidActivity.class));
                        break;
                    case 7:
                        //答题小游戏
                        ActivityManagerUtil.start(GameActivity.class, null);
//                        getContext().startActivity(new Intent(getContext(), GameActivity.class));
                        break;
                }

            }
        });
    }

    private List<CourseEntity> getAllCourse(Context context) {
        List<CourseEntity> courses = new ArrayList<>();
        try {
            JSONArray ja = new JSONArray(FileUtil.getAssetsFile(context, "course.json"));
            for (int i = 0; i < ja.length(); i++) {
                CourseEntity entity = new Gson().fromJson(ja.get(i).toString().replaceAll("\\\\", ""), CourseEntity.class);
                courses.add(entity);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return courses;
    }

    @Override
    public View onCreateView(ViewGroup parent) {
        return this;
    }

    @Override
    public void onBindView(View headerView) {

    }

    public void initBanner(Context ctx, WanAndroidBannerEntity bannerEntity) {
        List<String> bannerUrls = new ArrayList<>();
        List<String> pathUrls = new ArrayList<>();
        for (WanAndroidBannerEntity.DataBean data : bannerEntity.getData()) {
            bannerUrls.add(data.getImagePath());
            pathUrls.add(data.getUrl());
        }

        new Handler(Looper.getMainLooper()).post(() -> {
            bannerView.setPlayDelay(3000);
            //启用progressbar形式hintview
            bannerView.setHintPadding(bannerView.dp2px(10), 0, bannerView.dp2px(10), bannerView.dp2px(10));
            bannerView.setAnimationDuration(1000);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, bannerView.dp2px(185));
            bannerView.setLayoutParams(layoutParams);
            BannerAdapter adapter = new BannerAdapter(ctx, bannerUrls, bannerView);
            adapter.setItemClickListener(realPosition -> new WebViewDialog(getContext(), pathUrls.get(realPosition)).show());
            //开启轮播
            bannerView.setAdapter(adapter);
        });
    }

    public void onBannerResume() {
        if (bannerView != null) {
            bannerView.resume();
        }
    }

    public void onBannerPause() {
        if (bannerView != null) {
            bannerView.pause();
        }
    }
}
