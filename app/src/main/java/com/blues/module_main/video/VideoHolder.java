package com.blues.module_main.video;

import android.view.ViewGroup;

import com.blues.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

/**
 * User : Blues
 * Date : 2019/5/17
 * Time : 10:39
 */

public class VideoHolder extends BaseViewHolder<VideoInfoEntity> {

    private NiceVideoPlayer nvPlayer;

    public VideoHolder(ViewGroup parent) {
        super(parent, R.layout.item_video_mp);

        nvPlayer = $(R.id.nvp_video);
    }

    @Override
    public void setData(VideoInfoEntity data) {
        super.setData(data);
        nvPlayer.setPlayerType(NiceVideoPlayer.TYPE_NATIVE);
        nvPlayer.setBackgroundResource(R.drawable.shape_background);
        nvPlayer.setUp(data.getVideo_url(), null);

        TxVideoPlayerController controller = new TxVideoPlayerController(getContext());
        controller.setTitle(data.getVideo_title());
        controller.setImage(R.color.color_black);
        controller.setShouldShowLength(false);
        nvPlayer.setController(controller);

        //自动播放
//        nvPlayer.post(() -> {
//            if (nvPlayer != null) {
//                nvPlayer.continueFromLastPosition(false);
//                if (nvPlayer.isIdle()) {
//                    nvPlayer.start();
//                }
//            }
//        });
    }
}
