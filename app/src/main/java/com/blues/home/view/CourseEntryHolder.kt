package com.blues.home.view

import com.blues.framework.utils.ScreenUtil.screenWidth
import android.view.ViewGroup
import android.widget.ImageView
import com.blues.bean.CourseEntity
import com.blues.R
import android.widget.TextView
import android.widget.LinearLayout
import coil.load
import com.blues.framework.utils.dp
import com.jude.easyrecyclerview.adapter.BaseViewHolder

/**
 * File: com.blues.module_main.CourseEntryHolder
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-07-16
 */
class CourseEntryHolder(parent: ViewGroup?) :
    BaseViewHolder<CourseEntity>(parent, R.layout.item_course_entry) {

    private val tvTitle: TextView = itemView.findViewById(R.id.tv_entry_title)

    private val ivIcon: ImageView = itemView.findViewById(R.id.iv_entry_icon)

    override fun setData(data: CourseEntity) {
        super.setData(data)

        ivIcon.load(data.icon)

        tvTitle.text = data.name
    }

    init {
        val llContainer = itemView.findViewById<LinearLayout>(R.id.ll_course_entry)
        LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                .apply {
                    width = screenWidth / 4
                    topMargin = 5f.dp.toInt()
                    bottomMargin = 5f.dp.toInt()
                }
                .also {
                    llContainer.layoutParams = it
                }
    }
}