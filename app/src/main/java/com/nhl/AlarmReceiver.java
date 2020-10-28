package com.nhl;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.*;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import org.json.JSONObject;

import java.util.*;

public class AlarmReceiver extends BroadcastReceiver {

    private static Map<String, String> dateandteam = new HashMap<>();
    private static Map<String, String> dateandalarm = new HashMap<>();
    private static Map<String, String> dateandfavteam = new HashMap<>();
    private static Map<String, String> dateandrow = new HashMap<>();


    public static Map<String,String> loadMap(Context context,String nameid){
        Map<String,String> outputMap = new HashMap<String,String>();
        SharedPreferences pSharedPref = context.getSharedPreferences(nameid, Context.MODE_PRIVATE);
        try{
            if (pSharedPref != null){
                String jsonString = pSharedPref.getString("My_map", (new JSONObject()).toString());
                JSONObject jsonObject = new JSONObject(jsonString);
                Iterator<String> keysItr = jsonObject.keys();
                while(keysItr.hasNext()) {
                    String key = keysItr.next();
                    String value = (String) jsonObject.get(key);
                    outputMap.put(key, value);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return outputMap;
    }

    public void onReceive(Context context, Intent intent) {
        Calendar c = Calendar.getInstance();
        int yearnew=c.get(Calendar.YEAR);
        int monthnew= c.get(Calendar.MONTH)+1;
        int daynew= c.get(Calendar.DAY_OF_MONTH);
        int hournew= c.get(Calendar.HOUR_OF_DAY);
        int minnew= c.get(Calendar.MINUTE);

        long millisec = c.getTimeInMillis()+NotificationHelper.millisec; //30 min
        Calendar c2 = Calendar.getInstance();
        c2.setTimeInMillis(millisec);

        int year= c2.get(Calendar.YEAR);
        int month= c2.get(Calendar.MONTH)+1;
        int day= c2.get(Calendar.DAY_OF_MONTH);
        int hour= c2.get(Calendar.HOUR_OF_DAY);
        int min= c2.get(Calendar.MINUTE);

        int row=100;
        String[] string = new String[7];

        System.out.println("alarm reciever works!");

            dateandteam = NotificationHelper.loadMap(context, "dateandteam");
            dateandalarm = NotificationHelper.loadMap(context, "dateandalarm");
            dateandfavteam = NotificationHelper.loadMap(context, "dateandfavteam");
            dateandrow = NotificationHelper.loadMap(context, "dateandrow");
       // System.out.println(Integer.parseInt(dateandrow.get("row"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88)));
      //  System.out.println(dateandfavteam.get("favteam"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88));
       // System.out.println(dateandteam.get("team"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88));
      //  System.out.println(dateandalarm.get("alarm"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88));


        //dateandteam = NotificationHelper.dateandteam;
        //dateandalarm = NotificationHelper.dateandalarm;
        System.out.println(String.valueOf(year));
        System.out.println(String.valueOf(month));
        System.out.println(String.valueOf(day));
        System.out.println(String.valueOf(hour));
        System.out.println(String.valueOf(min));

        String teamname = dateandteam.get("team"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min));
        System.out.println(teamname);

        String id = dateandalarm.get("alarm"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min));
        System.out.println(id);
if (dateandteam.get("team"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min))!=null) {
    dateandalarm.remove("alarm" + String.valueOf(year) + String.valueOf(month) + String.valueOf(day) + String.valueOf(hour) + String.valueOf(min));
    dateandteam.remove("team" + String.valueOf(year) + String.valueOf(month) + String.valueOf(day) + String.valueOf(hour) + String.valueOf(min));

    row = Integer.parseInt(dateandrow.get("row" + String.valueOf(year) + String.valueOf(month) + String.valueOf(day) + String.valueOf(hour) + String.valueOf(min)));
    dateandrow.remove("row" + String.valueOf(year) + String.valueOf(month) + String.valueOf(day) + String.valueOf(hour) + String.valueOf(min));
    System.out.println(teamname);

}
        if (row==100) {
            row = Integer.parseInt(dateandrow.get("row"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88));
            dateandrow.remove("row"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88);
        }

        if (id==null) {
            id = dateandalarm.get("alarm"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88);
            dateandalarm.remove("alarm"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88);
            System.out.println(id);
        }

        if (teamname==null) {
            teamname = dateandteam.get("team"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88);
            dateandteam.remove("team"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88);
            System.out.println(id);

        }

        String Favteam = dateandfavteam.get("favteam"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min));
        dateandfavteam.remove("favteam"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min));
        System.out.println(id);



        if (Favteam==null) {
            Favteam = dateandfavteam.get("favteam"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88);
            System.out.println(id);
            dateandfavteam.remove("favteam"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88);
        }




        string= new String[]{String.valueOf(year), String.valueOf(month), String.valueOf(day), String.valueOf(hour), String.valueOf(min), teamname, String.valueOf(row)};
        System.out.println(Arrays.toString(string));

            for (int i=0;i<MainActivity.AlarmsBigList.size();i++)
                System.out.println("alarm rec1 "+ Arrays.toString(MainActivity.AlarmsBigList.get(i)));

            for (int i = 0; i < MainActivity.AlarmsBigList.size(); i++) {
                if (Arrays.toString(MainActivity.AlarmsBigList.get(i)).equals(Arrays.toString(string)))
                {
                    System.out.println("Remove in alarm list1"+Arrays.toString(MainActivity.AlarmsBigList.get(i)));

                    MainActivity.AlarmsBigList.remove(i);
                }
                MainActivity.saveBigList(context);
            }
            for (int i = 0; i < MainActivity.alarmlist.size(); i++) {

                if (Arrays.toString(MainActivity.alarmlist.get(i)).equals(Arrays.toString(string)))
                    MainActivity.alarmlist.remove(i);
            }


        for (int i=0;i<MainActivity.AlarmsBigList.size();i++)
            System.out.println("alarm rec2 "+ Arrays.toString(MainActivity.AlarmsBigList.get(i)));


        NotificationHelper.saveMap(dateandteam,context,"dateandteam");
        NotificationHelper.saveMap(dateandfavteam,context,"dateandfavteam");
        NotificationHelper.saveMap(dateandrow,context,"dateandrow");
        NotificationHelper.saveMap(dateandalarm,context,"dateandalarm");



        int req = (int) Integer.parseInt(id);
        System.out.println("req "+req);
        String h=String.valueOf(hour);
        String m=String.valueOf(min);

        if (String.valueOf(hour).length()==1) h="0"+String.valueOf(hour);
        if (String.valueOf(min).length()==1) m="0"+String.valueOf(min);

        new Task(context).createNotification(Favteam,teamname,h+":"+m,req);

        NotificationHelper.cancelAlarmRTC(PendingIntent.getBroadcast(context, req, intent, PendingIntent.FLAG_UPDATE_CURRENT));

        Toast.makeText(context, "Attention please...", Toast.LENGTH_LONG).show();
    }
}