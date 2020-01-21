package com.example.lanhuajian.blues.module_login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lanhuajian.blues.MainActivity;
import com.example.lanhuajian.blues.R;
import com.example.lanhuajian.blues.framework.base.BaseFragment;
import com.example.lanhuajian.blues.framework.utils.HelperUtil;

public class AccountLoginFragment extends BaseFragment implements View.OnClickListener, TextWatcher, LoginContract.iLoginContractView {

    private EditText etAccount, etPassword;
    private TextView tvLogin, tvSkip;

    private String account, password;

    private LoginContract.iLoginContractPresenter iPresenter;


    @Override
    public int setLayoutResourceId() {
        return R.layout.fragment_account_login;
    }

    @Override
    public void initLayout(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        etAccount = rootView.findViewById(R.id.et_input_account);
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
        etAccount.addTextChangedListener(this);
        etPassword.addTextChangedListener(this);

        tvLogin.setOnClickListener(this);
        tvSkip.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_skip:
//                getActivity().finish();
                break;
            case R.id.tv_login:
                //调用登陆接口
                iPresenter.doLogin(account, password);
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

    }

    @Override
    public void afterTextChanged(Editable s) {

    }


    @Override
    public void onSuccess(LoginResponse result) {
        HelperUtil.showToastShort("登陆成功");
        //登陆成功进行跳转
        getmContext().startActivity(new Intent(getmContext(), MainActivity.class));
        //跳转结束 finish上一个activity
        getmContext().finish();
    }

    @Override
    public void onFailure(String result) {
        //登陆失败进行提示
        HelperUtil.showToastShort(result);
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
