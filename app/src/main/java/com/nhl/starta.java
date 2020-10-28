package com.nhl;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.concurrent.TimeUnit;

public class starta extends Activity {
    private Handler mUiHandler = new Handler();
    ImageView logo,logo2;
    SharedPreferences sp1;
    String FT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starta);

        logo = (ImageView) findViewById(R.id.imageView4);

        TranslateAnimation animation = new TranslateAnimation(0, 0, 800, 0);
        animation.setDuration(500);
        animation.setFillAfter(false);
        animation.setAnimationListener(new MyAnimationListener());

        logo.startAnimation(animation);

        TranslateAnimation animation1 = new TranslateAnimation(0, 0, 800, 0);
        animation1.setDuration(500);
        animation1.setFillAfter(false);
        animation1.setAnimationListener(new MyAnimationListener());


        sp1 = getSharedPreferences("FavTeam", MODE_PRIVATE);
        FT = sp1.getString("FavTeam", "");
        MainActivity.FavTeam=FT;

    }

    private class MyAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationEnd(Animation animation) {

          /*  logo.clearAnimation();
            ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(logo.getWidth(), logo.getHeight());
            lp.setMargins(50, 100, 0, 0);
            logo.setLayoutParams(lp);
            logo2.clearAnimation();
            ConstraintLayout.LayoutParams lp2 = new ConstraintLayout.LayoutParams(logo2.getWidth(), logo2.getHeight());
           // lp2.setMargins(0, 0, 0, 0);
           // logo2.setLayoutParams(lp2);

           */
            Thread myThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    mUiHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            logo.animate().scaleX(2).scaleY(2).setDuration(1000);


                        }
                    });

                    mUiHandler.post(new Runnable() {
                        @Override
                        public void run() {

if (!FT.equals("")){
    Intent intent = new Intent(starta.this, MainActivity.class);
    startActivity(intent);
    finish();
}else
{
    Intent intent = new Intent(starta.this, ChooseActivity.class);
    startActivity(intent);
    finish();
}

                        }
                    });
                }
            });
            myThread.start();










        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }

    }
}
