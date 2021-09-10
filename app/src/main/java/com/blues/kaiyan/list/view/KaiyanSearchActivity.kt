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
import com.blues.adapter.TextWatcherAdapter
import com.blues.framework.base.BaseKoinActivity
import com.blues.kaiyan.list.vm.KaiyanViewModel
import com.jude.easyrecyclerview.adapter.BaseViewHolder
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

    private lateinit var etSearch: EditText
    private lateinit var ivClear: ImageView
    private lateinit var tvSearchResult: TextView
    private lateinit var llHotSearch: LinearLayout
    private lateinit var rvSearchResult: EasyRecyclerView
    private lateinit var rvHotSearchResult: EasyRecyclerView
    private lateinit var tvCancel: TextView

    private lateinit var mHotSearchAdapter: RecyclerArrayAdapter<String>
    private lateinit var mResultAdapter: RecyclerArrayAdapter<KaiyanBean.ItemListBean.DataBean>

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

    override fun observe() {
        searchViewModel.hotSearch.observe(this) {
            mHotSearchAdapter.apply {
                addAll(it)
                notifyDataSetChanged()
            }
        }

        searchViewModel.searchResult.observe(this) {
            llHotSearch.visibility = View.GONE
            rvSearchResult.visibility = View.VISIBLE
            tvSearchResult.apply {
                setTextColor(resources.getColor(R.color.color_black, null))
                setTextSize(TypedValue.COMPLEX_UNIT_SP, 13f)
                text = String.format("『%s』共有%s条搜索结果", textInput, it.itemList.size)
            }
            for (item in it.itemList) {
                mResultAdapter.add(item.data)
            }
            mResultAdapter.notifyDataSetChanged()
        }
    }

    override fun onEditorAction(v: TextView, actionId: Int, event: KeyEvent): Boolean {
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

        etSearch = findViewById<EditText>(R.id.et_search).apply {
            addTextChangedListener(this@KaiyanSearchActivity)
            setOnEditorActionListener(this@KaiyanSearchActivity)
        }
        ivClear = findViewById<ImageView>(R.id.iv_clear).apply {
            visibility = View.GONE
            setOnClickListener(this@KaiyanSearchActivity)
        }
        tvSearchResult = findViewById<TextView>(R.id.tv_search_result).apply {
            setTextColor(resources.getColor(R.color.color_weak_white, null))
            setTextSize(TypedValue.COMPLEX_UNIT_SP, 11f)
        }
        rvSearchResult = findViewById<EasyRecyclerView>(R.id.rv_search_result).apply {
            visibility = View.GONE
        }
        rvHotSearchResult = findViewById<EasyRecyclerView>(R.id.rv_hot_search).apply {
            setLayoutManager(StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL))
            adapter = object : RecyclerArrayAdapter<String>(this@KaiyanSearchActivity) {
                override fun OnCreateViewHolder(parent: ViewGroup,
                    viewType: Int): BaseViewHolder<*> {
                    return KaiyanHotSearchViewHolder(parent)
                }
            }.also { mHotSearchAdapter = it }
        }
        llHotSearch = findViewById<LinearLayout>(R.id.ll_hot_search).apply {
            visibility = View.VISIBLE
        }

        tvCancel = findViewById<TextView>(R.id.tv_cancel).apply {
            setOnClickListener(this@KaiyanSearchActivity)
        }

        rvSearchResult.apply {
            setLayoutManager(LinearLayoutManager(this@KaiyanSearchActivity))
            adapter = object :
                RecyclerArrayAdapter<KaiyanBean.ItemListBean.DataBean>(this@KaiyanSearchActivity) {
                override fun OnCreateViewHolder(parent: ViewGroup,
                    viewType: Int): BaseViewHolder<*> {
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