package com.blues.framework.widget.explosionanimator

import android.animation.Animator
import com.blues.framework.widget.explosionanimator.BitmapUtils.createBitmapFromView
import java.util.ArrayList
import java.util.HashMap
import android.graphics.Canvas
import android.view.ViewGroup
import android.app.Activity
import android.animation.ValueAnimator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.Window

class ExplosionField(context: Context, private val mParticleFactory: ParticleFactory) :
    View(context) {

    private val explosionAnimators: ArrayList<ExplosionAnimator> = ArrayList()
    private val explosionAnimatorHashMap: HashMap<View, ExplosionAnimator?> = HashMap()

    init {
        attachToActivity(context as Activity)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (explosionAnimator in explosionAnimators) {
            explosionAnimator.draw(canvas)
        }
    }

    /**
     * 爆炸
     *
     * @param view
     */
    fun explode(view: View) {
        //防止重复执行动画
        if (explosionAnimatorHashMap[view] != null && explosionAnimatorHashMap[view]!!.isStarted) {
            return
        }
        //视图不可见或者为透明的时候，不执行
        if (view.visibility != VISIBLE || view.alpha == 0f) {
            return
        }
        //获取view相对于整个屏幕的坐标
        val rect = Rect()
        view.getGlobalVisibleRect(rect)
        //计算标题栏高度
        val currentTop = (parent as ViewGroup).top

        //状态栏高度
        val frame = Rect()
        (context as Activity).window.decorView.getWindowVisibleDisplayFrame(frame)
        val statusTop = frame.top

        //去掉状态栏和标题栏高度
        rect.offset(0, -currentTop - statusTop)
        if (rect.width() == 0 || rect.height() == 0) {
            //无法实现爆炸效果
            return
        }

        //震动
        val animator = ValueAnimator.ofFloat(0f, 1.0f).setDuration(150)
        animator.addUpdateListener {
            view.translationX = (BitmapUtils.RANDOM.nextFloat() - 0.5f) * view.width * 0.05f
            view.translationY = (BitmapUtils.RANDOM.nextFloat() - 0.5f) * view.height * 0.05f
        }
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                view.translationX = 0f
                view.translationY = 0f
                explode(view, rect)
            }
        })
        animator.start()
    }

    private fun explode(view: View, rect: Rect) {

        //粒子爆炸
        val animator = ExplosionAnimator(this, createBitmapFromView(view), rect, mParticleFactory)
        explosionAnimators.add(animator)
        explosionAnimatorHashMap[view] = animator
        animator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
                view.isClickable = false
                view.animate().setDuration(150).scaleX(0f).scaleY(0f).alpha(0f).start()
            }

            override fun onAnimationEnd(animation: Animator) {
                view.isClickable = true
                view.animate().setDuration(150).scaleX(1f).scaleY(1f).alpha(1f).start()

                //移除动画
                explosionAnimators.remove(animation)
                explosionAnimatorHashMap.remove(view)
            }
        })
        animator.start()
    }

    /**
     * 添加全屏动画场地
     *
     * @param act
     */
    private fun attachToActivity(act: Activity) {
        val rootView = act.findViewById<View>(Window.ID_ANDROID_CONTENT) as ViewGroup
        val params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        rootView.addView(this, params)
    }
}