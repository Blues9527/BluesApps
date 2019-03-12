package com.example.lanhuajian.blues.model_fuli.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.framework.base.BaseFragment;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.model_fuli.contract.FuliContract;
import com.example.lanhuajian.blues.model_fuli.model.FuliEntity;
import com.example.lanhuajian.blues.model_fuli.presenter.FuliPresenter;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.List;

public class FuliFragment extends BaseFragment implements FuliContract.iContractView {

    private EasyRecyclerView iOSErv;
    private FuliContract.iContractPresenter iPresenter;
    private RecyclerArrayAdapter<FuliEntity.ResultsBean> mAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_ios;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        iOSErv = rootView.findViewById(R.id.rv_ios);

        mPresenter = new FuliPresenter(this);

        iPresenter.initData();

        iOSErv.addItemDecoration(new DividerDecoration(getResources().getColor(R.color.color_light_gray), 1));
        iOSErv.setLayoutManager(new LinearLayoutManager(getmContext()));
        iOSErv.setAdapter(mAdapter = new RecyclerArrayAdapter<FuliEntity.ResultsBean>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new FuliViewHolder(parent);
            }
        });
        mAdapter.setMore(R.layout.view_loading_more, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                iPresenter.loadMore();
            }

            @Override
            public void onMoreClick() {

            }
        });
        mAdapter.setNoMore(R.layout.view_load_no_more);

    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void setData(List<FuliEntity.ResultsBean> result) {

        if (result != null) {
            for (FuliEntity.ResultsBean ios : result) {

                mAdapter.add(ios);
            }

        }
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void setPresenter(FuliContract.iContractPresenter presenter) {
        this.iPresenter = presenter;
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
