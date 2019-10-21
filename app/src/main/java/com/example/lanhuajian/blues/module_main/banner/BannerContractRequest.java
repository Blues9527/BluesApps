package com.example.lanhuajian.blues.module_main.banner;


import retrofit2.http.GET;
import rx.Observable;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 17:20
 */

public interface BannerContractRequest {

    @GET("/banner/json")
    Observable<BannerEntity> getBanner();

    @GET("/j/microSpec/fetchLiveData.json")
    Observable<MicroSpecEntity> getMicroSpec();
}
