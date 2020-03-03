package com.blues.module_kaiyan;

import com.blues.constant.RequestUrl;
import com.blues.framework.http.RetrofitManager;
import com.blues.framework.utils.RxUtil;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:04
 */

public class OpenEyeAPI {

    private static volatile OpenEyeAPI instance;

    private OpenEyeAPI() {
    }

    public static OpenEyeAPI getInstance() {
        RetrofitManager.setBaseUrl(RequestUrl.BASE_KAIYAN_URL);
        if (null == instance) {
            synchronized (OpenEyeAPI.class) {
                if (null == instance) {
                    instance = new OpenEyeAPI();
                }
            }
        }
        return instance;
    }

    //获取排行内容
    public Subscription getRankList(Subscriber<OpenEyeEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(OpenEyeContractReq.class).getRankList();
        return RxUtil.setSubscribe(observable, subscriber);
    }

    //获取周/月/总排行内容
    public Subscription getRankList(String strategy, Subscriber<OpenEyeEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(OpenEyeContractReq.class).getRankList(strategy);
        return RxUtil.setSubscribe(observable, subscriber);
    }

    //获取搜索热词
    public Subscription getHotSearch(Subscriber<List<String>> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(OpenEyeContractReq.class).getHotSearch();
        return RxUtil.setSubscribe(observable, subscriber);
    }

    //获取搜索结果
    public Subscription getSearchResult(String query, Subscriber<OpenEyeEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(OpenEyeContractReq.class).getSearchResult(10, 10, query);
        return RxUtil.setSubscribe(observable, subscriber);
    }
}
