package com.example.anatoliko;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends Activity {
    private Handler mHandler = new Handler();
    int timer = 3500;

    ImageView pink,blue,gray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_start);

        pink = (ImageView)findViewById(R.id.pink);
        blue = (ImageView)findViewById(R.id.blue);
        gray = (ImageView)findViewById(R.id.gray);

        int animationTimer = 1300;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

            ObjectAnimator animator = ObjectAnimator.ofFloat(pink, "translationX",-650f );
            animator.setDuration(animationTimer);
            animator.start();
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(pink, "translationY",-300f );
            animator2.setDuration(animationTimer);
            animator2.start();

            ObjectAnimator animator3 = ObjectAnimator.ofFloat(blue, "translationX",450f );
            animator3.setDuration(animationTimer);
            animator3.start();
            ObjectAnimator animator4 = ObjectAnimator.ofFloat(blue, "translationY",-30f );
            animator4.setDuration(animationTimer);
            animator4.start();

            ObjectAnimator animator5 = ObjectAnimator.ofFloat(gray, "translationX",260f );
            animator5.setDuration(animationTimer);
            animator5.start();
            ObjectAnimator animator6 = ObjectAnimator.ofFloat(gray, "translationY",427f );
            animator6.setDuration(animationTimer);
            animator6.start();
        }

        mHandler.postDelayed(new Runnable() {
            public void run() {
                changeActivity();
            }
        }, timer);


    }

    private void changeActivity() {
        Intent intent = new Intent(StartActivity.this, MenuActivity.class);

        startActivity(intent);
    }
}