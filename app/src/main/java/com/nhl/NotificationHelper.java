package com.nhl;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.*;

import static android.content.Context.ALARM_SERVICE;
import static java.lang.Math.random;

/**
 * Created by ptyagi on 4/17/17.
 */

public class NotificationHelper {
    private static final int DAILY_REMINDER_REQUEST_CODE = 103 ;
    public static int ALARM_TYPE_RTC = 100;
    private static AlarmManager alarmManagerRTC;
    private static PendingIntent alarmIntentRTC1,alarmIntentRTC2,alarmIntentRTC3,alarmIntentRTC4,alarmIntentRTC5,alarmIntentRTC6,alarmIntentRTC7,alarmIntentRTC8,alarmIntentRTC9,alarmIntentRTC10;
    private static PendingIntent alarmIntentRTC11,alarmIntentRTC12,alarmIntentRTC13,alarmIntentRTC14,alarmIntentRTC15;
    public static ArrayList<PendingIntent> pendings = new ArrayList<PendingIntent>();
    public static int ALARM_TYPE_ELAPSED = 101;
    private static AlarmManager alarmManagerElapsed;
    private static PendingIntent alarmIntentElapsed;
    public static String teamname;
    public static Map<String, String> dateandteam = new HashMap<>();
    public static Map<String, String> dateandalarm = new HashMap<>();
    public static Map<String, String> dateandfavteam = new HashMap<>();
    public static Map<String, String> dateandrow = new HashMap<>();
    public static ArrayList<String> times = new ArrayList<String>();

    public static int millisec=15000;


    public static ArrayList<Integer> reqcode = new ArrayList<Integer>();
    public static ArrayList<HashMap> textboofer2= new ArrayList<HashMap>();


