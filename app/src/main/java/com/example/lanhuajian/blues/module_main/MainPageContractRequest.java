package com.example.lanhuajian.blues.module_main;

import retrofit2.http.GET;
import rx.Observable;

/**
 * User : Blues
 * Date : 2019/5/17
 * Time : 10:07
 */

public interface MainPageContractRequest {

    @GET("/getVideo")
    Observable<VideoEntity> getVideo();
}
