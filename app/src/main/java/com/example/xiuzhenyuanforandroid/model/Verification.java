package com.example.xiuzhenyuanforandroid.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class Verification extends BaseObservable {
    private String messageVerificationCode;

    @Bindable
    public String getMessageVerificationCode() {
        return messageVerificationCode;
    }

    public void setMessageVerificationCode(String messageVerificationCode) {
        this.messageVerificationCode = messageVerificationCode;
    }
}
