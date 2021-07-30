package com.blues.gankio.old.model_android.presenter;

import com.blues.framework.base.BaseView;
import com.blues.framework.base.RxPresenter;
import com.blues.framework.http.HttpCallBack;
import com.blues.gankio.old.model_android.AndroidContract;
import com.blues.gankio.old.model_android.model.AndroidEntity;
import com.blues.gankio.old.model_android.model.AndroidModel;

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

    private static final int LIMIT = 15;
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
        getData(LIMIT, mCurrentPage = 1);
    }

    @Override
    public void loadMore() {
        getData(LIMIT, ++mCurrentPage);
    }

    @Override
    public void getData(int limit, int page) {
        iView.showLoading();
        subscribe(iModel.getData(limit, page, new HttpCallBack<AndroidEntity>() {
            @Override
            public void onSuccess(AndroidEntity data) {
                if (data != null) {
                    mDatas.addAll(data.getResults());
                    iView.setData(data.getResults());
                    iView.showFinished();
                } else {
                    iView.showEmpty();
                }
            }

            @Override
            public void onFailure(String error) {
                iView.showError();
            }
        }));
    }
}
