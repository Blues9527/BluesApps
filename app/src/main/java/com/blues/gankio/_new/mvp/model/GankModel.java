package com.blues.gankio._new.mvp.model;

import com.blues.framework.http.HttpCallBack;
import com.blues.gankio._new.mvp.GankContract;
import com.blues.gankio._new.detail.GankPostComments;
import com.blues.gankio._new.detail.GankPostDetail;
import com.blues.gankio._new.hot.GankHotEntity;
import com.blues.gankio._new.random.GankRandomEntity;
import com.blues.gankio._new.search.GankSearchResult;

import rx.Subscriber;
import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public class GankModel implements GankContract.iGankModel {

    @Override
    public Subscription getGankBanner(HttpCallBack<GankBannerEntity> callBack) {
        return GankAPI.getInstance().getGankBanner(new Subscriber<GankBannerEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(GankBannerEntity entity) {
                callBack.onSuccess(entity);
            }
        });
    }

    @Override
    public Subscription getCategory(String type, HttpCallBack<GankCategory> callBack) {
        return GankAPI.getInstance().getCategory(type, new Subscriber<GankCategory>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(GankCategory category) {
                callBack.onSuccess(category);
            }
        });
    }

    @Override
    public Subscription getCategoryPostList(String category, String type, int page, int count, HttpCallBack<GankUniversalEntity> callBack) {
        return GankAPI.getInstance().getCategoryPostList(category, type, page, count, new Subscriber<GankUniversalEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(GankUniversalEntity entity) {
                callBack.onSuccess(entity);
            }
        });
    }

    @Override
    public Subscription getRandomCategoryPostList(String category, String type, int count, HttpCallBack<GankRandomEntity> callBack) {
        return GankAPI.getInstance().getRandomCategoryPostList(category, type, count, new Subscriber<GankRandomEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(GankRandomEntity entity) {
                callBack.onSuccess(entity);
            }
        });
    }

    @Override
    public Subscription getGankPostDetail(String postId, HttpCallBack<GankPostDetail> callBack) {
        return GankAPI.getInstance().getGankPostDetail(postId, new Subscriber<GankPostDetail>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(GankPostDetail detail) {
                callBack.onSuccess(detail);
            }
        });
    }

    @Override
    public Subscription getGankPostHotList(String type, String category, int count, HttpCallBack<GankHotEntity> callBack) {
        return GankAPI.getInstance().getGankPostHotList(type, category, count, new Subscriber<GankHotEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(GankHotEntity entity) {
                callBack.onSuccess(entity);
            }
        });
    }

    @Override
    public Subscription getGankPostComments(String postId, HttpCallBack<GankPostComments> callBack) {
        return GankAPI.getInstance().getGankPostComments(postId, new Subscriber<GankPostComments>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(GankPostComments comments) {
                callBack.onSuccess(comments);
            }
        });
    }

    @Override
    public Subscription getSearchContents(String search, String category, String type, int page, int count, HttpCallBack<GankSearchResult> callBack) {
        return GankAPI.getInstance().getSearchContents(search, category, type, page, count, new Subscriber<GankSearchResult>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                callBack.onFailure(e);
            }

            @Override
            public void onNext(GankSearchResult result) {
                callBack.onSuccess(result);
            }
        });
    }
}
