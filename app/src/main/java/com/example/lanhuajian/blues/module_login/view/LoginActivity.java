package com.example.lanhuajian.blues.module_login.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.lanhuajian.blues.R;
import com.example.framework.base.BaseActivity;


/**
 * User : Blues
 * Date : 2019/4/25
 * Time : 14:22
 */

public class LoginActivity extends BaseActivity {

    private String password;
    private String account;

    @Override
    public int setLayoutResourceId() {
        return R.layout.activity_login;
    }


    @Override
    public void initView(Bundle savedInstanceState) {

//        password = etInputPwd.getText().toString();
//        account = etInputAccount.getText().toString();
    }

    @Override
    public void setListener() {
//        ivGo.setOnClickListener(v -> {
//            if (checkNotNull(account, password)) {
//                if (account.equals("blues") && password.equals("000000")) {
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                    this.finish();
//                }
//            }
//        });
    }

    private boolean checkNotNull(String... strs) {
        for (String str : strs) {
            if (TextUtils.isEmpty(str)) {
                Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

}
