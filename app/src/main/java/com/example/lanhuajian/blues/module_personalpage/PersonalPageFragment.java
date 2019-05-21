package com.example.lanhuajian.blues.module_personalpage;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.lanhuajian.blues.framework.base.BaseFragment;
import com.example.lanhuajian.blues.framework.widget.AvatarView;
import com.example.lanhuajian.blues.R;

/**
 * User : Blues
 * Date : 2019/4/11
 * Time : 15:32
 */

public class PersonalPageFragment extends BaseFragment {

    private AvatarView avatar;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_personalpage;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        avatar = rootView.findViewById(R.id.custom_avatar);

        avatar.setCircleView(BitmapFactory.decodeResource(getResources(), R.mipmap.iv_my_avatar));
    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {

    }
}
