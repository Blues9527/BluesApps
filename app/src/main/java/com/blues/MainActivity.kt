package com.blues

import com.blues.framework.utils.HelperUtil.showSimpleLog
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.blues.framework.base.BaseKoinActivity
import com.blues.kaiyan.list.view.KaiyanFragment
import com.blues.framework.utils.HelperUtil
import com.blues.framework.utils.startActivity
import com.blues.kaiyan.list.view.KaiyanHotRankFragment
import com.blues.kaiyan.list.view.KaiyanSearchActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : BaseKoinActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private var mLastMillis: Long = 0
    private var mCurrentFragment: Fragment? = null
    private lateinit var toolBar: Toolbar
    private lateinit var editText: EditText
    private lateinit var floatActionButton: FloatingActionButton

    //private val fragmentList: MutableList<Fragment> = mutableListOf(MainPageFragment(), StudyPageFragment(), KaiyanFragment())
    private val fragmentList: MutableList<Fragment> = mutableListOf(
        KaiyanHotRankFragment(),
        KaiyanFragment()
    )

    override fun onBackPressed() {
        showSimpleLog("on back press")
        val currentMillis = System.currentTimeMillis()
        if (currentMillis - mLastMillis > 2000) {
            mLastMillis = currentMillis
            HelperUtil.showToast("再按一次退出程序")
            return
        }
        super.onBackPressed()
    }

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initData(savedInstanceState: Bundle?) {

        //先设置监听再添加tab，selected 标识就能起作用
        val bottomView = findViewById<BottomNavigationView>(R.id.bottom_view)
        bottomView.setOnNavigationItemSelectedListener(this)
        showFragment(null, fragmentList[0])

        toolBar = findViewById(R.id.toolbar)

        toolBar.setOnClickListener {
            startActivity<KaiyanSearchActivity>()
        }

        editText = findViewById(R.id.edit_text)

        floatActionButton = findViewById(R.id.float_action_button)

        floatActionButton.setOnTouchListener { _, _ ->
            Log.i("Blues", "onTouch FloatingActionButton")
            true
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val currentMillis = System.currentTimeMillis()
            if (currentMillis - mLastMillis > 2000) {
                mLastMillis = currentMillis
                HelperUtil.showToast("再按一次退出程序")
            } else { //返回退出界面，但不销毁
                moveTaskToBack(true)
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_home -> showFragment(mCurrentFragment, fragmentList[0])
            R.id.menu_open_eye -> showFragment(mCurrentFragment, fragmentList[1])
            //R.id.menu_mine -> showFragment(mCurrentFragment, fragmentList[2])
        }
        return true
    }

    private fun showFragment(from: Fragment?, to: Fragment?) {
        if (to == null) return
        val transaction = this.supportFragmentManager.beginTransaction()
        val isAdded = to.isAdded
        if (!isAdded) {
            if (from != null) {
                transaction.hide(from).add(R.id.fl_container, to, null).show(to)
                    .commitAllowingStateLoss()
            } else {
                transaction.add(R.id.fl_container, to, null).show(to).commitAllowingStateLoss()
            }
        } else {
            if (from != null) {
                transaction.hide(from).show(to).commitAllowingStateLoss()
            } else {
                transaction.show(to).commitAllowingStateLoss()
            }
        }
        mCurrentFragment = to
    }
}