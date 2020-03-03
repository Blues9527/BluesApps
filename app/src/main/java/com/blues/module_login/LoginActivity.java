package com.blues.module_login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blues.MainActivity;
import com.blues.R;
import com.blues.framework.base.BaseActivity;
import com.blues.module_register.RegisterActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * User : Blues
 * Date : 2019/4/25
 * Time : 14:22
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private TextView ivSkip;
    private TextView tvForgetPwd, tvUserReg;
    private TextView tvAccountLogin, tvPhoneLogin;

    private List<Fragment> fragments = new ArrayList<>();
    private Fragment mCurrentFragment;
    private FrameLayout flContainer;
    private LinearLayout llContainer;


    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_login;
    }


    @Override
    public void initView(Bundle savedInstanceState) {

        ivSkip = findViewById(R.id.tv_skip);
        tvForgetPwd = findViewById(R.id.tv_forget_pwd);
        tvUserReg = findViewById(R.id.tv_user_reg);
        tvAccountLogin = findViewById(R.id.tv_account_login);
        tvPhoneLogin = findViewById(R.id.tv_phone_login);
        flContainer = findViewById(R.id.fl_container);
        llContainer = findViewById(R.id.ll_container);

        fragments.add(new AccountLoginFragment());
        fragments.add(new PhoneLoginFragment());
    }

    @Override
    public void setListener() {
        ivSkip.setOnClickListener(this);
        tvUserReg.setOnClickListener(this);
        tvForgetPwd.setOnClickListener(this);
        tvAccountLogin.setOnClickListener(this);
        tvPhoneLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_skip:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.anim_zoom_in, R.anim.anim_slide_to_bottom);
                finish();
                break;
            case R.id.tv_account_login:
                //TODO 跳转账号登陆fragment
                llContainer.setVisibility(View.GONE);
                flContainer.setVisibility(View.VISIBLE);
                showFragment(mCurrentFragment, fragments.get(0));
                break;
            case R.id.tv_phone_login:
                //TODO 跳转手机登陆fragment
                llContainer.setVisibility(View.GONE);
                flContainer.setVisibility(View.VISIBLE);
                showFragment(mCurrentFragment, fragments.get(1));
                break;
            case R.id.tv_user_reg:
                startActivity(new Intent(this, RegisterActivity.class));
                finish();
                break;
        }
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
}
