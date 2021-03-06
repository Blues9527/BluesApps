package com.blues.framework.widget.endlessbannerview.hintview;

import android.database.DataSetObserver;
import androidx.viewpager.widget.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.blues.framework.widget.endlessbannerview.BannerView;

import java.util.ArrayList;

/**
 * Created by Mr.Jude on 2016/1/9.
 */
public abstract class LoopPagerAdapter extends PagerAdapter {
    private BannerView mViewPager;

    private ArrayList<View> mViewList = new ArrayList<>();

    private class LoopHintViewDelegate implements BannerView.HintViewDelegate {
        @Override
        public void setCurrentPosition(int position, int duration, HintView hintView) {
            if (hintView != null)
                hintView.setCurrent(position % getRealCount(), duration);
        }

        @Override
        public void initView(int length, int gravity, int duration, HintView hintView) {
            if (hintView != null)
                hintView.initView(getRealCount(), gravity, duration);
        }
    }

    @Override
    public void notifyDataSetChanged() {
        mViewList.clear();
        mViewPager.getViewPager().setAdapter(this);
        initPosition(true);
        super.notifyDataSetChanged();
    }

    //一定要用这个回调,因为它只有第一次设置Adapter才会被回调。而除了这个时候去设置位置都是...ANR
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        super.registerDataSetObserver(observer);
        initPosition(false);
    }

    private void initPosition(boolean isFast) {
        if (getCount() <= 1) return;
        int half = isFast ? getRealCount() * 3 : Integer.MAX_VALUE / 2;
        int start = half - half % getRealCount();
        mViewPager.getViewPager().setCurrentItem(start, false);
    }

    public LoopPagerAdapter(BannerView viewPager) {
        this.mViewPager = viewPager;
        viewPager.setHintViewDelegate(new LoopHintViewDelegate());
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int realPosition = position % getRealCount();
        View itemView = findViewByPosition(container, realPosition);
        container.removeView(itemView);
        container.addView(itemView);
        return itemView;
    }


    private View findViewByPosition(ViewGroup container, int position) {
        for (View view : mViewList) {
            if (((int) view.getTag()) == position && view.getParent() == null) {
                return view;
            }
        }
        View view = getView(container, position);
        view.setTag(position);
        mViewList.add(view);
        return view;
    }

    public abstract View getView(ViewGroup container, int position);

    @Deprecated
    @Override
    public final int getCount() {
        return getRealCount() <= 1 ? getRealCount() : Integer.MAX_VALUE;
    }

    protected abstract int getRealCount();
}
