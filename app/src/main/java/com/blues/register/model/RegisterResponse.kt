package com.blues.register.model

import com.alibaba.fastjson.annotation.JSONField

/**
 * data : {"admin":false,"chapterTops":[],"collectIds":[],"email":"","icon":"","id":36590,"nickname":"blues","password":"","publicName":"blues","token":"","type":0,"username":"blues"}
 * errorCode : 0
 * errorMsg :
 */
data class RegisterResponse(
    @JSONField(name = "data") var data: DataBean,
    @JSONField(name = "errorCode") var errorCode: Int = 0,
    @JSONField(name = "errorMsg") var errorMsg: String,
) {

    /**
     * admin : false
     * chapterTops : []
     * collectIds : []
     * email :
     * icon :
     * id : 36590
     * nickname : blues
     * password :
     * publicName : blues
     * token :
     * type : 0
     * username : blues
     */
    data class DataBean(
        @JSONField(name = "admin") var isAdmin: Boolean = false,
        @JSONField(name = "email") var email: String,
        @JSONField(name = "icon") var icon: String,
        @JSONField(name = "id") var id: Int = 0,
        @JSONField(name = "nickname") var nickname: String,
        @JSONField(name = "password") var password: String,
        @JSONField(name = "publicName") var publicName: String,
        @JSONField(name = "token") var token: String,
        @JSONField(name = "type") var type: Int = 0,
        @JSONField(name = "username") var username: String,
        @JSONField(name = "chapterTops") var chapterTops: List<Any>,
        @JSONField(name = "collectIds") var collectIds: List<Any>,
    )
}