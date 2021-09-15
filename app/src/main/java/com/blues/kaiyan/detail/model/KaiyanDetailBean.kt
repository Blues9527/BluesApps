package com.blues.kaiyan.detail.model

import com.alibaba.fastjson.annotation.JSONField
import java.io.Serializable

/**
 * User : Blues
 * Date : 2019/8/30
 * Time : 15:17
 */
class KaiyanDetailBean : Serializable {

    @JSONField(name = "count")
    var count = 0

    @JSONField(name = "total")
    var total = 0

    @JSONField(name = "nextPageUrl")
    var nextPageUrl: Any? = null

    @JSONField(name = "adExist")
    var isAdExist = false

    @JSONField(name = "itemList")
    var itemList: List<ItemListBean> = mutableListOf()

    class ItemListBean : Serializable {

        /**
         * type : textCard
         * data : {"dataType":"TextCard","id":0,"type":"header4","text":"音乐类最新视频","subTitle":null,"actionUrl":"eyepetizer://common/?title=%E9%9F%B3%E4%B9%90%E7%B1%BB%E6%9C%80%E6%96%B0%E8%A7%86%E9%A2%91&url=http%3A%2F%2Fbaobab.kaiyanapp.com%2Fapi%2Fv4%2Fvideo%2Fcategory%3Fid%3D20","adTrack":null,"follow":null}
         * tag : null
         * id : 0
         * adIndex : -1
         */
        @JSONField(name = "type")
        var type: String = ""

        @JSONField(name = "data")
        var data: DataBean? = null

        @JSONField(name = "tag")
        var tag: Any? = null

        @JSONField(name = "id")
        var id = 0

        @JSONField(name = "adIndex")
        var adIndex = 0

        class DataBean : Serializable {

            /**
             * dataType : TextCard
             * id : 0
             * type : header4
             * text : 音乐类最新视频
             * subTitle : null
             * actionUrl : eyepetizer://common/?title=%E9%9F%B3%E4%B9%90%E7%B1%BB%E6%9C%80%E6%96%B0%E8%A7%86%E9%A2%91&url=http%3A%2F%2Fbaobab.kaiyanapp.com%2Fapi%2Fv4%2Fvideo%2Fcategory%3Fid%3D20
             * adTrack : null
             * follow : null
             */

            @JSONField(name = "dataType")
            var dataType: String = ""

            @JSONField(name = "id")
            var id = 0

            @JSONField(name = "type")
            var type: String = ""

            @JSONField(name = "text")
            var text: String = ""

            @JSONField(name = "subTitle")
            var subTitle: Any? = null

            @JSONField(name = "actionUrl")
            var actionUrl: String = ""

            @JSONField(name = "adTrack")
            var adTrack: Any = ""

            @JSONField(name = "follow")
            var follow: Any? = null

            @JSONField(name = "title")
            var title: String = ""

            @JSONField(name = "description")
            var description: String = ""

            @JSONField(name = "library")
            var library: String = ""

            @JSONField(name = "consumption")
            var consumption: ConsumptionBean? = null

            @JSONField(name = "resourceType")
            var resourceType: String = ""

            @JSONField(name = "slogan")
            var slogan: Any? = null

            @JSONField(name = "provider")
            var provider: ProviderBean? = null

            @JSONField(name = "category")
            var category: String = ""

            @JSONField(name = "author")
            var author: AuthorBean? = null

            @JSONField(name = "cover")
            var cover: CoverBean? = null

            @JSONField(name = "playUrl")
            var playUrl: String = ""

            @JSONField(name = "thumbPlayUrl")
            var thumbPlayUrl: Any? = null

            @JSONField(name = "duration")
            var duration = 0

            @JSONField(name = "webUrl")
            var webUrl: WebUrlBean? = null

            @JSONField(name = "releaseTime")
            var releaseTime: Long = 0

            @JSONField(name = "campaign")
            var campaign: Any? = null

            @JSONField(name = "waterMarks")
            var waterMarks: Any? = null

            @JSONField(name = "ad")
            var isAd = false

            @JSONField(name = "titlePgc")
            var titlePgc: Any? = null

            @JSONField(name = "descriptionPgc")
            var descriptionPgc: Any? = null

            @JSONField(name = "remark")
            var remark: String = ""

            @JSONField(name = "ifLimitVideo")
            var isIfLimitVideo = false

