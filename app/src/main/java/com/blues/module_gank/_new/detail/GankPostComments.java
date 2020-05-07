package com.blues.module_gank._new.detail;

import java.io.Serializable;
import java.util.List;

public class GankPostComments implements Serializable {


    /**
     * data : ["{\"_id\": \"5ea10e8517bf93950887f228\", \"userId\": \"594dd254421aa90c9203d2de\", \"postId\": \"5e78b2f65d7c47fe610b0029\", \"userName\": \"OuyangPeng\", \"comment\": \"\\u56db\\u5e74\\u524d\\u5c31\\u662f\\u770b\\u6254\\u7269\\u7ebf\\u7684\\u8fd9\\u7bc7RxJava\\u7684\\u6587\\u7ae0\\u5165\\u95e8rxjava\\u7684\\u3002\\r\\n\\u7136\\u540e\\u9879\\u76ee\\u73b0\\u5728\\u8fd8\\u662f\\u5728\\u7528RxJava 1.3 , \\u540e\\u7eed\\u7684RxJava 2.0\\u8fd8\\u6ca1\\u719f\\u6089\\uff0cRxJava 3.0\\u53c8\\u6765\\u4e86\\uff0c\\u7136\\u800c\\u4e00\\u76f4\\u6ca1\\u6709\\u5347\\u7ea7\\u3002\\u5c34\\u5c2c\\uff01\", \"headUrl\": \"https://ae01.alicdn.com/kf/Ucffc39ec8ce7479cae1888cd0fe29daca.jpg\", \"ups\": 0, \"createdAt\": \"2020-04-23 11:41:57\", \"secondParentId\": \"5ea10e8517bf93950887f227\", \"secondParentName\": null}"]
     * status : 100
     */

    private int status;
    private List<String> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
