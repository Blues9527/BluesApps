package com.blues.kaiyan.daily.model

import com.alibaba.fastjson.annotation.JSONField


/**
 * File: com.blues.kaiyan.daily.model.KaiyanDailyBean.kt
 * Description: 开眼日报数据模型实体类
 *
 * @author lanhuajian
 * @date 2023/6/29
 **/

class KaiyanDailyBean {
    /**
     * {
    "itemList": [
    {
    "type": "textCard",
    "data": {
    "dataType": "TextCard",
    "id": 0,
    "type": "header5",
    "text": "今日开眼精选",
    "subTitle": null,
    "actionUrl": null,
    "adTrack": null,
    "follow": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318699,
    "title": "全球广告精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/2162/?title=%E5%85%A8%E7%90%83%E5%B9%BF%E5%91%8A%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg",
    "iconType": "round",
    "description": "#广告 / 收录于 每日编辑精选",
    "time": 1688000445000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318699,
    "title": "711 便利店脑洞广告，深夜的咖啡风暴",
    "description": "711 便利店脑洞广告短片，在大雪纷飞的深夜，便利店也不会打烊，为每一位顾客带来仅售 1 美元的冰咖啡，深夜送「温暖」。From Mark Leephaibul",
    "library": "DAILY",
    "tags": [
    {
    "id": 748,
    "name": "这些广告超有梗",
    "actionUrl": "eyepetizer://tag/748/?title=%E8%BF%99%E4%BA%9B%E5%B9%BF%E5%91%8A%E8%B6%85%E6%9C%89%E6%A2%97",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/9056413cfeffaf0c841d894390aa8e08.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ff0f6d0ad5f4b6211a3f746aaaffd916.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 172,
    "name": "什么鬼",
    "actionUrl": "eyepetizer://tag/172/?title=%E4%BB%80%E4%B9%88%E9%AC%BC",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/e6b5568e865b26f3f84270e613955e59.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/e6b5568e865b26f3f84270e613955e59.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 170,
    "name": "幽默",
    "actionUrl": "eyepetizer://tag/170/?title=%E5%B9%BD%E9%BB%98",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/8164ded95cfde8c5f42acf243c6ca3e6.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/8164ded95cfde8c5f42acf243c6ca3e6.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 134,
    "name": "反转",
    "actionUrl": "eyepetizer://tag/134/?title=%E5%8F%8D%E8%BD%AC",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/c4daeee307e8efca77e095faaf5a5ab9.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/c4daeee307e8efca77e095faaf5a5ab9.png?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 146,
    "name": "666",
    "actionUrl": "eyepetizer://tag/146/?title=666",
    "adTrack": null,
    "desc": null,
    "bgPicture": "https://i.ytimg.com/vi/MKWWhf8RAV8/maxresdefault.jpg",
    "headerImage": "http://img.kaiyanapp.com/522f7e51abb07a4a4438b82ee54174a4.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 200,
    "name": "酷炫",
    "actionUrl": "eyepetizer://tag/200/?title=%E9%85%B7%E7%82%AB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 192,
    "name": "迷幻",
    "actionUrl": "eyepetizer://tag/192/?title=%E8%BF%B7%E5%B9%BB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/b583ca556f865642edeca1a02e983fcc.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/b583ca556f865642edeca1a02e983fcc.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 16,
    "name": "广告",
    "actionUrl": "eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A",
    "adTrack": null,
    "desc": "为广告人的精彩创意点赞",
    "bgPicture": "http://img.kaiyanapp.com/e41e74fe73882b552de00d95d56748d2.jpeg?imageMogr2/quality/60",
    "headerImage": "http://img.kaiyanapp.com/23d1a1dce9756535d314aed3cf9777a0.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 54,
    "shareCount": 11,
    "replyCount": 5,
    "realCollectionCount": 0
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "Vimeo",
    "alias": "vimeo",
    "icon": "http://ali-img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png"
    },
    "category": "广告",
    "author": {
    "id": 2162,
    "icon": "http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg",
    "name": "全球广告精选",
    "description": "我们精选世界最好看的广告，为全世界广告人的精彩创意点赞。",
    "link": "",
    "latestReleaseTime": 1688000445000,
    "videoNum": 2787,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 2162,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 2162,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/431f36cefdec8a30dc3b07a628106215.png?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/431f36cefdec8a30dc3b07a628106215.png?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/c72cea5559e0c0183e49bbbf6dc242d6.png?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/431f36cefdec8a30dc3b07a628106215.png?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318699&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 30,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318699",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318699&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1688000445000,
    "playInfo": [],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "广告 ",
    "descriptionPgc": "",
    "remark": "https://www.xinpianchang.com/a12585576?from=ArticleList",
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1688000400000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "711 便利店脑洞广告短片，在大雪纷飞的深夜，便利店也不会打烊，为每一位顾客带来仅售 1 美元的冰咖啡，深夜送「温暖」。From Mark Leephaibul",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318637,
    "title": "全球广告精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/2162/?title=%E5%85%A8%E7%90%83%E5%B9%BF%E5%91%8A%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg",
    "iconType": "round",
    "description": "#广告 / 收录于 每日编辑精选",
    "time": 1688000440000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318637,
    "title": "猜广告系列｜韩国欧巴们都在干嘛",
    "description": "Double A 印刷打造最佳色彩！打印机内无人知晓的故事， A 队和 B 队联合不如双 A 队的质量与效率，现在就开始工作吧！Double A Korea 是韩国的印刷制品品牌，致力于生产高品质、环保的纸张，品牌将环境可持续性作为第一要务，使用可持续种植的树木，以帮助应对气候变化，且采购经过认证的木材和快速生长的纸树，避免砍伐天然森林。 From Double A Korea / 더블에이 코리아",
    "library": "DAILY",
    "tags": [
    {
    "id": 748,
    "name": "这些广告超有梗",
    "actionUrl": "eyepetizer://tag/748/?title=%E8%BF%99%E4%BA%9B%E5%B9%BF%E5%91%8A%E8%B6%85%E6%9C%89%E6%A2%97",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/9056413cfeffaf0c841d894390aa8e08.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ff0f6d0ad5f4b6211a3f746aaaffd916.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 170,
    "name": "幽默",
    "actionUrl": "eyepetizer://tag/170/?title=%E5%B9%BD%E9%BB%98",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/8164ded95cfde8c5f42acf243c6ca3e6.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/8164ded95cfde8c5f42acf243c6ca3e6.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 146,
    "name": "666",
    "actionUrl": "eyepetizer://tag/146/?title=666",
    "adTrack": null,
    "desc": null,
    "bgPicture": "https://i.ytimg.com/vi/MKWWhf8RAV8/maxresdefault.jpg",
    "headerImage": "http://img.kaiyanapp.com/522f7e51abb07a4a4438b82ee54174a4.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 144,
    "name": "魔性",
    "actionUrl": "eyepetizer://tag/144/?title=%E9%AD%94%E6%80%A7",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/f7a6f01d5425dcba563ef114501c169e.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/f7a6f01d5425dcba563ef114501c169e.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 140,
    "name": "搞笑",
    "actionUrl": "eyepetizer://tag/140/?title=%E6%90%9E%E7%AC%91",
    "adTrack": null,
    "desc": "哈哈哈哈哈哈哈哈",
    "bgPicture": "http://img.kaiyanapp.com/f787d5053443499e8d787911cd8b3876.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/f2b803d3c383bba5a3888b2709160b6e.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 2,
    "name": "创意",
    "actionUrl": "eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F",
    "adTrack": null,
    "desc": "技术与审美结合，探索视觉的无限可能",
    "bgPicture": "http://img.kaiyanapp.com/1b457058cf2b317304ff9f70543c040d.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 16,
    "name": "广告",
    "actionUrl": "eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A",
    "adTrack": null,
    "desc": "为广告人的精彩创意点赞",
    "bgPicture": "http://img.kaiyanapp.com/e41e74fe73882b552de00d95d56748d2.jpeg?imageMogr2/quality/60",
    "headerImage": "http://img.kaiyanapp.com/23d1a1dce9756535d314aed3cf9777a0.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 54,
    "shareCount": 68,
    "replyCount": 7,
    "realCollectionCount": 41
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "YouTube",
    "alias": "youtube",
    "icon": "http://ali-img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"
    },
    "category": "广告",
    "author": {
    "id": 2162,
    "icon": "http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg",
    "name": "全球广告精选",
    "description": "我们精选世界最好看的广告，为全世界广告人的精彩创意点赞。",
    "link": "",
    "latestReleaseTime": 1688000445000,
    "videoNum": 2787,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 2162,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 2162,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/cd82b46f2f7fc75b399893eba0e11a7d.jpeg?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/cd82b46f2f7fc75b399893eba0e11a7d.jpeg?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/1a5022bfcc19cfa5ed88f65769cc7f56.jpeg?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/cd82b46f2f7fc75b399893eba0e11a7d.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318637&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 69,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318637",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318637&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1688000440000,
    "playInfo": [
    {
    "height": 720,
    "width": 1280,
    "urlList": [
    {
    "name": "aliyun",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318637&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=",
    "size": 7629273
    },
    {
    "name": "ucloud",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318637&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=",
    "size": 7629273
    }
    ],
    "name": "高清",
    "type": "high",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318637&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="
    }
    ],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "广告 韩国",
    "descriptionPgc": "",
    "remark": "https://www.xinpianchang.com/a12578125?from=ArticleList",
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1688000400000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "Double A 印刷打造最佳色彩！打印机内无人知晓的故事， A 队和 B 队联合不如双 A 队的质量与效率，现在就开始工作吧！Double A Korea 是韩国的印刷制品品牌，致力于生产高品质、环保的纸张，品牌将环境可持续性作为第一要务，使用可持续种植的树木，以帮助应对气候变化，且采购经过认证的木材和快速生长的纸树，避免砍伐天然森林。 From Double A Korea / 더블에이 코리아",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318703,
    "title": "全球旅行视频精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/1313/?title=%E5%85%A8%E7%90%83%E6%97%85%E8%A1%8C%E8%A7%86%E9%A2%91%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/385d659e77af15fa4be37fe638c75917.jpeg?imageMogr2/quality/60/format/jpg",
    "iconType": "round",
    "description": "#旅行 / 收录于 每日编辑精选",
    "time": 1688000431000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318703,
    "title": "迷失撒哈拉，追随风的痕迹",
    "description": "毛里塔尼亚位于西非，西濒大西洋，全境内有一半国土属撒哈拉沙漠，在这里可以体验到大地的原始力量、风的温柔触感、火的迷人舞蹈和水的舒缓拥抱。奇妙的撒哈拉之眼默默地见证着这美妙的一切，就像一位天神在沙丘中注视着瞬息万变的生命，默默地保守着过去的秘密。沉浸在毛里塔尼亚的自然风光中，我们将会感受到永恒的历史厚重感。 From Timelab Pro\n",
    "library": "DAILY",
    "tags": [
    {
    "id": 10,
    "name": "跟着开眼看世界",
    "actionUrl": "eyepetizer://tag/10/?title=%E8%B7%9F%E7%9D%80%E5%BC%80%E7%9C%BC%E7%9C%8B%E4%B8%96%E7%95%8C",
    "adTrack": null,
    "desc": "去你想去的地方，发现世界的美",
    "bgPicture": "http://img.kaiyanapp.com/7ea328a893aa1f092b9328a53494a267.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/50dab5468ecd2dbe5eb99dab5d608a0a.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 14
    },
    {
    "id": 721,
    "name": "旅行灵感",
    "actionUrl": "eyepetizer://tag/721/?title=%E6%97%85%E8%A1%8C%E7%81%B5%E6%84%9F",
    "adTrack": null,
    "desc": "",
    "bgPicture": "http://img.kaiyanapp.com/32b7e220d9c012c96e5f9a68e6f3ad9a.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/32b7e220d9c012c96e5f9a68e6f3ad9a.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 52,
    "name": "风光大片",
    "actionUrl": "eyepetizer://tag/52/?title=%E9%A3%8E%E5%85%89%E5%A4%A7%E7%89%87",
    "adTrack": null,
    "desc": "",
    "bgPicture": "http://img.kaiyanapp.com/e484dd6aa22ea3c2e604812b44f8c60c.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/f333f225c9ccc78819120f3a888b2e7e.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 204,
    "name": "精致",
    "actionUrl": "eyepetizer://tag/204/?title=%E7%B2%BE%E8%87%B4",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 88,
    "name": "长镜头",
    "actionUrl": "eyepetizer://tag/88/?title=%E9%95%BF%E9%95%9C%E5%A4%B4",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/239121b97815a7d8387908e5d13fd14c.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/884d87e48bcf0fcce057f8769391ec36.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 24,
    "name": "记录",
    "actionUrl": "eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95",
    "adTrack": null,
    "desc": "告诉他们为什么与众不同",
    "bgPicture": "http://img.kaiyanapp.com/c3984cad49455e01637347e0c8f6a37d.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/fd76dab1411e07f0dcf45309720134f9.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 1019,
    "name": "旅行",
    "actionUrl": "eyepetizer://tag/1019/?title=%E6%97%85%E8%A1%8C",
    "adTrack": null,
    "desc": "世界这么大，总有你的目的地",
    "bgPicture": "http://img.kaiyanapp.com/67b5aa7b489b33e7894e04d293e9b01f.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/67b5aa7b489b33e7894e04d293e9b01f.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 68,
    "shareCount": 22,
    "replyCount": 5,
    "realCollectionCount": 45
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "YouTube",
    "alias": "youtube",
    "icon": "http://ali-img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"
    },
    "category": "旅行",
    "author": {
    "id": 1313,
    "icon": "http://ali-img.kaiyanapp.com/385d659e77af15fa4be37fe638c75917.jpeg?imageMogr2/quality/60/format/jpg",
    "name": "全球旅行视频精选",
    "description": "在这个世界上的很多地方都有着美丽的景色，我们用相机用镜头记录下这一切。",
    "link": "",
    "latestReleaseTime": 1688000431000,
    "videoNum": 2765,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 1313,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 1313,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/46a7318d141b20bfbf0567b5c79f098f.jpeg?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/46a7318d141b20bfbf0567b5c79f098f.jpeg?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/8ccd4aeedaa7c0f203ad285f8cc93e68.jpeg?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/46a7318d141b20bfbf0567b5c79f098f.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318703&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 325,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318703",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318703&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1688000431000,
    "playInfo": [],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "旅行",
    "descriptionPgc": "",
    "remark": null,
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1688000400000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "毛里塔尼亚位于西非，西濒大西洋，全境内有一半国土属撒哈拉沙漠，在这里可以体验到大地的原始力量、风的温柔触感、火的迷人舞蹈和水的舒缓拥抱。奇妙的撒哈拉之眼默默地见证着这美妙的一切，就像一位天神在沙丘中注视着瞬息万变的生命，默默地保守着过去的秘密。沉浸在毛里塔尼亚的自然风光中，我们将会感受到永恒的历史厚重感。 From Timelab Pro\n",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318661,
    "title": "爱马仕 Hermès 广告精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/5122/?title=%E7%88%B1%E9%A9%AC%E4%BB%95%20Herm%C3%A8s%20%E5%B9%BF%E5%91%8A%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/3d1f8ea58099cc6f980ef619c71b4c7a.jpeg?imageMogr2/quality/60/format/jpg",
    "iconType": "round",
    "description": "#广告 / 收录于 每日编辑精选",
    "time": 1688000443000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318661,
    "title": "爱马仕大地淡香水「隐入尘烟」",
    "description": "欢迎来到爱马仕的世界，这是一个新鲜与力量相互滋养的新领域。爱马仕「Hermès」的 Terre d'Hermes Eau Givree 是一款柑橘芳香调的男用香水。这是一款新香水，调香师是 Christine Nagel。前调是香橼，中调是杜松子和帖木儿，基调是木质香调和矿物香调。",
    "library": "DAILY",
    "tags": [
    {
    "id": 748,
    "name": "这些广告超有梗",
    "actionUrl": "eyepetizer://tag/748/?title=%E8%BF%99%E4%BA%9B%E5%B9%BF%E5%91%8A%E8%B6%85%E6%9C%89%E6%A2%97",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/9056413cfeffaf0c841d894390aa8e08.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ff0f6d0ad5f4b6211a3f746aaaffd916.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 200,
    "name": "酷炫",
    "actionUrl": "eyepetizer://tag/200/?title=%E9%85%B7%E7%82%AB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 204,
    "name": "精致",
    "actionUrl": "eyepetizer://tag/204/?title=%E7%B2%BE%E8%87%B4",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 202,
    "name": "唯美",
    "actionUrl": "eyepetizer://tag/202/?title=%E5%94%AF%E7%BE%8E",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/965a0a74d0af871eb174b5c7def6fd6d.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/965a0a74d0af871eb174b5c7def6fd6d.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 190,
    "name": "宏大",
    "actionUrl": "eyepetizer://tag/190/?title=%E5%AE%8F%E5%A4%A7",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/293eb0312d5ad76044f212950fdd676f.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/293eb0312d5ad76044f212950fdd676f.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 192,
    "name": "迷幻",
    "actionUrl": "eyepetizer://tag/192/?title=%E8%BF%B7%E5%B9%BB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/b583ca556f865642edeca1a02e983fcc.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/b583ca556f865642edeca1a02e983fcc.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 16,
    "name": "广告",
    "actionUrl": "eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A",
    "adTrack": null,
    "desc": "为广告人的精彩创意点赞",
    "bgPicture": "http://img.kaiyanapp.com/e41e74fe73882b552de00d95d56748d2.jpeg?imageMogr2/quality/60",
    "headerImage": "http://img.kaiyanapp.com/23d1a1dce9756535d314aed3cf9777a0.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 26,
    "shareCount": 30,
    "replyCount": 3,
    "realCollectionCount": 32
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "YouTube",
    "alias": "youtube",
    "icon": "http://ali-img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"
    },
    "category": "广告",
    "author": {
    "id": 5122,
    "icon": "http://ali-img.kaiyanapp.com/3d1f8ea58099cc6f980ef619c71b4c7a.jpeg?imageMogr2/quality/60/format/jpg",
    "name": "爱马仕 Hermès 广告精选",
    "description": "世界著名的奢侈品品牌，1837年由Thierry Hermès创立于法国巴黎。",
    "link": "",
    "latestReleaseTime": 1688000443000,
    "videoNum": 92,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 5122,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 5122,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/9deb5cb2fc8cc178097c5721463bc220.jpeg?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/9deb5cb2fc8cc178097c5721463bc220.jpeg?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/cc2c636336e3e2b1918d650de6c5e95c.jpeg?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/9deb5cb2fc8cc178097c5721463bc220.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318661&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 30,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318661",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318661&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1688000443000,
    "playInfo": [],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "广告",
    "descriptionPgc": "",
    "remark": "https://www.xinpianchang.com/a12579475?from=ArticleList",
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1688000400000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "欢迎来到爱马仕的世界，这是一个新鲜与力量相互滋养的新领域。爱马仕「Hermès」的 Terre d'Hermes Eau Givree 是一款柑橘芳香调的男用香水。这是一款新香水，调香师是 Christine Nagel。前调是香橼，中调是杜松子和帖木儿，基调是木质香调和矿物香调。",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318643,
    "title": "开眼记录精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/2166/?title=%E5%BC%80%E7%9C%BC%E8%AE%B0%E5%BD%95%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/a2fc6d32ac0b4f2842fb3d545d06f09b.jpeg",
    "iconType": "round",
    "description": "#记录 / 收录于 每日编辑精选",
    "time": 1688000448000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318643,
    "title": "别致而现代，建筑师的自有公寓",
    "description": "本周，我们将与房主乔尔和费利西亚一起参观他们装修精美的山景转售公寓。这套公寓占地 1,313 平方英尺，经过精心改造，从一个陈旧的、长满霉菌的单元变成了一个时尚的住宅。房屋采用中性色调，展示了精心挑选的材料，如天然染色胶合板、微水泥地板和藤条。整个房子里随处可见凹槽玻璃元素，增添了一丝精致感。From Stacked Homes",
    "library": "DAILY",
    "tags": [
    {
    "id": 743,
    "name": "记录精选",
    "actionUrl": "eyepetizer://tag/743/?title=%E8%AE%B0%E5%BD%95%E7%B2%BE%E9%80%89",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/a082f44b88e78daaf19fa4e1a2faaa5a.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/a082f44b88e78daaf19fa4e1a2faaa5a.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 190,
    "name": "宏大",
    "actionUrl": "eyepetizer://tag/190/?title=%E5%AE%8F%E5%A4%A7",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/293eb0312d5ad76044f212950fdd676f.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/293eb0312d5ad76044f212950fdd676f.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 506,
    "name": "经典",
    "actionUrl": "eyepetizer://tag/506/?title=%E7%BB%8F%E5%85%B8",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/1e948eab70737d8beca9f52fce907ab5.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/1e948eab70737d8beca9f52fce907ab5.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 64,
    "name": "装置艺术",
    "actionUrl": "eyepetizer://tag/64/?title=%E8%A3%85%E7%BD%AE%E8%89%BA%E6%9C%AF",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/a5ab37178bad19cfdce624d1967d5d3d.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/a5ab37178bad19cfdce624d1967d5d3d.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 66,
    "name": "平面设计",
    "actionUrl": "eyepetizer://tag/66/?title=%E5%B9%B3%E9%9D%A2%E8%AE%BE%E8%AE%A1",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/c2638be85084bdc6587cc88e0911b16e.jpeg?imageMogr2/quality/60",
    "headerImage": "http://img.kaiyanapp.com/c2638be85084bdc6587cc88e0911b16e.jpeg?imageMogr2/quality/60",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 68,
    "name": "建筑设计",
    "actionUrl": "eyepetizer://tag/68/?title=%E5%BB%BA%E7%AD%91%E8%AE%BE%E8%AE%A1",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/adf8a025c79de57992fee40085133e69.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/adf8a025c79de57992fee40085133e69.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 24,
    "name": "记录",
    "actionUrl": "eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95",
    "adTrack": null,
    "desc": "告诉他们为什么与众不同",
    "bgPicture": "http://img.kaiyanapp.com/c3984cad49455e01637347e0c8f6a37d.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/fd76dab1411e07f0dcf45309720134f9.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 27,
    "shareCount": 11,
    "replyCount": 3,
    "realCollectionCount": 0
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "YouTube",
    "alias": "youtube",
    "icon": "http://ali-img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"
    },
    "category": "记录",
    "author": {
    "id": 2166,
    "icon": "http://ali-img.kaiyanapp.com/a2fc6d32ac0b4f2842fb3d545d06f09b.jpeg",
    "name": "开眼记录精选",
    "description": "「每部电影都是一部纪录片」——比尔·尼科尔斯",
    "link": "",
    "latestReleaseTime": 1688000448000,
    "videoNum": 903,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 2166,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 2166,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/b5edbaa91d983f7fe025d3338e72405d.jpeg?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/b5edbaa91d983f7fe025d3338e72405d.jpeg?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/c205b529b4bf7e11ad1da815241e4e55.jpeg?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/b5edbaa91d983f7fe025d3338e72405d.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318643&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 425,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318643",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318643&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1688000448000,
    "playInfo": [
    {
    "height": 720,
    "width": 1280,
    "urlList": [
    {
    "name": "aliyun",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318643&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=",
    "size": 16128278
    },
    {
    "name": "ucloud",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318643&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=",
    "size": 16128278
    }
    ],
    "name": "高清",
    "type": "high",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318643&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="
    }
    ],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "记录",
    "descriptionPgc": "",
    "remark": null,
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1688000400000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "本周，我们将与房主乔尔和费利西亚一起参观他们装修精美的山景转售公寓。这套公寓占地 1,313 平方英尺，经过精心改造，从一个陈旧的、长满霉菌的单元变成了一个时尚的住宅。房屋采用中性色调，展示了精心挑选的材料，如天然染色胶合板、微水泥地板和藤条。整个房子里随处可见凹槽玻璃元素，增添了一丝精致感。From Stacked Homes",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318672,
    "title": "全球广告精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/2162/?title=%E5%85%A8%E7%90%83%E5%B9%BF%E5%91%8A%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg",
    "iconType": "round",
    "description": "#广告 / 收录于 每日编辑精选",
    "time": 1688000441000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318672,
    "title": "黑色幽默讽刺广告「一场窥见现实的舞会」",
    "description": "一场振奋人心的演讲，一首真挚的歌曲，呼吁所有人不要停止对未来的思考。绿色和平是在超过 55 个国家设有分部的非政府环保组织，总部设在阿姆斯特丹。 1971 年由美国与加拿大裔环保主义者成立，组织的宗旨为“保护地球孕育全部多样性生物的能力”，他们的活动聚焦于气候变化、森林采伐、过度捕捞、商业捕鲸、基因工程以及反核议题。 From Mother",
    "library": "DAILY",
    "tags": [
    {
    "id": 748,
    "name": "这些广告超有梗",
    "actionUrl": "eyepetizer://tag/748/?title=%E8%BF%99%E4%BA%9B%E5%B9%BF%E5%91%8A%E8%B6%85%E6%9C%89%E6%A2%97",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/9056413cfeffaf0c841d894390aa8e08.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ff0f6d0ad5f4b6211a3f746aaaffd916.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 24,
    "name": "记录",
    "actionUrl": "eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95",
    "adTrack": null,
    "desc": "告诉他们为什么与众不同",
    "bgPicture": "http://img.kaiyanapp.com/c3984cad49455e01637347e0c8f6a37d.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/fd76dab1411e07f0dcf45309720134f9.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 200,
    "name": "酷炫",
    "actionUrl": "eyepetizer://tag/200/?title=%E9%85%B7%E7%82%AB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 146,
    "name": "666",
    "actionUrl": "eyepetizer://tag/146/?title=666",
    "adTrack": null,
    "desc": null,
    "bgPicture": "https://i.ytimg.com/vi/MKWWhf8RAV8/maxresdefault.jpg",
    "headerImage": "http://img.kaiyanapp.com/522f7e51abb07a4a4438b82ee54174a4.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 148,
    "name": "匠心",
    "actionUrl": "eyepetizer://tag/148/?title=%E5%8C%A0%E5%BF%83",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/cf568288dc8087fa728308f2623b9527.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/cf568288dc8087fa728308f2623b9527.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 40,
    "name": "公益",
    "actionUrl": "eyepetizer://tag/40/?title=%E5%85%AC%E7%9B%8A",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/7d875f63d28804d0635ce8b286e047c5.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/7d875f63d28804d0635ce8b286e047c5.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 16,
    "name": "广告",
    "actionUrl": "eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A",
    "adTrack": null,
    "desc": "为广告人的精彩创意点赞",
    "bgPicture": "http://img.kaiyanapp.com/e41e74fe73882b552de00d95d56748d2.jpeg?imageMogr2/quality/60",
    "headerImage": "http://img.kaiyanapp.com/23d1a1dce9756535d314aed3cf9777a0.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 68,
    "shareCount": 34,
    "replyCount": 4,
    "realCollectionCount": 41
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "Vimeo",
    "alias": "vimeo",
    "icon": "http://ali-img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png"
    },
    "category": "广告",
    "author": {
    "id": 2162,
    "icon": "http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg",
    "name": "全球广告精选",
    "description": "我们精选世界最好看的广告，为全世界广告人的精彩创意点赞。",
    "link": "",
    "latestReleaseTime": 1688000445000,
    "videoNum": 2787,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 2162,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 2162,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/4800b0f12afe0904a69b27ccfb68a217.jpeg?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/4800b0f12afe0904a69b27ccfb68a217.jpeg?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/4e07c8af6d91fb5c6566c8e99580e60f.jpeg?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/4800b0f12afe0904a69b27ccfb68a217.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318672&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 443,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318672",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318672&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1688000441000,
    "playInfo": [
    {
    "height": 720,
    "width": 1280,
    "urlList": [
    {
    "name": "aliyun",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318672&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=",
    "size": 53708339
    },
    {
    "name": "ucloud",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318672&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=",
    "size": 53708339
    }
    ],
    "name": "高清",
    "type": "high",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318672&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="
    }
    ],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "广告 别停",
    "descriptionPgc": "",
    "remark": null,
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1688000400000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "一场振奋人心的演讲，一首真挚的歌曲，呼吁所有人不要停止对未来的思考。绿色和平是在超过 55 个国家设有分部的非政府环保组织，总部设在阿姆斯特丹。 1971 年由美国与加拿大裔环保主义者成立，组织的宗旨为“保护地球孕育全部多样性生物的能力”，他们的活动聚焦于气候变化、森林采伐、过度捕捞、商业捕鲸、基因工程以及反核议题。 From Mother",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318667,
    "title": "全球音乐视频精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/2163/?title=%E5%85%A8%E7%90%83%E9%9F%B3%E4%B9%90%E8%A7%86%E9%A2%91%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/9279c17b4da5ba5e7e4f21afb5bb0a74.jpeg",
    "iconType": "round",
    "description": "#音乐 / 收录于 每日编辑精选",
    "time": 1688000447000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318667,
    "title": "魔幻音乐短片：凝固的世界",
    "description": "Henry Alfred Steinway「艺名 RL Grime」是美国唱片制作人兼 DJ。RL Grime 擅长陷阱音乐和低音音乐，是洛杉矶电子音乐团体 WeDidIt 的成员。短片是其新歌 Pour Your Heart Out 的官方音乐短片。From Jake Oleson",
    "library": "DAILY",
    "tags": [
    {
    "id": 18,
    "name": "音乐电台",
    "actionUrl": "eyepetizer://tag/18/?title=%E9%9F%B3%E4%B9%90%E7%94%B5%E5%8F%B0",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/70e1bedfdff53729402f1998788c3ee9.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/79dcc408692e7b9170ba4451c21a196d.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 190,
    "name": "宏大",
    "actionUrl": "eyepetizer://tag/190/?title=%E5%AE%8F%E5%A4%A7",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/293eb0312d5ad76044f212950fdd676f.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/293eb0312d5ad76044f212950fdd676f.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 192,
    "name": "迷幻",
    "actionUrl": "eyepetizer://tag/192/?title=%E8%BF%B7%E5%B9%BB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/b583ca556f865642edeca1a02e983fcc.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/b583ca556f865642edeca1a02e983fcc.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 198,
    "name": "密恐",
    "actionUrl": "eyepetizer://tag/198/?title=%E5%AF%86%E6%81%90",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/233a96564f73db517b6945420ccb9e14.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/233a96564f73db517b6945420ccb9e14.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 200,
    "name": "酷炫",
    "actionUrl": "eyepetizer://tag/200/?title=%E9%85%B7%E7%82%AB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 94,
    "name": "实验性",
    "actionUrl": "eyepetizer://tag/94/?title=%E5%AE%9E%E9%AA%8C%E6%80%A7",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/e1a1a2b35f6916636594fe6bff4c5050.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/4aae1da4cea59eb15007e8d306c6eaea.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 1018,
    "name": "音乐",
    "actionUrl": "eyepetizer://tag/1018/?title=%E9%9F%B3%E4%B9%90",
    "adTrack": null,
    "desc": "用眼睛就能「听」的艺术",
    "bgPicture": "http://img.kaiyanapp.com/46b2ed7ccd3e241ff54a314faf2632b8.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/4f6643756d9ff5c41acdf7d0493055c4.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 41,
    "shareCount": 11,
    "replyCount": 2,
    "realCollectionCount": 54
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "Vimeo",
    "alias": "vimeo",
    "icon": "http://ali-img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png"
    },
    "category": "音乐",
    "author": {
    "id": 2163,
    "icon": "http://ali-img.kaiyanapp.com/9279c17b4da5ba5e7e4f21afb5bb0a74.jpeg",
    "name": "全球音乐视频精选",
    "description": "我们精选全球最酷炫、最有态度的音乐，一定能让你眼前一亮",
    "link": "",
    "latestReleaseTime": 1688000447000,
    "videoNum": 1229,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 2163,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 2163,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/d4253ec0acd6cf99edec674848dde74b.jpeg?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/d4253ec0acd6cf99edec674848dde74b.jpeg?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/ca64898fe73cd32de90606a009e1653e.jpeg?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/d4253ec0acd6cf99edec674848dde74b.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318667&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 223,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318667",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318667&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1688000447000,
    "playInfo": [],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "音乐",
    "descriptionPgc": "",
    "remark": null,
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1688000400000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "Henry Alfred Steinway「艺名 RL Grime」是美国唱片制作人兼 DJ。RL Grime 擅长陷阱音乐和低音音乐，是洛杉矶电子音乐团体 WeDidIt 的成员。短片是其新歌 Pour Your Heart Out 的官方音乐短片。From Jake Oleson",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318516,
    "title": "开眼剧情精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/2172/?title=%E5%BC%80%E7%9C%BC%E5%89%A7%E6%83%85%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/8581b06aa17c7dbe8970e4c27bbdbd98.png?imageMogr2/quality/60/format/jpg",
    "iconType": "round",
    "description": "#剧情 / 收录于 每日编辑精选",
    "time": 1688000446000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318516,
    "title": "BAFTA 获奖剧情「伊斯兰教堕胎指南」",
    "description": "在给贾瓦德打电话后，萨姆发现自己怀孕了，没有人陪伴她作为她的堕胎伴侣。 最重要的是，她需要对她的巴基斯坦父亲保守堕胎的秘密，因为她确切地知道他会如何反应。短片是 BAFTA 2023 电视奖获奖者 - 最佳短片。From Sindha Agha",
    "library": "DAILY",
    "tags": [
    {
    "id": 1032,
    "name": "给你讲个好故事",
    "actionUrl": "eyepetizer://tag/1032/?title=%E7%BB%99%E4%BD%A0%E8%AE%B2%E4%B8%AA%E5%A5%BD%E6%95%85%E4%BA%8B",
    "adTrack": null,
    "desc": "每周末更新，关注听开眼给你讲故事。",
    "bgPicture": "http://img.kaiyanapp.com/d471080a9de44e8fbaa4850887273332.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/33a2b832b7583dd9781f9fd40ad7617e.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 110,
    "name": "亲情",
    "actionUrl": "eyepetizer://tag/110/?title=%E4%BA%B2%E6%83%85",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/d810014de35f94b4fc56495aace37fd8.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/d810014de35f94b4fc56495aace37fd8.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 108,
    "name": "爱情",
    "actionUrl": "eyepetizer://tag/108/?title=%E7%88%B1%E6%83%85",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/67025fb5bf4f8ff4ccd63cdcfd0cd6c6.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/67025fb5bf4f8ff4ccd63cdcfd0cd6c6.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 134,
    "name": "反转",
    "actionUrl": "eyepetizer://tag/134/?title=%E5%8F%8D%E8%BD%AC",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/c4daeee307e8efca77e095faaf5a5ab9.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/c4daeee307e8efca77e095faaf5a5ab9.png?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 166,
    "name": "悲剧",
    "actionUrl": "eyepetizer://tag/166/?title=%E6%82%B2%E5%89%A7",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/ceb623331c9d83139362595b6faa7d04.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/ceb623331c9d83139362595b6faa7d04.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 168,
    "name": "讽刺",
    "actionUrl": "eyepetizer://tag/168/?title=%E8%AE%BD%E5%88%BA",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/a3de18fb448aa41a140f1901130c380a.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/d536b9c09b2681630afcc92222599f0e.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 12,
    "name": "剧情",
    "actionUrl": "eyepetizer://tag/12/?title=%E5%89%A7%E6%83%85",
    "adTrack": null,
    "desc": "用一个好故事，描绘生活的不可思议",
    "bgPicture": "http://img.kaiyanapp.com/945fa937f0955b31224314a4eeef59b8.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/945fa937f0955b31224314a4eeef59b8.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 54,
    "shareCount": 22,
    "replyCount": 5,
    "realCollectionCount": 0
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "Vimeo",
    "alias": "vimeo",
    "icon": "http://ali-img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png"
    },
    "category": "剧情",
    "author": {
    "id": 2172,
    "icon": "http://ali-img.kaiyanapp.com/8581b06aa17c7dbe8970e4c27bbdbd98.png?imageMogr2/quality/60/format/jpg",
    "name": "开眼剧情精选",
    "description": "用一个好故事，描绘生活的不可思议",
    "link": "",
    "latestReleaseTime": 1688000446000,
    "videoNum": 1172,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 2172,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 2172,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/3e8af7b4129839f3f82b4f0043cf9a9c.jpeg?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/3e8af7b4129839f3f82b4f0043cf9a9c.jpeg?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/72974c7e0a84db4e0534aecc5bf7c8bf.jpeg?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/3e8af7b4129839f3f82b4f0043cf9a9c.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318516&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 365,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318516",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318516&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1688000446000,
    "playInfo": [
    {
    "height": 720,
    "width": 1280,
    "urlList": [
    {
    "name": "aliyun",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318516&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=",
    "size": 24850501
    },
    {
    "name": "ucloud",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318516&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=",
    "size": 24850501
    }
    ],
    "name": "高清",
    "type": "high",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318516&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="
    }
    ],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "剧情",
    "descriptionPgc": "",
    "remark": null,
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1688000400000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "在给贾瓦德打电话后，萨姆发现自己怀孕了，没有人陪伴她作为她的堕胎伴侣。 最重要的是，她需要对她的巴基斯坦父亲保守堕胎的秘密，因为她确切地知道他会如何反应。短片是 BAFTA 2023 电视奖获奖者 - 最佳短片。From Sindha Agha",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318657,
    "title": "一条",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/170/?title=%E4%B8%80%E6%9D%A1&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/b1f252f2a97e014f6de7e65709c5eedd.png?imageMogr2/quality/60/format/jpg",
    "iconType": "round",
    "description": "#创意 / 收录于 每日编辑精选",
    "time": 1687681229000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318657,
    "title": "60 岁的中国传奇大佬，收藏 1000 件珍宝",
    "description": "程昕东，是中国当代艺术的重要推手。31 年，在他的推动和见证下，一个个艺术青年从边缘走向主流，名扬海外，中国与世界之间也由此建立起一座文化、艺术的桥梁。今年 4 月，他刚刚向上海当代艺术博物馆「PSA」无偿捐赠了 46 件珍贵藏品，用于做学术研究、公共艺术教育。这是他第 9 次向公立美术机构捐赠，总捐赠作品量近 200 件。",
    "library": "DAILY",
    "tags": [
    {
    "id": 743,
    "name": "记录精选",
    "actionUrl": "eyepetizer://tag/743/?title=%E8%AE%B0%E5%BD%95%E7%B2%BE%E9%80%89",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/a082f44b88e78daaf19fa4e1a2faaa5a.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/a082f44b88e78daaf19fa4e1a2faaa5a.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 482,
    "name": "人生感悟",
    "actionUrl": "eyepetizer://tag/482/?title=%E4%BA%BA%E7%94%9F%E6%84%9F%E6%82%9F",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/31f217a0db54b356fb709f08732c5e06.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/31f217a0db54b356fb709f08732c5e06.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 702,
    "name": "人物",
    "actionUrl": "eyepetizer://tag/702/?title=%E4%BA%BA%E7%89%A9",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/9101692746a60cd7360838bf394703c1.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/9101692746a60cd7360838bf394703c1.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 530,
    "name": "人生",
    "actionUrl": "eyepetizer://tag/530/?title=%E4%BA%BA%E7%94%9F",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/a57744110ddbaa1e99d148a01c1b1bd8.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/a57744110ddbaa1e99d148a01c1b1bd8.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 534,
    "name": "人文",
    "actionUrl": "eyepetizer://tag/534/?title=%E4%BA%BA%E6%96%87",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/5d6ee9241a0e2196bc1754b35f6f15e5.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/16b60131c2bc0885683ce7ee6ac75b52.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 506,
    "name": "经典",
    "actionUrl": "eyepetizer://tag/506/?title=%E7%BB%8F%E5%85%B8",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/1e948eab70737d8beca9f52fce907ab5.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/1e948eab70737d8beca9f52fce907ab5.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 24,
    "name": "记录",
    "actionUrl": "eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95",
    "adTrack": null,
    "desc": "告诉他们为什么与众不同",
    "bgPicture": "http://img.kaiyanapp.com/c3984cad49455e01637347e0c8f6a37d.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/fd76dab1411e07f0dcf45309720134f9.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 34,
    "shareCount": 11,
    "replyCount": 1,
    "realCollectionCount": 11
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "PGC",
    "alias": "PGC",
    "icon": ""
    },
    "category": "创意",
    "author": {
    "id": 170,
    "icon": "http://ali-img.kaiyanapp.com/b1f252f2a97e014f6de7e65709c5eedd.png?imageMogr2/quality/60/format/jpg",
    "name": "一条",
    "description": "所有未在美中度过的生活，都是被浪费了。",
    "link": "",
    "latestReleaseTime": 1687744852000,
    "videoNum": 2217,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 170,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 170,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/273658e668fa88461b4aec744ade8642.png?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/273658e668fa88461b4aec744ade8642.png?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/6e9f4b114dc1c454e2fb0e86ebbace52.png?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": null
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318657&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 388,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318657",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318657&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1687681229000,
    "playInfo": [],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "60岁的中国传奇大佬，收藏1000件珍宝",
    "descriptionPgc": "程昕东，是中国当代艺术的重要推手。31年，在他的推动和见证下，一个个艺术青年从边缘走向主流，名扬海外，中国与世界之间也由此建立起一座文化、艺术的桥梁。今年4月，他刚刚向上海当代艺术博物馆（PSA）无偿捐赠了46件珍贵藏品，用于做学术研究、公共艺术教育。这是他第9次向公立美术机构捐赠，总捐赠作品量近200件。\n",
    "remark": "",
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1688000400000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "程昕东，是中国当代艺术的重要推手。31 年，在他的推动和见证下，一个个艺术青年从边缘走向主流，名扬海外，中国与世界之间也由此建立起一座文化、艺术的桥梁。今年 4 月，他刚刚向上海当代艺术博物馆「PSA」无偿捐赠了 46 件珍贵藏品，用于做学术研究、公共艺术教育。这是他第 9 次向公立美术机构捐赠，总捐赠作品量近 200 件。",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318666,
    "title": "全球创意视频精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/2161/?title=%E5%85%A8%E7%90%83%E5%88%9B%E6%84%8F%E8%A7%86%E9%A2%91%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/f4a9aba1c6857ee0cefcdc5aee0a1fc9.png?imageMogr2/quality/60/format/jpg",
    "iconType": "round",
    "description": "#创意 / 收录于 每日编辑精选",
    "time": 1688000444000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318666,
    "title": "日常太枯燥，打开这个创意灵感库",
    "description": "创意短片集锦，作者 Kelly Tan 是一名2D、3D动画师和插画师，短片是他近年的作品，他将精彩部分进行混剪，汇成本片，以此展示精彩案例。From Kelly Tan",
    "library": "DAILY",
    "tags": [
    {
    "id": 744,
    "name": "每日创意灵感",
    "actionUrl": "eyepetizer://tag/744/?title=%E6%AF%8F%E6%97%A5%E5%88%9B%E6%84%8F%E7%81%B5%E6%84%9F",
    "adTrack": null,
    "desc": "技术与审美结合，探索视觉的无限可能",
    "bgPicture": "http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/bc2479c09cd15cb93b69d82e5f21c3fc.png?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 204,
    "name": "精致",
    "actionUrl": "eyepetizer://tag/204/?title=%E7%B2%BE%E8%87%B4",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 34,
    "name": "混剪",
    "actionUrl": "eyepetizer://tag/34/?title=%E6%B7%B7%E5%89%AA",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/ebf307197b634f30b2fa4eb867e908c1.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ebf307197b634f30b2fa4eb867e908c1.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 36,
    "name": "集锦",
    "actionUrl": "eyepetizer://tag/36/?title=%E9%9B%86%E9%94%A6",
    "adTrack": null,
    "desc": "最好的部分 + 有化学反应的混剪",
    "bgPicture": "http://img.kaiyanapp.com/ec07f44858caa7c4d8b309cde5500a84.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/ec07f44858caa7c4d8b309cde5500a84.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 146,
    "name": "666",
    "actionUrl": "eyepetizer://tag/146/?title=666",
    "adTrack": null,
    "desc": null,
    "bgPicture": "https://i.ytimg.com/vi/MKWWhf8RAV8/maxresdefault.jpg",
    "headerImage": "http://img.kaiyanapp.com/522f7e51abb07a4a4438b82ee54174a4.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 200,
    "name": "酷炫",
    "actionUrl": "eyepetizer://tag/200/?title=%E9%85%B7%E7%82%AB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 2,
    "name": "创意",
    "actionUrl": "eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F",
    "adTrack": null,
    "desc": "技术与审美结合，探索视觉的无限可能",
    "bgPicture": "http://img.kaiyanapp.com/1b457058cf2b317304ff9f70543c040d.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 27,
    "shareCount": 11,
    "replyCount": 5,
    "realCollectionCount": 0
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "Vimeo",
    "alias": "vimeo",
    "icon": "http://ali-img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png"
    },
    "category": "创意",
    "author": {
    "id": 2161,
    "icon": "http://ali-img.kaiyanapp.com/f4a9aba1c6857ee0cefcdc5aee0a1fc9.png?imageMogr2/quality/60/format/jpg",
    "name": "全球创意视频精选",
    "description": "我们精选最有创意的视频，我们用技术与审美结合，探索视觉的无限可能。",
    "link": "",
    "latestReleaseTime": 1688000444000,
    "videoNum": 1925,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 2161,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 2161,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/5fcccd6fafd5ccd592e903edd325b1d8.png?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/5fcccd6fafd5ccd592e903edd325b1d8.png?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/daef35c9482d03bc7e6b62cbb212e976.png?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/5fcccd6fafd5ccd592e903edd325b1d8.png?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318666&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 60,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318666",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318666&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1688000444000,
    "playInfo": [
    {
    "height": 720,
    "width": 1280,
    "urlList": [
    {
    "name": "aliyun",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318666&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=",
    "size": 14377445
    },
    {
    "name": "ucloud",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318666&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=",
    "size": 14377445
    }
    ],
    "name": "高清",
    "type": "high",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318666&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="
    }
    ],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "创意 色彩",
    "descriptionPgc": "",
    "remark": null,
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1688000400000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "创意短片集锦，作者 Kelly Tan 是一名2D、3D动画师和插画师，短片是他近年的作品，他将精彩部分进行混剪，汇成本片，以此展示精彩案例。From Kelly Tan",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "textCard",
    "data": {
    "dataType": "TextCard",
    "id": 0,
    "type": "header5",
    "text": "星期三",
    "subTitle": null,
    "actionUrl": null,
    "adTrack": null,
    "follow": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318662,
    "title": "全球广告精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/2162/?title=%E5%85%A8%E7%90%83%E5%B9%BF%E5%91%8A%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg",
    "iconType": "round",
    "description": "#广告 / 收录于 每日编辑精选",
    "time": 1687914000000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318662,
    "title": "索尼电影感广告「踩点最自由的人生」",
    "description": "「当我们移动时，我们就活着！」这是索尼的摄像机广告。电影摄影师 Ajay Menon 使用 Sony Cinema Line FX30 摄像机拍摄，捕捉移动的乐趣。这支视频汇聚了从舞者到自行车手等不同流派的多位艺术家，强调他们行动的自由与灵动。无论是日光、傍晚金光还是低光， Sony FX30 都能够很完美地在各种照明条件下进行拍摄，捕捉美丽动人的电影图像。 From Sony India",
    "library": "DAILY",
    "tags": [
    {
    "id": 10,
    "name": "跟着开眼看世界",
    "actionUrl": "eyepetizer://tag/10/?title=%E8%B7%9F%E7%9D%80%E5%BC%80%E7%9C%BC%E7%9C%8B%E4%B8%96%E7%95%8C",
    "adTrack": null,
    "desc": "去你想去的地方，发现世界的美",
    "bgPicture": "http://img.kaiyanapp.com/7ea328a893aa1f092b9328a53494a267.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/50dab5468ecd2dbe5eb99dab5d608a0a.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 14
    },
    {
    "id": 146,
    "name": "666",
    "actionUrl": "eyepetizer://tag/146/?title=666",
    "adTrack": null,
    "desc": null,
    "bgPicture": "https://i.ytimg.com/vi/MKWWhf8RAV8/maxresdefault.jpg",
    "headerImage": "http://img.kaiyanapp.com/522f7e51abb07a4a4438b82ee54174a4.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 1158,
    "name": "光影摄影",
    "actionUrl": "eyepetizer://tag/1158/?title=%E5%85%89%E5%BD%B1%E6%91%84%E5%BD%B1",
    "adTrack": null,
    "desc": "逐光影，寻灵魂",
    "bgPicture": "http://img.kaiyanapp.com/9085a783aaa80f90e382d0d53a606dc7.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/9085a783aaa80f90e382d0d53a606dc7.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": true,
    "newestEndTime": 1586767119000,
    "communityIndex": 16
    },
    {
    "id": 1019,
    "name": "旅行",
    "actionUrl": "eyepetizer://tag/1019/?title=%E6%97%85%E8%A1%8C",
    "adTrack": null,
    "desc": "世界这么大，总有你的目的地",
    "bgPicture": "http://img.kaiyanapp.com/67b5aa7b489b33e7894e04d293e9b01f.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/67b5aa7b489b33e7894e04d293e9b01f.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 2,
    "name": "创意",
    "actionUrl": "eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F",
    "adTrack": null,
    "desc": "技术与审美结合，探索视觉的无限可能",
    "bgPicture": "http://img.kaiyanapp.com/1b457058cf2b317304ff9f70543c040d.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 204,
    "name": "精致",
    "actionUrl": "eyepetizer://tag/204/?title=%E7%B2%BE%E8%87%B4",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 16,
    "name": "广告",
    "actionUrl": "eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A",
    "adTrack": null,
    "desc": "为广告人的精彩创意点赞",
    "bgPicture": "http://img.kaiyanapp.com/e41e74fe73882b552de00d95d56748d2.jpeg?imageMogr2/quality/60",
    "headerImage": "http://img.kaiyanapp.com/23d1a1dce9756535d314aed3cf9777a0.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 208,
    "shareCount": 67,
    "replyCount": 4,
    "realCollectionCount": 139
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "YouTube",
    "alias": "youtube",
    "icon": "http://ali-img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"
    },
    "category": "广告",
    "author": {
    "id": 2162,
    "icon": "http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg",
    "name": "全球广告精选",
    "description": "我们精选世界最好看的广告，为全世界广告人的精彩创意点赞。",
    "link": "",
    "latestReleaseTime": 1688000445000,
    "videoNum": 2787,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 2162,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 2162,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/c2ec3224c4ebd69ca8783b6fc34ba816.jpeg?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/c2ec3224c4ebd69ca8783b6fc34ba816.jpeg?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/8eeb7ffff6d85024ace30069ee905281.jpeg?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/c2ec3224c4ebd69ca8783b6fc34ba816.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318662&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 73,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318662",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318662&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1687914000000,
    "playInfo": [],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "旅行 sony",
    "descriptionPgc": "",
    "remark": "https://www.xinpianchang.com/a12579521?from=ArticleList",
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1687914000000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "「当我们移动时，我们就活着！」这是索尼的摄像机广告。电影摄影师 Ajay Menon 使用 Sony Cinema Line FX30 摄像机拍摄，捕捉移动的乐趣。这支视频汇聚了从舞者到自行车手等不同流派的多位艺术家，强调他们行动的自由与灵动。无论是日光、傍晚金光还是低光， Sony FX30 都能够很完美地在各种照明条件下进行拍摄，捕捉美丽动人的电影图像。 From Sony India",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318682,
    "title": "全球动画精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/2170/?title=%E5%85%A8%E7%90%83%E5%8A%A8%E7%94%BB%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/482c741c06644f5566c7218096dbaf26.jpeg",
    "iconType": "round",
    "description": "#动画 / 收录于 每日编辑精选",
    "time": 1687860377000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318682,
    "title": "全程高能，黑白定格动画「拯救无名氏」",
    "description": "黑白定格动画「拯救无名」讲述的是一群小丑聚集在一起表演一个关于牧师和难民的故事，但随着他们故事的跑偏，虚构和现实之间的界限开始出现裂痕。无论如何，希望每个世界里都能少一些颠沛流离。From Animatic",
    "library": "DAILY",
    "tags": [
    {
    "id": 14,
    "name": "动画梦工厂",
    "actionUrl": "eyepetizer://tag/14/?title=%E5%8A%A8%E7%94%BB%E6%A2%A6%E5%B7%A5%E5%8E%82",
    "adTrack": null,
    "desc": "有趣的人永远不缺童心",
    "bgPicture": "http://img.kaiyanapp.com/afb9e7d7f061d10ade5ebcb524dc8679.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/f9eae3e0321fa1e99a7b38641b5536a2.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 82,
    "name": "定格",
    "actionUrl": "eyepetizer://tag/82/?title=%E5%AE%9A%E6%A0%BC",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/e5c1340f5bae646976ed44714ac1dad7.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/e5c1340f5bae646976ed44714ac1dad7.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 148,
    "name": "匠心",
    "actionUrl": "eyepetizer://tag/148/?title=%E5%8C%A0%E5%BF%83",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/cf568288dc8087fa728308f2623b9527.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/cf568288dc8087fa728308f2623b9527.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 76,
    "name": "黑白",
    "actionUrl": "eyepetizer://tag/76/?title=%E9%BB%91%E7%99%BD",
    "adTrack": null,
    "desc": "定格黑白，聚焦光影，记录片刻和永恒",
    "bgPicture": "http://img.kaiyanapp.com/f91b71f98bea65a3330ab6aac290eeb8.jpeg?imageMogr2/quality/60",
    "headerImage": "http://img.kaiyanapp.com/f91b71f98bea65a3330ab6aac290eeb8.jpeg?imageMogr2/quality/60",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 168,
    "name": "讽刺",
    "actionUrl": "eyepetizer://tag/168/?title=%E8%AE%BD%E5%88%BA",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/a3de18fb448aa41a140f1901130c380a.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/d536b9c09b2681630afcc92222599f0e.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 1023,
    "name": "动画",
    "actionUrl": "eyepetizer://tag/1023/?title=%E5%8A%A8%E7%94%BB",
    "adTrack": null,
    "desc": "有趣的人永远不缺童心",
    "bgPicture": "http://img.kaiyanapp.com/349cbd33cdf71fc74d5e9c7a00b444fd.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/208aa67386c045497389f015ae28dd29.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 2,
    "name": "创意",
    "actionUrl": "eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F",
    "adTrack": null,
    "desc": "技术与审美结合，探索视觉的无限可能",
    "bgPicture": "http://img.kaiyanapp.com/1b457058cf2b317304ff9f70543c040d.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 236,
    "shareCount": 56,
    "replyCount": 6,
    "realCollectionCount": 190
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "YouTube",
    "alias": "youtube",
    "icon": "http://ali-img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"
    },
    "category": "动画",
    "author": {
    "id": 2170,
    "icon": "http://ali-img.kaiyanapp.com/482c741c06644f5566c7218096dbaf26.jpeg",
    "name": "全球动画精选",
    "description": "我们精选全球最好看的动画短片，有趣的人永远不缺童心。",
    "link": "",
    "latestReleaseTime": 1687860377000,
    "videoNum": 1736,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 2170,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 2170,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/8ce1ddaf4df34b0afb0c83de2e054056.png?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/8ce1ddaf4df34b0afb0c83de2e054056.png?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/fd7bda73e1507a96af30a77ac89a17ea.png?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/8ce1ddaf4df34b0afb0c83de2e054056.png?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318682&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 1010,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318682",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318682&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1687860377000,
    "playInfo": [
    {
    "height": 720,
    "width": 1280,
    "urlList": [
    {
    "name": "aliyun",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318682&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=",
    "size": 141259761
    },
    {
    "name": "ucloud",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318682&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=",
    "size": 141259761
    }
    ],
    "name": "高清",
    "type": "high",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318682&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="
    }
    ],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "动画 定格",
    "descriptionPgc": "",
    "remark": null,
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1687914000000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "黑白定格动画「拯救无名」讲述的是一群小丑聚集在一起表演一个关于牧师和难民的故事，但随着他们故事的跑偏，虚构和现实之间的界限开始出现裂痕。无论如何，希望每个世界里都能少一些颠沛流离。From Animatic",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318688,
    "title": "全球广告精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/2162/?title=%E5%85%A8%E7%90%83%E5%B9%BF%E5%91%8A%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg",
    "iconType": "round",
    "description": "#广告 / 收录于 每日编辑精选",
    "time": 1687914007000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318688,
    "title": "看 AI 打跆拳道，这个感觉太爽了！",
    "description": "这是国际跆拳道赛事 2023 年罗马大奖赛的宣传视频。用 AI 塑造出的人物在不同的场景里进行跆拳道运动，画面十分炫酷。世界跆拳道大奖赛是世界跆拳道联合会于 2013 年推出的一项跆拳道比赛，旨在为奥运会跆拳道锦标赛的参赛资格提供统一的选拔。截至去年，世界跆拳道大奖赛决赛历史奖牌数获得最多的国家排名依次为韩国、俄罗斯和中国。 From Roberto Zazzara",
    "library": "DAILY",
    "tags": [
    {
    "id": 748,
    "name": "这些广告超有梗",
    "actionUrl": "eyepetizer://tag/748/?title=%E8%BF%99%E4%BA%9B%E5%B9%BF%E5%91%8A%E8%B6%85%E6%9C%89%E6%A2%97",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/9056413cfeffaf0c841d894390aa8e08.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ff0f6d0ad5f4b6211a3f746aaaffd916.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 192,
    "name": "迷幻",
    "actionUrl": "eyepetizer://tag/192/?title=%E8%BF%B7%E5%B9%BB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/b583ca556f865642edeca1a02e983fcc.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/b583ca556f865642edeca1a02e983fcc.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 771,
    "name": "运动广告",
    "actionUrl": "eyepetizer://tag/771/?title=%E8%BF%90%E5%8A%A8%E5%B9%BF%E5%91%8A",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/605146d81e31e410a700de36a8cc8cef.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/605146d81e31e410a700de36a8cc8cef.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 204,
    "name": "精致",
    "actionUrl": "eyepetizer://tag/204/?title=%E7%B2%BE%E8%87%B4",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 200,
    "name": "酷炫",
    "actionUrl": "eyepetizer://tag/200/?title=%E9%85%B7%E7%82%AB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 146,
    "name": "666",
    "actionUrl": "eyepetizer://tag/146/?title=666",
    "adTrack": null,
    "desc": null,
    "bgPicture": "https://i.ytimg.com/vi/MKWWhf8RAV8/maxresdefault.jpg",
    "headerImage": "http://img.kaiyanapp.com/522f7e51abb07a4a4438b82ee54174a4.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 2,
    "name": "创意",
    "actionUrl": "eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F",
    "adTrack": null,
    "desc": "技术与审美结合，探索视觉的无限可能",
    "bgPicture": "http://img.kaiyanapp.com/1b457058cf2b317304ff9f70543c040d.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 16,
    "name": "广告",
    "actionUrl": "eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A",
    "adTrack": null,
    "desc": "为广告人的精彩创意点赞",
    "bgPicture": "http://img.kaiyanapp.com/e41e74fe73882b552de00d95d56748d2.jpeg?imageMogr2/quality/60",
    "headerImage": "http://img.kaiyanapp.com/23d1a1dce9756535d314aed3cf9777a0.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 122,
    "shareCount": 67,
    "replyCount": 6,
    "realCollectionCount": 82
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "Vimeo",
    "alias": "vimeo",
    "icon": "http://ali-img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png"
    },
    "category": "广告",
    "author": {
    "id": 2162,
    "icon": "http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg",
    "name": "全球广告精选",
    "description": "我们精选世界最好看的广告，为全世界广告人的精彩创意点赞。",
    "link": "",
    "latestReleaseTime": 1688000445000,
    "videoNum": 2787,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 2162,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 2162,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/944f82451dfce52695a7c4567b23619d.jpeg?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/944f82451dfce52695a7c4567b23619d.jpeg?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/bd8b469a8ab06111b0afabc0c5c778a8.jpeg?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/944f82451dfce52695a7c4567b23619d.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318688&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 70,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318688",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318688&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1687914007000,
    "playInfo": [],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "广告 ai",
    "descriptionPgc": "",
    "remark": "https://www.xinpianchang.com/a12585094?from=ArticleList",
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1687914000000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "这是国际跆拳道赛事 2023 年罗马大奖赛的宣传视频。用 AI 塑造出的人物在不同的场景里进行跆拳道运动，画面十分炫酷。世界跆拳道大奖赛是世界跆拳道联合会于 2013 年推出的一项跆拳道比赛，旨在为奥运会跆拳道锦标赛的参赛资格提供统一的选拔。截至去年，世界跆拳道大奖赛决赛历史奖牌数获得最多的国家排名依次为韩国、俄罗斯和中国。 From Roberto Zazzara",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318659,
    "title": "全球广告精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/2162/?title=%E5%85%A8%E7%90%83%E5%B9%BF%E5%91%8A%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg",
    "iconType": "round",
    "description": "#广告 / 收录于 每日编辑精选",
    "time": 1687914008000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318659,
    "title": "与朴叙俊欧巴的距离，就差这杯「香浓拿铁」",
    "description": "韩国咖啡品牌 Maxim Supreme Gold 典藏拿铁咖啡创意广告，携手朴叙俊和裴贤圣出镜演绎，驾驶复古跑车来到户外露营地，在大自然中品尝咖啡，十分轻松悠闲，是向往的生活吧！ Maxim Supreme Gold 由咖啡和奶的黄金比例诞生出来，奶味香浓同时保留咖啡的味道和香气。 From 커피라는 행복 맥심",
    "library": "DAILY",
    "tags": [
    {
    "id": 748,
    "name": "这些广告超有梗",
    "actionUrl": "eyepetizer://tag/748/?title=%E8%BF%99%E4%BA%9B%E5%B9%BF%E5%91%8A%E8%B6%85%E6%9C%89%E6%A2%97",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/9056413cfeffaf0c841d894390aa8e08.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ff0f6d0ad5f4b6211a3f746aaaffd916.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 146,
    "name": "666",
    "actionUrl": "eyepetizer://tag/146/?title=666",
    "adTrack": null,
    "desc": null,
    "bgPicture": "https://i.ytimg.com/vi/MKWWhf8RAV8/maxresdefault.jpg",
    "headerImage": "http://img.kaiyanapp.com/522f7e51abb07a4a4438b82ee54174a4.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 196,
    "name": "清新",
    "actionUrl": "eyepetizer://tag/196/?title=%E6%B8%85%E6%96%B0",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/9824ae7d052ca22de0a29e09d10364d8.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/9824ae7d052ca22de0a29e09d10364d8.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 142,
    "name": "浪漫",
    "actionUrl": "eyepetizer://tag/142/?title=%E6%B5%AA%E6%BC%AB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/460ed0b9e2912a5a0f64e4ede5e8159c.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/775357709cbbb780e2544f28e7a5f2b2.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 174,
    "name": "治愈",
    "actionUrl": "eyepetizer://tag/174/?title=%E6%B2%BB%E6%84%88",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/5417e0d8f72d7bb3f1cd69eb75b0759e.jpeg?imageMogr2/quality/60",
    "headerImage": "http://img.kaiyanapp.com/5417e0d8f72d7bb3f1cd69eb75b0759e.jpeg?imageMogr2/quality/60",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 202,
    "name": "唯美",
    "actionUrl": "eyepetizer://tag/202/?title=%E5%94%AF%E7%BE%8E",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/965a0a74d0af871eb174b5c7def6fd6d.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/965a0a74d0af871eb174b5c7def6fd6d.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 2,
    "name": "创意",
    "actionUrl": "eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F",
    "adTrack": null,
    "desc": "技术与审美结合，探索视觉的无限可能",
    "bgPicture": "http://img.kaiyanapp.com/1b457058cf2b317304ff9f70543c040d.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 16,
    "name": "广告",
    "actionUrl": "eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A",
    "adTrack": null,
    "desc": "为广告人的精彩创意点赞",
    "bgPicture": "http://img.kaiyanapp.com/e41e74fe73882b552de00d95d56748d2.jpeg?imageMogr2/quality/60",
    "headerImage": "http://img.kaiyanapp.com/23d1a1dce9756535d314aed3cf9777a0.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 27,
    "shareCount": 11,
    "replyCount": 5,
    "realCollectionCount": 13
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "YouTube",
    "alias": "youtube",
    "icon": "http://ali-img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"
    },
    "category": "广告",
    "author": {
    "id": 2162,
    "icon": "http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg",
    "name": "全球广告精选",
    "description": "我们精选世界最好看的广告，为全世界广告人的精彩创意点赞。",
    "link": "",
    "latestReleaseTime": 1688000445000,
    "videoNum": 2787,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 2162,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 2162,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/6300218bc56987949bf8ed79503533b6.jpeg?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/6300218bc56987949bf8ed79503533b6.jpeg?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/ca7eebe157f3e912818eab1e8b3040ca.jpeg?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/6300218bc56987949bf8ed79503533b6.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318659&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 60,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318659",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318659&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1687914008000,
    "playInfo": [
    {
    "height": 720,
    "width": 1280,
    "urlList": [
    {
    "name": "aliyun",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318659&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=",
    "size": 7135081
    },
    {
    "name": "ucloud",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318659&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=",
    "size": 7135081
    }
    ],
    "name": "高清",
    "type": "high",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318659&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="
    }
    ],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "广告 咖啡",
    "descriptionPgc": "",
    "remark": "https://www.xinpianchang.com/a12579547?from=ArticleList",
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1687914000000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "韩国咖啡品牌 Maxim Supreme Gold 典藏拿铁咖啡创意广告，携手朴叙俊和裴贤圣出镜演绎，驾驶复古跑车来到户外露营地，在大自然中品尝咖啡，十分轻松悠闲，是向往的生活吧！ Maxim Supreme Gold 由咖啡和奶的黄金比例诞生出来，奶味香浓同时保留咖啡的味道和香气。 From 커피라는 행복 맥심",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318663,
    "title": "Netflix 精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/339/?title=Netflix%20%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/c7871e4436ed01d77e02a8b3633a5ed0.jpeg?imageMogr2/quality/60",
    "iconType": "round",
    "description": "#影视 / 收录于 每日编辑精选",
    "time": 1687914010000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318663,
    "title": "NETFLIX 日本动画终极大盘点",
    "description": "Netflix 将正在放映中的日本动画进行了终极大盘点，汇成本片，画面内容涉及恶魔人：哭泣之子、范马刃牙、泥泥、暗黑破坏神 2023、赛博朋克边缘行者、东京复仇队、狂赌之渊、浪漫杀手、动物狂想曲等多部动画。",
    "library": "DAILY",
    "tags": [
    {
    "id": 796,
    "name": "迷影放映室",
    "actionUrl": "eyepetizer://tag/796/?title=%E8%BF%B7%E5%BD%B1%E6%94%BE%E6%98%A0%E5%AE%A4",
    "adTrack": null,
    "desc": "电影、剧集、戏剧抢先看",
    "bgPicture": "http://img.kaiyanapp.com/64f2b2ed039bd92c3be10d003d6041bf.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/56a8818adb038c59ab04ffc781db2f50.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 74,
    "name": "CG",
    "actionUrl": "eyepetizer://tag/74/?title=CG",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/fdac34e3c19adf85704b039126edef52.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/e2a1eec9efb7e7d0abca85bbdedc425b.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 56,
    "name": "3D",
    "actionUrl": "eyepetizer://tag/56/?title=3D",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/8648e4ce51da8444039ef046194fd6c8.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/8648e4ce51da8444039ef046194fd6c8.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 350,
    "name": "日本",
    "actionUrl": "eyepetizer://tag/350/?title=%E6%97%A5%E6%9C%AC",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/0e118c56a85899055348d15120841ecf.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/0e118c56a85899055348d15120841ecf.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 36,
    "name": "集锦",
    "actionUrl": "eyepetizer://tag/36/?title=%E9%9B%86%E9%94%A6",
    "adTrack": null,
    "desc": "最好的部分 + 有化学反应的混剪",
    "bgPicture": "http://img.kaiyanapp.com/ec07f44858caa7c4d8b309cde5500a84.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/ec07f44858caa7c4d8b309cde5500a84.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 34,
    "name": "混剪",
    "actionUrl": "eyepetizer://tag/34/?title=%E6%B7%B7%E5%89%AA",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/ebf307197b634f30b2fa4eb867e908c1.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ebf307197b634f30b2fa4eb867e908c1.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 1025,
    "name": "影视",
    "actionUrl": "eyepetizer://tag/1025/?title=%E5%BD%B1%E8%A7%86",
    "adTrack": null,
    "desc": "电影、剧集、戏剧抢先看",
    "bgPicture": "http://img.kaiyanapp.com/8a298964e7c9fc2ae16342832e36d88d.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/9d7fe42c1445031e4c8f2421b652a011.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 74,
    "shareCount": 37,
    "replyCount": 3,
    "realCollectionCount": 39
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "Vimeo",
    "alias": "vimeo",
    "icon": "http://ali-img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png"
    },
    "category": "影视",
    "author": {
    "id": 339,
    "icon": "http://ali-img.kaiyanapp.com/c7871e4436ed01d77e02a8b3633a5ed0.jpeg?imageMogr2/quality/60",
    "name": "Netflix 精选",
    "description": "Netflix 是一间在世界多国提供网络视频点播的公司，并同时在美国经营单一费率邮寄 DVD 出租服务",
    "link": "",
    "latestReleaseTime": 1687914010000,
    "videoNum": 818,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 339,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 339,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/14da9f5587e552e50366914e3d58ca61.jpeg?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/14da9f5587e552e50366914e3d58ca61.jpeg?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/780c1951800978ef422a11368356e404.jpeg?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/14da9f5587e552e50366914e3d58ca61.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318663&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 60,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318663",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318663&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1687914010000,
    "playInfo": [
    {
    "height": 720,
    "width": 1280,
    "urlList": [
    {
    "name": "aliyun",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318663&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=",
    "size": 15479340
    },
    {
    "name": "ucloud",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318663&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=",
    "size": 15479340
    }
    ],
    "name": "高清",
    "type": "high",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318663&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="
    }
    ],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "影视",
    "descriptionPgc": "",
    "remark": null,
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1687914000000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "Netflix 将正在放映中的日本动画进行了终极大盘点，汇成本片，画面内容涉及恶魔人：哭泣之子、范马刃牙、泥泥、暗黑破坏神 2023、赛博朋克边缘行者、东京复仇队、狂赌之渊、浪漫杀手、动物狂想曲等多部动画。",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318660,
    "title": "三星 Samsung 广告精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/5476/?title=%E4%B8%89%E6%98%9F%20Samsung%20%E5%B9%BF%E5%91%8A%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/39401fbccfebcc6af7a52b2759f33ac2.jpeg?imageMogr2/quality/60/format/jpg",
    "iconType": "round",
    "description": "#广告 / 收录于 每日编辑精选",
    "time": 1687914011000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318660,
    "title": "三星 Watch5，沉浸在表盘的世界中",
    "description": "三星 Watch5 是三星公司研发的智能手表，这款 Galaxy watch 5 主打的是轻盈设计，44mm 版本提供黑色、银色、浅蓝三种颜色，重量只有 33.5g。搭载 1.36 英寸高清 AMOLED 屏幕。",
    "library": "DAILY",
    "tags": [
    {
    "id": 748,
    "name": "这些广告超有梗",
    "actionUrl": "eyepetizer://tag/748/?title=%E8%BF%99%E4%BA%9B%E5%B9%BF%E5%91%8A%E8%B6%85%E6%9C%89%E6%A2%97",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/9056413cfeffaf0c841d894390aa8e08.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ff0f6d0ad5f4b6211a3f746aaaffd916.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 146,
    "name": "666",
    "actionUrl": "eyepetizer://tag/146/?title=666",
    "adTrack": null,
    "desc": null,
    "bgPicture": "https://i.ytimg.com/vi/MKWWhf8RAV8/maxresdefault.jpg",
    "headerImage": "http://img.kaiyanapp.com/522f7e51abb07a4a4438b82ee54174a4.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 192,
    "name": "迷幻",
    "actionUrl": "eyepetizer://tag/192/?title=%E8%BF%B7%E5%B9%BB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/b583ca556f865642edeca1a02e983fcc.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/b583ca556f865642edeca1a02e983fcc.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 190,
    "name": "宏大",
    "actionUrl": "eyepetizer://tag/190/?title=%E5%AE%8F%E5%A4%A7",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/293eb0312d5ad76044f212950fdd676f.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/293eb0312d5ad76044f212950fdd676f.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 204,
    "name": "精致",
    "actionUrl": "eyepetizer://tag/204/?title=%E7%B2%BE%E8%87%B4",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 200,
    "name": "酷炫",
    "actionUrl": "eyepetizer://tag/200/?title=%E9%85%B7%E7%82%AB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 16,
    "name": "广告",
    "actionUrl": "eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A",
    "adTrack": null,
    "desc": "为广告人的精彩创意点赞",
    "bgPicture": "http://img.kaiyanapp.com/e41e74fe73882b552de00d95d56748d2.jpeg?imageMogr2/quality/60",
    "headerImage": "http://img.kaiyanapp.com/23d1a1dce9756535d314aed3cf9777a0.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 26,
    "shareCount": 37,
    "replyCount": 4,
    "realCollectionCount": 25
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "Vimeo",
    "alias": "vimeo",
    "icon": "http://ali-img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png"
    },
    "category": "广告",
    "author": {
    "id": 5476,
    "icon": "http://ali-img.kaiyanapp.com/39401fbccfebcc6af7a52b2759f33ac2.jpeg?imageMogr2/quality/60/format/jpg",
    "name": "三星 Samsung 广告精选",
    "description": "三星电子是三星集团旗下的子公司，韩国最大的消费电子产品及电子组件制造商，亦是全球最大的信息技术公司。",
    "link": "",
    "latestReleaseTime": 1687914011000,
    "videoNum": 2159,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 5476,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 5476,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/f627055be3f89bda841316793415915e.png?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/f627055be3f89bda841316793415915e.png?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/e67cc6bfc07b74b3929bca2e59637d1b.png?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/feb4be750f818af5412a0b9624ec038f.png?imageMogr2/quality/60/format/jpg"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318660&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 60,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318660",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318660&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1687914011000,
    "playInfo": [],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "广告",
    "descriptionPgc": "",
    "remark": "https://www.xinpianchang.com/a12579441?from=ArticleList",
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1687914000000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "三星 Watch5 是三星公司研发的智能手表，这款 Galaxy watch 5 主打的是轻盈设计，44mm 版本提供黑色、银色、浅蓝三种颜色，重量只有 33.5g。搭载 1.36 英寸高清 AMOLED 屏幕。",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318567,
    "title": "全球广告精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/2162/?title=%E5%85%A8%E7%90%83%E5%B9%BF%E5%91%8A%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg",
    "iconType": "round",
    "description": "#广告 / 收录于 每日编辑精选",
    "time": 1687914012000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318567,
    "title": "这个汽车广告，把所有汽车都过了一遍？",
    "description": "创意汽车广告，汽车品牌含量较高，虽然含量多，但是却丝毫不显混乱，快节奏炫酷的同时展示品牌特色，短片由 SEHSUCHT 工作室制作。From SEHSUCHT",
    "library": "DAILY",
    "tags": [
    {
    "id": 748,
    "name": "这些广告超有梗",
    "actionUrl": "eyepetizer://tag/748/?title=%E8%BF%99%E4%BA%9B%E5%B9%BF%E5%91%8A%E8%B6%85%E6%9C%89%E6%A2%97",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/9056413cfeffaf0c841d894390aa8e08.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ff0f6d0ad5f4b6211a3f746aaaffd916.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 146,
    "name": "666",
    "actionUrl": "eyepetizer://tag/146/?title=666",
    "adTrack": null,
    "desc": null,
    "bgPicture": "https://i.ytimg.com/vi/MKWWhf8RAV8/maxresdefault.jpg",
    "headerImage": "http://img.kaiyanapp.com/522f7e51abb07a4a4438b82ee54174a4.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 204,
    "name": "精致",
    "actionUrl": "eyepetizer://tag/204/?title=%E7%B2%BE%E8%87%B4",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 182,
    "name": "冒险",
    "actionUrl": "eyepetizer://tag/182/?title=%E5%86%92%E9%99%A9",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/5ceee13e43098e32880cb76112e0a45b.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/5ceee13e43098e32880cb76112e0a45b.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 200,
    "name": "酷炫",
    "actionUrl": "eyepetizer://tag/200/?title=%E9%85%B7%E7%82%AB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 190,
    "name": "宏大",
    "actionUrl": "eyepetizer://tag/190/?title=%E5%AE%8F%E5%A4%A7",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/293eb0312d5ad76044f212950fdd676f.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/293eb0312d5ad76044f212950fdd676f.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 16,
    "name": "广告",
    "actionUrl": "eyepetizer://tag/16/?title=%E5%B9%BF%E5%91%8A",
    "adTrack": null,
    "desc": "为广告人的精彩创意点赞",
    "bgPicture": "http://img.kaiyanapp.com/e41e74fe73882b552de00d95d56748d2.jpeg?imageMogr2/quality/60",
    "headerImage": "http://img.kaiyanapp.com/23d1a1dce9756535d314aed3cf9777a0.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 54,
    "shareCount": 34,
    "replyCount": 4,
    "realCollectionCount": 41
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "Vimeo",
    "alias": "vimeo",
    "icon": "http://ali-img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png"
    },
    "category": "广告",
    "author": {
    "id": 2162,
    "icon": "http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg",
    "name": "全球广告精选",
    "description": "我们精选世界最好看的广告，为全世界广告人的精彩创意点赞。",
    "link": "",
    "latestReleaseTime": 1688000445000,
    "videoNum": 2787,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 2162,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 2162,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/f96d68aa15b2c8a6f1f468c77bda6c5d.jpeg?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/f96d68aa15b2c8a6f1f468c77bda6c5d.jpeg?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/96059a87bdd27a4e1765cbcc108fe7df.jpeg?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/f96d68aa15b2c8a6f1f468c77bda6c5d.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318567&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 97,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318567",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318567&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1687914012000,
    "playInfo": [],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "广告 汽车",
    "descriptionPgc": "",
    "remark": "https://www.xinpianchang.com/a12570017?from=ArticleList",
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1687914000000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "创意汽车广告，汽车品牌含量较高，虽然含量多，但是却丝毫不显混乱，快节奏炫酷的同时展示品牌特色，短片由 SEHSUCHT 工作室制作。From SEHSUCHT",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318620,
    "title": "一条",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/170/?title=%E4%B8%80%E6%9D%A1&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/b1f252f2a97e014f6de7e65709c5eedd.png?imageMogr2/quality/60/format/jpg",
    "iconType": "round",
    "description": "#创意 / 收录于 每日编辑精选",
    "time": 1687408236000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318620,
    "title": "因疫情失业，这一家人搬进 95㎡ 森林木屋",
    "description": "2020 年疫情袭来，40 岁的建筑师三家大地的所有工作瞬间停摆。他带着妻子和 2 个孩子搬到东京近郊，在一片原始森林中造房安家。这是一个只有 95m² 的三层小楼，却能住下四口人和一只猫，还能用作建筑事务所。为了顺应原始森林中各物种自然生长的姿态，他们在设计时留了很大空间并使用玻璃搭建出入口，使每间房都有多种路径可以直通自然。",
    "library": "DAILY",
    "tags": [
    {
    "id": 743,
    "name": "记录精选",
    "actionUrl": "eyepetizer://tag/743/?title=%E8%AE%B0%E5%BD%95%E7%B2%BE%E9%80%89",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/a082f44b88e78daaf19fa4e1a2faaa5a.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/a082f44b88e78daaf19fa4e1a2faaa5a.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 148,
    "name": "匠心",
    "actionUrl": "eyepetizer://tag/148/?title=%E5%8C%A0%E5%BF%83",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/cf568288dc8087fa728308f2623b9527.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/cf568288dc8087fa728308f2623b9527.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 144,
    "name": "魔性",
    "actionUrl": "eyepetizer://tag/144/?title=%E9%AD%94%E6%80%A7",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/f7a6f01d5425dcba563ef114501c169e.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/f7a6f01d5425dcba563ef114501c169e.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 729,
    "name": "生活方式",
    "actionUrl": "eyepetizer://tag/729/?title=%E7%94%9F%E6%B4%BB%E6%96%B9%E5%BC%8F",
    "adTrack": null,
    "desc": "在生活里找到理想的自己",
    "bgPicture": "http://img.kaiyanapp.com/df0ad616931c3c08b6775b8be5f418fa.gif",
    "headerImage": "http://img.kaiyanapp.com/df0ad616931c3c08b6775b8be5f418fa.gif",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 666,
    "name": "生活",
    "actionUrl": "eyepetizer://tag/666/?title=%E7%94%9F%E6%B4%BB",
    "adTrack": null,
    "desc": "匠心、健康、生活感悟",
    "bgPicture": "http://img.kaiyanapp.com/95ba262a92ac99db76794ca56233d5d1.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/06c71c30bca59ed5aed471e4ddfd2f6b.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 24,
    "name": "记录",
    "actionUrl": "eyepetizer://tag/24/?title=%E8%AE%B0%E5%BD%95",
    "adTrack": null,
    "desc": "告诉他们为什么与众不同",
    "bgPicture": "http://img.kaiyanapp.com/c3984cad49455e01637347e0c8f6a37d.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/fd76dab1411e07f0dcf45309720134f9.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 2,
    "name": "创意",
    "actionUrl": "eyepetizer://tag/2/?title=%E5%88%9B%E6%84%8F",
    "adTrack": null,
    "desc": "技术与审美结合，探索视觉的无限可能",
    "bgPicture": "http://img.kaiyanapp.com/1b457058cf2b317304ff9f70543c040d.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/fdefdb34cbe3d2ac9964d306febe9025.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 534,
    "name": "人文",
    "actionUrl": "eyepetizer://tag/534/?title=%E4%BA%BA%E6%96%87",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/5d6ee9241a0e2196bc1754b35f6f15e5.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/16b60131c2bc0885683ce7ee6ac75b52.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 260,
    "shareCount": 184,
    "replyCount": 5,
    "realCollectionCount": 92
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "PGC",
    "alias": "PGC",
    "icon": ""
    },
    "category": "创意",
    "author": {
    "id": 170,
    "icon": "http://ali-img.kaiyanapp.com/b1f252f2a97e014f6de7e65709c5eedd.png?imageMogr2/quality/60/format/jpg",
    "name": "一条",
    "description": "所有未在美中度过的生活，都是被浪费了。",
    "link": "",
    "latestReleaseTime": 1687744852000,
    "videoNum": 2217,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 170,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 170,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/fd7a003c07cd2d58aa51df144fe9c4c5.png?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/fd7a003c07cd2d58aa51df144fe9c4c5.png?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/6e9f4b114dc1c454e2fb0e86ebbace52.png?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/fd7a003c07cd2d58aa51df144fe9c4c5.png?imageMogr2/quality/60/format/jpg"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318620&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 370,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318620",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318620&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1687408236000,
    "playInfo": [],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "疫情失业，一家人搬进95㎡森林木屋",
    "descriptionPgc": "2020年疫情袭来，40岁的建筑师三家大地的所有工作瞬间停摆。他带着妻子和2个孩子搬到东京近郊，在一片原始森林中造房安家。95m²的三层小楼，住下四口人和一只猫，还用作建筑事务所。为了顺应原始森林中各物种自然生长的姿态，尽可能多地开口、使用玻璃，每间房都有多种路径可以直通自然。",
    "remark": "",
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1687914000000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "2020 年疫情袭来，40 岁的建筑师三家大地的所有工作瞬间停摆。他带着妻子和 2 个孩子搬到东京近郊，在一片原始森林中造房安家。这是一个只有 95m² 的三层小楼，却能住下四口人和一只猫，还能用作建筑事务所。为了顺应原始森林中各物种自然生长的姿态，他们在设计时留了很大空间并使用玻璃搭建出入口，使每间房都有多种路径可以直通自然。",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318569,
    "title": "全球音乐视频精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/2163/?title=%E5%85%A8%E7%90%83%E9%9F%B3%E4%B9%90%E8%A7%86%E9%A2%91%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/9279c17b4da5ba5e7e4f21afb5bb0a74.jpeg",
    "iconType": "round",
    "description": "#音乐 / 收录于 每日编辑精选",
    "time": 1687914014000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318569,
    "title": "迷幻音乐短片：一个「露珠」般的世界",
    "description": "Devendra Banhart 宣布了一张新专辑「Flying Wig」，将于 9 月发行。这是他继 2019 年的「Ma」之后的作品，本片是其专辑的主打单曲「Twin」的音乐视频。From Devendra Banhart",
    "library": "DAILY",
    "tags": [
    {
    "id": 18,
    "name": "音乐电台",
    "actionUrl": "eyepetizer://tag/18/?title=%E9%9F%B3%E4%B9%90%E7%94%B5%E5%8F%B0",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/70e1bedfdff53729402f1998788c3ee9.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/79dcc408692e7b9170ba4451c21a196d.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "IMPORTANT",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 192,
    "name": "迷幻",
    "actionUrl": "eyepetizer://tag/192/?title=%E8%BF%B7%E5%B9%BB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/b583ca556f865642edeca1a02e983fcc.jpeg?imageMogr2/quality/100",
    "headerImage": "http://img.kaiyanapp.com/b583ca556f865642edeca1a02e983fcc.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 214,
    "name": "摇滚",
    "actionUrl": "eyepetizer://tag/214/?title=%E6%91%87%E6%BB%9A",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/756608450a4f6d37ca7a1ece0141f277.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/756608450a4f6d37ca7a1ece0141f277.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 222,
    "name": "人声",
    "actionUrl": "eyepetizer://tag/222/?title=%E4%BA%BA%E5%A3%B0",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/138ec1aca3bcda71fe5bd8fd26f1e828.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/138ec1aca3bcda71fe5bd8fd26f1e828.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 208,
    "name": "器乐",
    "actionUrl": "eyepetizer://tag/208/?title=%E5%99%A8%E4%B9%90",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/f5b284ad6d9bd5812f7336983ed9e908.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/f5b284ad6d9bd5812f7336983ed9e908.png?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 204,
    "name": "精致",
    "actionUrl": "eyepetizer://tag/204/?title=%E7%B2%BE%E8%87%B4",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 1018,
    "name": "音乐",
    "actionUrl": "eyepetizer://tag/1018/?title=%E9%9F%B3%E4%B9%90",
    "adTrack": null,
    "desc": "用眼睛就能「听」的艺术",
    "bgPicture": "http://img.kaiyanapp.com/46b2ed7ccd3e241ff54a314faf2632b8.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/4f6643756d9ff5c41acdf7d0493055c4.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 13,
    "shareCount": 22,
    "replyCount": 2,
    "realCollectionCount": 0
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "YouTube",
    "alias": "youtube",
    "icon": "http://ali-img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"
    },
    "category": "音乐",
    "author": {
    "id": 2163,
    "icon": "http://ali-img.kaiyanapp.com/9279c17b4da5ba5e7e4f21afb5bb0a74.jpeg",
    "name": "全球音乐视频精选",
    "description": "我们精选全球最酷炫、最有态度的音乐，一定能让你眼前一亮",
    "link": "",
    "latestReleaseTime": 1688000447000,
    "videoNum": 1229,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 2163,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 2163,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/0982218800f98e8698d8cbc6af209769.jpeg?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/0982218800f98e8698d8cbc6af209769.jpeg?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/8b15e42d04073776b04ae7e6695c5088.jpeg?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/0982218800f98e8698d8cbc6af209769.jpeg?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318569&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 366,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318569",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318569&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1687914014000,
    "playInfo": [
    {
    "height": 720,
    "width": 1280,
    "urlList": [
    {
    "name": "aliyun",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318569&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=",
    "size": 27524565
    },
    {
    "name": "ucloud",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318569&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=",
    "size": 27524565
    }
    ],
    "name": "高清",
    "type": "high",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318569&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="
    }
    ],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "音乐",
    "descriptionPgc": "",
    "remark": null,
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1687914000000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "Devendra Banhart 宣布了一张新专辑「Flying Wig」，将于 9 月发行。这是他继 2019 年的「Ma」之后的作品，本片是其专辑的主打单曲「Twin」的音乐视频。From Devendra Banhart",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    {
    "type": "followCard",
    "data": {
    "dataType": "FollowCard",
    "header": {
    "id": 318327,
    "title": "开眼科技精选",
    "font": null,
    "subTitle": null,
    "subTitleFont": null,
    "textAlign": "left",
    "cover": null,
    "label": null,
    "actionUrl": "eyepetizer://pgc/detail/2171/?title=%E5%BC%80%E7%9C%BC%E7%A7%91%E6%8A%80%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1",
    "labelList": null,
    "rightText": null,
    "icon": "http://ali-img.kaiyanapp.com/0117b9108c7cff43700db8af5e24f2bf.jpeg",
    "iconType": "round",
    "description": "#科技 / 收录于 每日编辑精选",
    "time": 1687914015000,
    "showHateVideo": false
    },
    "content": {
    "type": "video",
    "data": {
    "dataType": "VideoBeanForClient",
    "id": 318327,
    "title": "摄影界难题，为什么在白天拍摄夜景难？",
    "description": "摄影师霍伊特范霍伊特创新了一种全新的昼夜拍摄方式。从历史上看，以日换夜的方法并不总是产生最令人信服的结果。在「Nope」中 Van Hoytema 和导演 Jordan Peele 希望避免传统昼夜场景所特有的实用烟雾和假人影的美学，Van Hoytema 和 Peele 将这种美学称为「电影之夜」。From Insider",
    "library": "DAILY",
    "tags": [
    {
    "id": 200,
    "name": "酷炫",
    "actionUrl": "eyepetizer://tag/200/?title=%E9%85%B7%E7%82%AB",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/71f39f985df512d0d9fb52b82737bcf5.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 202,
    "name": "唯美",
    "actionUrl": "eyepetizer://tag/202/?title=%E5%94%AF%E7%BE%8E",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/965a0a74d0af871eb174b5c7def6fd6d.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/965a0a74d0af871eb174b5c7def6fd6d.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 146,
    "name": "666",
    "actionUrl": "eyepetizer://tag/146/?title=666",
    "adTrack": null,
    "desc": null,
    "bgPicture": "https://i.ytimg.com/vi/MKWWhf8RAV8/maxresdefault.jpg",
    "headerImage": "http://img.kaiyanapp.com/522f7e51abb07a4a4438b82ee54174a4.jpeg?imageMogr2/quality/100",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 204,
    "name": "精致",
    "actionUrl": "eyepetizer://tag/204/?title=%E7%B2%BE%E8%87%B4",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/ee3a04688868510772ca7c30fdc7fce6.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 675,
    "name": "摄影艺术",
    "actionUrl": "eyepetizer://tag/675/?title=%E6%91%84%E5%BD%B1%E8%89%BA%E6%9C%AF",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/c2f92f2aa503674c0e344d565e7f406b.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/c2f92f2aa503674c0e344d565e7f406b.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 148,
    "name": "匠心",
    "actionUrl": "eyepetizer://tag/148/?title=%E5%8C%A0%E5%BF%83",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/cf568288dc8087fa728308f2623b9527.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/cf568288dc8087fa728308f2623b9527.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 1040,
    "name": "科普",
    "actionUrl": "eyepetizer://tag/1040/?title=%E7%A7%91%E6%99%AE",
    "adTrack": null,
    "desc": null,
    "bgPicture": "http://img.kaiyanapp.com/86af95dab03ab8fac3342517e83b07bb.jpeg?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/86af95dab03ab8fac3342517e83b07bb.jpeg?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    },
    {
    "id": 1024,
    "name": "科技",
    "actionUrl": "eyepetizer://tag/1024/?title=%E7%A7%91%E6%8A%80",
    "adTrack": null,
    "desc": "新知识与一切先进生产力",
    "bgPicture": "http://img.kaiyanapp.com/7e326064edc565ac6355921cfe4b3e46.png?imageMogr2/quality/60/format/jpg",
    "headerImage": "http://img.kaiyanapp.com/810adad06df812462bb0e00501fa679c.png?imageMogr2/quality/60/format/jpg",
    "tagRecType": "NORMAL",
    "childTagList": null,
    "childTagIdList": null,
    "haveReward": false,
    "ifNewest": false,
    "newestEndTime": null,
    "communityIndex": 0
    }
    ],
    "consumption": {
    "collectionCount": 54,
    "shareCount": 11,
    "replyCount": 2,
    "realCollectionCount": 27
    },
    "resourceType": "video",
    "slogan": null,
    "provider": {
    "name": "YouTube",
    "alias": "youtube",
    "icon": "http://ali-img.kaiyanapp.com/fa20228bc5b921e837156923a58713f6.png"
    },
    "category": "科技",
    "author": {
    "id": 2171,
    "icon": "http://ali-img.kaiyanapp.com/0117b9108c7cff43700db8af5e24f2bf.jpeg",
    "name": "开眼科技精选",
    "description": "新知识与一切先进生产力",
    "link": "",
    "latestReleaseTime": 1687914015000,
    "videoNum": 465,
    "adTrack": null,
    "follow": {
    "itemType": "author",
    "itemId": 2171,
    "followed": false
    },
    "shield": {
    "itemType": "author",
    "itemId": 2171,
    "shielded": false
    },
    "approvedNotReadyVideoCount": 0,
    "ifPgc": true,
    "recSort": 0,
    "expert": false
    },
    "cover": {
    "feed": "http://ali-img.kaiyanapp.com/36ea7a940ce13940c722430a0a0f6da7.png?imageMogr2/quality/60/format/jpg",
    "detail": "http://ali-img.kaiyanapp.com/36ea7a940ce13940c722430a0a0f6da7.png?imageMogr2/quality/60/format/jpg",
    "blurred": "http://ali-img.kaiyanapp.com/444360395259b09f68f3c358335aa331.png?imageMogr2/quality/60/format/jpg",
    "sharing": null,
    "homepage": "http://img.kaiyanapp.com/36ea7a940ce13940c722430a0a0f6da7.png?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim"
    },
    "playUrl": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318327&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=",
    "thumbPlayUrl": null,
    "duration": 655,
    "webUrl": {
    "raw": "http://www.eyepetizer.net/detail.html?vid=318327",
    "forWeibo": "https://m.eyepetizer.net/u1/video-detail?video_id=318327&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0"
    },
    "releaseTime": 1687914015000,
    "playInfo": [
    {
    "height": 720,
    "width": 1280,
    "urlList": [
    {
    "name": "aliyun",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318327&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=",
    "size": 51091654
    },
    {
    "name": "ucloud",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318327&resourceType=video&editionType=high&source=ucloud&playUrlType=url_oss&udid=",
    "size": 51091654
    }
    ],
    "name": "高清",
    "type": "high",
    "url": "http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318327&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid="
    }
    ],
    "campaign": null,
    "waterMarks": null,
    "ad": false,
    "adTrack": [],
    "type": "NORMAL",
    "titlePgc": "科普 为什么在白天拍摄黑夜难？",
    "descriptionPgc": "",
    "remark": null,
    "ifLimitVideo": false,
    "searchWeight": 0,
    "brandWebsiteInfo": null,
    "videoPosterBean": null,
    "idx": 0,
    "shareAdTrack": null,
    "favoriteAdTrack": null,
    "webAdTrack": null,
    "date": 1687914000000,
    "promotion": null,
    "label": null,
    "labelList": [],
    "descriptionEditor": "摄影师霍伊特范霍伊特创新了一种全新的昼夜拍摄方式。从历史上看，以日换夜的方法并不总是产生最令人信服的结果。在「Nope」中 Van Hoytema 和导演 Jordan Peele 希望避免传统昼夜场景所特有的实用烟雾和假人影的美学，Van Hoytema 和 Peele 将这种美学称为「电影之夜」。From Insider",
    "collected": false,
    "reallyCollected": false,
    "played": false,
    "subtitles": [],
    "lastViewTime": null,
    "playlists": null,
    "src": null,
    "recallSource": null,
    "recall_source": null
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    },
    "adTrack": []
    },
    "trackingData": null,
    "tag": null,
    "id": 0,
    "adIndex": -1
    }
    ],
    "count": 22,
    "total": 0,
    "nextPageUrl": "http://baobab.kaiyanapp.com/api/v5/index/tab/feed?date=1687827600000&num=2",
    "adExist": false
    }
     */