            @JSONField(name = "searchWeight")
            var searchWeight = 0

            @JSONField(name = "idx")
            var idx = 0

            @JSONField(name = "shareAdTrack")
            var shareAdTrack: Any? = null

            @JSONField(name = "favoriteAdTrack")
            var favoriteAdTrack: Any? = null

            @JSONField(name = "webAdTrack")
            var webAdTrack: Any? = null

            @JSONField(name = "date")
            var date: Long = 0

            @JSONField(name = "promotion")
            var promotion: Any? = null

            @JSONField(name = "label")
            var label: Any? = null

            @JSONField(name = "descriptionEditor")
            var descriptionEditor: String = ""

            @JSONField(name = "collected")
            var isCollected = false

            @JSONField(name = "played")
            var isPlayed = false

            @JSONField(name = "lastViewTime")
            var lastViewTime: Any? = null

            @JSONField(name = "playlists")
            var playlists: Any? = null

            @JSONField(name = "src")
            var src: Any? = null

            @JSONField(name = "tags")
            var tags: List<TagsBean> = mutableListOf()

            @JSONField(name = "playInfo")
            var playInfo: List<PlayInfoBean> = mutableListOf()

            @JSONField(name = "labelList")
            var labelList: List<Any> = mutableListOf()

            @JSONField(name = "subtitles")
            var subtitles: List<Any> = mutableListOf()

            class ConsumptionBean : Serializable {

                /**
                 * collectionCount : 1799
                 * shareCount : 860
                 * replyCount : 14
                 */
                @JSONField(name = "collectionCount")
                var collectionCount = 0

                @JSONField(name = "shareCount")
                var shareCount = 0

                @JSONField(name = "replyCount")
                var replyCount = 0
            }

            class ProviderBean : Serializable {

                /**
                 * name : Vimeo
                 * alias : vimeo
                 * icon : http://img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png
                 */
                @JSONField(name = "name")
                var name: String = ""

                @JSONField(name = "alias")
                var alias: String = ""

                @JSONField(name = "icon")
                var icon: String = ""
            }

            class AuthorBean : Serializable {

                /**
                 * id : 2163
                 * icon : http://img.kaiyanapp.com/9279c17b4da5ba5e7e4f21afb5bb0a74.jpeg
                 * name : 开眼音乐精选
                 * description : 全球最酷、最炫、最有态度的音乐集合
                 * link :
                 * latestReleaseTime : 1567472410000
                 * videoNum : 631
                 * adTrack : null
                 * follow : {"itemType":"author","itemId":2163,"followed":false}
                 * shield : {"itemType":"author","itemId":2163,"shielded":false}
                 * approvedNotReadyVideoCount : 0
                 * ifPgc : true
                 * recSort : 0
                 * expert : false
                 */
                @JSONField(name = "id")
                var id = 0

                @JSONField(name = "icon")
                var icon: String = ""

                @JSONField(name = "name")
                var name: String = ""

                @JSONField(name = "description")
                var description: String = ""

                @JSONField(name = "link")
                var link: String = ""

                @JSONField(name = "latestReleaseTime")
                var latestReleaseTime: Long = 0

                @JSONField(name = "videoNum")
                var videoNum = 0

                @JSONField(name = "adTrack")
                var adTrack: Any? = null

                @JSONField(name = "follow")
                var follow: FollowBean? = null

                @JSONField(name = "shield")
                var shield: ShieldBean? = null

                @JSONField(name = "approvedNotReadyVideoCount")
                var approvedNotReadyVideoCount = 0

                @JSONField(name = "ifPgc")
                var isIfPgc = false

                @JSONField(name = "recSort")
                var recSort = 0

                @JSONField(name = "expert")
                var isExpert = false

                class FollowBean : Serializable {

                    /**
                     * itemType : author
                     * itemId : 2163
                     * followed : false
                     */
                    @JSONField(name = "itemType")
                    var itemType: String = ""

                    @JSONField(name = "itemId")
                    var itemId = 0

                    @JSONField(name = "followed")
                    var isFollowed = false
                }

                class ShieldBean : Serializable {

                    /**
                     * itemType : author
                     * itemId : 2163
                     * shielded : false
                     */
                    @JSONField(name = "itemType")
                    var itemType: String = ""

                    @JSONField(name = "itemId")
                    var itemId = 0

                    @JSONField(name = "shielded")
                    var isShielded = false
                }
            }

