package com.blues.module_login;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.blues.R;
import com.blues.framework.base.BaseFragment;
import com.blues.framework.utils.HelperUtil;

public class PhoneLoginFragment extends BaseFragment implements View.OnClickListener, TextWatcher, LoginContract.iLoginContractView {

    private EditText etPhone, etPassword;
    private TextView tvLogin, tvSkip;

    private String phone, password;

    private LoginContract.iLoginContractPresenter iPresenter;


    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_phone_login;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        etPhone = rootView.findViewById(R.id.et_input_phone);
        etPassword = rootView.findViewById(R.id.et_input_password);

        tvSkip = rootView.findViewById(R.id.tv_skip);
        tvLogin = rootView.findViewById(R.id.tv_login);

        mPresenter = new LoginPresenter(this);
    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {
        etPhone.addTextChangedListener(this);
        etPassword.addTextChangedListener(this);

        tvLogin.setOnClickListener(this);
        tvSkip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_skip:

                break;
            case R.id.tv_login:
                //调用登陆接口
                iPresenter.doLogin(phone, password);
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        phone = etPhone.getText().toString().trim();
        password = etPassword.getText().toString().trim();

    }

    @Override
    public void afterTextChanged(Editable s) {

    }


    @Override
    public void onSuccess(LoginResponse result) {
        HelperUtil.showToastShort("登陆成功");
    }

    @Override
    public void onFailure(String result) {
        HelperUtil.showToastShort(result);
    }

    @Override
    public void setPresenter(LoginContract.iLoginContractPresenter presenter) {
        iPresenter = presenter;
    }
}
