package com.blues.framework.behavior

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.appbar.AppBarLayout

/**
 * File: com.blues.framework.behavior.RotateFloatingButtonBehavior
 * Description: xxx
 *
 * @author: lanhuajian
 * @time: 2021-09-16 11:16
 */
class RotateFloatingButtonBehavior(context: Context, attrs: AttributeSet?) :
    CoordinatorLayout.Behavior<FloatingActionButton>(context, attrs) {

    override fun layoutDependsOn(parent: CoordinatorLayout, child: FloatingActionButton,
        dependency: View): Boolean {
        return dependency is AppBarLayout
    }

    override fun onDependentViewChanged(parent: CoordinatorLayout, child: FloatingActionButton,
        dependency: View): Boolean {
        child.rotation += 10f
        return super.onDependentViewChanged(parent, child, dependency)
    }
}