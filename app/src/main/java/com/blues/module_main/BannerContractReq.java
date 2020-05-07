package com.blues.module_main;


import com.blues.model_wanandroid.WanAndroidBannerEntity;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @author lanhuajian
 * create at 2020/5/4 21:56
 */

public interface BannerContractReq {

    /**
     * wan android 获取banner
     *
     * @return
     */
    @GET("/banner/json")
    Observable<WanAndroidBannerEntity> getBanner();
}
