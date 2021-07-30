package com.blues.gankio._new.mvp;

import com.blues.framework.base.BasePresenter;
import com.blues.framework.base.BaseView;
import com.blues.framework.http.HttpCallBack;
import com.blues.gankio._new.detail.GankPostComments;
import com.blues.gankio._new.detail.GankPostDetail;
import com.blues.gankio._new.hot.GankHotEntity;
import com.blues.gankio._new.mvp.model.GankBannerEntity;
import com.blues.gankio._new.mvp.model.GankCategory;
import com.blues.gankio._new.mvp.model.GankUniversalEntity;
import com.blues.gankio._new.random.GankRandomEntity;
import com.blues.gankio._new.search.GankSearchResult;

import java.util.List;

import rx.Subscription;

public interface GankContract {
    interface iGankView extends BaseView<iGankPresenter> {

        void setBanner(List<GankBannerEntity.DataBean> banner);

        default void loadBannerFailed(String msg) {
        }

        void setCategory(List<GankCategory.DataBean> category);

        default void loadCategoryFailed(String msg) {
        }

        void setPostList(List<GankUniversalEntity.DataBean> postList);

        default void loadPostListFailed(String msg) {
        }

        void setRandomPostList(List<GankRandomEntity.DataBean> randomPostList);

        default void loadRandomPostListFailed(String msg) {
        }

        void setPostDetail(GankPostDetail.DataBean postDetail);

        default void loadPostDetailFailed(String msg) {
        }

        void setPostHotList(List<GankHotEntity.DataBean> hotList);

        default void loadPostHotListFailed(String msg) {
        }

        void setPostComments(GankPostComments comments);

        default void loadPostCommentsFailed(String msg) {
        }

        void setSearchContents(List<GankSearchResult.DataBean> searchContents);

        default void loadSearchContentsFailed(String msg) {
        }
    }

    interface iGankPresenter extends BasePresenter {

        void initData();

        void getGankBanner();

        void getCategory(String type);

        void getCategoryPostList(String type);

        void getCategoryPostList(String category, String type);

        void getCategoryPostList(String category,
                                 String type,
                                 int page,
                                 int count);

        void loadCategoryPostListMore(String type);

        void loadCategoryPostListMore(String category, String type);

        void getRandomCategoryPostList(String type);

        void getRandomCategoryPostList(String category,
                                       String type,
                                       int count);

        void getGankPostDetail(String postId);

        void getGankPostHotList(String type);

        void getGankPostHotList(String type,
                                String category,
                                int count);

        void getGankPostComments(String postId);

        void getSearchContents(String search,
                               String category,
                               String type,
                               int page,
                               int count);

        void loadSearchContentsMore();
    }

    interface iGankModel {

        /**
         * banner
         */
        Subscription getGankBanner(HttpCallBack<GankBannerEntity> callBack);

        /**
         * 分类
         */
        Subscription getCategory(String type, HttpCallBack<GankCategory> callBack);

        /**
         * 帖子列表
         */
        Subscription getCategoryPostList(String category,
                                         String type,
                                         int page,
                                         int count,
                                         HttpCallBack<GankUniversalEntity> callBack);

        /**
         * 随机帖子
         */
        Subscription getRandomCategoryPostList(String category,
                                               String type,
                                               int count,
                                               HttpCallBack<GankRandomEntity> callBack);

        /**
         * 帖子详情
         */
        Subscription getGankPostDetail(String postId, HttpCallBack<GankPostDetail> callBack);

        /**
         * 热门帖子
         */
        Subscription getGankPostHotList(String type,
                                        String category,
                                        int count,
                                        HttpCallBack<GankHotEntity> callBack);

        /**
         * 文章评论
         */
        Subscription getGankPostComments(String postId, HttpCallBack<GankPostComments> callBack);

        /**
         * 搜索
         */
        Subscription getSearchContents(String search,
                                       String category,
                                       String type,
                                       int page,
                                       int count,
                                       HttpCallBack<GankSearchResult> callBack);
    }
}
