package com.blues.kaiyan.detail.view

import com.blues.nicevideoplayer.TxVideoPlayerController
import com.jude.easyrecyclerview.EasyRecyclerView
import com.blues.kaiyan.list.model.KaiyanBean
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.blues.kaiyan.detail.model.KaiyanDetailBean
import com.blues.R
import android.os.Bundle
import com.jude.easyrecyclerview.decoration.DividerDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.ViewGroup
import android.content.Intent
import android.transition.AutoTransition
import android.transition.Explode
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import coil.load
import com.blues.framework.base.BaseKoinActivity
import com.blues.framework.utils.ScreenUtil
import com.blues.framework.utils.dp
import com.blues.kaiyan.detail.vm.KaiyanDetailViewModel
import com.blues.nicevideoplayer.NiceVideoPlayer
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * User : Blues
 * Date : 2019/8/29
 * Time : 14:23
 */
class KaiyanDetailActivity : BaseKoinActivity(), View.OnClickListener {

    private val kaiyanDetailViewModel: KaiyanDetailViewModel by viewModel()

    private val rootFl: FrameLayout by lazy {
        findViewById(R.id.rl_root)
    }
    private val nvpVideo: NiceVideoPlayer by lazy {
        findViewById(R.id.nvp_oe_detail)
    }
    private val ivBack: ImageView by lazy {
        findViewById(R.id.iv_back)
    }
    private val ervRelated: EasyRecyclerView by lazy {
        findViewById(R.id.erv_related)
    }

    private var itemListBean: KaiyanBean.ItemListBean? = null
    private lateinit var mAdapter: RecyclerArrayAdapter<KaiyanDetailBean.ItemListBean>
    private lateinit var mHeader: KaiyanDetailHeaderView

    private fun initDefaultView(data: KaiyanBean.ItemListBean) {

        val controller = TxVideoPlayerController(this).apply {
            setTitle(null)
            setLength(data.data?.duration!!.toLong() * 1000L) //这里将long类型时间长度转换成时分秒的单位是毫秒
        }
        controller.imageView().load(data.data?.cover?.blurred) {
            error(R.mipmap.ic_img_error)
        }

        //视频相关
        nvpVideo.apply {
            setPlayerType(NiceVideoPlayer.TYPE_NATIVE)
            setBackgroundResource(R.drawable.shape_background)
            setUp(data.data?.playUrl, null)
            setController(controller)
            post {
                nvpVideo.continueFromLastPosition(false)
                if (nvpVideo.isIdle) {
                    nvpVideo.start()
                }
            }
        }

        val decoration = DividerDecoration(R.color.color_white, 1)
        ervRelated.apply {
            addItemDecoration(decoration)
            setLayoutManager(LinearLayoutManager(this@KaiyanDetailActivity))
            adapter = object :
                RecyclerArrayAdapter<KaiyanDetailBean.ItemListBean>(this@KaiyanDetailActivity) {
                override fun OnCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int
                ): BaseViewHolder<*> {
                    return KaiyanDetailRelatedViewHolder(parent)
                }
            }.also { mAdapter = it }
        }

        mAdapter.apply {
            setNoMore(R.layout.view_load_no_more)
            addHeader(KaiyanDetailHeaderView(this@KaiyanDetailActivity).also { mHeader = it })
            notifyDataSetChanged()
        }
        mHeader.initDefault(data)
        window.apply {
            enterTransition = AutoTransition()
            exitTransition = Explode()
        }
    }

    override fun collect() {
//        kaiyanDetailViewModel.detail.observe(this) {
//            mAdapter.apply {
//                addAll(it.itemList)
//                notifyDataSetChanged()
//            }
//        }
        lifecycleScope.launch {
            kaiyanDetailViewModel.detail.collect { result ->
                result?.let {
                    mAdapter.apply {
                        addAll(it.itemList)
                        notifyDataSetChanged()
                    }
                }
            }
        }
    }

    override fun getLayoutId(): Int = R.layout.item_oe_hotrank_detail

    override fun initData(savedInstanceState: Bundle?) {
        itemListBean = intent.extras?.get("itemDetail") as KaiyanBean.ItemListBean
        itemListBean?.let {
            initDefaultView(it)
            kaiyanDetailViewModel.getDetail(it.data?.id.toString())
        }

        ivBack.setOnClickListener(this)

        rootFl.setPadding(0, ScreenUtil.statusBarHeight, 0, 0)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        itemListBean = intent.extras?.get("itemDetail") as KaiyanBean.ItemListBean
        itemListBean?.let {
            initDefaultView(it)
            kaiyanDetailViewModel.getDetail(it.data?.id.toString())
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.iv_back -> supportFinishAfterTransition()
        }
    }
}