package com.blues.kaiyan.list.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.blues.R
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter

/**
 * File: com.blues.kaiyan.list.view.KaiyanMainHeaderView.kt
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2022/1/21
 **/

class KaiyanMainHeaderView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    ConstraintLayout(context, attrs, defStyleAttr), RecyclerArrayAdapter.ItemView {


    override fun onCreateView(parent: ViewGroup?): View {
        val rootView = LayoutInflater.from(context)
            .inflate(R.layout.header_kaiyan, this)
        val toolBar: Toolbar = findViewById(R.id.toolbar)
        toolBar.setOnClickListener {
            context.startActivity(Intent(context as Activity, KaiyanSearchActivity::class.java))
        }
        return rootView
    }

    override fun onBindView(headerView: View?) {

    }
}