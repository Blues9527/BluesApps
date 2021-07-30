package com.blues.gankio._new.mvp;

import com.blues.gankio._new.detail.GankPostComments;
import com.blues.gankio._new.detail.GankPostDetail;
import com.blues.gankio._new.hot.GankHotEntity;
import com.blues.gankio._new.mvp.model.GankBannerEntity;
import com.blues.gankio._new.mvp.model.GankCategory;
import com.blues.gankio._new.mvp.model.GankUniversalEntity;
import com.blues.gankio._new.random.GankRandomEntity;
import com.blues.gankio._new.search.GankSearchResult;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author lanhuajian
 * create at 2020/5/4 22:32
 */
public interface GankContractRequest {

    /**
     * 获取gank.io的banner
     */
    @GET("/api/v2/banners")
    Observable<GankBannerEntity> getGankBanner();


    /**
     * 获取分类
     *
     * @param type 可传参数Article | GanHuo | Girl
     */
    @GET("/api/v2/categories/{category_type}")
    Observable<GankCategory> getCategory(@Path("category_type") String type);

    /**
     * 获取对应分类的数据
     *
     * @param category 可接受参数 All(所有分类) | Article | GanHuo | Girl
     * @param type     可接受参数 All(全部类型) | Android | iOS | Flutter | Girl ...，即分类API返回的类型数据
     * @param page     >=1
     * @param count    [10, 50]
     */
    @GET("/api/v2/data/category/{category}/type/{type}/page/{page}/count/{count}")
    Observable<GankUniversalEntity> getCategoryPostList(@Path("category") String category,
                                                        @Path("type") String type,
                                                        @Path("page") int page,
                                                        @Path("count") int count);

    /**
     * 获取随机分类的{count}条数据
     *
     * @param category 可接受参数 All(所有分类) | Article | GanHuo | Girl
     * @param type     可接受参数 All(全部类型) | Android | iOS | Flutter | Girl ...，即分类API返回的类型数据
     * @param count    [10, 50]
     */
    @GET("/api/v2/random/category/{category}/type/{type}/count/{count}")
    Observable<GankRandomEntity> getRandomCategoryPostList(@Path("category") String category,
                                                           @Path("type") String type,
                                                           @Path("count") int count);

    /**
     * 文章详情
     *
     * @param postId 帖子Id 文章id[分类数据API返回的_id字段]
     */
    @GET("/api/v2/post/{post_id}")
    Observable<GankPostDetail> getGankPostDetail(@Path("post_id") String postId);

    /**
     * 本周最热文章列表
     *
     * @param type     可接受参数 views（浏览数） | likes（点赞数） | comments（评论数）
     * @param category 可接受参数 Article | GanHuo | Girl
     * @param count    [1, 20]
     */
    @GET("/api/v2/hot/{hot_type}/category/{category}/count/{count}")
    Observable<GankHotEntity> getGankPostHotList(@Path("hot_type") String type,
                                                 @Path("category") String category,
                                                 @Path("count") int count);

    /**
     * 文章评论
     *
     * @param postId 帖子Id 文章id[分类数据API返回的_id字段]
     */
    @GET("/api/v2/post/comments/{post_id}")
    Observable<GankPostComments> getGankPostComments(@Path("post_id") String postId);

    /**
     * 搜索
     *
     * @param search   要搜索的内容
     * @param category 可接受参数 All[所有分类] | Article | GanHuo
     * @param type     Android | iOS | Flutter ...，即分类API返回的类型数据
     * @param page     >=1
     * @param count    [10, 50]
     */
    @GET("/api/v2/search/{search}/category/{category}/type/{type}/page/{page}/count/{count}")
    Observable<GankSearchResult> getSearchContents(@Path("search") String search,
                                                   @Path("category") String category,
                                                   @Path("type") String type,
                                                   @Path("page") int page,
                                                   @Path("count") int count);
}
