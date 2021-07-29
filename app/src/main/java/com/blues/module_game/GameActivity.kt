package com.blues.module_game;

import android.os.Bundle;
import android.view.ViewGroup;

import com.blues.R;
import com.blues.framework.base.BaseActivity;
import com.blues.framework.utils.FileUtil;
import com.google.gson.Gson;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class GameActivity extends BaseActivity {

    private EasyRecyclerView ervGame;
    private RecyclerArrayAdapter<QuestionEntity.QuestionsBean> mAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_game;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        ervGame = findViewById(R.id.erv_game);

        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(ervGame.getRecyclerView());
        //禁止recyclerview 滑动
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, RecyclerView.HORIZONTAL, false) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        ervGame.setLayoutManager(layoutManager);
        ervGame.setAdapter(mAdapter = new RecyclerArrayAdapter<QuestionEntity.QuestionsBean>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new QuestionViewHolder(parent);
            }
        });

        String gameJson = FileUtil.getAssetsFile(mContext, "game.json");
        Gson gson = new Gson();
        QuestionEntity questionEntity = gson.fromJson(gameJson, QuestionEntity.class);
        mAdapter.addAll(questionEntity.getQuestions());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setListener() {

    }
}
