package com.example.lanhuajian.blues.module_personalpage;

import retrofit2.http.GET;
import rx.Observable;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 09:59
 */

public interface UserInfoContractReq {

    @GET("/mock/5ce5f817c97ddf44b9fe3354/blues/userInfo")
    Observable<UserInfoEntity> getUserInfo();
}