    /**
     * This is the real time /wall clock time
     * @param context
     */
    public static void scheduleRepeatingRTCNotification(Context context,int year, int month, int day, int hour,int min, String teamname, int row, String favteam) {
        int index;
        int millisec=30000;
        boolean added=false;
        TinyDB tinyDB = new TinyDB(context);
        dateandteam=loadMap(context,"dateandteam");
        dateandalarm=loadMap(context,"dateandalarm");
        dateandfavteam=loadMap(context,"dateandfavteam");
        dateandrow=loadMap(context,"dateandrow");
        times = tinyDB.getListString("times");

        if (times.size()==0)        times.add(0,"0");

        if (times.size()>100) times.clear();



        for (int i=0;i<times.size();i++){
            if (times.get(i).equals(String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min))) {
                millisec=30000;
                added=true;
                tinyDB.putListString("times",times);
                System.out.println("alreade has same time");
                dateandteam.put("team"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88,teamname);
                dateandfavteam.put("favteam"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88,favteam);
                dateandrow.put("row"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88,String.valueOf(row));

                System.out.println(Integer.parseInt(dateandrow.get("row"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min))));
                System.out.println(dateandfavteam.get("favteam"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)));
                System.out.println(dateandteam.get("team"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)));
                break;

            } }
                if (!added){
                    millisec=15000;
                times.add(String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min));
                tinyDB.putListString("times",times);
                System.out.println("first time");
                dateandteam.put("team"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min),teamname);
                dateandfavteam.put("favteam"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min),favteam);
                dateandrow.put("row"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min),String.valueOf(row));
                System.out.println(Integer.parseInt(dateandrow.get("row"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min))));
                System.out.println(dateandfavteam.get("favteam"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)));
                System.out.println(dateandteam.get("team"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)));
            }



        System.out.println("times: "+times);
       // times.clear();
        System.out.println(times);
      // tinyDB.putListString("times",times);


        textboofer2.add((HashMap) dateandteam);

        saveMap(dateandrow,context,"dateandrow");
        saveMap(dateandteam,context,"dateandteam");
        saveMap(dateandfavteam,context,"dateandfavteam");


        //get calendar instance to be able to select what time notification should be scheduled
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);

        c.set(Calendar.MONTH, month-1);

        c.set(Calendar.DAY_OF_MONTH, day);

        c.set(Calendar.HOUR_OF_DAY, hour);

        c.set(Calendar.MINUTE, min);

        c.set(Calendar.SECOND, 40);
        long firstTime = c.getTimeInMillis()-millisec; //30 min


       // cancelAlarmRTC();
        //Setting time of the day (8am here) when notification will be sent every day (default)

        //Setting intent to class where Alarm broadcast message will be handled
        Intent intent = new Intent(context, AlarmReceiver.class);
        reqcode=tinyDB.getListInt("reqcode"); //23456789
        if (reqcode.isEmpty()) {
            for (index = 1; index < 500; index++) {
                reqcode.add(index);
            }
            tinyDB.putListInt("reqcode", reqcode);

        }
       // reqcode.clear();
       // tinyDB.putListInt("reqcode", reqcode);

        for (int i=0;i<reqcode.size();i++){
            pendings.add(PendingIntent.getBroadcast(context, reqcode.get(i), intent, PendingIntent.FLAG_UPDATE_CURRENT));

        }

        alarmManagerRTC = (AlarmManager)context.getSystemService(ALARM_SERVICE);

        for (int i=0;i<15;i++){
           if (row==i) {
               alarmManagerRTC.set(AlarmManager.RTC_WAKEUP, firstTime, pendings.get(0));//PendingIntent.getBroadcast(context, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT)

               if (added) dateandalarm.put("alarm"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min)+88,String.valueOf(reqcode.get(0)));
else                dateandalarm.put("alarm"+String.valueOf(year)+String.valueOf(month)+String.valueOf(day)+String.valueOf(hour)+String.valueOf(min),String.valueOf(reqcode.get(0))); //2


               pendings.remove(0); //PendingIntent.getBroadcast(context, 2, intent, PendingIntent.FLAG_UPDATE_CURRENT)
               reqcode.remove(0);  //del 1 2
               tinyDB.putListInt("reqcode", reqcode);
               saveMap(dateandalarm,context,"dateandalarm");

           }
        }

        //getting instance of AlarmManager service

        //Setting alarm to wake up device every day for clock time.
        //AlarmManager.RTC_WAKEUP is responsible to wake up device for sure, which may not be good practice all the time.
        // Use this when you know what you're doing.
        //Use RTC when you don't need to wake up device, but want to deliver the notification whenever device is woke-up
        //We'll be using RTC.WAKEUP for demo purpose only


    }
    public static void put(Context context,ArrayList<String> times){
        TinyDB tinyDB = new TinyDB(context);
        tinyDB.putListString("times",times);
    }
    public static ArrayList<String> get(Context context){
        TinyDB tinyDB = new TinyDB(context);
        return tinyDB.getListString("times");
    }


    public static void saveMap(Map<String,String> inputMap,Context context,String nameid){
        SharedPreferences pSharedPref = context.getSharedPreferences(nameid, Context.MODE_PRIVATE);
        if (pSharedPref != null){
            JSONObject jsonObject = new JSONObject(inputMap);
            String jsonString = jsonObject.toString();
            SharedPreferences.Editor editor = pSharedPref.edit();
            editor.remove("My_map").commit();
            editor.putString("My_map", jsonString);
            editor.commit();
        }
    }

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

    /***
     * This is another way to schedule notifications using the elapsed time.
     * Its based on the relative time since device was booted up.
     * @param context
     */
    public static void scheduleRepeatingElapsedNotification(Context context) {
        //Setting intent to class where notification will be handled
        Intent intent = new Intent(context, AlarmReceiver.class);

        //Setting pending intent to respond to broadcast sent by AlarmManager everyday at 8am
        alarmIntentElapsed = PendingIntent.getBroadcast(context, ALARM_TYPE_ELAPSED, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //getting instance of AlarmManager service
        alarmManagerElapsed = (AlarmManager)context.getSystemService(ALARM_SERVICE);

        //Inexact alarm everyday since device is booted up. This is a better choice and
        //scales well when device time settings/locale is changed
        //We're setting alarm to fire notification after 15 minutes, and every 15 minutes there on
        alarmManagerElapsed.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
                SystemClock.elapsedRealtime() + AlarmManager.INTERVAL_FIFTEEN_MINUTES,
                AlarmManager.INTERVAL_FIFTEEN_MINUTES, alarmIntentElapsed);
    }


    public static void cancelAlarmRTC(PendingIntent alarmIntentRTC) {
        if (alarmManagerRTC!= null) {
            alarmManagerRTC.cancel(alarmIntentRTC);
        }
    }

    public static void cancelAlarmElapsed() {
        if (alarmManagerElapsed!= null) {
            alarmManagerElapsed.cancel(alarmIntentElapsed);
        }
    }

    public static NotificationManager getNotificationManager(Context context) {
        return (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    /**
     * Enable boot receiver to persist alarms set for notifications across device reboots
     */
    public static void enableBootReceiver(Context context) {
        ComponentName receiver = new ComponentName(context, AlarmBootReceiver.class);
        PackageManager pm = context.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    /**
     * Disable boot receiver when user cancels/opt-out from notifications
     */
    public static void disableBootReceiver(Context context) {
        ComponentName receiver = new ComponentName(context, AlarmBootReceiver.class);
        PackageManager pm = context.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }
}