            class CoverBean : Serializable {

                /**
                 * feed : http://img.kaiyanapp.com/20a2d60c40c8cb6983e05918b5488d37.jpeg?imageMogr2/quality/60/format/jpg
                 * detail : http://img.kaiyanapp.com/20a2d60c40c8cb6983e05918b5488d37.jpeg?imageMogr2/quality/60/format/jpg
                 * blurred : http://img.kaiyanapp.com/3346238101b8cf4d3f3bee3a133e8990.jpeg?imageMogr2/quality/60/format/jpg
                 * sharing : null
                 * homepage : http://img.kaiyanapp.com/20a2d60c40c8cb6983e05918b5488d37.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim
                 */
                @JSONField(name = "feed")
                var feed: String = ""

                @JSONField(name = "detail")
                var detail: String = ""

                @JSONField(name = "blurred")
                var blurred: String = ""

                @JSONField(name = "sharing")
                var sharing: Any? = null

                @JSONField(name = "homepage")
                var homepage: String = ""
            }

            class WebUrlBean : Serializable {

                /**
                 * raw : http://www.eyepetizer.net/detail.html?vid=171095
                 * forWeibo : http://www.eyepetizer.net/detail.html?vid=171095&resourceType=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0
                 */
                @JSONField(name = "raw")
                var raw: String = ""

                @JSONField(name = "forWeibo")
                var forWeibo: String = ""
            }

            class TagsBean : Serializable {

                /**
                 * id : 18
                 * name : 音乐电台
                 * actionUrl : eyepetizer://tag/18/?title=%E9%9F%B3%E4%B9%90%E7%94%B5%E5%8F%B0
                 * adTrack : null
                 * desc : null
                 * bgPicture : http://img.kaiyanapp.com/70e1bedfdff53729402f1998788c3ee9.jpeg?imageMogr2/quality/60/format/jpg
                 * headerImage : http://img.kaiyanapp.com/a27b2660a5c84adaf5c9fc1ea8cc9946.jpeg?imageMogr2/quality/60/format/jpg
                 * tagRecType : IMPORTANT
                 * childTagList : null
                 * childTagIdList : null
                 * communityIndex : 0
                 */
                @JSONField(name = "id")
                var id = 0

                @JSONField(name = "name")
                var name: String = ""

                @JSONField(name = "actionUrl")
                var actionUrl: String = ""

                @JSONField(name = "adTrack")
                var adTrack: Any? = null

                @JSONField(name = "desc")
                var desc: Any? = null

                @JSONField(name = "bgPicture")
                var bgPicture: String = ""

                @JSONField(name = "headerImage")
                var headerImage: String = ""

                @JSONField(name = "tagRecType")
                var tagRecType: String = ""

                @JSONField(name = "childTagList")
                var childTagList: Any? = null

                @JSONField(name = "childTagIdList")
                var childTagIdList: Any? = null

                @JSONField(name = "communityIndex")
                var communityIndex = 0
            }

            class PlayInfoBean : Serializable {

                /**
                 * height : 480
                 * width : 854
                 * urlList : [{"name":"aliyun","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=171095&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss","size":20077971},{"name":"qcloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=171095&resourceType=video&editionType=normal&source=qcloud&playUrlType=url_oss","size":20077971},{"name":"ucloud","url":"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=171095&resourceType=video&editionType=normal&source=ucloud&playUrlType=url_oss","size":20077971}]
                 * name : 标清
                 * type : normal
                 * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=171095&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss
                 */
                @JSONField(name = "height")
                var height = 0

                @JSONField(name = "width")
                var width = 0

                @JSONField(name = "name")
                var name: String = ""

                @JSONField(name = "type")
                var type: String = ""

                @JSONField(name = "url")
                var url: String = ""

                @JSONField(name = "urlList")
                var urlList: List<UrlListBean> = mutableListOf()

                class UrlListBean : Serializable {

                    /**
                     * name : aliyun
                     * url : http://baobab.kaiyanapp.com/api/v1/playUrl?vid=171095&resourceType=video&editionType=normal&source=aliyun&playUrlType=url_oss
                     * size : 20077971
                     */
                    @JSONField(name = "name")
                    var name: String = ""

                    @JSONField(name = "url")
                    var url: String = ""

                    @JSONField(name = "size")
                    var size = 0
                }
            }
        }
    }
}