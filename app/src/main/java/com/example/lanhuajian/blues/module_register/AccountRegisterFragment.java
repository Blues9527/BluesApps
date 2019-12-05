package com.example.lanhuajian.blues.module_register;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.framework.base.BaseFragment;
import com.example.lanhuajian.blues.framework.utils.HelperUtil;
import com.example.lanhuajian.blues.module_login.AccountLoginFragment;

public class AccountRegisterFragment extends BaseFragment implements View.OnClickListener, TextWatcher, RegisterContract.iRegisterContractView {

    private EditText etAccount, etPassword, etRepassword;
    private TextView tvRegister, tvSkip;

    private String account, password, repassword;

    private RegisterContract.iRegisterContractPresenter iPresenter;

    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_account_register;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        etAccount = rootView.findViewById(R.id.et_input_account);
        etPassword = rootView.findViewById(R.id.et_input_password);
        etRepassword = rootView.findViewById(R.id.et_input_repassword);

        tvSkip = rootView.findViewById(R.id.tv_skip);
        tvRegister = rootView.findViewById(R.id.tv_register);

        mPresenter = new RegisterPresenter(this);
    }

    @Override
    public void lazyFetchData() {

    }

    @Override
    public void setListener() {
        etAccount.addTextChangedListener(this);
        etPassword.addTextChangedListener(this);
        etRepassword.addTextChangedListener(this);

        tvRegister.setOnClickListener(this);
        tvSkip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_skip:

                break;
            case R.id.tv_register:
                //调用注册接口
                iPresenter.doRegister(account, password, repassword);
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        account = etAccount.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        repassword = etRepassword.getText().toString().trim();

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onSuccess(RegisterResponse result) {
        HelperUtil.showToastShort("注册成功");
        //跳转登陆界面
        getmContext().startActivity(new Intent(getmContext(), AccountLoginFragment.class));
        getmContext().finish();
    }

    @Override
    public void onFailure(String result) {
        HelperUtil.showToastShort(result);
    }

    @Override
    public void setPresenter(RegisterContract.iRegisterContractPresenter presenter) {
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
