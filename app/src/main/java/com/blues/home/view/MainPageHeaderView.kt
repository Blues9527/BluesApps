package com.blues.home.view

import com.blues.framework.utils.FileUtil.getAssetsFile
import kotlin.jvm.JvmOverloads
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter
import com.jude.easyrecyclerview.EasyRecyclerView
import com.blues.framework.widget.DrawableTextView
import android.view.LayoutInflater
import com.blues.R
import android.content.Intent
import com.blues.kaiyan.list.view.OpenEyeSearchActivity
import androidx.core.app.ActivityOptionsCompat
import android.app.Activity
import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import com.blues.bean.CourseEntity
import android.view.ViewGroup
import com.blues.gankio._new.girl.GankGirlActivity
import android.widget.Toast
import com.blues.gankio._new.mvp.view.GankActivity
import com.blues.kaiyan.list.view.OpenEyeActivity
import com.blues.wanandroid.view.WanAndroidActivity
import com.blues.game.GameActivity
import org.json.JSONArray
import com.google.gson.Gson
import com.blues.home.model.WanAndroidBannerEntity
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.jude.easyrecyclerview.adapter.BaseViewHolder
import org.json.JSONException
import java.util.ArrayList

/**
 * User : Blues
 * Date : 2019/9/4
 * Time : 15:32
 */
class MainPageHeaderView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null,
    defStyleAttr: Int = 0) : ConstraintLayout(context, attrs, defStyleAttr),
    RecyclerArrayAdapter.ItemView {

    private lateinit var ervEntry: EasyRecyclerView
    private lateinit var viewPager2: ViewPager2
    private var tvSearch: DrawableTextView? = null

    private fun initView(ctx: Context) {
        val rootView = LayoutInflater.from(ctx).inflate(R.layout.header_main, this)
        viewPager2 = rootView.findViewById(R.id.vp_header)
        ervEntry = rootView.findViewById(R.id.erv_entry)
        tvSearch = rootView.findViewById<DrawableTextView>(R.id.tv_search).apply {
            setOnClickListener {
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation((ctx as Activity), it, "transitionSearch")
                ctx.startActivity(Intent(ctx, OpenEyeSearchActivity::class.java), options.toBundle())
            }
        }
        initEntry(ctx)
    }

    private fun initEntry(context: Context) {
        var mEntryAdapter: RecyclerArrayAdapter<CourseEntity>
        ervEntry.apply {
            setLayoutManager(GridLayoutManager(getContext(), 4))
            adapter = object : RecyclerArrayAdapter<CourseEntity>(getContext()) {
                override fun OnCreateViewHolder(parent: ViewGroup,
                    viewType: Int): BaseViewHolder<*> {
                    return CourseEntryHolder(parent)
                }
            }.also { mEntryAdapter = it }
        }
        mEntryAdapter.apply {
            addAll(getAllCourse(context))
            notifyDataSetChanged()

            setOnItemClickListener { position: Int ->
                if (getContext() is FragmentActivity) {
                    when (position) {
                        0 -> ActivityUtil.start(GankGirlActivity::class.java)
                        1, 2, 3 ->                         //商城
                            Toast.makeText(getContext(), "敬请期待", Toast.LENGTH_SHORT).show()
                        4 ->                         //干货
                            ActivityUtil.start(GankActivity::class.java)
                        5 ->                         //开眼
                            ActivityUtil.start(OpenEyeActivity::class.java)
                        6 ->                         //玩 Android
                            ActivityUtil.start(WanAndroidActivity::class.java)
                        7 ->                         //答题小游戏
                            ActivityUtil.start(GameActivity::class.java)
                    }
                }
            }
        }
    }

    private fun getAllCourse(context: Context): List<CourseEntity> {
        val courses: MutableList<CourseEntity> = ArrayList()
        try {
            val ja = JSONArray(getAssetsFile(context, "course.json"))
            for (i in 0 until ja.length()) {
                val entity = Gson().fromJson(ja[i].toString()
                    .replace("\\\\".toRegex(), ""), CourseEntity::class.java)
                courses.add(entity)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return courses
    }

    override fun onCreateView(parent: ViewGroup): View {
        return this
    }

    override fun onBindView(headerView: View) {}

    //fun initBanner(ctx: Context?, bannerEntity: WanAndroidBannerEntity) {
    //    val bannerUrls: MutableList<String> = ArrayList()
    //    val pathUrls: MutableList<String> = ArrayList()
    //    for (data in bannerEntity.data) {
    //        bannerUrls.add(data.imagePath)
    //        pathUrls.add(data.url)
    //    }
    //    Handler(Looper.getMainLooper()).post {
    //        val adapter = BannerAdapter(ctx, bannerUrls, viewPager2).apply {
    //            setItemClickListener { realPosition: Int -> WebViewDialog(context, pathUrls[realPosition]).show() } //开启轮播
    //        }
    //        val params = LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 185f.dp.toInt())
    //        viewPager2.apply {
    //            setPlayDelay(3000) //启用progressbar形式hintview
    //            setHintPadding(10f.dp.toInt(), 0, 10f.dp.toInt(), 10f.dp.toInt())
    //            setAnimationDuration(1000)
    //            layoutParams = params
    //            setAdapter(adapter)
    //        }
    //    }
    //}

    fun initBanner(ctx: Context, bannerEntity: WanAndroidBannerEntity) {
        val vpAdapter = object : RecyclerArrayAdapter<WanAndroidBannerEntity.DataBean>(ctx) {
            override fun OnCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<*> {
                return WanAndroidBannerViewHolder(parent)
            }
        }

        vpAdapter.addAll(bannerEntity.data)
        vpAdapter.notifyDataSetChanged()
        viewPager2.adapter = vpAdapter
    }

    init {
        initView(context)
    }
}