    @JSONField(name = "adExist")
    var adExist: Boolean = false // false

    @JSONField(name = "count")
    var count: Int = 0 // 22

    @JSONField(name = "itemList")
    var itemList: List<Item> = mutableListOf()

    @JSONField(name = "nextPageUrl")
    var nextPageUrl: String =
        "" // http://baobab.kaiyanapp.com/api/v5/index/tab/feed?date=1687827600000&num=2

    @JSONField(name = "total")
    var total: Int = 0 // 0

    class Item {
        @JSONField(name = "adIndex")
        var adIndex: Int = 0 // -1

        @JSONField(name = "data")
        var itemData: Data = Data()

        @JSONField(name = "id")
        var id: Int = 0 // 0

        @JSONField(name = "tag")
        var tag: String = "" // null

        @JSONField(name = "trackingData")
        var trackingData: String = "" // null

        @JSONField(name = "type")
        var type: String = "" // textCard

        class Data {

            @JSONField(name = "actionUrl")
            var actionUrl: String = "" // null

            @JSONField(name = "adTrack")
            var adTrack: List<Any> = mutableListOf()

            @JSONField(name = "content")
            var content: Content = Content()

            @JSONField(name = "dataType")
            var dataType: String = "" // TextCard

            @JSONField(name = "follow")
            var follow: String = "" // null

