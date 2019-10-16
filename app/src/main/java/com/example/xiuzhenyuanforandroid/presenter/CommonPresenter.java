package com.example.xiuzhenyuanforandroid.presenter;

import android.app.Activity;
import android.view.View;

public class CommonPresenter {
    public void onCloseClicked(View view) {
        ((Activity)view.getContext()).finish();
    }
}
