package com.blues.module_gank.old;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.blues.R;
import com.blues.module_gank.old.model_android.model.AndroidEntity;
import com.jude.easyrecyclerview.EasyRecyclerView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

/**
 * User : Blues
 * Date : 2019/4/17
 */

public class ShowImageActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_image);

        EasyRecyclerView rvImg = findViewById(R.id.rv_show_img);
        TextView textView = findViewById(R.id.tv_num);

        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        AndroidEntity.ResultsBean data = (AndroidEntity.ResultsBean) getIntent().getSerializableExtra("param");
        if (data != null) {
            SnapHelper snapHelper = new PagerSnapHelper();
            snapHelper.attachToRecyclerView(rvImg.getRecyclerView());
            ImagesAdapter adapter = new ImagesAdapter(data.getImages());
            textView.setText(String.format("1/%s", data.getImages().size()));
            rvImg.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            rvImg.setAdapter(adapter);

            rvImg.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
                    if (manager instanceof LinearLayoutManager) {
                        //第一个可见的位置
                        int firstPosition = ((LinearLayoutManager) manager).findFirstVisibleItemPosition();
                        textView.setText(String.format("%s/%s", firstPosition + 1, data.getImages().size()));

                    }
                }
            });
        }
    }
}
