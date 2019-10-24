package com.example.lanhuajian.blues.module_main.banner;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.ViewGroup;

import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.framework.base.BaseDialogFragment;
import com.example.lanhuajian.blues.framework.utils.HelperUtil;
import com.example.lanhuajian.blues.framework.utils.SizeUtil;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import static com.example.lanhuajian.blues.constant.UsedConstant.DIALOGFRAGMENT_TITLE;

/**
 * User : Blues
 * Date : 2019/10/21
 * Time : 16:35
 */

public class CategoryDialogFragment extends BaseDialogFragment implements BannerContract.iBannerContractView {

    private RecyclerArrayAdapter<CategoryEntity.ResultBean.SectionDtoListBean.ElementDtoListBean> mAdapter;
    private BannerContract.iBannerContractPresenter iPresenter;

    public CategoryDialogFragment() {

    }

    public static CategoryDialogFragment newInstance(String id) {
        CategoryDialogFragment fragment = new CategoryDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("categoryId", id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initView() {

        String id = this.getArguments().getString("categoryId");
        mPresenter = new BannerPresenter(this);
        Log.i("Bluesss", "传过来的id是：" + id);
        iPresenter.getCategory(id);

        EasyRecyclerView ervCategory = rootView.findViewById(R.id.erv_category);
        DividerDecoration decoration = new DividerDecoration(getResources().getColor(R.color.color_black_translucent50), SizeUtil.dp2px(1));
        ervCategory.addItemDecoration(decoration);
        ervCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new RecyclerArrayAdapter<CategoryEntity.ResultBean.SectionDtoListBean.ElementDtoListBean>(getActivity()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new CategoryViewHolder(parent);
            }
        };
        ervCategory.setAdapter(mAdapter);
    }

    @Override
    public int setLayoutResourceId() {
        return R.layout.dialogfragment_category;
    }

    @Override
    public void onSuccess(BannerEntity banner) {

    }

    @Override
    public void onFailure(String result) {

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
        for (CategoryEntity.ResultBean.SectionDtoListBean sectionDtoListBean : category.getResult().getSectionDtoList()) {
            mAdapter.addAll(sectionDtoListBean.getElementDtoList());
        }
        mAdapter.notifyDataSetChanged();
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
}
