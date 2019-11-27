package com.example.lanhuajian.blues.constant;

public class RequestUrl {


    //干货
    public static final String BASE_GANKIO_URL = "http://gank.io";

    //本地服务器
    public static final String BASE_LOCAL_URL = "http://192.168.33.93:8090/";

    //easy-mock
    public static final String BASE_MOCK_URL = "https://easy-mock.com/";

    //wan android
    public static final String BASE_WANANDROID_URL = "https://www.wanandroid.com/";

    public static final String BASE_NETEASE_URL = "https://m.study.163.com/";

    //微博内容url,containerid=102803 热门微博， 102803_ctg1_4388_-_ctg1_4388 搞笑微博 102803_ctg1_7978_-_ctg1_7978 新鲜事 102803_ctg1_1388_-_ctg1_1388 体育
    // https://m.weibo.cn/api/lbs/near?page=2 获取附近的人微博
    // https://m.weibo.cn/api/container/getIndex?containerid=102803&since_id=3
    public static final String BASE_WEIBO_URL = "https://m.weibo.cn/";

    public static class WeiboUrl {
        //热门微博
        public static final String HOT_WEIBO = "102803";

        //搞笑微博
        public static final String FUN_WEIBO = "102803_ctg1_4388_-_ctg1_4388";

        //新鲜事
        public static final String NEW_WEIBO = "102803_ctg1_7978_-_ctg1_7978";

        //体育
        public static final String PE_WEIBO = "102803_ctg1_1388_-_ctg1_1388";
    }

    //开眼
    public static final String BASE_KAIYAN_URL = "http://baobab.kaiyanapp.com/";

    public static class KaiYanType {

        //周排行
        public static final String WEEKLY = "weekly";

        //月排行
        public static final String MONTHLY = "monthly";

        //总排行
        public static final String HISTORICAL = "historical";
    }
}
