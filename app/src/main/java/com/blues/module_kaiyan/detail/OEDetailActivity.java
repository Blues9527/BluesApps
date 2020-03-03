package com.blues.module_kaiyan.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.transition.AutoTransition;
import android.transition.Explode;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.blues.R;
import com.blues.framework.base.BaseActivity;
import com.blues.module_kaiyan.OpenEyeEntity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
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
    private ImageView ivBack;
    private EasyRecyclerView ervRelated;

    private OEDetailRelatedContract.iOEDetailRelatedPresenter iPresenter;
    private OpenEyeEntity.ItemListBean itemListBean;
    private RecyclerArrayAdapter<OEDetailRelatedEntity.ItemListBean> mAdapter;
    private OEDetailHeaderView mHeader;

    @Override
    public int setLayoutResourceId() {
        return R.layout.item_oe_hotrank_detail;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        nvpVideo = findViewById(R.id.nvp_oe_detail);
        ivBack = findViewById(R.id.iv_back);
        ervRelated = findViewById(R.id.erv_related);

        mPresenter = new OEDetailPresenter(this);

        itemListBean = (OpenEyeEntity.ItemListBean) this.getIntent().getExtras().get("itemDetail");

        if (itemListBean != null) {
            initDefaultView(itemListBean);
            iPresenter.getRelatedVideos(String.valueOf(itemListBean.getData().getId()));
        }
    }

    private void initDefaultView(OpenEyeEntity.ItemListBean data) {
        //视频相关
        nvpVideo.setPlayerType(NiceVideoPlayer.TYPE_NATIVE);
        nvpVideo.setBackgroundResource(R.drawable.shape_background);
        nvpVideo.setUp(data.getData().getPlayUrl(), null);
        TxVideoPlayerController controller = new TxVideoPlayerController(mContext);
        controller.setTitle(null);
        controller.setLength((long) data.getData().getDuration() * 1000L);//这里将long类型时间长度转换成时分秒的单位是毫秒
        Glide.with(mContext).load(data.getData().getCover().getBlurred()).into(controller.imageView());
        nvpVideo.setController(controller);

        nvpVideo.post(() -> {
            if (nvpVideo != null) {
                nvpVideo.continueFromLastPosition(false);
                if (nvpVideo.isIdle()) {
                    nvpVideo.start();
                }
            }
        });

        DividerDecoration decoration = new DividerDecoration(R.color.color_white, 1);
        ervRelated.addItemDecoration(decoration);
        ervRelated.setLayoutManager(new LinearLayoutManager(mContext));
        ervRelated.setAdapter(mAdapter = new RecyclerArrayAdapter<OEDetailRelatedEntity.ItemListBean>(mContext) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new OEDetailRelatedViewHolder(parent);
            }
        });
        mAdapter.setNoMore(R.layout.view_load_no_more);

        mAdapter.addHeader(mHeader = new OEDetailHeaderView(mContext));
        mHeader.initDefault(mContext, data);
        mAdapter.notifyDataSetChanged();

        getWindow().setEnterTransition(new AutoTransition());
        getWindow().setExitTransition(new Explode());
    }

    @Override
    public void setListener() {
        ivBack.setOnClickListener(this);
    }

    @Override
    public void showRelatedVideos(List<OEDetailRelatedEntity.ItemListBean> openEyeRelatedList) {
        if (openEyeRelatedList != null) {
            mAdapter.addAll(openEyeRelatedList);
            mAdapter.notifyDataSetChanged();
        }
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
        if (itemListBean != null) {
            initDefaultView(itemListBean);
            iPresenter.getRelatedVideos(String.valueOf(itemListBean.getData().getId()));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                supportFinishAfterTransition();
                break;
        }
    }
}
