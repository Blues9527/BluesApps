package com.blues.module_gank.old.model_web;

import static com.blues.constant.ConstantKt.BASE_GANKIO_URL;

import com.blues.framework.http.RetrofitManager;
import com.blues.framework.utils.RxUtil;
import com.blues.module_gank.old.model_web.model.WebEntity;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/11
 * Email : huajianlan@rastar.com
 */

public class WebAPI {

    private static volatile WebAPI instance;

    private WebAPI() {
    }

    public static WebAPI getInstance() {
        RetrofitManager.setBaseUrl(BASE_GANKIO_URL);
        if (null == instance) {
            synchronized (WebAPI.class) {
                if (null == instance) {
                    instance = new WebAPI();
                }
            }
        }
        return instance;
    }

    public Subscription getData(int limit, int page, Subscriber<WebEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(WebContractRequest.class).getData(limit, page);
        return RxUtil.setSubscribe(observable, subscriber);
    }
}
