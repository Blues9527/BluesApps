package com.blues.gankio.v2.model;

import java.io.Serializable;
import java.util.List;

public class GankioRandomBean implements Serializable {


    /**
     * counts : 10
     * data : [{"_id":"5e72267a907078dcbfe95b96","author":"有时放纵","category":"GanHuo","createdAt":"2015-12-17 03:12:28","desc":"一个textView的动画","images":[],"likeCounts":0,"publishedAt":"2015-12-17 03:57:36","stars":1,"title":"AnimTextView","type":"Android","url":"https://github.com/z56402344/AnimTextView","views":2},{"_id":"5e7225dd907078dcbfe956c8","author":"代码家","category":"GanHuo","createdAt":"2017-07-11 13:38:46","desc":"Android 信用卡交易效果 UI 。","images":[],"likeCounts":0,"publishedAt":"2017-07-11 13:46:33","stars":1,"title":"Luhn","type":"Android","url":"https://github.com/KingsMentor/Luhn","views":2},{"_id":"5e722681907078dcbfe95bd1","author":"Ailurus","category":"GanHuo","createdAt":"2015-11-20 02:52:08","desc":"GitHub Android SDK .","images":[],"likeCounts":0,"publishedAt":"2015-11-20 03:54:49","stars":1,"title":"GithubAndroidSdk","type":"Android","url":"https://github.com/gitskarios/GithubAndroidSdk","views":2},{"_id":"5e722691907078dcbfe95c4f","author":"Jason","category":"GanHuo","createdAt":"2015-10-07 13:06:17","desc":"组图互动模式与动画效果","images":[],"likeCounts":0,"publishedAt":"2015-10-08 04:29:48","stars":1,"title":"beauty-treatment-android-animations","type":"Android","url":"https://github.com/JlUgia/beauty-treatment-android-animations","views":2},{"_id":"5e72262f907078dcbfe95953","author":"郑州","category":"GanHuo","createdAt":"2016-07-28 00:46:32","desc":"Android平台的原生Markdown解析器，将源文本直接解析为Spanned，高效、轻量","images":[],"likeCounts":0,"publishedAt":"2016-07-28 18:17:20","stars":1,"title":"Markdown","type":"Android","url":"https://github.com/zzhoujay/Markdown","views":2},{"_id":"5e722650907078dcbfe95a4b","author":"gzsll","category":"GanHuo","createdAt":"2016-05-06 11:22:33","desc":"https://github.com/marcuswestin/WebViewJavascriptBridge Objective-C与JavaScript交互在Android端的扩展","images":[],"likeCounts":0,"publishedAt":"2016-05-06 12:04:47","stars":1,"title":"WebViewJavascriptBridge","type":"Android","url":"https://github.com/gzsll/WebViewJavascriptBridge","views":2},{"_id":"5e722603907078dcbfe957f0","author":"github","category":"GanHuo","createdAt":"2016-12-30 08:43:12","desc":"类似手机QQ界面右上角的弹出菜单，使用 recyclerview 和 popupwindow 封装了一下。","images":[],"likeCounts":0,"publishedAt":"2016-12-30 16:16:11","stars":1,"title":"TopRightMenu","type":"Android","url":"https://github.com/zaaach/TopRightMenu","views":2},{"_id":"5e7225fb907078dcbfe957b1","author":"KuTear","category":"GanHuo","createdAt":"2017-02-14 11:30:01","desc":"接手老项目，难免遇到前辈的硬编码,怎么办？利用工具剔除出来啊","images":[],"likeCounts":0,"publishedAt":"2017-02-14 11:42:37","stars":1,"title":"Fuck-Hard-Code","type":"Android","url":"https://github.com/Kutear/Fuck-Hard-Code","views":2},{"_id":"5e72263c907078dcbfe959af","author":"dreamxuwj","category":"GanHuo","createdAt":"2016-06-22 10:29:07","desc":"可读取pdf文件的view","images":[],"likeCounts":0,"publishedAt":"2016-06-22 11:57:27","stars":1,"title":"AndroidPdfViewer","type":"Android","url":"https://github.com/barteksc/AndroidPdfViewer","views":2},{"_id":"5e7225cf907078dcbfe9565b","author":"drakeet","category":"GanHuo","createdAt":"2017-12-11 19:21:28","desc":"safe adb：在多设备时更方便地操作 adb，支持批量操作。","images":[],"likeCounts":0,"publishedAt":"2017-12-15 08:59:11","stars":1,"title":"sadb","type":"Android","url":"https://github.com/linroid/sadb","views":2}]
     * status : 100
     */

    private int counts;
    private int status;
    private List<DataBean> data;

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
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

        public List<?> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
