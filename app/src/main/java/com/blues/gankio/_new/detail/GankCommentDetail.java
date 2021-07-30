package com.blues.gankio._new.detail;

import java.io.Serializable;

public class GankCommentDetail implements Serializable {

    /**
     * _id : 5ea10e8517bf93950887f228
     * userId : 594dd254421aa90c9203d2de
     * postId : 5e78b2f65d7c47fe610b0029
     * userName : OuyangPeng
     * comment : \u56db\u5e74\u524d\u5c31\u662f\u770b\u6254\u7269\u7ebf\u7684\u8fd9\u7bc7RxJava\u7684\u6587\u7ae0\u5165\u95e8rxjava\u7684\u3002\r\n\u7136\u540e\u9879\u76ee\u73b0\u5728\u8fd8\u662f\u5728\u7528RxJava 1.3 , \u540e\u7eed\u7684RxJava 2.0\u8fd8\u6ca1\u719f\u6089\uff0cRxJava3.0\u53c8\u6765\u4e86\uff0c\u7136\u800c\u4e00\u76f4\u6ca1\u6709\u5347\u7ea7\u3002\u5c34\u5c2c\uff01
     * headUrl : https://ae01.alicdn.com/kf/Ucffc39ec8ce7479cae1888cd0fe29daca.jpg
     * ups : 0
     * createdAt : 2020-04-23 11:41:57
     * secondParentId : 5ea10e8517bf93950887f227
     * secondParentName : null
     */

    private String _id;
    private String userId;
    private String postId;
    private String userName;
    private String comment;
    private String headUrl;
    private int ups;
    private String createdAt;
    private String secondParentId;
    private Object secondParentName;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public int getUps() {
        return ups;
    }

    public void setUps(int ups) {
        this.ups = ups;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getSecondParentId() {
        return secondParentId;
    }

    public void setSecondParentId(String secondParentId) {
        this.secondParentId = secondParentId;
    }

    public Object getSecondParentName() {
        return secondParentName;
    }

    public void setSecondParentName(Object secondParentName) {
        this.secondParentName = secondParentName;
    }

    @Override
    public String toString() {
        return "GankCommentDetail{" +
                "_id='" + _id + '\'' +
                ", userId='" + userId + '\'' +
                ", postId='" + postId + '\'' +
                ", userName='" + userName + '\'' +
                ", comment='" + comment + '\'' +
                ", headUrl='" + headUrl + '\'' +
                ", ups=" + ups +
                ", createdAt='" + createdAt + '\'' +
                ", secondParentId='" + secondParentId + '\'' +
                ", secondParentName=" + secondParentName +
                '}';
    }
}
