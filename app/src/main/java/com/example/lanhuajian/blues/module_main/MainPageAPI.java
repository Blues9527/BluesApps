package com.example.lanhuajian.blues.module_main;

import com.example.lanhuajian.blues.constant.RequestUrl;
import com.example.lanhuajian.blues.framework.http.RetrofitManager;
import com.example.lanhuajian.blues.framework.utils.RxUtil;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/17
 * Time : 10:07
 */

public class MainPageAPI {

    private static volatile MainPageAPI instance;

    private MainPageAPI() {
    }

    public static MainPageAPI getInstance() {
        RetrofitManager.setBaseUrl(RequestUrl.BASE_LOCAL_URL);
        if (instance == null) {
            synchronized (MainPageAPI.class) {
                if (instance == null) {
                    instance = new MainPageAPI();
                }
            }
        }
        return instance;
    }

    public Subscription getVideos(Subscriber<VideoEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(MainPageContractRequest.class).getVideo();
        return RxUtil.setObserve(observable, subscriber);
    }
}
