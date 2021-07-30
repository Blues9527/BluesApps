package com.blues.game

import com.blues.framework.utils.FileUtil.getAssetsFile
import com.jude.easyrecyclerview.EasyRecyclerView
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.blues.game.QuestionEntity.QuestionsBean
import com.blues.R
import android.os.Bundle
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import com.blues.framework.base.BaseKoinActivity
import com.blues.framework.utils.fromJson
import com.jude.easyrecyclerview.adapter.BaseViewHolder

class GameActivity : BaseKoinActivity() {

    private val ervGame: EasyRecyclerView by lazy { findViewById(R.id.erv_game) }
    private var mAdapter: RecyclerArrayAdapter<QuestionsBean>? = null

    override fun getLayoutId(): Int = R.layout.activity_game

    override fun initData(savedInstanceState: Bundle?) {
        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(ervGame.recyclerView) //禁止recyclerview 滑动
        val layoutManager: LinearLayoutManager = object :
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false) {
            override fun canScrollHorizontally(): Boolean {
                return false
            }
        }
        ervGame.setLayoutManager(layoutManager)
        ervGame.adapter = object : RecyclerArrayAdapter<QuestionsBean>(this) {
            override fun OnCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
                return QuestionViewHolder(parent)
            }
        }.also { mAdapter = it }
        val gameJson = getAssetsFile(this, "game.json")
        mAdapter?.let {
            it.addAll(gameJson.fromJson<QuestionEntity>().questions)
            it.notifyDataSetChanged()
        }
    }
}