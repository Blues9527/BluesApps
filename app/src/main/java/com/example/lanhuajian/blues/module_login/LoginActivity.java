package com.example.lanhuajian.blues.module_login;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lanhuajian.blues.framework.http.HttpResponse;
import com.example.lanhuajian.blues.MainActivity;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.framework.base.BaseActivity;


/**
 * User : Blues
 * Date : 2019/4/25
 * Time : 14:22
 */

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginContract.iLoginContractView {

    private TextView ivSkip;

    private TextView tvForgetPwd, tvUserReg;

    private LoginContract.iLoginContractPresenter iPresenter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_login;
    }


    @Override
    public void initView(Bundle savedInstanceState) {

        ivSkip = findViewById(R.id.tv_skip);

        tvForgetPwd = findViewById(R.id.tv_forget_pwd);
        tvUserReg = findViewById(R.id.tv_user_reg);


        mPresenter = new LoginPresenter(this);

    }

    @Override
    public void setListener() {
        ivSkip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_skip:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.anim_zoom_in, R.anim.anim_slide_to_bottom);
                finish();
                break;
        }
    }

    @Override
    public void onSuccess(HttpResponse result) {
        if (result.getCode() == 200) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            overridePendingTransition(R.anim.anim_zoom_in, 0);
            finish();
        }
    }

    @Override
    public void onFailure(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(LoginContract.iLoginContractPresenter presenter) {
        iPresenter = presenter;
    }

    @Override
    public void showBegin() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showFinished() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showEmpty() {

    }
}
