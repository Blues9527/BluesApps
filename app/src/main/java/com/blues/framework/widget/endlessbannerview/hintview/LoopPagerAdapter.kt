package com.blues.framework.widget.endlessbannerview.hintview

import com.blues.framework.widget.endlessbannerview.BannerView
import androidx.viewpager.widget.PagerAdapter
import java.util.ArrayList
import com.blues.framework.widget.endlessbannerview.BannerView.HintViewDelegate
import android.database.DataSetObserver
import android.view.View
import android.view.ViewGroup

/**
 * Created by Mr.Jude on 2016/1/9.
 */
abstract class LoopPagerAdapter(private val mViewPager: BannerView) : PagerAdapter() {

    init {
        mViewPager.setHintViewDelegate(LoopHintViewDelegate())
    }

    private val mViewList = ArrayList<View>()

    private inner class LoopHintViewDelegate : HintViewDelegate {

        override fun setCurrentPosition(position: Int, duration: Int, hintView: HintView?) {
            hintView?.setCurrent(position % getRealCount(), duration)
        }

        override fun initView(length: Int, gravity: Int, duration: Int, hintView: HintView?) {
            hintView?.initView(getRealCount(), gravity, duration)
        }
    }

    override fun notifyDataSetChanged() {
        mViewList.clear()
        mViewPager.viewPager?.adapter = this
        initPosition(true)
        super.notifyDataSetChanged()
    }

    //一定要用这个回调,因为它只有第一次设置Adapter才会被回调。而除了这个时候去设置位置都是...ANR
    override fun registerDataSetObserver(observer: DataSetObserver) {
        super.registerDataSetObserver(observer)
        initPosition(false)
    }

    private fun initPosition(isFast: Boolean) {
        if (count <= 1) return
        val half = if (isFast) getRealCount() * 3 else Int.MAX_VALUE / 2
        val start = half - half % getRealCount()
        mViewPager.viewPager?.setCurrentItem(start, false)
    }

    override fun isViewFromObject(arg0: View, arg1: Any): Boolean {
        return arg0 === arg1
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val realPosition = position % getRealCount()
        val itemView = findViewByPosition(container, realPosition)
        container.removeView(itemView)
        container.addView(itemView)
        return itemView
    }

    private fun findViewByPosition(container: ViewGroup, position: Int): View {
        for (view in mViewList) {
            if (view.tag as Int == position && view.parent == null) {
                return view
            }
        }
        val view = getView(container, position)
        view.tag = position
        mViewList.add(view)
        return view
    }

    abstract fun getView(container: ViewGroup, position: Int): View

    override fun getCount(): Int {
        return if (getRealCount() <= 1) getRealCount() else Int.MAX_VALUE
    }

    protected abstract fun  getRealCount(): Int

}