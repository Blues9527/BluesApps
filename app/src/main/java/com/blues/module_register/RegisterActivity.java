package com.blues.module_register;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.blues.R;
import com.blues.framework.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 10:21
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private List<Fragment> fragments = new ArrayList<>();
    private Fragment mCurrentFragment;

    private TextView tvAccountRegister, tvPhoneRegister;
    private FrameLayout flContainer;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_register;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

        tvAccountRegister = findViewById(R.id.tv_account_register);
        tvPhoneRegister = findViewById(R.id.tv_phone_register);
        flContainer = findViewById(R.id.fl_container);

        fragments.add(new AccountRegisterFragment());
        fragments.add(new PhoneRegisterFragment());


    }

    @Override
    public void setListener() {
        tvAccountRegister.setOnClickListener(this);
        tvPhoneRegister.setOnClickListener(this);
    }

    private void showFragment(Fragment from, Fragment to) {
        if (to == null) return;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        boolean isAdded = to.isAdded();
        if (!isAdded) {
            if (from != null) {
                transaction.hide(from)
                        .add(R.id.fl_container, to, null)
                        .show(to)
                        .commitAllowingStateLoss();
            } else {
                transaction.add(R.id.fl_container, to, null)
                        .show(to)
                        .commitAllowingStateLoss();
            }
        } else {
            if (from != null) {
                transaction.hide(from)
                        .show(to)
                        .commitAllowingStateLoss();
            } else {
                transaction.show(to)
                        .commitAllowingStateLoss();
            }
        }

        mCurrentFragment = to;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_account_register:
                //TODO 跳转账号注册fragment
                tvAccountRegister.setVisibility(View.GONE);
                tvPhoneRegister.setVisibility(View.GONE);
                flContainer.setVisibility(View.VISIBLE);
                showFragment(mCurrentFragment, fragments.get(0));
                break;
            case R.id.tv_phone_register:
                //TODO 跳转手机注册fragment
                tvAccountRegister.setVisibility(View.GONE);
                tvPhoneRegister.setVisibility(View.GONE);
                flContainer.setVisibility(View.VISIBLE);
                showFragment(mCurrentFragment, fragments.get(1));
                break;
        }
    }
}
