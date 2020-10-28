package com.nhl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
      /*  if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)) {
            Intent startServiceIntent = new Intent(context, MessageService.class);
            context.startService(startServiceIntent);
            Toast.makeText(context, "Boot Complete.", Toast.LENGTH_LONG).show();
        }

       */
    }

}