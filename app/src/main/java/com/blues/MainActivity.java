package com.blues;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.blues.framework.base.BaseActivity;
import com.blues.framework.utils.HelperUtil;
import com.blues.framework.utils.SizeUtil;
import com.blues.module_kaiyan.OpenEyeFragment;
import com.blues.module_main.MainPageFragment;
import com.blues.module_study.StudyPageFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {

    private String[] tabs = {"主页", "学习", "开眼"};
    private int[] icons = {R.drawable.ic_svg_home_grey, R.drawable.ic_svg_book_grey, R.drawable.ic_svg_user_grey};
    private int[] icons_selected = {R.drawable.ic_svg_home_blue, R.drawable.ic_svg_book_blue, R.drawable.ic_svg_user_blue};
    private long mLastMillis;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        TabLayout mTab = findViewById(R.id.tl_activity_bottom);

        fragmentList.add(new MainPageFragment());
        fragmentList.add(new StudyPageFragment());
        fragmentList.add(new OpenEyeFragment());

        //先设置监听再添加tab，selected 标识就能起作用
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                updateTabItem(tab, true);
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragmentList.get(tab.getPosition())).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                updateTabItem(tab, false);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //隐藏指示器
        mTab.setSelectedTabIndicatorHeight(0);

        //添加自定义的tab item
        for (int i = 0; i < tabs.length; i++) {
            mTab.addTab(mTab.newTab().setCustomView(getCustomView(mContext, i)), i == 0);
        }
    }

    @Override
    public void setListener() {

    }

    @Override
    public void onBackPressed() {
        HelperUtil.showSimpleLog("on back press");

        long currentMillis = System.currentTimeMillis();
        if (currentMillis - mLastMillis > 2000) {
            mLastMillis = currentMillis;
            HelperUtil.showToastShort("再按一次退出程序");
            return;
        }

        super.onBackPressed();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long currentMillis = System.currentTimeMillis();
            if (currentMillis - mLastMillis > 2000) {
                mLastMillis = currentMillis;
                HelperUtil.showToastShort("再按一次退出程序");
            } else {
                //返回退出界面，但不销毁
                moveTaskToBack(true);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private View getCustomView(Context context, int position) {
        View container = LayoutInflater.from(context).inflate(R.layout.view_tablayout_item, null);
        ImageView iv = container.findViewById(R.id.tabv_icon);
        TextView tv = container.findViewById(R.id.tabv_title);

        iv.setImageResource(icons[position]);
        tv.setText(tabs[position]);
        tv.setTextColor(tv.getResources().getColor(R.color.color_black));
        tv.setTextSize(SizeUtil.dp2px(5f));

        return container;
    }

    private void updateTabItem(TabLayout.Tab tab, boolean selected) {
        View view = tab.getCustomView();
        if (view instanceof ConstraintLayout) {
            ImageView imageView = (ImageView) ((ConstraintLayout) view).getChildAt(0);
            imageView.setImageResource(selected ? icons_selected[tab.getPosition()] : icons[tab.getPosition()]);
            TextView textView = (TextView) ((ConstraintLayout) view).getChildAt(1);
            textView.setTextColor(textView.getResources().getColor(selected ? R.color.color_light_blue : R.color.color_black));
        }
    }
}
