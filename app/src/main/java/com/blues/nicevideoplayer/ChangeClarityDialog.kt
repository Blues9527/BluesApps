package com.blues.nicevideoplayer

import android.app.Dialog
import android.content.Context
import android.widget.LinearLayout
import android.view.Gravity
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.ViewGroup.MarginLayoutParams
import android.widget.TextView
import com.blues.R
import com.blues.framework.utils.dp

/**
 * Created by XiaoJianjun on 2017/7/6.
 * 切换清晰度对话框（仿腾讯视频切换清晰度的对话框）.
 */
class ChangeClarityDialog(context: Context) : Dialog(context, R.style.dialog_change_clarity) {

    private lateinit var mLinearLayout: LinearLayout
    private var mCurrentCheckedIndex = 0

    private fun init(context: Context) {
        mLinearLayout = LinearLayout(context).apply {
            gravity = Gravity.CENTER
            orientation = LinearLayout.VERTICAL
            setOnClickListener {
                mListener?.onClarityNotChanged()
                dismiss()
            }
        }

        ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            MarginLayoutParams.MATCH_PARENT
        ).also {
            setContentView(mLinearLayout, it)
        }

        window?.let {
            it.attributes.apply {
                width = NiceUtil.getScreenHeight(context)
                height = NiceUtil.getScreenWidth(context)
            }
        }
    }

    /**
     * 设置清晰度等级
     *
     * @param items          清晰度等级items
     * @param defaultChecked 默认选中的清晰度索引
     */
    fun setClarityGrade(items: List<String?>, defaultChecked: Int) {
        mCurrentCheckedIndex = defaultChecked
        for (i in items.indices) {
            val itemView = (LayoutInflater.from(context)
                .inflate(
                    R.layout.item_change_clarity,
                    mLinearLayout,
                    false,
                ) as TextView).apply {
                tag = i
                setOnClickListener { v ->
                    mListener?.let {
                        val checkIndex = v.tag as Int
                        if (checkIndex != mCurrentCheckedIndex) {
                            for (j in 0 until mLinearLayout.childCount) {
                                mLinearLayout.getChildAt(j).isSelected = checkIndex == j
                            }
                            it.onClarityChanged(checkIndex)
                            mCurrentCheckedIndex = checkIndex
                        } else {
                            it.onClarityNotChanged()
                        }
                    }
                    dismiss()
                }
                text = items[i]
                isSelected = i == defaultChecked
            }

            (itemView.layoutParams as MarginLayoutParams).also {
                it.topMargin = if (i == 0) 0 else 16f.dp.toInt()
                mLinearLayout.addView(itemView, it)
            }

        }
    }

    interface OnClarityChangedListener {

        /**
         * 切换清晰度后回调
         *
         * @param clarityIndex 切换到的清晰度的索引值
         */
        fun onClarityChanged(clarityIndex: Int)

        /**
         * 清晰度没有切换，比如点击了空白位置，或者点击的是之前的清晰度
         */
        fun onClarityNotChanged()
    }

    private var mListener: OnClarityChangedListener? = null

    fun setOnClarityCheckedListener(listener: OnClarityChangedListener?) {
        mListener = listener
    }

    override fun onBackPressed() {
        // 按返回键时回调清晰度没有变化
        mListener?.onClarityNotChanged()
        super.onBackPressed()
    }

    init {
        init(context)
    }
}