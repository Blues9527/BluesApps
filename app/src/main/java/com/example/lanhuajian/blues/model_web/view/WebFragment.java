package com.example.lanhuajian.blues.model_web.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.framework.base.BaseFragment;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.model_web.contract.WebContract;
import com.example.lanhuajian.blues.model_web.model.WebEntity;
import com.example.lanhuajian.blues.model_web.presenter.WebPresenter;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.List;

public class WebFragment extends BaseFragment implements WebContract.iContractView {

    private EasyRecyclerView iOSErv;
    private WebContract.iContractPresenter iPresenter;
    private RecyclerArrayAdapter<WebEntity.ResultsBean> mAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_ios;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        iOSErv = rootView.findViewById(R.id.rv_ios);

        mPresenter = new WebPresenter(this);

        iPresenter.initData();

        iOSErv.addItemDecoration(new DividerDecoration(getResources().getColor(R.color.color_light_gray), 1));
        iOSErv.setLayoutManager(new LinearLayoutManager(getmContext()));
        iOSErv.setAdapter(mAdapter = new RecyclerArrayAdapter<WebEntity.ResultsBean>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new WebViewHolder(parent);
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
    public void setData(List<WebEntity.ResultsBean> result) {

        if (result != null) {
            for (WebEntity.ResultsBean ios : result) {

                mAdapter.add(ios);
            }

        }
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void setPresenter(WebContract.iContractPresenter presenter) {
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
