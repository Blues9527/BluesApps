package com.example.lanhuajian.blues.presenter;

import android.util.Log;

import com.example.framework.base.BaseView;
import com.example.framework.base.RxPresenter;
import com.example.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.contract.Contract;
import com.example.lanhuajian.blues.model.CModel;
import com.example.lanhuajian.blues.model.Entity;

import java.util.ArrayList;
import java.util.List;


/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public class CPresenter extends RxPresenter implements Contract.iContractPresenter {

    private Contract.iContractModel iModel;
    private Contract.iContractView iView;

    private List<Entity.ResultsBean> mDatas;

    private static final int LIMIT = 10;
    private int mCurrentPage = 1;

    public CPresenter(BaseView mView) {
        super(mView);
        iModel = new CModel();
        iView = (Contract.iContractView) mView;
        mDatas = new ArrayList<>();
    }

    @Override
    public void initData() {
        mDatas.clear();
        getData(LIMIT, mCurrentPage);
    }

    @Override
    public void loadMore() {
        getData(LIMIT, mCurrentPage++);
    }

    @Override
    public void getData(int limit, int page) {
        subscribe(iModel.getData(limit, page, new HttpCallBack<Entity>() {
            @Override
            public void onSuccess(Entity data) {
                mDatas.addAll(data.getResults());
                iView.setData(data.getResults());
            }

            @Override
            public void onFailure(String error) {
                Log.e("Blues", error);
            }
        }));
    }
}
