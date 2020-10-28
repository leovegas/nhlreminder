package com.nhl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ListActivity extends AppCompatActivity {
public static Button but;
 public static SharedPreferences sp;
 public static ImageView image1;
 Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        TableRow row1 = (TableRow) findViewById(R.id.row100);
        TableRow row2 = (TableRow) findViewById(R.id.row101);
        TableRow row3 = (TableRow) findViewById(R.id.row102);
        TableRow row4 = (TableRow) findViewById(R.id.row103);
        TableRow row5 = (TableRow) findViewById(R.id.row104);
        TableRow row6 = (TableRow) findViewById(R.id.row105);
        TableRow row7 = (TableRow) findViewById(R.id.row106);
        TableRow row8 = (TableRow) findViewById(R.id.row107);
        TableRow row9 = (TableRow) findViewById(R.id.row108);
        TableRow row10 = (TableRow) findViewById(R.id.row109);
        TableRow row11 = (TableRow) findViewById(R.id.row110);
        TableRow row12 = (TableRow) findViewById(R.id.row111);
        TableRow row13 = (TableRow) findViewById(R.id.row112);
        TableRow row14 = (TableRow) findViewById(R.id.row113);
        TableRow row15 = (TableRow) findViewById(R.id.row114);
        TableRow row16 = (TableRow) findViewById(R.id.row115);
        TableRow row17 = (TableRow) findViewById(R.id.row116);
        TableRow row18 = (TableRow) findViewById(R.id.row117);
        TableRow row19 = (TableRow) findViewById(R.id.row118);
        TableRow row20 = (TableRow) findViewById(R.id.row119);
        TableRow row21 = (TableRow) findViewById(R.id.row120);
        TableRow row22 = (TableRow) findViewById(R.id.row121);
        TableRow row23 = (TableRow) findViewById(R.id.row122);
        TableRow row24 = (TableRow) findViewById(R.id.row123);
        TableRow row25 = (TableRow) findViewById(R.id.row124);
        TableRow row26 = (TableRow) findViewById(R.id.row125);
        TableRow row27 = (TableRow) findViewById(R.id.row126);
        TableRow row28 = (TableRow) findViewById(R.id.row127);
        TableRow row29 = (TableRow) findViewById(R.id.row128);
        TableRow row30 = (TableRow) findViewById(R.id.row129);
        TableRow row31 = (TableRow) findViewById(R.id.row130);




        row1.setClickable(true);
                row2.setClickable(true);
        row3.setClickable(true);
                row4.setClickable(true);
        row5.setClickable(true);
                row6.setClickable(true);
        row7.setClickable(true);
                row8.setClickable(true);
        row9.setClickable(true);
                row10.setClickable(true);
        row11.setClickable(true);
                row12.setClickable(true);
        row13.setClickable(true);
                row14.setClickable(true);
        row15.setClickable(true);
                row16.setClickable(true);
        row17.setClickable(true);
                row18.setClickable(true);
        row19.setClickable(true);
                row20.setClickable(true);
        row21.setClickable(true);
                row22.setClickable(true);
        row23.setClickable(true);
                row24.setClickable(true);
        row25.setClickable(true);
                row26.setClickable(true);
        row27.setClickable(true);
                row28.setClickable(true);
        row29.setClickable(true);
                row30.setClickable(true);
        row31.setClickable(true);

                but = (Button) findViewById(R.id.button);
        Button but2 = (Button) findViewById(R.id.button1);




        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });


        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });



        row1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));
                MainActivity.FavTeam="New York Rangers";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });

        row2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Vegas Golden Knights";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row3.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Toronto Maple Leafs";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                row4.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Tampa Bay Lightning";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row5.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Vancouver Canucks";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row6.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Washington Capitals";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row7.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Minnesota Wild";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row8.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Columbus Blue Jackets";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row9.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Ottawa Senators";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row10.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Pittsburgh Penguins";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row11.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Philadelphia Flyers";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });

        row12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row12.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Arizona Coyotes";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row13.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="San Jose Sharks";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row14.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="St. Louis Blues";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row15.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Florida Panthers";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row16.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Montreal Canadiens";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row17.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Nashville Predators";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row18.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="New Jersey Devils";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row19.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="New York Islanders";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row20.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Los Angeles Kings";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row21.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Winnipeg Jets";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row22.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Buffalo Sabres";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row23.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Boston Bruins";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row24.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Calgary Flames";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row25.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Carolina Hurricanes";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row26.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Chicago Blackhawks";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row27.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Colorado Avalanche";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row28.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Dallas Stars";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row29.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Detroit Red Wings";
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row30.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Edmonton Oilers";
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
        row31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row31.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));
                MainActivity.FavTeam="Anaheim Ducks";

                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }






}
