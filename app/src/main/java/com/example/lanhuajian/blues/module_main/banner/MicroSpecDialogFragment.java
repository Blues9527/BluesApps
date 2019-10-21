package com.example.lanhuajian.blues.module_main.banner;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.ViewGroup;

import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.framework.base.BaseDialogFragment;
import com.example.lanhuajian.blues.framework.utils.HelperUtil;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import static com.example.lanhuajian.blues.constant.UsedConstant.DIALOGFRAGMENT_TITLE;

/**
 * User : Blues
 * Date : 2019/10/21
 * Time : 16:35
 */

public class MicroSpecDialogFragment extends BaseDialogFragment implements BannerContract.iBannerContractView {

    private RecyclerArrayAdapter<MicroSpecEntity.ResultBean> mAdapter;
    private BannerContract.iBannerContractPresenter iPresenter;

    public MicroSpecDialogFragment() {

    }

    public static MicroSpecDialogFragment newInstance(String title) {
        MicroSpecDialogFragment fragment = new MicroSpecDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(DIALOGFRAGMENT_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initView() {
        mPresenter = new BannerPresenter(this);
        iPresenter.getMicroSpec();

        EasyRecyclerView ervMicroSpec = rootView.findViewById(R.id.erv_microspec);
        ervMicroSpec.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new RecyclerArrayAdapter<MicroSpecEntity.ResultBean>(getActivity()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                Log.i("Bluesss", "MicroSpecViewHolder");
                return new MicroSpecViewHolder(parent);
            }
        };
        ervMicroSpec.setAdapter(mAdapter);
    }

    @Override
    public int setLayoutResourceId() {
        return R.layout.dialogfragment_microspec;
    }

    @Override
    public void onSuccess(BannerEntity banner) {

    }

    @Override
    public void onFailure(String result) {

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
