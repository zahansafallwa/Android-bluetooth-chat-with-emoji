package com.zahan.safallwa.donttalk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/**
 * Created by Zahan on 1/22/2016.
 */
public class Splash extends Activity {
    Intent mainintent;
    ImageView bus;
    Animation down, up, animation, still;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        bus = (ImageView) findViewById(R.id.imageView);
        mainintent = new Intent(Splash.this,MainActivity.class);
        still = new TranslateAnimation(0, -50, 0, 0);
        still.setDuration(500);
        still.setFillAfter(true);
        down = new TranslateAnimation(-50, 0, 0, 0);
        down.setDuration(500);
        down.setFillAfter(true);
        animation = new TranslateAnimation(0, -50, 0, 0);
        animation.setDuration(500);
        animation.setFillAfter(false);
        up = new TranslateAnimation(-50, 0, 0, 0);
        up.setDuration(500);
        up.setFillAfter(true);


        still.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation still) {

            }

            @Override
            public void onAnimationEnd(Animation still) {

                bus.startAnimation(down);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        down.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation down) {

            }

            @Override
            public void onAnimationEnd(Animation down) {

                bus.startAnimation(animation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        animation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {


                bus.startAnimation(up);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        up.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation up) {


            }

            @Override
            public void onAnimationEnd(Animation up) {


                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(mainintent);
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        bus.startAnimation(still);

    }


    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}