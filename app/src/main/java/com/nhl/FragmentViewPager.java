package com.nhl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.concurrent.TimeUnit;

public class FragmentViewPager extends Fragment {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);


        TextView tv = (TextView) v.findViewById(R.id.title);
        tv.setText(getArguments().getString("text"));

        ImageView imageView = (ImageView) v.findViewById(R.id.image);
        imageView.setBackgroundResource(getArguments().getInt("img"));
        imageView.setClickable(true);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                imageView.animate().scaleX((float) 0.8).scaleY((float) 0.8).setDuration(300);
                return false;

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imageView.animate().scaleX(1).scaleY(1).setDuration(300);

                try {
                    TimeUnit.SECONDS.sleep((long) 0.3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                MainActivity.FavTeam=getArguments().getString("text");
                ChooseActivity.but.performClick();
            }
        });


        return v;
    }



    public static FragmentViewPager newInstance(String text, int image) {

        FragmentViewPager f = new FragmentViewPager();

        Bundle b = new Bundle();
        b.putString("text", text);
        b.putInt("img", image);

        f.setArguments(b);

        return f;
    }


}