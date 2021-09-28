package com.blues.gankio.v2.model;

import java.io.Serializable;
import java.util.List;

public class GankioHotBean implements Serializable {


    /**
     * category : Article
     * data : [{"_id":"5e78b2f65d7c47fe610b0029","author":"扔物线","category":"Article","createdAt":"2020-03-23 20:59:40","desc":"我从去年开始使用 RxJava ，到现在一年多了。今年加入了 Flipboard 后，看到 Flipboard 的 Android 项目也在使用 RxJava ，并且使用的场景越来越多 。而最近这几个月，我也发现国内越来越多的人开始提及 RxJava 。有人说『RxJava 真是太好用了』，有人说『RxJava 真是太难用了』，另外更多的人表示：我真的百度了也谷歌了，但我还是想问： RxJava 到底是什么？","images":["http://gank.io/images/9a91a5f16f9749638c0ba6ab2e1a3127",""],"likeCounts":3,"publishedAt":"2015-10-02 12:59:40","stars":4,"title":"给 Android 开发者的 RxJava 详解","type":"Android","url":"https://www.baidu.com","views":5254},{"_id":"5e552d9befd6f28e2554f486","author":"李金山","category":"Article","createdAt":"2020-02-25 05:08:15","desc":"Android Studio 3.6 稳定版终于来了，此版本的 Android Studio 包括对一些设计工具的更新，包括布局编辑器和资源管理器。","images":["http://gank.io/images/3587b553fe10404abcce4dde1b28772c"],"likeCounts":2,"publishedAt":"2020-02-25 05:08:15","stars":4,"title":"Android Studio 3.6 发布啦，快来围观","type":"Android","url":"https://juejin.im/post/5e549ef5e51d4526fe650f3c","views":713},{"_id":"5e50eaf6a4f7880ef87b35f2","author":"李金山","category":"Article","createdAt":"2020-02-09 05:15:08","desc":"Android开发架构已经由由最最初的Activity架构（MVC），发展到到现在主流的MVP、MVVM架构了。社区也有不少优秀的实践。今天笔者想结合自己的经验谈一谈，一个合理的Android架构应该是怎么样的呢？","images":["http://gank.io/images/01b635252da7418c900b720f5a42f327"],"likeCounts":1,"publishedAt":"2020-02-09 05:15:08","stars":4,"title":"2020年关于Android开发架构，我们还能做些什么？","type":"Android","url":"https://juejin.im/post/5e3f92d46fb9a07ca80a9b64","views":385},{"_id":"5e552d00efd6f28e2554f482","author":"李金山","category":"Article","createdAt":"2019-12-04 07:23:10","desc":"11 月 23 日，字节跳动技术沙龙 | Flutter 技术专场 在北京后山艺术空间圆满结束。我们邀请到字节跳动移动平台部 Flutter 架构师袁辉辉，Google Flutter 团队工程师 Justin McCandless，字节跳动移动平台部 Flutter 资深工程师李梦云，阿里巴巴高级技术专家王树彬和大家进行分享交流。","images":["http://gank.io/images/f3c8eee737d84a3b8e17b517a13ee4b7"],"likeCounts":1,"publishedAt":"2019-12-04 07:23:10","stars":1,"title":"跨平台技术趋势及字节跳动 Flutter 架构实践 | Flutter 沙龙回顾","type":"Flutter","url":"https://juejin.im/post/5de75c6b518825127c26f0e7","views":89},{"_id":"5e7990d81e12e48ff711862e","author":"李金山","category":"Article","createdAt":"2020-03-24 12:46:30","desc":"上回就已经承诺过大家，一定会出 HTTP 的系列文章，今天终于整理完成了。作为一个 web 开发，HTTP 几乎是天天要打交道的东西，但我发现大部分人对 HTTP 只是浅尝辄止，对更多的细节及原理就了解不深了，在面试的时候感觉非常吃力。这篇文章就是为了帮助大家树立完整的 HTTP 知识体系，并达到一定的深度，从容地应对各种灵魂之问，也同时提升自己作为一个 web 开发的专业素养吧","images":["http://gank.io/images/48c898d46629447d8cfbf690100f2d2d"],"likeCounts":1,"publishedAt":"2020-03-24 12:46:30","stars":5,"title":"（建议精读）HTTP灵魂之问，巩固你的 HTTP 知识体系","type":"frontend","url":"https://juejin.im/post/5e76bd516fb9a07cce750746","views":333},{"_id":"5e7b5a8b6d2e518fdeab27aa","author":"李金山","category":"Article","createdAt":"2020-03-25 21:19:19","desc":"图床就是一个在网络上存储图片的地方，目的是为了节省本地服务器空间，主要是个人博客和网站使用，为了小伙伴们玩耍，这里收集了一些国内访问相对比较稳定的图床。","images":["http://gank.io/images/fee6bd9dcd8141559c3e01c3f4b2a9d9"],"likeCounts":1,"publishedAt":"2020-03-25 21:19:19","stars":5,"title":"盘点国内那些免费好用的图床","type":"promote","url":"https://gank.io/post/5e7b5a8b6d2e518fdeab27aa","views":872},{"_id":"5e50e9a22963efebabd4b612","author":"李金山","category":"Article","createdAt":"2020-02-20 01:39:38","desc":"Handler 机制算是 Android 基本功，面试常客。但现在面试，多数已经不会直接让你讲讲 Handler 的机制，Looper 是如何循环的，MessageQueue 是如何管理 Message 等，而是基于场景去提问，看看你对 Handler 机制的掌握是否扎实。","images":["http://gank.io/images/15a617ce0a8a478b99b5c00e7929c13d"],"likeCounts":0,"publishedAt":"2020-02-20 01:39:38","stars":4,"title":"面试官：\u201c看你简历上写熟悉 Handler 机制，那聊聊 IdleHandler 吧？\u201d","type":"Android","url":"https://juejin.im/post/5e4de2f2f265da572d12b78f","views":461},{"_id":"5e50efd4db06ad63bff07de4","author":"李金山","category":"Article","createdAt":"2020-02-19 09:33:42","desc":"刚毕业开始还是一名普通的 iOS 工程师，做的东西一般是跟着 TL 开会讨论需求，完了自己脑补技术细节，完了编码、UI 还原、测试、发布、维护。在第一家公司做开发的时候，某次和一个后端工程师对接口遇到问题，人家说\u201c别跟我说接口有问题。你跟我说是什么样的问题？我需要参数\u201d。","images":["http://gank.io/images/0e01cb9f73d04f88931f0f6a0fee78e6"],"likeCounts":0,"publishedAt":"2020-02-19 09:33:42","stars":5,"title":"1995年的资深工程师，和你谈谈如何进阶","type":"iOS","url":"https://juejin.im/post/5e4d009e6fb9a07cd74f4f4c","views":160},{"_id":"5e50f29cccad97da1aa9f6e8","author":"李金山","category":"Article","createdAt":"2020-02-20 05:33:56","desc":"随着vue/react这类以数据驱动为主的web框架的不断完善和壮大，越来越多的前端团队开始着手搭建内部的组件库。虽然目前市面上已经有很多功能强大且完善的组件库供我们使用，比如基于react的开源组件库ant-design，material，又比如基于vue的开源组件库elementUI，iView等。","images":["http://gank.io/images/bdd0135160544b469181327868385f63"],"likeCounts":0,"publishedAt":"2020-02-20 05:33:56","stars":4,"title":"从0到1教你搭建前端团队的组件系统（高级进阶必备）","type":"frontend","url":"https://juejin.im/post/5e4d3a8de51d45270a709954","views":94},{"_id":"5e514692059c0fe5d9b27204","author":"李金山","category":"Article","createdAt":"2020-02-20 07:02:40","desc":"Android 通过 5G、折叠屏、内置机器学习等新技术，照亮了移动设备的未来。而在这背后，我们也越来越清楚地看到，一个强大的开发者社区有多么重要。这个社区为我们提供及时、全面的反馈，帮助我们打造出强大的平台，从而让开发者们的应用和游戏得以吸引全球数十亿用户。","images":["http://gank.io/images/9e6add5e6f8644e5b2f5f1ad669db6c8"],"likeCounts":0,"publishedAt":"2020-02-20 07:02:40","stars":1,"title":"更上一层楼: Android 11 首个开发者预览版到来","type":"Android","url":"https://juejin.im/post/5e4e1f0ef265da575a6a07d4","views":182}]
     * hot : likes
     * status : 100
     */