            @JSONField(name = "header")
            var header: Header = Header()

            @JSONField(name = "id")
            var id: Int = 0 // 0

            @JSONField(name = "subTitle")
            var subTitle: String = "" // null

            @JSONField(name = "text")
            var text: String = "" // 今日开眼精选

            @JSONField(name = "type")
            var type: String = "" // header5


            class Content {

                @JSONField(name = "adIndex")
                var adIndex: Int = 0 // -1

                @JSONField(name = "data")
                var contentData: Item.Data = Item.Data()

                @JSONField(name = "id")
                var id: Int = 0 // 0

                @JSONField(name = "tag")
                var tag: String = "" // null

                @JSONField(name = "trackingData")
                var trackingData: String = "" // null

                @JSONField(name = "type")
                var type: String = "" // video

                class Data {

                    @JSONField(name = "ad")
                    var ad: Boolean = false // false

                    @JSONField(name = "adTrack")
                    var adTrack: List<Any> = mutableListOf()

                    @JSONField(name = "author")
                    var author: Author = Author()

                    @JSONField(name = "brandWebsiteInfo")
                    var brandWebsiteInfo: String = "" // null

                    @JSONField(name = "campaign")
                    var campaign: String = "" // null

                    @JSONField(name = "category")
                    var category: String = "" // 广告

