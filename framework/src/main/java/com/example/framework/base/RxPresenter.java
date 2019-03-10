package com.example.framework.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * User : Blues
 * Date : 2019/3/5
 * Email : huajianlan@rastar.com
 */

public class RxPresenter<V extends BaseView> implements BasePresenter {

    private CompositeSubscription mCompositeSubscription;
    public V mView;

    public RxPresenter(V mView) {
        this.mView = mView;
        if (mView != null) {
            mView.setPresenter(this);
        }
    }

    @Override
    public void subscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void unSubscribe() {
        mView = null;
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }
}
