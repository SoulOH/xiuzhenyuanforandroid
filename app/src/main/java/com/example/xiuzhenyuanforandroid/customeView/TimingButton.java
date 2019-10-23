package com.example.xiuzhenyuanforandroid.customeView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.widget.Button;

import com.example.xiuzhenyuanforandroid.R;

@SuppressLint("AppCompatCustomView")
public class TimingButton extends Button {

    private int total, interval;
    private String psText;

    public TimingButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取自定义属性，并赋值
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TimingButton);
        total = typedArray.getInteger(R.styleable.TimingButton_tb_totalTime, 600000);
        interval = typedArray.getInteger(R.styleable.TimingButton_tb_timeInterval, 1000);
        psText = typedArray.getString(R.styleable.TimingButton_tb_psText);
        typedArray.recycle();
    }

    //执行
    public void start() {
        TimeCount time = new TimeCount(total, interval);
        time.start();
    }

    public class TimeCount extends CountDownTimer {

        private long countDownInterval;


        TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval); //参数依次为总时长，和计时的时间间隔
            this.countDownInterval = countDownInterval;
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onTick(long millisUntilFinished) {
            setText(millisUntilFinished / countDownInterval + "秒后重新获取");
            setEnabled(false);
        }

        @Override
        public void onFinish() { //计时完毕后触发
            setText(psText);
            setEnabled(true);
        }
    }
}
