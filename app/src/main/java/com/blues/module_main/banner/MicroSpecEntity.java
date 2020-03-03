package com.blues.module_main.banner;

import java.io.Serializable;
import java.util.List;

/**
 * User : Blues
 * Date : 2019/10/21
 * Time : 16:16
 */

public class MicroSpecEntity implements Serializable {

    /**
     * code : 0
     * message : ok
     * result : [{"productId":1279905596,"productName":"大厂面试必考之深入解析图片缓存框架原理","startTime":null,"endTime":null,"description":"1、规避任何环节都可能爆发的OOM\n2、详解面向接口的定义及实现\n3、网络-本地-内存具体表现\n4、如何设计配置、扩展、健壮","webOneDesc":null,"provider":null,"score":null,"scoreLevel":null,"learnerCount":null,"imgUrl":"http://edu-image.nosdn.127.net/ED913E73DEB3798BACF0243E1D5EF5C5.jpg?imageView&thumbnail=234y234&quality=100","bigImgUrl":null,"originalPrice":0,"discountPrice":0,"gmtModified":null,"firstPublishTime":null,"displayType":0,"browseCount":null,"resourceType":null,"targetUrl":"https://study.163.com/lessonlive/h5/1279905596.htm","courseCardProps":"null","searchItemType":5,"belongToId":1209570837,"appType":null,"productType":1,"actionScene":"SCENE_UNKNOWN","activityIds":null,"activityUrl":null,"isTopGrade":false,"totalCount":null,"discountCouponId":null,"discountCouponType":null,"remainingCount":null,"instructor":"彭锡 网易特邀安卓高级工程师","subTitle":null,"recommendRequestId":null,"recommendAlgInfo":null,"appImgUrl":null,"webImgUrl":null,"wapImgUrl":null,"webImgColor":null,"bannerTitle":null,"capsuleImgUrl":null,"popupImgUrl":null,"readyStatus":null,"vipContentType":null,"vipPrice":null,"categoryId":-3,"cornerMark":null,"advertiseSearchUuid":null,"advertiseFlag":null,"title":"大厂面试必考之深入解析图片缓存框架原理","liveStartTime":1571659200000,"liveFinishedTime":1571666400000,"followed":false,"liveId":480000001874708,"liveStatus":1,"firstCategoryId":480000003128011},{"productId":1279907550,"productName":"数据可视化基础：如何正确做图表表达？","startTime":null,"endTime":null,"description":"1.matplotlib介绍及基础功能\n2.必知的数据表达及图标逻辑\n3.如何用一行代码实现图表制作\n4.实操案例：不同场景下的图表制作方法","webOneDesc":null,"provider":null,"score":null,"scoreLevel":null,"learnerCount":null,"imgUrl":"http://edu-image.nosdn.127.net/0de4c33afc5144caa123b0ba2a287991.jpg?imageView&quality=100","bigImgUrl":null,"originalPrice":0,"discountPrice":0,"gmtModified":null,"firstPublishTime":null,"displayType":0,"browseCount":null,"resourceType":null,"targetUrl":"https://study.163.com/lessonlive/h5/1279907550.htm","courseCardProps":"null","searchItemType":5,"belongToId":1209491904,"appType":null,"productType":1,"actionScene":"SCENE_UNKNOWN","activityIds":null,"activityUrl":null,"isTopGrade":false,"totalCount":null,"discountCouponId":null,"discountCouponType":null,"remainingCount":null,"instructor":"大鹏  网易金牌数据分析讲师","subTitle":null,"recommendRequestId":null,"recommendAlgInfo":null,"appImgUrl":null,"webImgUrl":null,"wapImgUrl":null,"webImgColor":null,"bannerTitle":null,"capsuleImgUrl":null,"popupImgUrl":null,"readyStatus":null,"vipContentType":null,"vipPrice":null,"categoryId":-3,"cornerMark":null,"advertiseSearchUuid":null,"advertiseFlag":null,"title":"数据可视化基础：如何正确做图表表达？","liveStartTime":1571659200000,"liveFinishedTime":1571666400000,"followed":false,"liveId":480000001875692,"liveStatus":1,"firstCategoryId":480000003128012},{"productId":1279906986,"productName":"网易云课堂-分布式事务解决方案实录","startTime":null,"endTime":null,"description":"1、隐藏在业务场景中的分布式事务问题；\n2、分布式事务处理的核心理念\n3、如何真正将分布式事务技术落地\n4、实战：结合外卖项目下单分单场景解决事务问题\n5、分享分布式系统开发中必须要了解的几个技术解决方案 ","webOneDesc":null,"provider":null,"score":null,"scoreLevel":null,"learnerCount":null,"imgUrl":"http://edu-image.nosdn.127.net/150A588542BB379C9F52915730DCF347.png?imageView&thumbnail=234y234&quality=100","bigImgUrl":null,"originalPrice":0,"discountPrice":0,"gmtModified":null,"firstPublishTime":null,"displayType":0,"browseCount":null,"resourceType":null,"targetUrl":"https://study.163.com/lessonlive/h5/1279906986.htm","courseCardProps":"null","searchItemType":5,"belongToId":1209509811,"appType":null,"productType":1,"actionScene":"SCENE_UNKNOWN","activityIds":null,"activityUrl":null,"isTopGrade":false,"totalCount":null,"discountCouponId":null,"discountCouponType":null,"remainingCount":null,"instructor":"张峰 网易特邀Java高级工程师","subTitle":null,"recommendRequestId":null,"recommendAlgInfo":null,"appImgUrl":null,"webImgUrl":null,"wapImgUrl":null,"webImgColor":null,"bannerTitle":null,"capsuleImgUrl":null,"popupImgUrl":null,"readyStatus":null,"vipContentType":null,"vipPrice":null,"categoryId":-3,"cornerMark":null,"advertiseSearchUuid":null,"advertiseFlag":null,"title":"网易云课堂-分布式事务解决方案实录","liveStartTime":1571659200000,"liveFinishedTime":1571666400000,"followed":false,"liveId":480000001877737,"liveStatus":1,"firstCategoryId":480000003128011}]
     * uuid : null
     */

