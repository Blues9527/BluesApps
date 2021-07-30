package com.blues.gankio.old.model_video;

import java.io.Serializable;

/**
 * User : Blues
 * Date : 2019/5/17
 * Time : 10:10
 */

public class VideoInfoEntity implements Serializable {
    private String video_url;
    private String video_title;

    public VideoInfoEntity(String video_url, String video_title) {
        this.video_url = video_url;
        this.video_title = video_title;
    }

    public String getVideo_url() {
        return video_url;
    }

    public VideoInfoEntity setVideo_url(String video_url) {
        this.video_url = video_url;
        return this;
    }

    public String getVideo_title() {
        return video_title;
    }

    public VideoInfoEntity setVideo_title(String video_title) {
        this.video_title = video_title;
        return this;
    }
}
