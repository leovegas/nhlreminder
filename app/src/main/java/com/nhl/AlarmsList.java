package com.nhl;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

public class AlarmsList extends AppCompatActivity {
    public static TextView text;
    public static TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarms_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        text = (TextView) findViewById(R.id.textView);
        text2 = (TextView) findViewById(R.id.textView2);

        text.setText("");
        for(int i=0;i<MainActivity.textboofer.size();i++){
            text.append(MainActivity.textboofer.get(i));
            text.append(" \n");
        }
        text2.setText("");
        for(int i=0;i<NotificationHelper.textboofer2.size();i++){
            text2.append(String.valueOf(NotificationHelper.textboofer2.get(i)));
            text2.append(" \n");
        }


        Intent startServiceIntent = new Intent(getApplicationContext(), MessageService.class);
        getApplicationContext().startService(startServiceIntent);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
