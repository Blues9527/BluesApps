package com.blues.login.model

import com.alibaba.fastjson.annotation.JSONField
import java.io.Serializable

class LoginResponse : Serializable {

    /**
     * data : {"admin":false,"chapterTops":[],"collectIds":[],"email":"","icon":"","id":36590,"nickname":"blues","password":"","publicName":"blues","token":"","type":0,"username":"blues"}
     * errorCode : 0
     * errorMsg :
     */
    @JSONField(name = "data")
    var data: DataBean? = null

    @JSONField(name = "errorCode")
    var errorCode = 0

    @JSONField(name = "errorMsg")
    var errorMsg: String = ""

    class DataBean : Serializable {

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
        @JSONField(name = "admin")
        var isAdmin = false

        @JSONField(name = "email")
        var email: String = ""

        @JSONField(name = "icon")
        var icon: String = ""

        @JSONField(name = "id")
        var id = 0

        @JSONField(name = "nickname")
        var nickname: String = ""

        @JSONField(name = "password")
        var password: String = ""

        @JSONField(name = "publicName")
        var publicName: String = ""

        @JSONField(name = "token")
        var token: String = ""

        @JSONField(name = "type")
        var type = 0

        @JSONField(name = "username")
        var username: String = ""

        @JSONField(name = "chapterTops")
        var chapterTops: List<Any> = mutableListOf()

        @JSONField(name = "collectIds")
        var collectIds: List<Any> = mutableListOf()
    }
}