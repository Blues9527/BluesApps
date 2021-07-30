package com.blues.gankio.old.model_ios.view;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blues.R;
import com.blues.WebViewDialog;
import com.blues.gankio.old.model_ios.model.IOSEntity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

public class IOSViewHolder extends BaseViewHolder<IOSEntity.ResultsBean> {

    private ImageView ivAvatar;
    private TextView tvDesc, tvAuthor, tvSource, tvPTime;
    private EasyRecyclerView rvImages;
    private RelativeLayout rlRoot;

    public IOSViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_test);

        rvImages = $(R.id.rv_images);
        tvDesc = $(R.id.tv_desc);
        tvAuthor = $(R.id.tv_author);
        tvSource = $(R.id.tv_source);
        tvPTime = $(R.id.tv_publish_time);
        ivAvatar = $(R.id.iv_avatar);
        rlRoot = $(R.id.rl_root);
    }

    @Override
    public void setData(IOSEntity.ResultsBean data) {
        super.setData(data);


        tvDesc.setText(data.getDesc());
        tvAuthor.setText(String.format("作者：%s", data.getWho()));
        tvSource.setText(String.format("来自：%s", data.getSource()));
        tvPTime.setText(String.format("日期：%s", data.getPublishedAt().substring(0, data.getPublishedAt().indexOf("T"))));

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rvImages.setLayoutManager(layoutManager);
        rvImages.setAdapter(new IOSImagesAdapter(data.getImages()));
        rlRoot.setOnClickListener(v -> new WebViewDialog(getContext(), data.getUrl()).show());
    }
}
