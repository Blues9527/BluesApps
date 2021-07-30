package com.blues.gankio.old.model_video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.blues.R;
import com.blues.framework.base.BaseFragment;
import com.blues.mock.VideoUrlConstant;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class VideoFragment extends BaseFragment {

    //当前recycler view 的item下标
    private static int mCurrentPosition = 0;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_video;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EasyRecyclerView revVideo = rootView.findViewById(R.id.ev_video);
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(revVideo.getRecyclerView());
        revVideo.setLayoutManager(new LinearLayoutManager(getmContext()));
        RecyclerArrayAdapter<VideoInfoEntity> mAdapter;
        revVideo.setAdapter(mAdapter = new RecyclerArrayAdapter<VideoInfoEntity>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new VideoHolder(parent);
            }
        });
        revVideo.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (layoutManager != null) {
                    int firstVisible = layoutManager.findFirstVisibleItemPosition();
                    if (firstVisible != mCurrentPosition) {
                        mCurrentPosition = firstVisible;
                        //停止当前视频的播放
                        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
                    }
                }
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
