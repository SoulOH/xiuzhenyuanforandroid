package com.example.xiuzhenyuanforandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.xiuzhenyuanforandroid.databinding.ActivityRegisterBinding;
import com.example.xiuzhenyuanforandroid.model.User;
import com.example.xiuzhenyuanforandroid.model.Verification;
import com.example.xiuzhenyuanforandroid.presenter.CommonPresenter;
import com.example.xiuzhenyuanforandroid.presenter.LoginPresenter;
import com.example.xiuzhenyuanforandroid.presenter.RegisterPresenter;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_register);

        initModel(binding);
        initPresenter(binding);
    }

    private void initPresenter(ActivityRegisterBinding binding) {
        CommonPresenter commonPresenter = new CommonPresenter();
        binding.setCommonPresenter(commonPresenter);

        RegisterPresenter registerPresenter = new RegisterPresenter();
        binding.setRegisterPresenter(registerPresenter);
    }

    private void initModel(ActivityRegisterBinding binding) {
        User user = new User();
        binding.setUser(user);

        Verification verification = new Verification();
        binding.setVerification(verification);
    }
}
