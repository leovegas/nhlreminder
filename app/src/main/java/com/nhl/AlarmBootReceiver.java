package com.nhl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;


public class AlarmBootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_BOOT_COMPLETED) || action.equals(Intent.ACTION_LOCKED_BOOT_COMPLETED)) {

            Intent startServiceIntent = new Intent(context, MessageService.class); //put alarms after reboot
            context.startService(startServiceIntent);

            Toast.makeText(context, "Alarms succesfully has been set!", Toast.LENGTH_LONG).show();
            Toast.makeText(context, "Alarms succesfully has been set!", Toast.LENGTH_LONG).show();
            Toast.makeText(context, "Alarms succesfully has been set!", Toast.LENGTH_LONG).show();
            Toast.makeText(context, "Alarms succesfully has been set!", Toast.LENGTH_LONG).show();

        }
        }

}