                    @JSONField(name = "collected")
                    var collected: Boolean = false // false

                    @JSONField(name = "consumption")
                    var consumption: Consumption = Consumption()

                    @JSONField(name = "cover")
                    var cover: Cover = Cover()

                    @JSONField(name = "dataType")
                    var dataType: String = "" // VideoBeanForClient

                    @JSONField(name = "date")
                    var date: Long = 0 // 1688000400000

                    @JSONField(name = "description")
                    var description: String =
                        "" // 711 便利店脑洞广告短片，在大雪纷飞的深夜，便利店也不会打烊，为每一位顾客带来仅售 1 美元的冰咖啡，深夜送「温暖」。From Mark Leephaibul

                    @JSONField(name = "descriptionEditor")
                    var descriptionEditor: String =
                        "" // 711 便利店脑洞广告短片，在大雪纷飞的深夜，便利店也不会打烊，为每一位顾客带来仅售 1 美元的冰咖啡，深夜送「温暖」。From Mark Leephaibul

                    @JSONField(name = "descriptionPgc")
                    var descriptionPgc: String = ""

                    @JSONField(name = "duration")
                    var duration: Int = 0 // 30

                    @JSONField(name = "favoriteAdTrack")
                    var favoriteAdTrack: String = "" // null

                    @JSONField(name = "id")
                    var id: Int = 0 // 318699

