package com.blues.gankio.v1.view

import com.blues.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import com.jude.easyrecyclerview.EasyRecyclerView
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.blues.gankio.v1.model.VideoInfoBean
import androidx.recyclerview.widget.RecyclerView
import com.blues.framework.base.BaseKoinFragment
import com.xiao.nicevideoplayer.NiceVideoPlayerManager
import com.blues.mock.VideoUrlConstant
import com.jude.easyrecyclerview.adapter.BaseViewHolder

class VideoFragment : BaseKoinFragment() {

    companion object {

        //当前recycler view 的item下标
        private var mCurrentPosition = 0
    }

    override fun getLayoutId(): Int = R.layout.fragment_video

    override fun initData(inflater: LayoutInflater, container: ViewGroup?, saveInstanced: Bundle?) {

        val revVideo: EasyRecyclerView = rootView.findViewById(R.id.ev_video)
        PagerSnapHelper().attachToRecyclerView(revVideo.recyclerView)
        revVideo.setLayoutManager(LinearLayoutManager(requireContext()))

        var mAdapter: RecyclerArrayAdapter<VideoInfoBean?>
        revVideo.adapter = object : RecyclerArrayAdapter<VideoInfoBean?>(requireContext()) {
            override fun OnCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
                return VideoHolder(parent)
            }
        }.also { mAdapter = it }

        revVideo.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager?
                if (layoutManager != null) {
                    val firstVisible = layoutManager.findFirstVisibleItemPosition()
                    if (firstVisible != mCurrentPosition) {
                        mCurrentPosition = firstVisible //停止当前视频的播放
                        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer()
                    }
                }
            }
        })
        mAdapter.addAll(VideoUrlConstant.getVideos())
        mAdapter.notifyDataSetChanged()
    }
}