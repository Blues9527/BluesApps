package com.example.lanhuajian.blues.module_main;

import com.example.lanhuajian.blues.framework.http.HttpCallBack;

import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/17
 * Time : 10:07
 */

public class MainPageModel implements MainPageContract.iMainPageModel {


    @Override
    public Subscription getVideo(HttpCallBack<VideoEntity> callBack) {
        return MainPageAPI.getInstance().getVideos(new Subscriber<VideoEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(VideoEntity videoEntity) {
                callBack.onSuccess(videoEntity);
            }
        });
    }
}
