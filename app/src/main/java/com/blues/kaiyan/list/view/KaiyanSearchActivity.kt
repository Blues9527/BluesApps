package com.blues.kaiyan.list.view

import android.widget.TextView.OnEditorActionListener
import android.widget.EditText
import android.widget.TextView
import android.widget.LinearLayout
import com.jude.easyrecyclerview.EasyRecyclerView
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.blues.R
import android.os.Bundle
import android.util.TypedValue
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import com.blues.kaiyan.list.model.KaiyanBean
import android.view.inputmethod.EditorInfo
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import com.blues.adapter.TextWatcherAdapter
import com.blues.framework.base.BaseKoinActivity
import com.blues.kaiyan.list.vm.KaiyanViewModel
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * File: com.blues.kaiyan.list.view.KaiyanSearchActivity.kt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021/7/30
 **/

class KaiyanSearchActivity : BaseKoinActivity(), TextWatcherAdapter, View.OnClickListener,
    OnEditorActionListener {

    private val searchViewModel: KaiyanViewModel by viewModel()

    private val etSearch: EditText by lazy {
        findViewById(R.id.et_search)
    }
    private val ivClear: ImageView by lazy {
        findViewById(R.id.iv_clear)
    }
    private val tvSearchResult: TextView by lazy {
        findViewById(R.id.tv_search_result)
    }
    private val llHotSearch: LinearLayout by lazy {
        findViewById(R.id.ll_hot_search)
    }
    private val rvSearchResult: EasyRecyclerView by lazy {
        findViewById(R.id.rv_search_result)
    }
    private val rvHotSearchResult: EasyRecyclerView by lazy {
        findViewById(R.id.rv_hot_search)
    }
    private val tvCancel: TextView by lazy {
        findViewById(R.id.tv_cancel)
    }

    private lateinit var mHotSearchAdapter: RecyclerArrayAdapter<String>
    private lateinit var mResultAdapter: RecyclerArrayAdapter<KaiyanBean.ItemListBean>

    private var textInput: String = ""

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
        textInput = etSearch.text.toString().trim()
        ivClear.visibility = if (!TextUtils.isEmpty(textInput)) View.VISIBLE else View.GONE
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.iv_clear -> {
                etSearch.setText("")
                textInput = ""
            }
            R.id.tv_cancel -> finish()
        }
    }

    override fun collect() {
        lifecycleScope.launch {
            searchViewModel.hotSearch.collect {
                mHotSearchAdapter.apply {
                    addAll(it)
                    notifyDataSetChanged()
                }
            }
        }

        lifecycleScope.launch {
            searchViewModel.searchResult.collect {
                llHotSearch.visibility = View.GONE
                rvSearchResult.visibility = View.VISIBLE
                tvSearchResult.apply {
                    setTextColor(resources.getColor(R.color.color_black, null))
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 13f)
                    text = "『$textInput』共有${it.itemList.size}条搜索结果"
                }
                for (item in it.itemList) {
                    mResultAdapter.add(item)
                }
                mResultAdapter.notifyDataSetChanged()
            }
        }
    }


    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            mResultAdapter.clear()
            searchViewModel.getSearchResult(textInput)
            return true
        }
        return false
    }

    override fun getLayoutId(): Int = R.layout.activity_oe_search

    override fun initData(savedInstanceState: Bundle?) {

        //获取热搜
        searchViewModel.getHotSearch()

        etSearch.apply {
            addTextChangedListener(this@KaiyanSearchActivity)
            setOnEditorActionListener(this@KaiyanSearchActivity)
        }
        ivClear.setOnClickListener(this@KaiyanSearchActivity)

        tvSearchResult.apply {
            setTextColor(resources.getColor(R.color.color_weak_white, null))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 11f)
        }

        rvHotSearchResult.apply {
            setLayoutManager(StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL))
            adapter = object : RecyclerArrayAdapter<String>(this@KaiyanSearchActivity) {
                override fun OnCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): BaseViewHolder<*> {
                    return KaiyanHotSearchViewHolder(parent)
                }
            }.also { mHotSearchAdapter = it }
        }

        tvCancel.setOnClickListener(this@KaiyanSearchActivity)

        rvSearchResult.apply {
            setLayoutManager(LinearLayoutManager(this@KaiyanSearchActivity))
            adapter = object :
                RecyclerArrayAdapter<KaiyanBean.ItemListBean>(this@KaiyanSearchActivity) {
                override fun OnCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): BaseViewHolder<*> {
                    return KaiyanSearchResultViewHolder(parent)
                }
            }.also { mResultAdapter = it }
        }

        mHotSearchAdapter.setOnItemClickListener { position: Int ->
            textInput = mHotSearchAdapter.getItem(position)
            etSearch.setText(textInput)
            searchViewModel.getSearchResult(textInput)
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_fade_out)
    }
}