package com.blues.gankio.v1.view

import android.view.ViewGroup
import com.blues.gankio.v1.model.VideoInfoBean
import com.blues.R
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import com.xiao.nicevideoplayer.NiceVideoPlayer
import com.xiao.nicevideoplayer.TxVideoPlayerController

/**
 * User : Blues
 * Date : 2019/5/17
 * Time : 10:39
 */
class VideoHolder(parent: ViewGroup?) :
    BaseViewHolder<VideoInfoBean>(parent, R.layout.item_video_mp) {

    private val nvPlayer: NiceVideoPlayer = itemView.findViewById(R.id.nvp_video)

    override fun setData(data: VideoInfoBean) {
        super.setData(data)
        nvPlayer.apply {
            setPlayerType(NiceVideoPlayer.TYPE_NATIVE)
            setBackgroundResource(R.drawable.shape_background)
            setUp(data.video_url, null)
            setController(TxVideoPlayerController(context).apply {
                setTitle(data.video_title)
                setImage(R.color.color_black)
                setShouldShowLength(false)
            })
        }
    }
}