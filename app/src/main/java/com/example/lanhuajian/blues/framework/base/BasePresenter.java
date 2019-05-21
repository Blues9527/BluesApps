package com.example.lanhuajian.blues.framework.base;

import rx.Subscription;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public interface BasePresenter {

    //订阅
    void subscribe(Subscription subscription);

    //取消订阅
    void unSubscribe();
}
