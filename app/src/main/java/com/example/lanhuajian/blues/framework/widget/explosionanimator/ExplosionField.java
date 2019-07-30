package com.example.lanhuajian.blues.framework.widget.explosionanimator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import java.util.ArrayList;
import java.util.HashMap;

public class ExplosionField extends View {

    private OnClickListener onClickListener;
    private ArrayList<ExplosionAnimator> explosionAnimators;
    private HashMap<View, ExplosionAnimator> explosionAnimatorHashMap;
    private ParticleFactory mParticleFactory;


    public ExplosionField(Context context, ParticleFactory factory) {
        super(context);
        explosionAnimators = new ArrayList<>();
        explosionAnimatorHashMap = new HashMap<>();
        mParticleFactory = factory;
        attachToActivity((Activity) context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (ExplosionAnimator explosionAnimator : explosionAnimators) {
            explosionAnimator.draw(canvas);
        }
    }

    /**
     * 爆炸
     *
     * @param view
     */
    public void explode(final View view) {
        //防止重复执行动画
        if (explosionAnimatorHashMap.get(view) != null && explosionAnimatorHashMap.get(view).isStarted()) {
            return;
        }
        //视图不可见或者为透明的时候，不执行
        if (view.getVisibility() != VISIBLE || view.getAlpha() == 0) {
            return;
        }
        //获取view相对于整个屏幕的坐标
        final Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        //计算标题栏高度
        int currentTop = ((ViewGroup) getParent()).getTop();

        //状态栏高度
        Rect frame = new Rect();
        ((Activity) getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);

        int statusTop = frame.top;

        //去掉状态栏和标题栏高度
        rect.offset(0, -currentTop - statusTop);

        if (rect.width() == 0 || rect.height() == 0) {
            //无法实现爆炸效果
            return;
        }

        //震动
        ValueAnimator animator = ValueAnimator.ofFloat(0f, 1.0f).setDuration(150);
        animator.addUpdateListener(animation -> {
            view.setTranslationX((BitmapUtils.RANDOM.nextFloat() - 0.5f) * view.getWidth() * 0.05f);
            view.setTranslationY((BitmapUtils.RANDOM.nextFloat() - 0.5f) * view.getHeight() * 0.05f);
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                view.setTranslationX(0f);
                view.setTranslationY(0f);

                explode(view, rect);
            }
        });
        animator.start();
    }

    private void explode(final View view, Rect rect) {

        //粒子爆炸
        final ExplosionAnimator animator = new ExplosionAnimator(this, BitmapUtils.createBitmapFromView(view), rect, mParticleFactory);
        explosionAnimators.add(animator);
        explosionAnimatorHashMap.put(view, animator);
        animator.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                view.setClickable(false);
                view.animate().setDuration(150).scaleX(0f).scaleY(0f).alpha(0f).start();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setClickable(true);
                view.animate().setDuration(150).scaleX(1f).scaleY(1f).alpha(1f).start();

                //移除动画
                explosionAnimators.remove(animation);
                explosionAnimatorHashMap.remove(view);
            }
        });
        animator.start();
    }

    /**
     * 添加全屏动画场地
     *
     * @param act
     */
    private void attachToActivity(Activity act) {
        ViewGroup rootView = (ViewGroup) act.findViewById(Window.ID_ANDROID_CONTENT);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rootView.addView(this, params);
    }

    /**
     * 要实现此效果的view添加监听
     *
     * @param v
     */
    public void addListener(View v) {
        if (v instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) v;

            int count = viewGroup.getChildCount();

            for (int i = 0; i < count; i++) {
                addListener(viewGroup.getChildAt(i));
            }
        } else {
            v.setClickable(true);
            v.setOnClickListener(getOnClickListener());
        }
    }

    private OnClickListener getOnClickListener() {

        if (onClickListener == null) {
            onClickListener = new OnClickListener() {
                @Override
                public void onClick(View v) {
                    //开始执行粒子动画
                    ExplosionField.this.explode(v);
                }
            };
        }
        return onClickListener;
    }
}
