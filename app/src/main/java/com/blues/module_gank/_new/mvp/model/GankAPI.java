package com.blues.module_gank._new.mvp.model;

import com.blues.constant.RequestUrl;
import com.blues.framework.http.RetrofitManager;
import com.blues.framework.utils.RxUtil;
import com.blues.module_gank._new.mvp.GankContractRequest;
import com.blues.module_gank._new.detail.GankPostComments;
import com.blues.module_gank._new.detail.GankPostDetail;
import com.blues.module_gank._new.hot.GankHotEntity;
import com.blues.module_gank._new.random.GankRandomEntity;
import com.blues.module_gank._new.search.GankSearchResult;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/**
 * @author lanhuajian
 * create at 2020/5/5 21:42
 */

public class GankAPI {

    private static volatile GankAPI instance;

    private GankAPI() {
    }

    public static GankAPI getInstance() {
        RetrofitManager.setBaseUrl(RequestUrl.BASE_GANKIO_URL);
        if (null == instance) {
            synchronized (GankAPI.class) {
                if (null == instance) {
                    instance = new GankAPI();
                }
            }
        }
        return instance;
    }

    /**
     * 获取gank.io的banner
     */
    public Subscription getGankBanner(Subscriber<GankBannerEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(GankContractRequest.class).getGankBanner();
        return RxUtil.setSubscribe(observable, subscriber);
    }

    /**
     * 获取分类
     */
    public Subscription getCategory(String type, Subscriber<GankCategory> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(GankContractRequest.class).getCategory(type);
        return RxUtil.setSubscribe(observable, subscriber);
    }

    /**
     * 获取对应分类的数据
     */
    public Subscription getCategoryPostList(String category, String type, int page, int count, Subscriber<GankUniversalEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(GankContractRequest.class).getCategoryPostList(category, type, page, count);
        return RxUtil.setSubscribe(observable, subscriber);
    }

    /**
     * 获取随机分类的{count}条数据
     */
    public Subscription getRandomCategoryPostList(String category, String type, int count, Subscriber<GankRandomEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(GankContractRequest.class).getRandomCategoryPostList(category, type, count);
        return RxUtil.setSubscribe(observable, subscriber);
    }

    /**
     * 文章详情
     */
    public Subscription getGankPostDetail(String postId, Subscriber<GankPostDetail> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(GankContractRequest.class).getGankPostDetail(postId);
        return RxUtil.setSubscribe(observable, subscriber);
    }

    /**
     * 本周最热文章列表
     */
    public Subscription getGankPostHotList(String type, String category, int count, Subscriber<GankHotEntity> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(GankContractRequest.class).getGankPostHotList(type, category, count);
        return RxUtil.setSubscribe(observable, subscriber);
    }

    /**
     * 文章评论
     */
    public Subscription getGankPostComments(String postId, Subscriber<GankPostComments> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(GankContractRequest.class).getGankPostComments(postId);
        return RxUtil.setSubscribe(observable, subscriber);
    }

    /**
     * 搜索
     */
    public Subscription getSearchContents(String search, String category, String type,
                                          int page, int count, Subscriber<GankSearchResult> subscriber) {
        Observable observable = RetrofitManager.getInstance().create(GankContractRequest.class).getSearchContents(search, category, type, page, count);
        return RxUtil.setSubscribe(observable, subscriber);
    }


}
