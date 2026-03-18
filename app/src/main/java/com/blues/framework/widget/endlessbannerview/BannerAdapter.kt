package com.blues.framework.widget.endlessbannerview

import android.content.Context
import com.blues.framework.widget.endlessbannerview.hintview.LoopPagerAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import coil.load
import com.blues.R

/**
 * User : Blues
 * Date : 2019/7/9
 * Time : 15:00
 */
class BannerAdapter(private val mContext: Context, private val mBannerUrls: MutableList<String>,
    private val mBannerView: BannerView) : LoopPagerAdapter(mBannerView) {

    private var mListener: ItemClickListener? = null
    override fun notifyDataSetChanged() {
        mBannerUrls.clear()
        mBannerView.viewPager?.adapter = this
        initPosition()
        super.notifyDataSetChanged()
    }

    private fun initPosition() {
        if (count <= 1) return
        val half = Int.MAX_VALUE / 2
        val start = half - half / mBannerUrls.size
        mBannerView.viewPager?.setCurrentItem(start, false)
    }

    override fun getRealCount(): Int {
        return mBannerUrls.size
    }

    override fun getView(container: ViewGroup, position: Int): View {
        val realPosition = position % mBannerUrls.size
        val itemView = LayoutInflater.from(mContext).inflate(R.layout.item_banner, container, false)
        val iv = itemView.findViewById<ImageView>(R.id.iv_banner)

        iv.load(mBannerUrls[realPosition]) {
            placeholder(R.mipmap.ic_img_error)
        }

        iv.setOnClickListener {
            if (mListener != null) {
                mListener!!.onClick(realPosition)
            }
        }
        container.addView(itemView)
        return itemView
    }

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        mListener = itemClickListener
    }

    interface ItemClickListener {

        fun onClick(realPosition: Int)
    }
}