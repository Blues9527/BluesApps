package com.blues.home.model

import com.alibaba.fastjson.annotation.JSONField
import java.io.Serializable

/**
 * User : Blues
 * Date : 2019/8/1
 * Time : 11:04
 */
class WanAndroidBannerEntity : Serializable {

    /**
     * data : [{"desc":"Android高级进阶直播课免费学习","id":24,"imagePath":"https://www.wanandroid.com/blogimgs/bb4937de-b6f3-4c7e-b7d0-66d02f54abee.jpeg","isVisible":1,"order":10,"title":"Android高级进阶直播课免费学习\t","type":0,"url":"https://url.163.com/4bj"},{"desc":"一起来做个App吧","id":10,"imagePath":"https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png","isVisible":1,"order":0,"title":"一起来做个App吧","type":1,"url":"http://www.wanandroid.com/blog/show/2"},{"desc":"","id":6,"imagePath":"https://www.wanandroid.com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png","isVisible":1,"order":1,"title":"我们新增了一个常用导航Tab~","type":1,"url":"http://www.wanandroid.com/navi"},{"desc":"","id":20,"imagePath":"https://www.wanandroid.com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png","isVisible":1,"order":2,"title":"flutter 中文社区 ","type":1,"url":"https://flutter.cn/"}]
     * errorCode : 0
     * errorMsg :
     */

    @JSONField(name = "errorCode")
    var errorCode = 0

    @JSONField(name = "errorMsg")
    var errorMsg: String = ""

    @JSONField(name = "data")
    var data: List<DataBean> = mutableListOf()

    class DataBean : Serializable {

        /**
         * desc : Android高级进阶直播课免费学习
         * id : 24
         * imagePath : https://www.wanandroid.com/blogimgs/bb4937de-b6f3-4c7e-b7d0-66d02f54abee.jpeg
         * isVisible : 1
         * order : 10
         * title : Android高级进阶直播课免费学习
         * type : 0
         * url : https://url.163.com/4bj
         */
        @JSONField(name = "desc")
        var desc: String = ""

        @JSONField(name = "id")
        var id = 0

        @JSONField(name = "imagePath")
        var imagePath: String = ""

        @JSONField(name = "isVisible")
        var isVisible = 0

        @JSONField(name = "order")
        var order = 0

        @JSONField(name = "title")
        var title: String = ""

        @JSONField(name = "type")
        var type = 0

        @JSONField(name = "url")
        var url: String = ""
    }
}