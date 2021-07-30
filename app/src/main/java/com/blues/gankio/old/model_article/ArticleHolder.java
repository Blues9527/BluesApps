package com.blues.gankio.old.model_article;

import android.view.ViewGroup;
import android.widget.TextView;

import com.blues.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * User : Blues
 * Date : 2019/5/17
 * Time : 10:39
 */

public class ArticleHolder extends BaseViewHolder<Article.ArticleBean> {

    private TextView tvTitle;

    public ArticleHolder(ViewGroup parent) {
        super(parent, R.layout.item_article_mp);

        tvTitle = $(R.id.tv_title);
    }

    @Override
    public void setData(Article.ArticleBean data) {
        super.setData(data);

        tvTitle.setText(data.getTitle());

    }
}