    private int code;
    private String message;
    private Object uuid;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getUuid() {
        return uuid;
    }

    public void setUuid(Object uuid) {
        this.uuid = uuid;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean  implements Serializable {
        /**
         * productId : 1279905596
         * productName : 大厂面试必考之深入解析图片缓存框架原理
         * startTime : null
         * endTime : null
         * description : 1、规避任何环节都可能爆发的OOM
         2、详解面向接口的定义及实现
         3、网络-本地-内存具体表现
         4、如何设计配置、扩展、健壮
         * webOneDesc : null
         * provider : null
         * score : null
         * scoreLevel : null
         * learnerCount : null
         * imgUrl : http://edu-image.nosdn.127.net/ED913E73DEB3798BACF0243E1D5EF5C5.jpg?imageView&thumbnail=234y234&quality=100
         * bigImgUrl : null
         * originalPrice : 0
         * discountPrice : 0
         * gmtModified : null
         * firstPublishTime : null
         * displayType : 0
         * browseCount : null
         * resourceType : null
         * targetUrl : https://study.163.com/lessonlive/h5/1279905596.htm
         * courseCardProps : null
         * searchItemType : 5
         * belongToId : 1209570837
         * appType : null
         * productType : 1
         * actionScene : SCENE_UNKNOWN
         * activityIds : null
         * activityUrl : null
         * isTopGrade : false
         * totalCount : null
         * discountCouponId : null
         * discountCouponType : null
         * remainingCount : null
         * instructor : 彭锡 网易特邀安卓高级工程师
         * subTitle : null
         * recommendRequestId : null
         * recommendAlgInfo : null
         * appImgUrl : null
         * webImgUrl : null
         * wapImgUrl : null
         * webImgColor : null
         * bannerTitle : null
         * capsuleImgUrl : null
         * popupImgUrl : null
         * readyStatus : null
         * vipContentType : null
         * vipPrice : null
         * categoryId : -3
         * cornerMark : null
         * advertiseSearchUuid : null
         * advertiseFlag : null
         * title : 大厂面试必考之深入解析图片缓存框架原理
         * liveStartTime : 1571659200000
         * liveFinishedTime : 1571666400000
         * followed : false
         * liveId : 480000001874708
         * liveStatus : 1
         * firstCategoryId : 480000003128011
         */

        private int productId;
        private String productName;
        private Object startTime;
        private Object endTime;
        private String description;
        private Object webOneDesc;
        private Object provider;
        private Object score;
        private Object scoreLevel;
        private Object learnerCount;
        private String imgUrl;
        private Object bigImgUrl;
        private int originalPrice;
        private int discountPrice;
        private Object gmtModified;
        private Object firstPublishTime;
        private int displayType;
        private Object browseCount;
        private Object resourceType;
        private String targetUrl;
        private String courseCardProps;
        private int searchItemType;
        private int belongToId;
        private Object appType;
        private int productType;
        private String actionScene;
        private Object activityIds;
        private Object activityUrl;
        private boolean isTopGrade;
        private Object totalCount;
        private Object discountCouponId;
        private Object discountCouponType;
        private Object remainingCount;
        private String instructor;
        private Object subTitle;
        private Object recommendRequestId;
        private Object recommendAlgInfo;
        private Object appImgUrl;
        private Object webImgUrl;
        private Object wapImgUrl;
        private Object webImgColor;
        private Object bannerTitle;
        private Object capsuleImgUrl;
        private Object popupImgUrl;
        private Object readyStatus;
        private Object vipContentType;
        private Object vipPrice;
        private int categoryId;
        private Object cornerMark;
        private Object advertiseSearchUuid;
        private Object advertiseFlag;
        private String title;
        private long liveStartTime;
        private long liveFinishedTime;
        private boolean followed;
        private long liveId;
        private int liveStatus;
        private long firstCategoryId;

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Object getStartTime() {
            return startTime;
        }

        public void setStartTime(Object startTime) {
            this.startTime = startTime;
        }

        public Object getEndTime() {
            return endTime;
        }

        public void setEndTime(Object endTime) {
            this.endTime = endTime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getWebOneDesc() {
            return webOneDesc;
        }

        public void setWebOneDesc(Object webOneDesc) {
            this.webOneDesc = webOneDesc;
        }

        public Object getProvider() {
            return provider;
        }

        public void setProvider(Object provider) {
            this.provider = provider;
        }

        public Object getScore() {
            return score;
        }

        public void setScore(Object score) {
            this.score = score;
        }

        public Object getScoreLevel() {
            return scoreLevel;
        }

        public void setScoreLevel(Object scoreLevel) {
            this.scoreLevel = scoreLevel;
        }

        public Object getLearnerCount() {
            return learnerCount;
        }

        public void setLearnerCount(Object learnerCount) {
            this.learnerCount = learnerCount;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public Object getBigImgUrl() {
            return bigImgUrl;
        }

        public void setBigImgUrl(Object bigImgUrl) {
            this.bigImgUrl = bigImgUrl;
        }

        public int getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(int originalPrice) {
            this.originalPrice = originalPrice;
        }

        public int getDiscountPrice() {
            return discountPrice;
        }

        public void setDiscountPrice(int discountPrice) {
            this.discountPrice = discountPrice;
        }

        public Object getGmtModified() {
            return gmtModified;
        }

        public void setGmtModified(Object gmtModified) {
            this.gmtModified = gmtModified;
        }

        public Object getFirstPublishTime() {
            return firstPublishTime;
        }

        public void setFirstPublishTime(Object firstPublishTime) {
            this.firstPublishTime = firstPublishTime;
        }

        public int getDisplayType() {
            return displayType;
        }

        public void setDisplayType(int displayType) {
            this.displayType = displayType;
        }

        public Object getBrowseCount() {
            return browseCount;
        }

        public void setBrowseCount(Object browseCount) {
            this.browseCount = browseCount;
        }

        public Object getResourceType() {
            return resourceType;
        }

        public void setResourceType(Object resourceType) {
            this.resourceType = resourceType;
        }

        public String getTargetUrl() {
            return targetUrl;
        }

        public void setTargetUrl(String targetUrl) {
            this.targetUrl = targetUrl;
        }

        public String getCourseCardProps() {
            return courseCardProps;
        }

        public void setCourseCardProps(String courseCardProps) {
            this.courseCardProps = courseCardProps;
        }

        public int getSearchItemType() {
            return searchItemType;
        }

        public void setSearchItemType(int searchItemType) {
            this.searchItemType = searchItemType;
        }

        public int getBelongToId() {
            return belongToId;
        }

        public void setBelongToId(int belongToId) {
            this.belongToId = belongToId;
        }

        public Object getAppType() {
            return appType;
        }

        public void setAppType(Object appType) {
            this.appType = appType;
        }

        public int getProductType() {
            return productType;
        }

        public void setProductType(int productType) {
            this.productType = productType;
        }

        public String getActionScene() {
            return actionScene;
        }

        public void setActionScene(String actionScene) {
            this.actionScene = actionScene;
        }

        public Object getActivityIds() {
            return activityIds;
        }

        public void setActivityIds(Object activityIds) {
            this.activityIds = activityIds;
        }

        public Object getActivityUrl() {
            return activityUrl;
        }

        public void setActivityUrl(Object activityUrl) {
            this.activityUrl = activityUrl;
        }

        public boolean isIsTopGrade() {
            return isTopGrade;
        }

        public void setIsTopGrade(boolean isTopGrade) {
            this.isTopGrade = isTopGrade;
        }

        public Object getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(Object totalCount) {
            this.totalCount = totalCount;
        }

        public Object getDiscountCouponId() {
            return discountCouponId;
        }

        public void setDiscountCouponId(Object discountCouponId) {
            this.discountCouponId = discountCouponId;
        }

        public Object getDiscountCouponType() {
            return discountCouponType;
        }

        public void setDiscountCouponType(Object discountCouponType) {
            this.discountCouponType = discountCouponType;
        }

        public Object getRemainingCount() {
            return remainingCount;
        }

        public void setRemainingCount(Object remainingCount) {
            this.remainingCount = remainingCount;
        }

        public String getInstructor() {
            return instructor;
        }

        public void setInstructor(String instructor) {
            this.instructor = instructor;
        }

        public Object getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(Object subTitle) {
            this.subTitle = subTitle;
        }

        public Object getRecommendRequestId() {
            return recommendRequestId;
        }

        public void setRecommendRequestId(Object recommendRequestId) {
            this.recommendRequestId = recommendRequestId;
        }

        public Object getRecommendAlgInfo() {
            return recommendAlgInfo;
        }

        public void setRecommendAlgInfo(Object recommendAlgInfo) {
            this.recommendAlgInfo = recommendAlgInfo;
        }

        public Object getAppImgUrl() {
            return appImgUrl;
        }

        public void setAppImgUrl(Object appImgUrl) {
            this.appImgUrl = appImgUrl;
        }

        public Object getWebImgUrl() {
            return webImgUrl;
        }

        public void setWebImgUrl(Object webImgUrl) {
            this.webImgUrl = webImgUrl;
        }

        public Object getWapImgUrl() {
            return wapImgUrl;
        }

        public void setWapImgUrl(Object wapImgUrl) {
            this.wapImgUrl = wapImgUrl;
        }

        public Object getWebImgColor() {
            return webImgColor;
        }

        public void setWebImgColor(Object webImgColor) {
            this.webImgColor = webImgColor;
        }

        public Object getBannerTitle() {
            return bannerTitle;
        }

        public void setBannerTitle(Object bannerTitle) {
            this.bannerTitle = bannerTitle;
        }

        public Object getCapsuleImgUrl() {
            return capsuleImgUrl;
        }

        public void setCapsuleImgUrl(Object capsuleImgUrl) {
            this.capsuleImgUrl = capsuleImgUrl;
        }

        public Object getPopupImgUrl() {
            return popupImgUrl;
        }

        public void setPopupImgUrl(Object popupImgUrl) {
            this.popupImgUrl = popupImgUrl;
        }

        public Object getReadyStatus() {
            return readyStatus;
        }

        public void setReadyStatus(Object readyStatus) {
            this.readyStatus = readyStatus;
        }

        public Object getVipContentType() {
            return vipContentType;
        }

        public void setVipContentType(Object vipContentType) {
            this.vipContentType = vipContentType;
        }

        public Object getVipPrice() {
            return vipPrice;
        }

        public void setVipPrice(Object vipPrice) {
            this.vipPrice = vipPrice;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public Object getCornerMark() {
            return cornerMark;
        }

        public void setCornerMark(Object cornerMark) {
            this.cornerMark = cornerMark;
        }

        public Object getAdvertiseSearchUuid() {
            return advertiseSearchUuid;
        }

        public void setAdvertiseSearchUuid(Object advertiseSearchUuid) {
            this.advertiseSearchUuid = advertiseSearchUuid;
        }

        public Object getAdvertiseFlag() {
            return advertiseFlag;
        }

        public void setAdvertiseFlag(Object advertiseFlag) {
            this.advertiseFlag = advertiseFlag;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getLiveStartTime() {
            return liveStartTime;
        }

        public void setLiveStartTime(long liveStartTime) {
            this.liveStartTime = liveStartTime;
        }

        public long getLiveFinishedTime() {
            return liveFinishedTime;
        }

        public void setLiveFinishedTime(long liveFinishedTime) {
            this.liveFinishedTime = liveFinishedTime;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public long getLiveId() {
            return liveId;
        }

        public void setLiveId(long liveId) {
            this.liveId = liveId;
        }

        public int getLiveStatus() {
            return liveStatus;
        }

        public void setLiveStatus(int liveStatus) {
            this.liveStatus = liveStatus;
        }

        public long getFirstCategoryId() {
            return firstCategoryId;
        }

        public void setFirstCategoryId(long firstCategoryId) {
            this.firstCategoryId = firstCategoryId;
        }
    }
}
