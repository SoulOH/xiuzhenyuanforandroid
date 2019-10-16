package com.example.xiuzhenyuanforandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.xiuzhenyuanforandroid.databinding.ActivityLoginBinding;
import com.example.xiuzhenyuanforandroid.model.User;
import com.example.xiuzhenyuanforandroid.presenter.CommonPresenter;
import com.example.xiuzhenyuanforandroid.presenter.LoginPresenter;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        initModel(binding);
        initPresenter(binding);
    }

    private void initPresenter(ActivityLoginBinding binding) {
        CommonPresenter commonPresenter = new CommonPresenter();
        binding.setCommonPresenter(commonPresenter);

        LoginPresenter loginPresenter = new LoginPresenter();
        binding.setLoginPresenter(loginPresenter);
    }

    private void initModel(ActivityLoginBinding binding) {
        User user = new User();
        binding.setUser(user);
    }
}