                    @JSONField(name = "idx")
                    var idx: Int = 0 // 0

                    @JSONField(name = "ifLimitVideo")
                    var ifLimitVideo: Boolean = false // false

                    @JSONField(name = "label")
                    var label: String = "" // null

                    @JSONField(name = "labelList")
                    var labelList: List<Any> = mutableListOf()

                    @JSONField(name = "lastViewTime")
                    var lastViewTime: String = "" // null

                    @JSONField(name = "library")
                    var library: String = "" // DAILY

                    @JSONField(name = "playInfo")
                    var playInfo: List<PlayInfo> = mutableListOf()

                    @JSONField(name = "playUrl")
                    var playUrl: String =
                        "" // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318699&resourceType=video&editionType=default&source=aliyun&playUrlType=url_oss&udid=

                    @JSONField(name = "played")
                    var played: Boolean = false // false

                    @JSONField(name = "playlists")
                    var playlists: String = "" // null

                    @JSONField(name = "promotion")
                    var promotion: String = "" // null

                    @JSONField(name = "provider")
                    var provider: Provider = Provider()

                    @JSONField(name = "reallyCollected")
                    var reallyCollected: Boolean = false // false

                    @JSONField(name = "recallSource")
                    var recallSource: String = "" // null

                    @JSONField(name = "recall_source")
                    var recall_source: String = "" // null

