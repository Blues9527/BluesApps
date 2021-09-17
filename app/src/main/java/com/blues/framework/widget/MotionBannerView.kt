package com.blues.framework.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.constraintlayout.helper.widget.Carousel
import coil.load
import com.blues.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * File: com.blues.framework.widget.MotionBannerView
 * Description: 使用MotionLayout的 Carousel实现无限轮播图
 *
 * @author: lanhuajian
 * @time: 2021-09-17 15:41
 **/

class MotionBannerView(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    private var carousel: Carousel

    private var urls: List<String> = mutableListOf()

    init {
        val rootView = inflate(context, R.layout.layout_banner, this)

        carousel = rootView.findViewById(R.id.carousel)

        //设置Carousel adapter
        setCarouselAdapter()

        //开始无线循环
        startLoop()
    }

    private fun setCarouselAdapter() {
        carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return urls.size
            }

            override fun populate(view: View?, index: Int) {
                if (urls.isNotEmpty()) {
                    (view as? ImageView)?.load(urls[index]) {
                        placeholder(R.drawable.shape_place_holder)
                    }
                }
            }

            override fun onNewItem(index: Int) {
                //这里可以拿到中间image真正的下标，然后调用transitionToIndex进行轮播
                if (urls.isNotEmpty()) {
                    CoroutineScope(Dispatchers.Main).launch {
                        delay(2500)
                        carousel.transitionToIndex(index + 1, 2500)
                    }
                }
            }
        })
    }

    private fun startLoop() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(2500)
            //第二个参数表示动画执行的事件，并不是延迟多少秒执行
            carousel.transitionToIndex(1, 2500)
        }
    }

    fun setDataSource(urls: List<String> = mutableListOf()) {
        this.urls = urls
    }


}