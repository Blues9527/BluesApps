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
import com.blues.database.course.CourseEntity;
import com.blues.database.course.CourseManager;
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


    /**
     * 获取course数据，1：优先本地数据库的数据 2：asset目录下的配置
     *
     * @param ctx 上下文对象
     * @return 返回的是一个course列表
     */
    @Deprecated
    private List<CourseEntity> getAllCourses(Context ctx) {
        List<CourseEntity> course = CourseManager.getInstance().getAllCourse();
        if (course.size() != 0) {
            Log.i("Blues", "从本地数据库读取course数据");
            return course;
        } else {
            try {
                JSONArray ja = new JSONArray(FileUtil.getAssetsFile(ctx, "course.json"));
                for (int i = 0; i < ja.length(); i++) {
                    //json转译/有问题，会转译成\/，所以要通过字符串替换掉
                    Log.i("Blues", ja.get(i).toString().replaceAll("\\\\", ""));
                    CourseEntity entity = new Gson().fromJson(ja.get(i).toString().replaceAll("\\\\", ""), CourseEntity.class);
                    course.add(entity);
                    //再将数据写入数据库
                    CourseManager.getInstance().insertCourse(entity);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        Log.i("Blues", "从本地配置表读取course数据");
        return course;
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
//            bannerView.setHintView(new ProgressHintView(ctx, 0xffffffff, 0xff505050, 3000));
            bannerView.setHintPadding(bannerView.dp2px(10), 0, bannerView.dp2px(10), bannerView.dp2px(10));
            bannerView.setAnimationDuration(1000);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, bannerView.dp2px(185));
//            layoutParams.setMargins(bannerView.dp2px(15f), bannerView.dp2px(10f), bannerView.dp2px(15f), 0);
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
