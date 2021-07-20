package com.blues.module_register.view;

import android.content.Intent;
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
import com.blues.module_login.AccountLoginFragment;
import com.blues.module_register.model.RegisterResponse;

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
        HelperUtil.showToast("注册成功");
        //跳转登陆界面
        getmContext().startActivity(new Intent(getmContext(), AccountLoginFragment.class));
        getmContext().finish();
    }

    @Override
    public void onFailure(String result) {
        HelperUtil.showToast(result);
    }

    @Override
    public void setPresenter(RegisterContract.iRegisterContractPresenter presenter) {
        iPresenter = presenter;
    }
}
