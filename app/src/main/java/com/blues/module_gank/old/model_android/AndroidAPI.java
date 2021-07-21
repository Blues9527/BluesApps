package com.blues.module_gank.old.model_android;

import static com.blues.constant.ConstantKt.BASE_GANKIO_URL;

import com.blues.framework.http.RetrofitManager;
import com.blues.framework.utils.RxUtil;
import com.blues.module_gank.old.model_android.model.AndroidEntity;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public class AndroidAPI {

    private static volatile AndroidAPI instance;

    private AndroidAPI() {
    }

    public static AndroidAPI getInstance() {
        RetrofitManager.setBaseUrl(BASE_GANKIO_URL);
        if (null == instance) {
            synchronized (AndroidAPI.class) {
                if (null == instance) {
                    instance = new AndroidAPI();
                }
            }
        }
        return instance;
    }

    public Subscription getData(int limit, int page, Subscriber<AndroidEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(AndroidContractRequest.class).getData(limit, page);
        return RxUtil.setSubscribe(observable, subscriber);
    }
}
