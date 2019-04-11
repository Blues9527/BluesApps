package com.example.lanhuajian.blues.model_study.model_android.presenter;

import android.util.Log;

import com.example.framework.base.BaseView;
import com.example.framework.base.RxPresenter;
import com.example.framework.http.HttpCallBack;
import com.example.lanhuajian.blues.model_study.model_android.contract.AndroidContract;
import com.example.lanhuajian.blues.model_study.model_android.model.AndroidModel;
import com.example.lanhuajian.blues.model_study.model_android.model.AndroidEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public class AndroidPresenter extends RxPresenter implements AndroidContract.iContractPresenter {

    private AndroidContract.iContractModel iModel;
    private AndroidContract.iContractView iView;

    private List<AndroidEntity.ResultsBean> mDatas;

    private static final int LIMIT = 10;
    private int mCurrentPage = 1;

    public AndroidPresenter(BaseView mView) {
        super(mView);
        iModel = new AndroidModel();
        iView = (AndroidContract.iContractView) mView;
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
        subscribe(iModel.getData(limit, page, new HttpCallBack<AndroidEntity>() {
            @Override
            public void onSuccess(AndroidEntity data) {
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
