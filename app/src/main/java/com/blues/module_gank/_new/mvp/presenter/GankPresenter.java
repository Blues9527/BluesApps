package com.blues.module_gank._new.mvp.presenter;

import com.blues.framework.base.BaseView;
import com.blues.framework.base.RxPresenter;
import com.blues.framework.http.HttpCallBack;
import com.blues.module_gank._new.detail.GankPostComments;
import com.blues.module_gank._new.detail.GankPostDetail;
import com.blues.module_gank._new.hot.GankHotEntity;
import com.blues.module_gank._new.mvp.GankConstant;
import com.blues.module_gank._new.mvp.GankContract;
import com.blues.module_gank._new.mvp.model.GankBannerEntity;
import com.blues.module_gank._new.mvp.model.GankCategory;
import com.blues.module_gank._new.mvp.model.GankModel;
import com.blues.module_gank._new.mvp.model.GankUniversalEntity;
import com.blues.module_gank._new.random.GankRandomEntity;
import com.blues.module_gank._new.search.GankSearchResult;


/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public class GankPresenter extends RxPresenter implements GankContract.iGankPresenter {

    private GankContract.iGankModel iModel;
    private GankContract.iGankView iView;

    private static final int DEFAULT_COUNT = 15;
    private static int mCurrentPostListPage;

    public GankPresenter(BaseView mView) {
        super(mView);
        iModel = new GankModel();
        iView = (GankContract.iGankView) mView;
    }

    @Override
    public void initData() {
        //一开始要加载banner和category
        getGankBanner();
        //干货，可能需要合并girl
        getCategory(GankConstant.GANK);
    }

    @Override
    public void getGankBanner() {
        iView.showLoading();
        subscribe(iModel.getGankBanner(new HttpCallBack<GankBannerEntity>() {
            @Override
            public void onSuccess(GankBannerEntity data) {
                if (data != null) {
                    iView.setBanner(data.getData());
                    iView.showFinished();
                } else {
                    iView.showEmpty();
                }
            }

            @Override
            public void onFailure(String error) {
                iView.showError();
            }
        }));
    }

    @Override
    public void getCategory(String type) {
        iView.showLoading();
        subscribe(iModel.getCategory(type, new HttpCallBack<GankCategory>() {
            @Override
            public void onSuccess(GankCategory data) {
                if (data != null) {
                    iView.setCategory(data.getData());
                    iView.showFinished();
                } else {
                    iView.showEmpty();
                }
            }

            @Override
            public void onFailure(String error) {
                iView.showError();
            }
        }));
    }

    @Override
    public void getCategoryPostList(String type) {
        getCategoryPostList(GankConstant.GANK, type, mCurrentPostListPage = 1, DEFAULT_COUNT);
    }

    @Override
    public void getCategoryPostList(String category, String type) {
        getCategoryPostList(category, type, mCurrentPostListPage = 1, DEFAULT_COUNT);
    }

    @Override
    public void getCategoryPostList(String category, String type, int page, int count) {
        iView.showLoading();
        subscribe(iModel.getCategoryPostList(category, type, page, count, new HttpCallBack<GankUniversalEntity>() {
            @Override
            public void onSuccess(GankUniversalEntity data) {
                if (data != null) {
                    iView.setPostList(data.getData());
                    iView.showFinished();
                } else {
                    iView.showEmpty();
                }
            }

            @Override
            public void onFailure(String error) {
                iView.showError();
            }
        }));
    }

    @Override
    public void loadCategoryPostListMore(String type) {
        getCategoryPostList(GankConstant.GANK, type, ++mCurrentPostListPage, DEFAULT_COUNT);
    }

    @Override
    public void loadCategoryPostListMore(String category, String type) {
        getCategoryPostList(category, type, ++mCurrentPostListPage, DEFAULT_COUNT);
    }

    @Override
    public void getRandomCategoryPostList(String type) {
        getRandomCategoryPostList(GankConstant.GANK, type, DEFAULT_COUNT);
    }

    @Override
    public void getRandomCategoryPostList(String category, String type, int count) {
        iView.showLoading();
        subscribe(iModel.getRandomCategoryPostList(category, type, count, new HttpCallBack<GankRandomEntity>() {
            @Override
            public void onSuccess(GankRandomEntity data) {
                if (data != null) {
                    iView.setRandomPostList(data.getData());
                    iView.showFinished();
                } else {
                    iView.showEmpty();
                }
            }

            @Override
            public void onFailure(String error) {
                iView.showError();
            }
        }));
    }

    @Override
    public void getGankPostDetail(String postId) {
        iView.showLoading();
        subscribe(iModel.getGankPostDetail(postId, new HttpCallBack<GankPostDetail>() {
            @Override
            public void onSuccess(GankPostDetail data) {
                if (data != null) {
                    iView.setPostDetail(data.getData());
                    iView.showFinished();
                } else {
                    iView.showEmpty();
                }
            }

            @Override
            public void onFailure(String error) {
                iView.showError();
            }
        }));
    }

    @Override
    public void getGankPostHotList(String type) {
        getGankPostHotList(type, GankConstant.GANK, DEFAULT_COUNT);
    }

    @Override
    public void getGankPostHotList(String type, String category, int count) {
        iView.showLoading();
        subscribe(iModel.getGankPostHotList(type, category, count, new HttpCallBack<GankHotEntity>() {
            @Override
            public void onSuccess(GankHotEntity data) {
                if (data != null) {
                    iView.setPostHotList(data.getData());
                    iView.showFinished();
                } else {
                    iView.showEmpty();
                }
            }

            @Override
            public void onFailure(String error) {
                iView.showError();
            }
        }));
    }

    @Override
    public void getGankPostComments(String postId) {
        iView.showLoading();
        subscribe(iModel.getGankPostComments(postId, new HttpCallBack<GankPostComments>() {
            @Override
            public void onSuccess(GankPostComments data) {
                if (data != null) {
                    iView.setPostComments(data);
                    iView.showFinished();
                } else {
                    iView.showEmpty();
                }
            }

            @Override
            public void onFailure(String error) {
                iView.showError();
            }
        }));
    }

    @Override
    public void getSearchContents(String search, String category, String type, int page, int count) {
        iView.showLoading();
        subscribe(iModel.getSearchContents(search, category, type, page, count, new HttpCallBack<GankSearchResult>() {
            @Override
            public void onSuccess(GankSearchResult data) {
                if (data != null) {
                    iView.setSearchContents(data.getData());
                    iView.showFinished();
                } else {
                    iView.showEmpty();
                }
            }

            @Override
            public void onFailure(String error) {
                iView.showError();
            }
        }));
    }

    @Override
    public void loadSearchContentsMore() {

    }
}