    private String category;
    private String hot;
    private int status;
    private List<DataBean> data;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * _id : 5e78b2f65d7c47fe610b0029
         * author : 扔物线
         * category : Article
         * createdAt : 2020-03-23 20:59:40
         * desc : 我从去年开始使用 RxJava ，到现在一年多了。今年加入了 Flipboard 后，看到 Flipboard 的 Android 项目也在使用 RxJava ，并且使用的场景越来越多 。而最近这几个月，我也发现国内越来越多的人开始提及 RxJava 。有人说『RxJava 真是太好用了』，有人说『RxJava 真是太难用了』，另外更多的人表示：我真的百度了也谷歌了，但我还是想问： RxJava 到底是什么？
         * images : ["http://gank.io/images/9a91a5f16f9749638c0ba6ab2e1a3127",""]
         * likeCounts : 3
         * publishedAt : 2015-10-02 12:59:40
         * stars : 4
         * title : 给 Android 开发者的 RxJava 详解
         * type : Android
         * url : https://www.baidu.com
         * views : 5254
         */

        private String _id;
        private String author;
        private String category;
        private String createdAt;
        private String desc;
        private int likeCounts;
        private String publishedAt;
        private int stars;
        private String title;
        private String type;
        private String url;
        private int views;
        private List<String> images;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
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

        public int getLikeCounts() {
            return likeCounts;
        }

        public void setLikeCounts(int likeCounts) {
            this.likeCounts = likeCounts;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public int getStars() {
            return stars;
        }

        public void setStars(int stars) {
            this.stars = stars;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public int getViews() {
            return views;
        }

        public void setViews(int views) {
            this.views = views;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "_id='" + _id + '\'' +
                    ", author='" + author + '\'' +
                    ", category='" + category + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", desc='" + desc + '\'' +
                    ", likeCounts=" + likeCounts +
                    ", publishedAt='" + publishedAt + '\'' +
                    ", stars=" + stars +
                    ", title='" + title + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", views=" + views +
                    ", images=" + images +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "GankHotEntity{" +
                "category='" + category + '\'' +
                ", hot='" + hot + '\'' +
                ", status=" + status +
                ", data=" + data +
                '}';
    }
}
