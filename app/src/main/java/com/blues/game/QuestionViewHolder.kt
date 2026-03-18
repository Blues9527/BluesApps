package com.blues.game

import android.view.ViewGroup
import com.blues.game.QuestionEntity.QuestionsBean
import com.blues.R
import android.app.Activity
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.blues.framework.utils.HelperUtil
import com.jude.easyrecyclerview.adapter.BaseViewHolder

class QuestionViewHolder(parent: ViewGroup?) :
    BaseViewHolder<QuestionsBean>(parent, R.layout.item_game) {

    private val tvTitle: TextView by lazy { itemView.findViewById(R.id.tv_title) }
    private val btnSubmit: Button by lazy { itemView.findViewById(R.id.btn_submit) }
    private val rgAnswers: RadioGroup by lazy { itemView.findViewById(R.id.rg_answer) }

    override fun setData(data: QuestionsBean) {
        super.setData(data)

        //1.问题
        tvTitle.text = String.format("%s.%s", data.id, data.title)

        //设置监听
        btnSubmit.setOnClickListener {

            //根据焦点radiobutton的id获取对应radiobutton的实例

            val answer = ((context as Activity).findViewById<View>(rgAnswers.checkedRadioButtonId) as RadioButton).text.toString()
            if (answer == data.answer) {
                HelperUtil.showToast("回答正确")
                ownerRecyclerView?.let {
                    val layoutManager = it.layoutManager as LinearLayoutManager?
                    layoutManager?.let { manager ->
                        val currentPosition = manager.findFirstVisibleItemPosition()
                        it.adapter?.takeIf { adapter ->
                            currentPosition + 1 < adapter.itemCount
                        }?.apply {
                            it.scrollToPosition(currentPosition + 1)
                        }
                    }
                }
            } else {
                HelperUtil.showToast("回答错误")
            }
        }

        //动态添加radiobutton
        for (i in data.selections.indices) {
            val radioButton = RadioButton(context)
            radioButton.text = data.selections[i]
            rgAnswers.addView(radioButton)
        }
        (rgAnswers.getChildAt(0) as RadioButton).isChecked = true
    }
}