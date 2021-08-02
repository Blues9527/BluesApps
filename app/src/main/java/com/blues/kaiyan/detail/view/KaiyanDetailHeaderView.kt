package com.blues.kaiyan.detail.view

import android.content.Context
import android.util.AttributeSet
import kotlin.jvm.JvmOverloads
import android.widget.RelativeLayout
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import android.widget.TextView
import android.view.LayoutInflater
import android.view.View
import com.blues.R
import com.blues.kaiyan.list.model.KaiyanBean
import com.bumptech.glide.Glide
import android.view.ViewGroup
import android.widget.ImageView
import coil.load

/**
 * User : Blues
 * Date : 2019/9/4
 * Time : 15:32
 */
class KaiyanDetailHeaderView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0) : RelativeLayout(context, attrs, defStyleAttr),
    RecyclerArrayAdapter.ItemView {

    private lateinit var tvTitle: TextView
    private lateinit var tvDesc: TextView
    private lateinit var tvShare: TextView
    private lateinit var tvReply: TextView
    private lateinit var tvLike: TextView
    private lateinit var ivAvatar: ImageView
    private lateinit var tvAuthor: TextView
    private lateinit var tvAuthorDesc: TextView

    private fun initView(ctx: Context) {
        val view = LayoutInflater.from(ctx).inflate(R.layout.item_oe_detail_header, this)
        tvTitle = view.findViewById(R.id.tv_title)
        tvDesc = view.findViewById(R.id.tv_desc)
        tvShare = view.findViewById(R.id.tv_share)
        tvReply = view.findViewById(R.id.tv_reply)
        tvLike = view.findViewById(R.id.tv_like)
        ivAvatar = view.findViewById(R.id.iv_avatar)
        tvAuthor = view.findViewById(R.id.tv_author)
        tvAuthorDesc = view.findViewById(R.id.tv_author_desc)
    }

    fun initDefault(ctx: Context, data: KaiyanBean.ItemListBean) {
        tvTitle.text = data.data.title
        tvDesc.text = data.data.description
        tvShare.text = data.data.consumption.shareCount.toString()
        tvReply.text = data.data.consumption.replyCount.toString()
        tvLike.text = data.data.consumption.collectionCount.toString()
        ivAvatar.load(data.data.author.icon)
        //Glide.with(ctx).load(data.data.author.icon).into(ivAvatar)
        tvAuthor.text = data.data.author.name
        tvAuthorDesc.text = data.data.author.description
    }

    override fun onCreateView(parent: ViewGroup): View {
        return this
    }

    override fun onBindView(headerView: View) {}

    init {
        initView(context)
    }
}