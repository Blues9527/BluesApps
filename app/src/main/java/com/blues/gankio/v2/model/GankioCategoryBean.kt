package com.blues.gankio.v2.model

import com.alibaba.fastjson.annotation.JSONField
import java.io.Serializable

class GankioCategoryBean : Serializable {

    /**
     * data : [{"_id":"5e59ec146d359d60b476e621","coverImageUrl":"http://gank.io/images/b9f867a055134a8fa45ef8a321616210","desc":"Always deliver more than expected.（Larry Page）","title":"Android","type":"Android"},{"_id":"5e59ed0e6e851660b43ec6bb","coverImageUrl":"http://gank.io/images/d435eaad954849a5b28979dd3d2674c7","desc":"Innovation distinguishes between a leader and a follower.（Steve Jobs）","title":"苹果","type":"iOS"},{"_id":"5e5a25346e851660b43ec6bc","coverImageUrl":"http://gank.io/images/c1ce555daf954961a05a69e64892b2cc","desc":"The man who has made up his mind to win will never say \u201c Impossible\u201d。（ Napoleon ）","title":"Flutter","type":"Flutter"},{"_id":"5e5a254b6e851660b43ec6bd","coverImageUrl":"http://gank.io/images/4415653ca3b341be8c61fcbe8cd6c950","desc":"Education is a progressive discovery of our own ignorance. （ W. Durant ）","title":"前端","type":"frontend"},{"_id":"5e5a25716e851660b43ec6bf","coverImageUrl":"http://gank.io/images/c3c7e64f0c0647e3a6453ccf909e9780","desc":"Do not, for one repulse, forgo the purpose that you resolved to effort. （ Shakespeare ）","title":"APP","type":"app"}]
     * status : 100
     */
    @JSONField(name = "status")
    var status = 0

    @JSONField(name = "data")
    var data: List<DataBean> = mutableListOf()

    class DataBean : Serializable {

        /**
         * _id : 5e59ec146d359d60b476e621
         * coverImageUrl : http://gank.io/images/b9f867a055134a8fa45ef8a321616210
         * desc : Always deliver more than expected.（Larry Page）
         * title : Android
         * type : Android
         */

        @JSONField(name = "_id")
        private var id: String = ""

        @JSONField(name = "coverImageUrl")
        var coverImageUrl: String = ""

        @JSONField(name = "desc")
        var desc: String = ""

        @JSONField(name = "title")
        var title: String = ""

        @JSONField(name = "type")
        var type: String = ""
    }
}