package com.blues.kaiyan.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.blues.R;
import com.blues.kaiyan.list.model.OpenEyeEntity;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * User : Blues
 * Date : 2019/9/4
 * Time : 15:32
 */

public class OEDetailHeaderView extends RelativeLayout implements RecyclerArrayAdapter.ItemView {

    private TextView tvTitle, tvDesc;
    private TextView tvShare, tvReply, tvLike;
    private ImageView ivAvatar;
    private TextView tvAuthor, tvAuthorDesc;


    public OEDetailHeaderView(Context context) {
        this(context, null);
    }

    public OEDetailHeaderView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OEDetailHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context ctx) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.item_oe_detail_header, this);
        tvTitle = view.findViewById(R.id.tv_title);
        tvDesc = view.findViewById(R.id.tv_desc);
        tvShare = view.findViewById(R.id.tv_share);
        tvReply = view.findViewById(R.id.tv_reply);
        tvLike = view.findViewById(R.id.tv_like);
        ivAvatar = view.findViewById(R.id.iv_avatar);
        tvAuthor = view.findViewById(R.id.tv_author);
        tvAuthorDesc = view.findViewById(R.id.tv_author_desc);
    }

    public void initDefault(Context ctx, OpenEyeEntity.ItemListBean data) {

        tvTitle.setText(data.getData().getTitle());
        tvDesc.setText(data.getData().getDescription());
        tvShare.setText(String.valueOf(data.getData().getConsumption().getShareCount()));
        tvReply.setText(String.valueOf(data.getData().getConsumption().getReplyCount()));
        tvLike.setText(String.valueOf(data.getData().getConsumption().getCollectionCount()));
        Glide.with(ctx).load(data.getData().getAuthor().getIcon()).into(ivAvatar);
        tvAuthor.setText(data.getData().getAuthor().getName());
        tvAuthorDesc.setText(data.getData().getAuthor().getDescription());
    }

    @Override
    public View onCreateView(ViewGroup parent) {
        return this;
    }

    @Override
    public void onBindView(View headerView) {

    }
}
