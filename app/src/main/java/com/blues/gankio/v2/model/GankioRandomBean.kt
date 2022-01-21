package com.blues.gankio.v2.model

import com.alibaba.fastjson.annotation.JSONField
import java.io.Serializable

class GankioRandomBean : Serializable {

    /**
     * counts : 10
     * data : [{"_id":"5e72267a907078dcbfe95b96","author":"有时放纵","category":"GanHuo","createdAt":"2015-12-17 03:12:28","desc":"一个textView的动画","images":[],"likeCounts":0,"publishedAt":"2015-12-17 03:57:36","stars":1,"title":"AnimTextView","type":"Android","url":"https://github.com/z56402344/AnimTextView","views":2},{"_id":"5e7225dd907078dcbfe956c8","author":"代码家","category":"GanHuo","createdAt":"2017-07-11 13:38:46","desc":"Android 信用卡交易效果 UI 。","images":[],"likeCounts":0,"publishedAt":"2017-07-11 13:46:33","stars":1,"title":"Luhn","type":"Android","url":"https://github.com/KingsMentor/Luhn","views":2},{"_id":"5e722681907078dcbfe95bd1","author":"Ailurus","category":"GanHuo","createdAt":"2015-11-20 02:52:08","desc":"GitHub Android SDK .","images":[],"likeCounts":0,"publishedAt":"2015-11-20 03:54:49","stars":1,"title":"GithubAndroidSdk","type":"Android","url":"https://github.com/gitskarios/GithubAndroidSdk","views":2},{"_id":"5e722691907078dcbfe95c4f","author":"Jason","category":"GanHuo","createdAt":"2015-10-07 13:06:17","desc":"组图互动模式与动画效果","images":[],"likeCounts":0,"publishedAt":"2015-10-08 04:29:48","stars":1,"title":"beauty-treatment-android-animations","type":"Android","url":"https://github.com/JlUgia/beauty-treatment-android-animations","views":2},{"_id":"5e72262f907078dcbfe95953","author":"郑州","category":"GanHuo","createdAt":"2016-07-28 00:46:32","desc":"Android平台的原生Markdown解析器，将源文本直接解析为Spanned，高效、轻量","images":[],"likeCounts":0,"publishedAt":"2016-07-28 18:17:20","stars":1,"title":"Markdown","type":"Android","url":"https://github.com/zzhoujay/Markdown","views":2},{"_id":"5e722650907078dcbfe95a4b","author":"gzsll","category":"GanHuo","createdAt":"2016-05-06 11:22:33","desc":"https://github.com/marcuswestin/WebViewJavascriptBridge Objective-C与JavaScript交互在Android端的扩展","images":[],"likeCounts":0,"publishedAt":"2016-05-06 12:04:47","stars":1,"title":"WebViewJavascriptBridge","type":"Android","url":"https://github.com/gzsll/WebViewJavascriptBridge","views":2},{"_id":"5e722603907078dcbfe957f0","author":"github","category":"GanHuo","createdAt":"2016-12-30 08:43:12","desc":"类似手机QQ界面右上角的弹出菜单，使用 recyclerview 和 popupwindow 封装了一下。","images":[],"likeCounts":0,"publishedAt":"2016-12-30 16:16:11","stars":1,"title":"TopRightMenu","type":"Android","url":"https://github.com/zaaach/TopRightMenu","views":2},{"_id":"5e7225fb907078dcbfe957b1","author":"KuTear","category":"GanHuo","createdAt":"2017-02-14 11:30:01","desc":"接手老项目，难免遇到前辈的硬编码,怎么办？利用工具剔除出来啊","images":[],"likeCounts":0,"publishedAt":"2017-02-14 11:42:37","stars":1,"title":"Fuck-Hard-Code","type":"Android","url":"https://github.com/Kutear/Fuck-Hard-Code","views":2},{"_id":"5e72263c907078dcbfe959af","author":"dreamxuwj","category":"GanHuo","createdAt":"2016-06-22 10:29:07","desc":"可读取pdf文件的view","images":[],"likeCounts":0,"publishedAt":"2016-06-22 11:57:27","stars":1,"title":"AndroidPdfViewer","type":"Android","url":"https://github.com/barteksc/AndroidPdfViewer","views":2},{"_id":"5e7225cf907078dcbfe9565b","author":"drakeet","category":"GanHuo","createdAt":"2017-12-11 19:21:28","desc":"safe adb：在多设备时更方便地操作 adb，支持批量操作。","images":[],"likeCounts":0,"publishedAt":"2017-12-15 08:59:11","stars":1,"title":"sadb","type":"Android","url":"https://github.com/linroid/sadb","views":2}]
     * status : 100
     */
    @JSONField(name = "counts")
    var counts = 0

    @JSONField(name = "status")
    var status = 0

    @JSONField(name = "data")
    var data: List<DataBean> = mutableListOf()

    class DataBean : Serializable {

        /**
         * _id : 5e72267a907078dcbfe95b96
         * author : 有时放纵
         * category : GanHuo
         * createdAt : 2015-12-17 03:12:28
         * desc : 一个textView的动画
         * images : []
         * likeCounts : 0
         * publishedAt : 2015-12-17 03:57:36
         * stars : 1
         * title : AnimTextView
         * type : Android
         * url : https://github.com/z56402344/AnimTextView
         * views : 2
         */

        @JSONField(name = "_id")
        var id: String = ""

        @JSONField(name = "author")
        var author: String = ""

        @JSONField(name = "category")
        var category: String = ""

        @JSONField(name = "createdAt")
        var createdAt: String = ""

        @JSONField(name = "desc")
        var desc: String = ""

        @JSONField(name = "likeCounts")
        var likeCounts = 0

        @JSONField(name = "publishedAt")
        var publishedAt: String = ""

        @JSONField(name = "stars")
        var stars = 0

        @JSONField(name = "title")
        var title: String = ""

        @JSONField(name = "type")
        var type: String = ""

        @JSONField(name = "url")
        var url: String = ""

        @JSONField(name = "views")
        var views = 0

        @JSONField(name = "images")
        var images: List<String> = mutableListOf()
    }
}