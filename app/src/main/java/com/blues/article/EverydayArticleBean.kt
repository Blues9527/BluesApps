package com.blues.article

import com.alibaba.fastjson.annotation.JSONField

/**
 * 每日一文实体类
 * 使用本地模拟数据
 */
class EverydayArticleBean {
    @JSONField(name = "data")
    var data: Data? = null

    class Data {

        @JSONField(name = "author")
        var author: String? = null

        @JSONField(name = "content")
        var content: String? = null

        @JSONField(name = "date")
        var date: String? = null

        @JSONField(name = "digest")
        var digest: String? = null

        @JSONField(name = "title")
        var title: String? = null

        @JSONField(name = "wc")
        var wc: Int = 0
    }
}
