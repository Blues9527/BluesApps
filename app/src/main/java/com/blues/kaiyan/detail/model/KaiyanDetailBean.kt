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

                @JSONField(name = "collectionCount")
                var collectionCount = 0

                @JSONField(name = "shareCount")
                var shareCount = 0

                @JSONField(name = "replyCount")
                var replyCount = 0
            }

            class ProviderBean : Serializable {

                @JSONField(name = "name")
                var name: String = ""

                @JSONField(name = "alias")
                var alias: String = ""

                @JSONField(name = "icon")
                var icon: String = ""
            }

            class AuthorBean : Serializable {

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

                    @JSONField(name = "itemType")
                    var itemType: String = ""

                    @JSONField(name = "itemId")
                    var itemId = 0

                    @JSONField(name = "followed")
                    var isFollowed = false
                }

                class ShieldBean : Serializable {

                    @JSONField(name = "itemType")
                    var itemType: String = ""

                    @JSONField(name = "itemId")
                    var itemId = 0

                    @JSONField(name = "shielded")
                    var isShielded = false
                }
            }

            class CoverBean : Serializable {

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

                @JSONField(name = "raw")
                var raw: String = ""

                @JSONField(name = "forWeibo")
                var forWeibo: String = ""
            }

            class TagsBean : Serializable {

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