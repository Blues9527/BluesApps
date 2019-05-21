package com.example.lanhuajian.blues.module_main;

import com.example.lanhuajian.blues.framework.base.BasePresenter;
import com.example.lanhuajian.blues.framework.base.BaseView;
import com.example.lanhuajian.blues.framework.http.HttpCallBack;

import java.util.List;

import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/17
 * Time : 10:07
 */

public interface MainPageContract {

    interface iMainPageView extends BaseView<iMainPagePresenter> {

        void getVideoSuccess(List<VideoEntity.DataBean> bean);

        void getVideoFailure(String msg);

    }

    interface iMainPagePresenter extends BasePresenter {

        void getVideos();

    }

    interface iMainPageModel {

        Subscription getVideo(HttpCallBack<VideoEntity> callBack);
    }
}
