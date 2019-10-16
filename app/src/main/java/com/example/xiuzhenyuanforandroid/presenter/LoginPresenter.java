package com.example.xiuzhenyuanforandroid.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.xiuzhenyuanforandroid.RegisterActivity;
import com.example.xiuzhenyuanforandroid.model.User;

public class LoginPresenter {
    public void login(View view, User user) {
        if (TextUtils.isEmpty(user.getPhoneNumber())) {
            Toast.makeText(view.getContext(), "手机号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Log.i("Login", "用户" + user.getPhoneNumber() + "正在尝试登录");
        if (TextUtils.isEmpty(user.getPassword())) {
            Toast.makeText(view.getContext(), "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(view.getContext(), "用户" + user.getPhoneNumber() + "登录成功", Toast.LENGTH_SHORT).show();
        Log.i("Login", "用户" + user.getPhoneNumber() + "登录成功");
    }

    public void jump2RegisterActivity(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }
}
