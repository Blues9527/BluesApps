package com.blues.module_main;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.blues.R;
import com.blues.WebViewDialog;
import com.blues.constant.UsedConstant;
import com.blues.database.course.CourseEntity;
import com.blues.database.course.CourseManager;
import com.blues.framework.base.BaseFragment;
import com.blues.framework.utils.FileUtil;
import com.blues.framework.widget.endlessbannerview.BannerAdapter;
import com.blues.framework.widget.endlessbannerview.BannerView;
import com.blues.module_main.article.ArticleFragment;
import com.blues.module_main.banner.BannerContract;
import com.blues.module_main.banner.BannerEntity;
import com.blues.module_main.banner.BannerPresenter;
import com.blues.module_main.banner.CategoryCourseEntity;
import com.blues.module_main.banner.CategoryCourseFragment;
import com.blues.module_main.banner.CategoryDialogFragment;
import com.blues.module_main.banner.CategoryEntity;
import com.blues.module_main.banner.CourseEntryHolder;
import com.blues.module_main.banner.MicroSpecDialogFragment;
import com.blues.module_main.banner.MicroSpecEntity;
import com.blues.module_main.video.VideoFragment;
import com.google.gson.Gson;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:27
 */

public class MainPageFragment extends BaseFragment implements BannerContract.iBannerContractView, View.OnClickListener {

    private BannerContract.iBannerContractPresenter iPresenter;
    private EasyRecyclerView ervEntry;
    private BannerView bannerView;
    private Fragment mCurrentFragment;
    private List<Fragment> fragments = new ArrayList<>();

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_mainpage;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPresenter = new BannerPresenter(this);

        iPresenter.getBanner();

        bannerView = rootView.findViewById(R.id.bv_header);
        ervEntry = rootView.findViewById(R.id.erv_entry);
        initEntry(getmContext());

        rootView.findViewById(R.id.tv_video).setOnClickListener(this);
        rootView.findViewById(R.id.tv_article).setOnClickListener(this);

        fragments.add(new VideoFragment());
        fragments.add(new ArticleFragment());
        showFragment(null, fragments.get(0));
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
        mEntryAdapter.addAll(getAllCourses(context));
        mEntryAdapter.notifyDataSetChanged();

        mEntryAdapter.setOnItemClickListener(position -> {
            if (getContext() instanceof FragmentActivity) {
                switch (position) {
                    case 0:
                        MicroSpecDialogFragment.newInstance("免费课程").show(((FragmentActivity) getContext()).getSupportFragmentManager(), "microspec");
                        break;
                    case 1:
                        CategoryDialogFragment.newInstance(UsedConstant.NETEASE_JOB_ID).show(((FragmentActivity) getContext()).getSupportFragmentManager(), "category1");
                        break;
                    case 2:
                        CategoryDialogFragment.newInstance(UsedConstant.NETEASE_PROGRAM_ID).show(((FragmentActivity) getContext()).getSupportFragmentManager(), "category2");
                        break;
                    case 3:
                        CategoryDialogFragment.newInstance(UsedConstant.NETEASE_AI_ID).show(((FragmentActivity) getContext()).getSupportFragmentManager(), "category3");
                        break;
                    case 4:
                        CategoryDialogFragment.newInstance(UsedConstant.NETEASE_PRODUCT_ID).show(((FragmentActivity) getContext()).getSupportFragmentManager(), "category4");
                        break;
                    case 5:
                        CategoryDialogFragment.newInstance(UsedConstant.NETEASE_DESIGN_ID).show(((FragmentActivity) getContext()).getSupportFragmentManager(), "category5");
                        break;
                    case 6:
                        CategoryDialogFragment.newInstance(UsedConstant.NETEASE_BUSINESS_ID).show(((FragmentActivity) getContext()).getSupportFragmentManager(), "category6");
                        break;
                    case 7:
                        CategoryCourseFragment.newInstance().show(((FragmentActivity) getContext()).getSupportFragmentManager(), "category7");
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

    @Override
    public void lazyFetchData() {
    }

    @Override
    public void setListener() {

    }

    @Override
    public void onSuccess(BannerEntity banner) {
        if (banner != null) {
            initBanner(getmContext(), banner);
        }
    }

    @Override
    public void onFailure(String result) {

    }

    @Override
    public void onFetchMicroSuccess(MicroSpecEntity microSpec) {

    }

    @Override
    public void onFetchMicroFailed(String msg) {

    }

    @Override
    public void onFetchCategorySuccess(CategoryEntity category) {

    }

    @Override
    public void onFetchCategoryFailed(String msg) {

    }

    @Override
    public void onFetchCategoryCourseSuccess(CategoryCourseEntity categoryCourse) {

    }

    @Override
    public void onFetchCategoryCourseFailed(String msg) {

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
        if (bannerView != null) {
            bannerView.pause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (bannerView != null) {
            bannerView.resume();
        }
    }

    public void initBanner(Context ctx, BannerEntity bannerEntity) {
        List<String> bannerUrls = new ArrayList<>();
        List<String> pathUrls = new ArrayList<>();
        for (BannerEntity.DataBean data : bannerEntity.getData()) {
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
            adapter.setItemClickListener(new BannerAdapter.ItemClickListener() {
                @Override
                public void onClick(int realPosition) {
                    new WebViewDialog(getContext(), pathUrls.get(realPosition)).show();
                }
            });
            //开启轮播
            bannerView.setAdapter(adapter);

        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_video:
                //显示video fragment页
                showFragment(mCurrentFragment, fragments.get(0));
                break;
            case R.id.tv_article:
                //显示article fragment页
                showFragment(mCurrentFragment, fragments.get(1));
                break;
        }
    }

    private void showFragment(Fragment from, Fragment to) {
        if (to == null) return;
        FragmentTransaction transaction = ((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction();
        boolean isAdded = to.isAdded();
        if (!isAdded) {
            if (from != null) {
                transaction.hide(from)
                        .add(R.id.fl_main_container, to, null)
                        .show(to)
                        .commitAllowingStateLoss();
            } else {
                transaction.add(R.id.fl_main_container, to, null)
                        .show(to)
                        .commitAllowingStateLoss();
            }
        } else {
            if (from != null) {
                transaction.hide(from)
                        .show(to)
                        .commitAllowingStateLoss();
            } else {
                transaction.show(to)
                        .commitAllowingStateLoss();
            }
        }

        mCurrentFragment = to;
    }
}
