package com.example.xiuzhenyuanforandroid.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.xiuzhenyuanforandroid.LoginActivity;
import com.example.xiuzhenyuanforandroid.model.User;
import com.example.xiuzhenyuanforandroid.model.Verification;

import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPresenter {
    private String messageVerificationCode;

    public void jump2LoginActivity(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    public void register(View view, User user, Verification verification) {
        Log.i("Register", "有新的用户正在注册");
        if (user == null) {
            Toast.makeText(view.getContext(), "手机号不能为空" , Toast.LENGTH_SHORT).show();
            return;
        }

        String inputtedPhoneNumber = user.getPhoneNumber();
        if (TextUtils.isEmpty(inputtedPhoneNumber)) {
            Toast.makeText(view.getContext(), "手机号不能为空" , Toast.LENGTH_SHORT).show();
            return;
        }
        //用于匹配手机号码格式
        Pattern p = Pattern.compile("^[1]\\d{10}$");
        Matcher m = p.matcher(inputtedPhoneNumber);
        if (!m.find()) {
            Toast.makeText(view.getContext(), "手机号格式不正确" , Toast.LENGTH_SHORT).show();
            return;
        }

        String inputtedPassword = user.getPassword();
        if (TextUtils.isEmpty(inputtedPassword)) {
            Toast.makeText(view.getContext(), "密码不能为空" , Toast.LENGTH_SHORT).show();
            return;
        }

        if (verification == null) {
            Toast.makeText(view.getContext(), "短信验证码不能为空" , Toast.LENGTH_SHORT).show();
            return;
        }
        String inputtedMessageVerificationCode = verification.getMessageVerificationCode();
        if (TextUtils.isEmpty(inputtedMessageVerificationCode)) {
            Toast.makeText(view.getContext(), "短信验证码不能为空" , Toast.LENGTH_SHORT).show();
            return;
        }
        if (!inputtedMessageVerificationCode.equals(messageVerificationCode)) {
            Toast.makeText(view.getContext(), "短信验证码不正确" , Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(view.getContext(), "注册成功" , Toast.LENGTH_SHORT).show();
        Log.i("Register", "新的用户" + inputtedPhoneNumber + "注册成功");
    }

    public void getMessageVerificationCode(View view) {
        int verificationCode = new Random().nextInt(10000);
        messageVerificationCode = String.format(Locale.getDefault(), "%04d",verificationCode);
        Toast.makeText(view.getContext(), "验证码：" + messageVerificationCode, Toast.LENGTH_SHORT).show();
    }
}
