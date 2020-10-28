package com.nhl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class ChooseActivity extends AppCompatActivity {
public static Button but;
 public static SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        but = (Button) findViewById(R.id.button);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
    }



    private class MyPagerAdapter extends FragmentPagerAdapter {

        MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {
            switch (pos) {

                default:
                    return FragmentViewPager.newInstance(getString(R.string.DallasStars), R.drawable.dallas);
                case 1:
                    return FragmentViewPager.newInstance(getString(R.string.NYRangers), R.drawable.rangers );
                case 2:
                    return FragmentViewPager.newInstance(getString(R.string.WashingtonCap), R.drawable.washington);
                case 3:
                    return FragmentViewPager.newInstance(getString(R.string.Anaheim), R.drawable.anaheim);
                case 4:
                    return FragmentViewPager.newInstance(getString(R.string.Arizona), R.drawable.arizona);
               case 5:
                    return FragmentViewPager.newInstance(getString(R.string.Calgary), R.drawable.calgary);
                case 6:
                    return FragmentViewPager.newInstance(getString(R.string.Edmonton), R.drawable.oilers);
                case 7:
                    return FragmentViewPager.newInstance(getString(R.string.LosAngeles), R.drawable.la);
                case 8:
                    return FragmentViewPager.newInstance(getString(R.string.SanJose), R.drawable.sharks);
                case 9:
                    return FragmentViewPager.newInstance(getString(R.string.Vancouver), R.drawable.vancouver);
                case 10:
                    return FragmentViewPager.newInstance(getString(R.string.Vegas), R.drawable.vegas);
                case 11:
                    return FragmentViewPager.newInstance(getString(R.string.Chicago), R.drawable.chicago);
                case 12:
                    return FragmentViewPager.newInstance(getString(R.string.Colorado), R.drawable.colorado);
                case 13:
                    return FragmentViewPager.newInstance(getString(R.string.Minnesota), R.drawable.minnessota);
                case 14:
                    return FragmentViewPager.newInstance(getString(R.string.Nashville), R.drawable.nashvill);
                case 15:
                    return FragmentViewPager.newInstance(getString(R.string.Blues), R.drawable.blues);
                case 16:
                    return FragmentViewPager.newInstance(getString(R.string.Winnipeg), R.drawable.winnipeg);
                case 17:
                    return FragmentViewPager.newInstance(getString(R.string.Boston), R.drawable.boston);
                case 18:
                    return FragmentViewPager.newInstance(getString(R.string.Buffalo), R.drawable.buffalo);
                case 19:
                    return FragmentViewPager.newInstance(getString(R.string.Florida), R.drawable.florida);
                case 20:
                    return FragmentViewPager.newInstance(getString(R.string.Montreal), R.drawable.monreal);
                case 21:
                    return FragmentViewPager.newInstance(getString(R.string.Ottawa), R.drawable.ottawa);
                case 22:
                    return FragmentViewPager.newInstance(getString(R.string.TampaBay), R.drawable.tampa);
                case 23:
                    return FragmentViewPager.newInstance(getString(R.string.Toronto), R.drawable.toronto);
                case 24:
                    return FragmentViewPager.newInstance(getString(R.string.Carolina), R.drawable.carolina);
                case 25:
                    return FragmentViewPager.newInstance(getString(R.string.Columbus), R.drawable.colambus);
                case 26:
                    return FragmentViewPager.newInstance(getString(R.string.NewJersey), R.drawable.devils);
                case 27:
                    return FragmentViewPager.newInstance(getString(R.string.Islanders), R.drawable.islanders);
                case 28:
                    return FragmentViewPager.newInstance(getString(R.string.Philadelphia), R.drawable.filadelfia);
                case 29:
                    return FragmentViewPager.newInstance(getString(R.string.Pittsburgh), R.drawable.pitsburg);



            }
        }


        @Override
        public int getCount() {
            return 30;
        }

    }
}