                    @JSONField(name = "releaseTime")
                    var releaseTime: Long = 0 // 1688000445000

                    @JSONField(name = "remark")
                    var remark: String =
                        "" // https://www.xinpianchang.com/a12585576?from=ArticleList

                    @JSONField(name = "resourceType")
                    var resourceType: String = "" // video

                    @JSONField(name = "searchWeight")
                    var searchWeight: Int = 0 // 0

                    @JSONField(name = "shareAdTrack")
                    var shareAdTrack: String = "" // null

                    @JSONField(name = "slogan")
                    var slogan: String = "" // null

                    @JSONField(name = "src")
                    var src: String = "" // null

                    @JSONField(name = "subtitles")
                    var subtitles: List<Any> = mutableListOf()

                    @JSONField(name = "tags")
                    var tags: List<Tag> = mutableListOf()

                    @JSONField(name = "thumbPlayUrl")
                    var thumbPlayUrl: String = "" // null

                    @JSONField(name = "title")
                    var title: String = "" // 711 便利店脑洞广告，深夜的咖啡风暴

                    @JSONField(name = "titlePgc")
                    var titlePgc: String = "" // 广告

                    @JSONField(name = "type")
                    var type: String = "" // NORMAL

                    @JSONField(name = "videoPosterBean")
                    var videoPosterBean: String = "" // null

