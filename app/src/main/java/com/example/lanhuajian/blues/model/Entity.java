package com.example.lanhuajian.blues.model;

import java.util.List;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public class Entity {


    /**
     * error : false
     * results : [{"_id":"5bbbd36d9d212203189ecd46","createdAt":"2018-10-08T22:00:13.979Z","desc":"回归初心：极简 Android 组件化方案 \u2014 AppJoint","publishedAt":"2019-03-08T07:06:58.689Z","source":"web","type":"Android","url":"https://juejin.im/post/5bb9c0d55188255c7566e1e2","used":true,"who":"潇湘剑雨"},{"_id":"5c80c0e59d212233d5c508cf","createdAt":"2019-03-07T06:57:41.57Z","desc":"小红书图片裁剪库","publishedAt":"2019-03-07T06:59:41.704Z","source":"web","type":"Android","url":"https://juejin.im/post/5c7ce036e51d4558d36061ec","used":true,"who":"fingdo"},{"_id":"5c7f68cc9d212233da370f4d","createdAt":"2019-03-07T03:39:41.8Z","desc":"StarrySky 集成了音频播放需要的所有功能","images":["http://img.gank.io/17129b78-de3c-4fa7-9321-8839d218a4db"],"publishedAt":"2019-03-07T03:39:56.475Z","source":"web","type":"Android","url":"https://github.com/lizixian18/StarrySky","used":true,"who":"fingdo"},{"_id":"5c7df3b79d212233da370f49","createdAt":"2019-03-06T01:21:11.636Z","desc":" 可配置自定义规则来格式化输入内容的输入框","images":["http://img.gank.io/5235c384-e75d-4761-be5a-0913e8b606f0"],"publishedAt":"2019-03-06T01:21:34.150Z","source":"web","type":"Android","url":"https://github.com/dkzwm/FormatEditText","used":true,"who":"fingdo"},{"_id":"5c77484d9d212233d5c508b8","createdAt":"2019-02-28T02:32:45.646Z","desc":"码云最有价值开源项目：后端接口和文档自动化，前端(客户端) 定制返回JSON的数据和结构！","images":["http://img.gank.io/4f37384f-745d-4422-8b13-b9cdbdf8e136"],"publishedAt":"2019-03-03T13:19:31.291Z","source":"web","type":"Android","url":"https://gitee.com/TommyLemon/APIJSON","used":true,"who":"潇湘剑雨"},{"_id":"5c63734f9d21225dd1275931","createdAt":"2019-02-13T01:30:55.629Z","desc":"Android组件化开发实践和案例分享","images":["http://img.gank.io/a0f2cb98-d8f5-40ed-9c2c-0c4cfb045eea"],"publishedAt":"2019-03-03T13:16:28.307Z","source":"web","type":"Android","url":"https://juejin.im/post/5c46e6fb6fb9a049a5713bcc","used":true,"who":"潇湘剑雨"},{"_id":"5c789ee19d212233d4b3da89","createdAt":"2019-03-01T02:54:25.522Z","desc":"Android消息总线的演进之路：用LiveDataBus替代RxBus、EventBus","images":["http://img.gank.io/48d7129b-ee08-4a5d-8eb8-bd626254eeae","http://img.gank.io/85c21024-8f3b-4899-91b6-95451a0f3b07"],"publishedAt":"2019-03-01T03:13:05.882Z","source":"web","type":"Android","url":"https://tech.meituan.com/2018/07/26/android-livedatabus.html","used":true,"who":"潇湘剑雨"},{"_id":"5c74b1eb9d21223945d4dde6","createdAt":"2019-02-26T06:23:16.419Z","desc":"Android组件化开发实践和案例分享案例","images":["http://img.gank.io/b440c48f-9b77-4974-9789-1a6b7e7fa2fa"],"publishedAt":"2019-02-26T06:24:05.977Z","source":"web","type":"Android","url":"https://github.com/yangchong211/LifeHelper","used":true,"who":"fingdo"},{"_id":"5c71169c9d212251b29ad46d","createdAt":"2019-02-23T09:47:08.688Z","desc":"WaveView优雅的水波纹动画实现","images":["http://img.gank.io/9335fc17-d0c4-44cc-ace7-bcf75497b425"],"publishedAt":"2019-02-25T01:27:07.146Z","source":"web","type":"Android","url":"https://github.com/jenly1314/WaveView","used":true,"who":"fingdo"},{"_id":"5c6a49b99d2122267ad2c503","createdAt":"2019-02-18T05:59:21.90Z","desc":"一个Android App快速开发框架。","images":["http://img.gank.io/d5a61f4f-5718-475c-92ac-2bac01b437d5"],"publishedAt":"2019-02-18T06:00:33.410Z","source":"chrome","type":"Android","url":"https://github.com/ddnosh/AndroidQuick","used":true,"who":"lijinshanmx"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5bbbd36d9d212203189ecd46
         * createdAt : 2018-10-08T22:00:13.979Z
         * desc : 回归初心：极简 Android 组件化方案 — AppJoint
         * publishedAt : 2019-03-08T07:06:58.689Z
         * source : web
         * type : Android
         * url : https://juejin.im/post/5bb9c0d55188255c7566e1e2
         * used : true
         * who : 潇湘剑雨
         * images : ["http://img.gank.io/17129b78-de3c-4fa7-9321-8839d218a4db"]
         */

        private String id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;
        private List<String> images;

        public String get_id() {
            return id;
        }

        public void set_id(String _id) {
            this.id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
