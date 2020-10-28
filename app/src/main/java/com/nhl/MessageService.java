package com.nhl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MessageService extends Service {
    public static PendingIntent pendingIntent = null;
    Context context;

    private void serviceMessageStart() {


        if (MainActivity.alarmlist.size()>0){
            MainActivity.saveBigList(MessageService.this);
            Toast.makeText(MessageService.this, "Alerts are added.", Toast.LENGTH_LONG).show();

            MainActivity.saveAlarmList(MessageService.this);
        } // save all alarms
            MainActivity.getAlarmList(MessageService.this); //put alarms



    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();

      //  Toast.makeText(MessageService.this, "Boot Complete service 1.", Toast.LENGTH_LONG).show();
      //  NotificationHelper.scheduleRepeatingRTCNotification(MessageService.this,2019,10,17,11,30,"fffff",11);

    }

    public void onDestroy() {
        super.onDestroy();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
     //   Toast.makeText(MessageService.this, "Boot Complete service 2.", Toast.LENGTH_LONG).show();
       // NotificationHelper.scheduleRepeatingRTCNotification(MessageService.this,2019,10,17,11,31,"fffff",11);
        serviceMessageStart(); //start service

      //  new Task(MessageService.this).createNotification("gerwgwer","22:22");
        return super.onStartCommand(intent, flags, startId);
    }
}