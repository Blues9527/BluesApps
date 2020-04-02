package com.blues.module_study.model_article;

import java.io.Serializable;
import java.util.List;

public class Article implements Serializable {

    private List<ArticleBean> article;

    public List<ArticleBean> getArticle() {
        return article;
    }

    public void setArticle(List<ArticleBean> article) {
        this.article = article;
    }

    public static class ArticleBean implements Serializable {
        /**
         * id : 1
         * title : Gradle配置技巧
         * url : http://note.youdao.com/noteshare?id=2eb23a0d21cb8ef133c29814e99eec1c
         */

        private int id;
        private String title;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "ArticleBean{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Article{" +
                "article=" + article +
                '}';
    }
}
