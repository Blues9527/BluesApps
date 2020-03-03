package com.blues.module_study.model_ios;

import com.blues.framework.http.RetrofitManager;
import com.blues.framework.utils.RxUtil;
import com.blues.constant.RequestUrl;
import com.blues.module_study.model_ios.model.IOSEntity;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public class IOSAPI {

    private static volatile IOSAPI instance;

    private IOSAPI() {
    }

    public static IOSAPI getInstance() {
        RetrofitManager.setBaseUrl(RequestUrl.BASE_GANKIO_URL);
        if (null == instance) {
            synchronized (IOSAPI.class) {
                if (null == instance) {
                    instance = new IOSAPI();
                }
            }
        }
        return instance;
    }

    public Subscription getData(int limit, int page, Subscriber<IOSEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(IOSContractRequest.class).getData(limit, page);
        return RxUtil.setSubscribe(observable, subscriber);
    }
}
