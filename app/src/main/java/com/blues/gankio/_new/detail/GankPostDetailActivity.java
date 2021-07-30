package com.blues.gankio._new.detail;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.blues.R;
import com.blues.framework.base.BaseActivity;
import com.blues.gankio._new.hot.GankHotEntity;
import com.blues.gankio._new.mvp.GankContract;
import com.blues.gankio._new.mvp.model.GankBannerEntity;
import com.blues.gankio._new.mvp.model.GankCategory;
import com.blues.gankio._new.mvp.model.GankUniversalEntity;
import com.blues.gankio._new.mvp.presenter.GankPresenter;
import com.blues.gankio._new.random.GankRandomEntity;
import com.blues.gankio._new.search.GankSearchResult;
import com.bumptech.glide.Glide;

import org.markdown4j.Markdown4jProcessor;

import java.io.IOException;
import java.util.List;

public class GankPostDetailActivity extends BaseActivity implements GankContract.iGankView {

    private GankContract.iGankPresenter iPresenter;
    private TextView tvTitle, tvAuthor, tvDate, tvTag, tvLikes, tvComments, tvViews, tvDesc, tvContents;
    private ImageView ivContent;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_gank_detail;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        mPresenter = new GankPresenter(this);

        String postId = getIntent().getStringExtra("postId");
        //初始化数据

        if (!TextUtils.isEmpty(postId)) {
            iPresenter.getGankPostDetail(postId);
        }

        tvTitle = findViewById(R.id.tv_title);
        tvAuthor = findViewById(R.id.tv_author);
        tvDate = findViewById(R.id.tv_date);
        tvTag = findViewById(R.id.tv_tag);
        tvLikes = findViewById(R.id.tv_likes);
        tvComments = findViewById(R.id.tv_comments);
        tvViews = findViewById(R.id.tv_views);
        tvDesc = findViewById(R.id.tv_desc);
        tvContents = findViewById(R.id.tv_content);
        ivContent = findViewById(R.id.iv_content);

    }

    @Override
    public void setBanner(List<GankBannerEntity.DataBean> banner) {

    }

    @Override
    public void setCategory(List<GankCategory.DataBean> category) {

    }

    @Override
    public void setPostList(List<GankUniversalEntity.DataBean> postList) {

    }

    @Override
    public void setRandomPostList(List<GankRandomEntity.DataBean> randomPostList) {

    }

    @Override
    public void setPostDetail(GankPostDetail.DataBean postDetail) {
        //TODO 在这里装载数据

        tvTitle.setText(postDetail.getTitle());
        tvAuthor.setText(postDetail.getAuthor());
        tvDate.setText(postDetail.getPublishedAt());
        tvTag.setText(String.format("#%s#", postDetail.getType()));
        tvLikes.setText(String.valueOf(postDetail.getLikeCounts()));
        tvComments.setText(String.valueOf(postDetail.getLikeCount()));
        tvViews.setText(String.valueOf(postDetail.getViews()));
        if (!TextUtils.isEmpty(postDetail.getContent())) {
            tvContents.setText(Html.fromHtml(postDetail.getContent()));
        } else {
            try {
                String html = new Markdown4jProcessor().process(postDetail.getMarkdown());
                tvContents.setText(Html.fromHtml(html));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Glide.with(mContext).load(postDetail.getImages().get(0)).into(ivContent);
    }

    @Override
    public void setPostHotList(List<GankHotEntity.DataBean> hotList) {

    }

    @Override
    public void setPostComments(GankPostComments comments) {

    }

    @Override
    public void setSearchContents(List<GankSearchResult.DataBean> searchContents) {

    }

    @Override
    public void setPresenter(GankContract.iGankPresenter presenter) {
        iPresenter = presenter;
    }
}
