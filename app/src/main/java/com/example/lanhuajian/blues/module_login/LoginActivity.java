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

    private String password, account;
    private EditText etInputAccount, etInputPwd;
    private ImageView ivEyesOn, ivEyesOff;
    private ImageView ivGo;
    private ImageView ivCleanAct, ivCleanPwd;
    private TextView ivSkip;

    private LoginContract.iLoginContractPresenter iPresenter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_login;
    }


    @Override
    public void initView(Bundle savedInstanceState) {

        etInputAccount = findViewById(R.id.et_input_account);
        etInputPwd = findViewById(R.id.et_input_pwd);
        ivEyesOn = findViewById(R.id.iv_eyes_on);
        ivEyesOff = findViewById(R.id.iv_eyes_off);
        ivGo = findViewById(R.id.iv_go);
        ivCleanAct = findViewById(R.id.iv_clean_act);
        ivCleanPwd = findViewById(R.id.iv_clean_pwd);
        ivSkip = findViewById(R.id.tv_skip);

        mPresenter = new LoginPresenter(this);

    }

    @Override
    public void setListener() {
        ivEyesOn.setOnClickListener(this);
        ivEyesOff.setOnClickListener(this);
        ivGo.setOnClickListener(this);
        ivCleanPwd.setOnClickListener(this);
        ivCleanAct.setOnClickListener(this);
        ivSkip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_go:
                password = etInputPwd.getText().toString();
                account = etInputAccount.getText().toString();

                iPresenter.doLogin(account, password);

                break;
            case R.id.iv_clean_act:
                etInputAccount.getText().clear();
                account = "";
                break;

            case R.id.iv_clean_pwd:
                etInputPwd.getText().clear();
                password = "";
                break;
            case R.id.iv_eyes_on:
                etInputPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//显示
                ivEyesOn.setVisibility(View.GONE);
                ivEyesOff.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_eyes_off:
                etInputPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());//隐藏
                ivEyesOn.setVisibility(View.VISIBLE);
                ivEyesOff.setVisibility(View.GONE);
                break;
            case R.id.tv_skip:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void onSuccess(HttpResponse result) {
        if (result.getCode() == 200) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
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
