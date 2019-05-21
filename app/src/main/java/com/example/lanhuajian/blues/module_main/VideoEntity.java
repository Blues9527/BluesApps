package com.example.lanhuajian.blues.module_main;

import java.io.Serializable;
import java.util.List;

/**
 * User : Blues
 * Date : 2019/5/17
 * Time : 10:10
 */

public class VideoEntity implements Serializable {

    /**
     * msg : 获取成功
     * code : 200
     * data : [{"video_title":"8岁拳击小魔女!一拳打到哥哥脑震荡","video_url":"https://www.pearvideo.com/video_1554457","cover_url":"https://image2.pearvideo.com/cont/20190515/cont-1554457-11961164.png","video_time":"02:15","video_author":"看球"},{"video_title":"机关干部与交警起争执，被当场按倒","video_url":"https://www.pearvideo.com/video_1554475","cover_url":"https://image1.pearvideo.com/cont/20190515/cont-1554475-11961190.png","video_time":"00:34","video_author":"梨河北"},{"video_title":"男子疑似猥亵女孩,乘客拍视频呵止","video_url":"https://www.pearvideo.com/video_1554572","cover_url":"https://image2.pearvideo.com/cont/20190515/cont-1554572-11961458.png","video_time":"01:34","video_author":"梨广东"},{"video_title":"学生曝实习宿舍脏乱，多人患荨麻疹","video_url":"https://www.pearvideo.com/video_1554888","cover_url":"https://image.pearvideo.com/cont/20190515/cont-1554888-11962461.png","video_time":"01:25","video_author":"梨落西安"},{"video_title":"雪豹被救一年后放回天山：凶悍依旧","video_url":"https://www.pearvideo.com/video_1554761","cover_url":"https://image2.pearvideo.com/cont/20190515/cont-1554761-11962049.jpeg","video_time":"01:42","video_author":"拜城县融媒体中心"},{"video_title":"2年就赚1040万！这便宜能让你赚？","video_url":"https://www.pearvideo.com/video_1555068","cover_url":"https://image1.pearvideo.com/cont/20190516/cont-1555068-11962978.png","video_time":"01:15","video_author":"梨重庆"},{"video_title":"外卖哥曝扶车被当肇事者,遭2人踢打","video_url":"https://www.pearvideo.com/video_1554667","cover_url":"https://image2.pearvideo.com/cont/20190515/cont-1554667-11961713.png","video_time":"02:26","video_author":"岁月"},{"video_title":"老头与女孩发生关系被打，警方通报","video_url":"https://www.pearvideo.com/video_1553529","cover_url":"https://image.pearvideo.com/cont/20190512/cont-1553529-11958195.png","video_time":"00:36","video_author":"梨广西"},{"video_title":"留美学员自杀：\"航校只赔偿不道歉\"","video_url":"https://www.pearvideo.com/video_1555174","cover_url":"https://image1.pearvideo.com/cont/20190516/cont-1555174-11963332.png","video_time":"03:24","video_author":"元气少年Easea"},{"video_title":"最文气公厕！进门有沙发满墙文物画","video_url":"https://www.pearvideo.com/video_1555136","cover_url":"https://image2.pearvideo.com/cont/20190516/cont-1555136-11963300.png","video_time":"00:53","video_author":"小新在云端"},{"video_title":"一键自动驾驶！5G无人驾驶汽车来袭","video_url":"https://www.pearvideo.com/video_1555157","cover_url":"https://image.pearvideo.com/cont/20190516/cont-1555157-11963241.jpg","video_time":"02:02","video_author":"梨天津"},{"video_title":"终身不退休!日本拟延迟退休至70岁","video_url":"https://www.pearvideo.com/video_1555132","cover_url":"https://image1.pearvideo.com/cont/20190516/cont-1555132-11963179.jpg","video_time":"00:59","video_author":"公司联播"}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * video_title : 8岁拳击小魔女!一拳打到哥哥脑震荡
         * video_url : https://www.pearvideo.com/video_1554457
         * cover_url : https://image2.pearvideo.com/cont/20190515/cont-1554457-11961164.png
         * video_time : 02:15
         * video_author : 看球
         */

        private String video_title;
        private String video_url;
        private String cover_url;
        private String video_time;
        private String video_author;

        public String getVideo_title() {
            return video_title;
        }

        public void setVideo_title(String video_title) {
            this.video_title = video_title;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public String getCover_url() {
            return cover_url;
        }

        public void setCover_url(String cover_url) {
            this.cover_url = cover_url;
        }

        public String getVideo_time() {
            return video_time;
        }

        public void setVideo_time(String video_time) {
            this.video_time = video_time;
        }

        public String getVideo_author() {
            return video_author;
        }

        public void setVideo_author(String video_author) {
            this.video_author = video_author;
        }
    }
}
