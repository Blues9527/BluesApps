package com.blues.module_register.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.blues.R;
import com.blues.framework.base.BaseFragment;
import com.blues.framework.utils.HelperUtil;

/**
 * User : Blues
 * Date : 2019/5/8
 * Time : 10:21
 */

public class PhoneRegisterFragment extends BaseFragment implements TextWatcher, View.OnClickListener {

    private TextView tvSkip;
    private EditText etPhone, etVerify, etPassword;
    private TextView tvGetVerify, tvRegister;

    private String phoneNum, verifyCode, password;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_phone_register;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        tvSkip = rootView.findViewById(R.id.tv_skip);
        etPhone = rootView.findViewById(R.id.et_phone);
        etVerify = rootView.findViewById(R.id.et_verify);
        etPassword = rootView.findViewById(R.id.et_password);
        tvRegister = rootView.findViewById(R.id.tv_register);
        tvGetVerify = rootView.findViewById(R.id.tv_get_verify);
    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {
        etPhone.addTextChangedListener(this);
        etVerify.addTextChangedListener(this);

        tvSkip.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        tvGetVerify.setOnClickListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        phoneNum = etPhone.getText().toString().trim();
        verifyCode = etVerify.getText().toString().trim();
        password = etPassword.getText().toString().trim();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_skip:
                //点击跳过

                break;

            case R.id.tv_register:
                //TODO 点击注册
                if (TextUtils.isEmpty(phoneNum) || TextUtils.isEmpty(verifyCode)) {
                    HelperUtil.showToast("手机号码 or 验证码不能为空");
                }
                //TODO 调用注册接口进行验证
                break;
            case R.id.tv_get_verify:
                //TODO 点击获取验证码，调用接口进行验证码请求，须与发行商合作
                break;
        }
    }
}
