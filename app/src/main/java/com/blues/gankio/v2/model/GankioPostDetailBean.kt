package com.blues.gankio.v2.model

import com.alibaba.fastjson.annotation.JSONField
import java.io.Serializable

class GankioPostDetailBean : Serializable {

    /**
     * data : {"_id":"5e777432b8ea09cade05263f","author":"鸢媛","category":"Girl","content":"这世界总有人在笨拙地爱着你，想把全部的温柔都给你。","createdAt":"2020-03-25 08:00:00","desc":"这世界总有人在笨拙地爱着你，想把全部的温柔都给你。","images":["http://gank.io/images/624ade89f93f421b8d4e8fafd86b1d8d"],"index":35,"isOriginal":true,"license":"","likeCount":0,"likeCounts":1,"likes":["DBRef('users', ObjectId('5b6ce9c89d21226f4e09c779'))"],"markdown":"","originalAuthor":"","publishedAt":"2020-03-25 08:00:00","stars":1,"status":1,"tags":[],"title":"第35期","type":"Girl","updatedAt":"2020-03-25 08:00:00","url":"http://gank.io/images/624ade89f93f421b8d4e8fafd86b1d8d","views":1077}
     * status : 100
     */

    @JSONField(name = "data")
    var data: DataBean? = null

    @JSONField(name = "status")
    var status = 0

    class DataBean : Serializable {

        /**
         * _id : 5e777432b8ea09cade05263f
         * author : 鸢媛
         * category : Girl
         * content : 这世界总有人在笨拙地爱着你，想把全部的温柔都给你。
         * createdAt : 2020-03-25 08:00:00
         * desc : 这世界总有人在笨拙地爱着你，想把全部的温柔都给你。
         * images : ["http://gank.io/images/624ade89f93f421b8d4e8fafd86b1d8d"]
         * index : 35
         * isOriginal : true
         * license :
         * likeCount : 0
         * likeCounts : 1
         * likes : ["DBRef('users', ObjectId('5b6ce9c89d21226f4e09c779'))"]
         * markdown :
         * originalAuthor :
         * publishedAt : 2020-03-25 08:00:00
         * stars : 1
         * status : 1
         * tags : []
         * title : 第35期
         * type : Girl
         * updatedAt : 2020-03-25 08:00:00
         * url : http://gank.io/images/624ade89f93f421b8d4e8fafd86b1d8d
         * views : 1077
         */
        @JSONField(name = "_id")
        var id: String = ""

        @JSONField(name = "author")
        var author: String = ""

        @JSONField(name = "category")
        var category: String = ""

        @JSONField(name = "content")
        var content: String = ""

        @JSONField(name = "createdAt")
        var createdAt: String = ""

        @JSONField(name = "desc")
        var desc: String = ""

        @JSONField(name = "index")
        var index = 0

        @JSONField(name = "isOriginal")
        var isIsOriginal = false

        @JSONField(name = "license")
        var license: String = ""

        @JSONField(name = "likeCount")
        var likeCount = 0

        @JSONField(name = "likeCounts")
        var likeCounts = 0

        @JSONField(name = "markdown")
        var markdown: String = ""

        @JSONField(name = "originalAuthor")
        var originalAuthor: String = ""

        @JSONField(name = "publishedAt")
        var publishedAt: String = ""

        @JSONField(name = "stars")
        var stars = 0

        @JSONField(name = "status")
        var status = 0

        @JSONField(name = "title")
        var title: String = ""

        @JSONField(name = "type")
        var type: String = ""

        @JSONField(name = "updatedAt")
        var updatedAt: String = "¬"

        @JSONField(name = "url")
        var url: String = ""

        @JSONField(name = "views")
        var views = 0

        @JSONField(name = "images")
        var images: List<String> = mutableListOf()

        @JSONField(name = "likes")
        var likes: List<String> = mutableListOf()

        @JSONField(name = "tags")
        var tags: List<Any> = mutableListOf()
    }
}