                    @JSONField(name = "waterMarks")
                    var waterMarks: String = "" // null

                    @JSONField(name = "webAdTrack")
                    var webAdTrack: String = "" // null

                    @JSONField(name = "webUrl")
                    var webUrl: WebUrl = WebUrl()

                    class Author {

                        @JSONField(name = "adTrack")
                        var adTrack: String = "" // null

                        @JSONField(name = "approvedNotReadyVideoCount")
                        var approvedNotReadyVideoCount: Int = 0 // 0

                        @JSONField(name = "description")
                        var description: String = "" // 我们精选世界最好看的广告，为全世界广告人的精彩创意点赞。

                        @JSONField(name = "expert")
                        var expert: Boolean = false // false

                        @JSONField(name = "follow")
                        var follow: Follow = Follow()

                        @JSONField(name = "icon")
                        var icon: String =
                            "" // http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg

                        @JSONField(name = "id")
                        var id: Int = 0 // 2162

                        @JSONField(name = "ifPgc")
                        var ifPgc: Boolean = false // true

                        @JSONField(name = "latestReleaseTime")
                        var latestReleaseTime: Long = 0 // 1688000445000

                        @JSONField(name = "link")
                        var link: String = ""

                        @JSONField(name = "name")
                        var name: String = "" // 全球广告精选

