package com.blues.module_gank.old.model_article;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.blues.R;
import com.blues.WebViewDialog;
import com.blues.framework.base.BaseFragment;
import com.blues.framework.utils.FileUtil;
import com.google.gson.Gson;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import androidx.recyclerview.widget.LinearLayoutManager;

public class ArticleFragment extends BaseFragment {

    private RecyclerArrayAdapter<Article.ArticleBean> mAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_article;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EasyRecyclerView revVideo = rootView.findViewById(R.id.ev_article);
        revVideo.setLayoutManager(new LinearLayoutManager(getmContext()));
        revVideo.setAdapter(mAdapter = new RecyclerArrayAdapter<Article.ArticleBean>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new ArticleHolder(parent);
            }
        });
        String io = FileUtil.getAssetsFile(getmContext(), "article.json");
        Article article = new Gson().fromJson(io, Article.class);
        Log.i("Blues", article.toString());
        mAdapter.addAll(article.getArticle());
        mAdapter.notifyDataSetChanged();

        mAdapter.setOnItemClickListener(position -> new WebViewDialog(getmContext(), article.getArticle().get(position).getUrl()).show());
    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {

    }
}
