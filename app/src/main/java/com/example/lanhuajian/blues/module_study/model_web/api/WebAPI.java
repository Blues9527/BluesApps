package com.example.lanhuajian.blues.module_study.model_web.api;

import com.example.framework.http.RetrofitManager;
import com.example.framework.utils.RxUtil;
import com.example.lanhuajian.blues.constant.RequestUrl;
import com.example.lanhuajian.blues.module_study.model_web.model.WebEntity;
import com.example.lanhuajian.blues.module_study.model_web.request.WebContractRequest;

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
        RetrofitManager.setBaseUrl(RequestUrl.BASE_URL);
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