                        @JSONField(name = "recSort")
                        var recSort: Int = 0 // 0

                        @JSONField(name = "shield")
                        var shield: Shield = Shield()

                        @JSONField(name = "videoNum")
                        var videoNum: Int = 0 // 2787

                        class Follow {
                            @JSONField(name = "followed")
                            var followed: Boolean = false // false

                            @JSONField(name = "itemId")
                            var itemId: Int = 0 // 2162

                            @JSONField(name = "itemType")
                            var itemType: String = "" // author
                        }

                        class Shield {
                            @JSONField(name = "itemId")
                            var itemId: Int = 0 // 2162

                            @JSONField(name = "itemType")
                            var itemType: String = "" // author

                            @JSONField(name = "shielded")
                            var shielded: Boolean = false // false
                        }
                    }

                    class Consumption {

                        @JSONField(name = "collectionCount")
                        var collectionCount: Int = 0 // 54

                        @JSONField(name = "realCollectionCount")
                        var realCollectionCount: Int = 0 // 0

                        @JSONField(name = "replyCount")
                        var replyCount: Int = 0 // 5

                        @JSONField(name = "shareCount")
                        var shareCount: Int = 0 // 11
                    }

                    class Cover {
                        @JSONField(name = "blurred")
                        var blurred: String =
                            "" // http://ali-img.kaiyanapp.com/c72cea5559e0c0183e49bbbf6dc242d6.png?imageMogr2/quality/60/format/jpg

                        @JSONField(name = "detail")
                        var detail: String =
                            "" // http://ali-img.kaiyanapp.com/431f36cefdec8a30dc3b07a628106215.png?imageMogr2/quality/60/format/jpg

                        @JSONField(name = "feed")
                        var feed: String =
                            "" // http://ali-img.kaiyanapp.com/431f36cefdec8a30dc3b07a628106215.png?imageMogr2/quality/60/format/jpg

                        @JSONField(name = "homepage")
                        var homepage: String =
                            "" // http://img.kaiyanapp.com/431f36cefdec8a30dc3b07a628106215.png?imageView2/1/w/720/h/560/format/jpg/q/75|watermark/1/image/aHR0cDovL2ltZy5rYWl5YW5hcHAuY29tL2JsYWNrXzMwLnBuZw==/dissolve/100/gravity/Center/dx/0/dy/0|imageslim

                        @JSONField(name = "sharing")
                        var sharing: String = "" // null
                    }

                    class PlayInfo {

                        @JSONField(name = "height")
                        var height: Int = 0 // 720

                        @JSONField(name = "name")
                        var name: String = "" // 高清

                        @JSONField(name = "type")
                        var type: String = "" // high

                        @JSONField(name = "url")
                        var url: String =
                            "" // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318637&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=

                        @JSONField(name = "urlList")
                        var urlList: List<Url> = mutableListOf()

                        @JSONField(name = "width")
                        var width: Int = 0 // 1280

                        class Url {

                            @JSONField(name = "name")
                            var name: String = "" // aliyun

                            @JSONField(name = "size")
                            var size: Int = 0 // 7629273

                            @JSONField(name = "url")
                            var url: String =
                                "" // http://baobab.kaiyanapp.com/api/v1/playUrl?vid=318637&resourceType=video&editionType=high&source=aliyun&playUrlType=url_oss&udid=

                        }
                    }

                    class Provider {

                        @JSONField(name = "alias")
                        var alias: String = "" // vimeo

                        @JSONField(name = "icon")
                        var icon: String =
                            "" // http://ali-img.kaiyanapp.com/c3ad630be461cbb081649c9e21d6cbe3.png

                        @JSONField(name = "name")
                        var name: String = "" // Vimeo
                    }

                    class Tag {

                        @JSONField(name = "actionUrl")
                        var actionUrl: String =
                            "" // eyepetizer://tag/748/?title=%E8%BF%99%E4%BA%9B%E5%B9%BF%E5%91%8A%E8%B6%85%E6%9C%89%E6%A2%97

                        @JSONField(name = "adTrack")
                        var adTrack: String = "" // null

                        @JSONField(name = "bgPicture")
                        var bgPicture: String =
                            "" // http://img.kaiyanapp.com/9056413cfeffaf0c841d894390aa8e08.jpeg?imageMogr2/quality/60/format/jpg

                        @JSONField(name = "childTagIdList")
                        var childTagIdList: String = "" // null

                        @JSONField(name = "childTagList")
                        var childTagList: String = "" // null

                        @JSONField(name = "communityIndex")
                        var communityIndex: Int = 0 // 0

                        @JSONField(name = "desc")
                        var desc: String = "" // 为广告人的精彩创意点赞

                        @JSONField(name = "haveReward")
                        var haveReward: Boolean = false // false

                        @JSONField(name = "headerImage")
                        var headerImage: String =
                            "" // http://img.kaiyanapp.com/ff0f6d0ad5f4b6211a3f746aaaffd916.jpeg?imageMogr2/quality/60/format/jpg

                        @JSONField(name = "id")
                        var id: Int = 0 // 748

                        @JSONField(name = "ifNewest")
                        var ifNewest: Boolean = false // false

                        @JSONField(name = "name")
                        var name: String = "" // 这些广告超有梗

                        @JSONField(name = "newestEndTime")
                        var newestEndTime: Long = 0 // 1586767119000

                        @JSONField(name = "tagRecType")
                        var tagRecType: String = "" // IMPORTANT
                    }

                    class WebUrl {

                        @JSONField(name = "forWeibo")
                        var forWeibo: String =
                            "" // https://m.eyepetizer.net/u1/video-detail?video_id=318699&resource_type=video&utm_campaign=routine&utm_medium=share&utm_source=weibo&uid=0

                        @JSONField(name = "raw")
                        var raw: String = "" // http://www.eyepetizer.net/detail.html?vid=318699

                    }
                }
            }

            class Header {

                @JSONField(name = "actionUrl")
                var actionUrl: String =
                    "" // eyepetizer://pgc/detail/2162/?title=%E5%85%A8%E7%90%83%E5%B9%BF%E5%91%8A%E7%B2%BE%E9%80%89&userType=PGC&tabIndex=1

                @JSONField(name = "cover")
                var cover: String = "" // null

                @JSONField(name = "description")
                var description: String = "" // #广告 / 收录于 每日编辑精选

                @JSONField(name = "font")
                var font: String = "" // null

                @JSONField(name = "icon")
                var icon: String =
                    "" // http://ali-img.kaiyanapp.com/98beab66d3885a139b54f21e91817c4f.jpeg

                @JSONField(name = "iconType")
                var iconType: String = "" // round

                @JSONField(name = "id")
                var id: Int = 0 // 318699

                @JSONField(name = "label")
                var label: String = "" // null

                @JSONField(name = "labelList")
                var labelList: String = "" // null

                @JSONField(name = "rightText")
                var rightText: String = "" // null

                @JSONField(name = "showHateVideo")
                var showHateVideo: Boolean = false // false

                @JSONField(name = "subTitle")
                var subTitle: String = "" // null

                @JSONField(name = "subTitleFont")
                var subTitleFont: String = "" // null

                @JSONField(name = "textAlign")
                var textAlign: String = "" // left

                @JSONField(name = "time")
                var time: Long = 0 // 1688000445000

                @JSONField(name = "title")
                var title: String = "" // 全球广告精选
            }
        }
    }
}