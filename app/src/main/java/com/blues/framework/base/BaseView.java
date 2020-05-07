package com.blues.framework.base;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public interface BaseView<P extends BasePresenter> {

    //设置presenter
    void setPresenter(P presenter);

    //发送请求
    default void showBegin() {
    }

    //加载进度条
    default void showLoading() {
    }

    //加载数据
    default void showFinished() {
    }

    //加载错误
    default void showError() {
    }

    //空数据
    default void showEmpty() {
    }
}
