package com.example.lanhuajian.blues.module_main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.lanhuajian.blues.framework.base.BaseFragment;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.mock.VideoUrlConstant;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:27
 */

public class MainPageFragment extends BaseFragment {

    private List<VideoInfoEntity> videos = new ArrayList<>();

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_mainpage;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        EasyRecyclerView mainErv = rootView.findViewById(R.id.ev_main);

        mainErv.setLayoutManager(new LinearLayoutManager(getmContext()));
        RecyclerArrayAdapter<VideoInfoEntity> mAdapter;
        mainErv.setAdapter(mAdapter = new RecyclerArrayAdapter<VideoInfoEntity>(getmContext()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new VideoHolder(parent);
            }
        });
        for (int i = 0; i < VideoUrlConstant.urls.length; i++) {
            videos.add(new VideoInfoEntity(VideoUrlConstant.urls[i], VideoUrlConstant.titles[i]));
        }
        mAdapter.addAll(videos);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {

    }
}
