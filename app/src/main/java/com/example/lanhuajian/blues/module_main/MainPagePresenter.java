package com.example.lanhuajian.blues.module_main;

import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.base.RxPresenter;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;

/**
 * User : Blues
 * Date : 2019/5/17
 * Time : 10:08
 */

public class MainPagePresenter extends RxPresenter implements MainPageContract.iMainPagePresenter {

    private MainPageContract.iMainPageModel iModel;
    private MainPageContract.iMainPageView iView;

    public MainPagePresenter(BaseView mView) {
        super(mView);
        iView = (MainPageContract.iMainPageView) mView;
        iModel = new MainPageModel();
    }

    @Override
    public void getVideos() {
        subscribe(iModel.getVideo(new HttpCallBack<VideoEntity>() {
            @Override
            public void onSuccess(VideoEntity data) {
                iView.getVideoSuccess(data.getData());
            }

            @Override
            public void onFailure(String error) {
                iView.getVideoFailure(error);
            }
        }));
    }
}
