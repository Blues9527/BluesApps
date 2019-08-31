package com.example.lanhuajian.blues.module_kaiyan.detail;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.framework.base.BaseActivity;
import com.example.lanhuajian.blues.module_kaiyan.OpenEyeEntity;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import java.util.List;

/**
 * User : Blues
 * Date : 2019/8/29
 * Time : 14:23
 */

public class OEDetailActivity extends BaseActivity implements OEDetailRelatedContract.iOEDetailRelatedView, View.OnClickListener {

    private NiceVideoPlayer nvpVideo;
    private TextView tvTitle, tvDesc;
    private ImageView ivBack;

    private TextView tvShare, tvReply, tvLike;
    private ImageView ivAvatar;
    private TextView tvAuthor, tvAuthorDesc;

    private OEDetailRelatedContract.iOEDetailRelatedPresenter iPresenter;
    private OpenEyeEntity.ItemListBean itemListBean;

    @Override
    public int setLayoutResourceId() {
        return R.layout.item_oe_hotrank_detail;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        nvpVideo = findViewById(R.id.nvp_oe_detail);
        tvTitle = findViewById(R.id.tv_title);
        tvDesc = findViewById(R.id.tv_desc);
        tvShare = findViewById(R.id.tv_share);
        tvReply = findViewById(R.id.tv_reply);
        tvLike = findViewById(R.id.tv_like);
        ivAvatar = findViewById(R.id.iv_avatar);
        tvAuthor = findViewById(R.id.tv_author);
        tvAuthorDesc = findViewById(R.id.tv_author_desc);
        ivBack = findViewById(R.id.iv_back);

        mPresenter = new OEDetailPresenter(this);

        itemListBean = (OpenEyeEntity.ItemListBean) this.getIntent().getExtras().get("itemDetail");

        if (itemListBean != null) {
            initDefaultView(itemListBean);
        }
    }

    private void initDefaultView(OpenEyeEntity.ItemListBean data) {
        //视频相关
        nvpVideo.setPlayerType(NiceVideoPlayer.TYPE_NATIVE);
        nvpVideo.setBackgroundResource(R.drawable.shape_background);
        nvpVideo.setUp(data.getData().getPlayUrl(), null);
        TxVideoPlayerController controller = new TxVideoPlayerController(mContext);
        controller.setTitle(null);
        Glide.with(mContext).load(data.getData().getCover().getBlurred()).into(controller.imageView());
        nvpVideo.setController(controller);

        tvTitle.setText(data.getData().getTitle());
        tvDesc.setText(data.getData().getDescription());
        tvShare.setText(String.valueOf(data.getData().getConsumption().getShareCount()));
        tvReply.setText(String.valueOf(data.getData().getConsumption().getReplyCount()));
        tvLike.setText(String.valueOf(data.getData().getConsumption().getCollectionCount()));

        Glide.with(mContext).load(data.getData().getAuthor().getIcon()).into(ivAvatar);
        tvAuthor.setText(data.getData().getAuthor().getName());
        tvAuthorDesc.setText(data.getData().getAuthor().getDescription());

    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
    }

    @Override
    public void showRelatedVideos(List<OEDetailRelatedEntity.ItemListBean> openEyeRelatedList) {

    }

    @Override
    public void setPresenter(OEDetailRelatedContract.iOEDetailRelatedPresenter presenter) {
        iPresenter = presenter;
    }

    @Override
    public void showBegin() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showFinished() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        itemListBean = (OpenEyeEntity.ItemListBean) intent.getExtras().get("itemDetail");
        if (itemListBean != null)
            initDefaultView(itemListBean);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
        }
    }
}
