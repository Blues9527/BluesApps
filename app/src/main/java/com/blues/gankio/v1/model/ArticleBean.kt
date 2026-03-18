package com.blues.gankio.v1.model

import com.alibaba.fastjson.annotation.JSONField
import java.io.Serializable

class ArticleBean : Serializable {

    var articleDetail: List<ArticleDetailBean> = mutableListOf()

    class ArticleDetailBean : Serializable {

        /**
         * id : 1
         * title : Gradle配置技巧
         * url : http://note.youdao.com/noteshare?id=2eb23a0d21cb8ef133c29814e99eec1c
         */
        @JSONField(name = "id")
        var id = 0

        @JSONField(name = "title")
        var title: String = ""

        @JSONField(name = "url")
        var url: String = ""
    }
}