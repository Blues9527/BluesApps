package com.blues.model_wanandroid.netease;

import android.os.Bundle;
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

import java.lang.ref.WeakReference;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;

import static com.blues.constant.UsedConstant.DIALOGFRAGMENT_TITLE;

/**
 * User : Blues
 * Date : 2019/10/21
 * Time : 16:35
 */

public class MicroSpecDialogFragment extends BaseDialogFragment implements WanAndroidContract.iWanAndroidView {

    private RecyclerArrayAdapter<MicroSpecEntity.ResultBean> mAdapter;
    private WanAndroidContract.iWanAndroidPresenter iPresenter;
    private static WeakReference<MicroSpecDialogFragment> weakReference;

    public MicroSpecDialogFragment() {

    }

    public static MicroSpecDialogFragment newInstance(String title) {
        weakReference = new WeakReference<>(new MicroSpecDialogFragment());
        Bundle bundle = new Bundle();
        bundle.putString(DIALOGFRAGMENT_TITLE, title);
        weakReference.get().setArguments(bundle);
        weakReference.get().setCancelable(false);
        return weakReference.get();
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initView() {
        mPresenter = new WanAndroidPresenter(this);
        iPresenter.getMicroSpec();

        EasyRecyclerView ervMicroSpec = rootView.findViewById(R.id.erv_microspec);
        DividerDecoration decoration = new DividerDecoration(getResources().getColor(R.color.color_black_translucent50), SizeUtil.dp2px(1));
        ervMicroSpec.addItemDecoration(decoration);
        ervMicroSpec.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new RecyclerArrayAdapter<MicroSpecEntity.ResultBean>(getActivity()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new MicroSpecViewHolder(parent);
            }
        };
        ervMicroSpec.setAdapter(mAdapter);

        rootView.findViewById(R.id.iv_close).setOnClickListener(v -> {
            weakReference.get().getDialog().dismiss();
        });
    }

    @Override
    public int setLayoutResourceId() {
        return R.layout.dialogfragment_microspec;
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
        mAdapter.addAll(microSpec.getResult());
        mAdapter.notifyDataSetChanged();
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
