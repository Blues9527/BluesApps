package com.blues.module_study.model_video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.blues.R;
import com.blues.framework.base.BaseFragment;
import com.blues.mock.VideoUrlConstant;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import androidx.recyclerview.widget.LinearLayoutManager;

public class VideoFragment extends BaseFragment {

    private RecyclerArrayAdapter<VideoInfoEntity> mAdapter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_video;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EasyRecyclerView revVideo = rootView.findViewById(R.id.ev_video);
        revVideo.setLayoutManager(new LinearLayoutManager(getmContext()));
        revVideo.setAdapter(mAdapter = new RecyclerArrayAdapter<VideoInfoEntity>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new VideoHolder(parent);
            }
        });
        mAdapter.addAll(VideoUrlConstant.getVideos());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {

    }
}
