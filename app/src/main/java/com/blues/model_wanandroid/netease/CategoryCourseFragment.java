package com.blues.model_wanandroid.netease;

import android.view.ViewGroup;

import com.blues.R;
import com.blues.framework.base.BaseDialogFragment;
import com.blues.framework.utils.HelperUtil;
import com.blues.framework.utils.SizeUtil;
import com.blues.model_wanandroid.WanAndroidBannerEntity;
import com.blues.model_wanandroid.WanAndroidContract;
import com.blues.model_wanandroid.WanAndroidEntity;
import com.blues.model_wanandroid.WanAndroidPresenter;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * User : Blues
 * Date : 2019/10/21
 * Time : 16:35
 */

public class CategoryCourseFragment extends BaseDialogFragment implements WanAndroidContract.iWanAndroidView {

    private RecyclerArrayAdapter<CategoryCourseEntity.ResultBean.CourseDtoListBean> mAdapter;
    private WanAndroidContract.iWanAndroidPresenter iPresenter;
    private static int DEFAULT_PAGE_INDEX = 1;

    public CategoryCourseFragment() {

    }

    public static CategoryCourseFragment newInstance() {
        return new CategoryCourseFragment();
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initView() {
        mPresenter = new WanAndroidPresenter(this);
        iPresenter.getCategoryCourse(DEFAULT_PAGE_INDEX = 1);

        EasyRecyclerView ervCategoryCourseSpec = rootView.findViewById(R.id.erv_categorycourse);
        DividerDecoration decoration = new DividerDecoration(getResources().getColor(R.color.color_black_translucent50), SizeUtil.dp2px(1));
        ervCategoryCourseSpec.addItemDecoration(decoration);
        ervCategoryCourseSpec.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new RecyclerArrayAdapter<CategoryCourseEntity.ResultBean.CourseDtoListBean>(getActivity()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new CategoryCourseViewHolder(parent);
            }
        };
        mAdapter.setMore(R.layout.view_loading_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                iPresenter.getCategoryCourse(++DEFAULT_PAGE_INDEX);
            }

            @Override
            public void onMoreClick() {

            }
        });

        mAdapter.setNoMore(R.layout.view_load_no_more);

        ervCategoryCourseSpec.setAdapter(mAdapter);
    }

    @Override
    public void setLayout(int width, int height) {
        super.setLayout(getDisplayMetrics().widthPixels, getDisplayMetrics().heightPixels);
    }

    @Override
    public int setLayoutResourceId() {
        return R.layout.dialogfragment_categorycourse;
    }

    @Override
    public void showWanAndroidPostList(List<WanAndroidEntity.DataBean.DatasBean> wanAndroidList) {

    }

    @Override
    public void showRequestError(String msg) {

    }

    @Override
    public void onBannerReqSuccess(WanAndroidBannerEntity banner) {

    }

    @Override
    public void onBannerReqFailure(String result) {

    }

    @Override
    public void onFetchMicroSuccess(MicroSpecEntity microSpec) {

    }

    @Override
    public void onFetchMicroFailed(String msg) {
        HelperUtil.showToastShort(msg);
    }

    @Override
    public void onFetchCategorySuccess(CategoryEntity category) {

    }

    @Override
    public void onFetchCategoryFailed(String msg) {

    }

    @Override
    public void onFetchCategoryCourseSuccess(CategoryCourseEntity categoryCourse) {
        mAdapter.addAll(categoryCourse.getResult().getCourseDtoList());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFetchCategoryCourseFailed(String msg) {

    }

    @Override
    public void setPresenter(WanAndroidContract.iWanAndroidPresenter presenter) {
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
}
