package com.blues.kaiyan.detail;

import static com.blues.constant.ConstantKt.BASE_KAIYAN_URL;

import com.blues.framework.http.RetrofitManager;
import com.blues.framework.utils.RxUtil;


import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:04
 */

public class OEDetailAPI {

    private static volatile OEDetailAPI instance;

    private OEDetailAPI() {
    }

    public static OEDetailAPI getInstance() {
        RetrofitManager.setBaseUrl(BASE_KAIYAN_URL);
        if (null == instance) {
            synchronized (OEDetailAPI.class) {
                if (null == instance) {
                    instance = new OEDetailAPI();
                }
            }
        }
        return instance;
    }

    //获取先关视频
    public Subscription getRelatedVideos(String relatedId, Subscriber<OEDetailRelatedEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(OEDetailRelatedContractReq.class).getRelatedVideos(relatedId);
        return RxUtil.setSubscribe(observable, subscriber);
    }
}
