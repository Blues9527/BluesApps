package com.blues.gankio.old.model_fuli;

import static com.blues.constant.ConstantKt.BASE_GANKIO_URL;

import com.blues.framework.http.RetrofitManager;
import com.blues.framework.utils.RxUtil;
import com.blues.gankio.old.model_fuli.model.FuliEntity;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/11
 * Email : huajianlan@rastar.com
 */

public class FuliAPI {

    private static volatile FuliAPI instance;

    private FuliAPI() {
    }

    public static FuliAPI getInstance() {
        RetrofitManager.setBaseUrl(BASE_GANKIO_URL);
        if (null == instance) {
            synchronized (FuliAPI.class) {
                if (null == instance) {
                    instance = new FuliAPI();
                }
            }
        }
        return instance;
    }

    public Subscription getData(int limit, int page, Subscriber<FuliEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(FuliContractRequest.class).getData(limit, page);
        return RxUtil.setSubscribe(observable, subscriber);
    }
}
