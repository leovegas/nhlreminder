package com.nhl;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.StrictMode;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task extends AsyncTask<Void, Integer, Void> {

    Elements test=null;
    ArrayList<String> list = new ArrayList<String>();
    private ArrayList<String> listEng = new ArrayList<String>();
    ArrayList<String> hometeam = new ArrayList<String>();
    ArrayList<String> guestteam = new ArrayList<String>();
    ArrayList<String> timeM = new ArrayList<String>();
    public static ArrayList<String> onEngT = new ArrayList<String>();
    public static ArrayList<String> onRusT = new ArrayList<String>();
    int day,month,year,hour;
    public TimeZone tz;
    public static final String CHANNEL_ID = "my app";
    PendingIntent pendingIntent;
    private NotificationManagerCompat notificationManager;
    private Context mContext;
    public long TimeNow;
    Date TimeNow1;
    java.util.Calendar c2;

    Task(Context mContext) {
        this.mContext = mContext;
    }

    public static void setalarms(Context context){

    }




    public void createNotificationChannel(String chid) {

        NotificationManager notificationManager = (NotificationManager) mContext.getApplicationContext().getSystemService(mContext.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(chid, "My channel",
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("My channel description");
            channel.enableLights(true);
            channel.enableVibration(false);
            notificationManager.createNotificationChannel(channel);

        }
    }


    public void createNotification(String favteam,String team, String time,int myid) {
        Intent intent = new Intent(mContext, starta.class);
        new IntentFilter(Intent.ACTION_SCREEN_ON);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        pendingIntent = PendingIntent.getActivity(mContext, 0, intent, 0);

        createNotificationChannel(String.valueOf(myid));
        NotificationCompat.Builder builder;
        builder = new NotificationCompat.Builder(this.mContext.getApplicationContext(), String.valueOf(myid))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(favteam+" vs "+team)
                .setContentText("The game will begin at "+time)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setOngoing(true)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
        notificationManager = NotificationManagerCompat.from(mContext);
        notificationManager.notify(myid, builder.build());
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        onEngT.add("0"); onRusT.add("0");
        onEngT.add("Anaheim Ducks");   onRusT.add("Анахайм");
        onEngT.add("Winnipeg Jets");   onRusT.add("Виннипег");
        onEngT.add("Boston Bruins");onRusT.add("Бостон");
        onEngT.add("Buffalo Sabres");onRusT.add("Баффало");
        onEngT.add("Calgary Flames");onRusT.add("Калгари");
        onEngT.add("Carolina Hurricanes");onRusT.add("Каролина");
        onEngT.add("Chicago Blackhawks");onRusT.add("Чикаго");
        onEngT.add("Colorado Avalanche");onRusT.add("Колорадо");
        onEngT.add("Dallas Stars");onRusT.add("Даллас");
        onEngT.add("Detroit Red Wings");onRusT.add("Детройт");
        onEngT.add("Edmonton Oilers");onRusT.add("Эдмонтон");
        onEngT.add("Florida Panthers");onRusT.add("Флорида");
        onEngT.add("Montreal Canadiens");onRusT.add("Монреаль");
        onEngT.add("Nashville Predators");onRusT.add("Нэшвилл");
        onEngT.add("New Jersey Devils");onRusT.add("Нью-Джерси");
        onEngT.add("New York Rangers");onRusT.add("Рейнджерс");
        onEngT.add("New York Islanders");onRusT.add("Айлендерс");
        onEngT.add("Los Angeles Kings");onRusT.add("Лос-Анджелес");
        onEngT.add("Ottawa Senators");onRusT.add("Оттава");
        onEngT.add("Pittsburgh Penguins");onRusT.add("Питтсбург");
        onEngT.add("Philadelphia Flyers");onRusT.add("Филадельфия");
        onEngT.add("Arizona Coyotes");onRusT.add("Аризона");
        onEngT.add("San Jose Sharks");onRusT.add("Сан-Хосе");
        onEngT.add("St. Louis Blues");onRusT.add("Сент-Луис");
        onEngT.add("Toronto Maple Leafs");onRusT.add("Торонто");
        onEngT.add("Tampa Bay Lightning");onRusT.add("Тампа-Бэй");
        onEngT.add("Vancouver Canucks");onRusT.add("Ванкувер");
        onEngT.add("Washington Capitals");onRusT.add("Вашингтон");
        onEngT.add("Minnesota Wild");onRusT.add("Миннесота");
        onEngT.add("Columbus Blue Jackets");onRusT.add("Коламбус");
        onEngT.add("Vegas Golden Knights");onRusT.add("Вегас");

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        final Calendar c;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            c = Calendar.getInstance();
            hour = c.get(Calendar.HOUR_OF_DAY);
            month = c.get(android.icu.util.Calendar.MONTH);
            year = c.get(Calendar.YEAR);
            day = c.get(Calendar.DAY_OF_MONTH);
            tz = c.getTimeZone();
        }
        c2 = java.util.Calendar.getInstance();
        c2.set(java.util.Calendar.YEAR, year);

        c2.set(java.util.Calendar.MONTH, month);

        c2.set(java.util.Calendar.DAY_OF_MONTH, day);

        c2.set(java.util.Calendar.HOUR_OF_DAY, hour);

        Date TimeNow1 = c2.getTime();


        //Тут храним значение заголовка сайта
    }

    public static void enableSSLSocket() {
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });

        SSLContext context = null;
        try {
            context = SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("ssl error 1");
            e.printStackTrace();
        }
        try {
            context.init(null, new X509TrustManager[]{new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new SecureRandom());
        } catch (KeyManagementException e) {
            System.out.println("ssl error 2");
            e.printStackTrace();
        }
        HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
        //-------------------------------------------------------------
    }
    private static String findstring(String text){
        Pattern pattern1 = Pattern.compile("\\d{4}\\D\\d{4}");
        Pattern pattern2 = Pattern.compile("\\d{3}\\D\\d{3}");
        Pattern pattern3 = Pattern.compile("\\d{2}\\D\\d{2}");
        Pattern pattern4 = Pattern.compile("\\d{1}\\D\\d{1}");

        Matcher matcher1 = pattern1.matcher(text);
        Matcher matcher2 = pattern2.matcher(text);
        Matcher matcher3 = pattern3.matcher(text);
        Matcher matcher4 = pattern4.matcher(text);

        if (matcher1.find()) {return matcher1.group();} else
        if (matcher2.find()) {return matcher2.group();} else
        if (matcher3.find()) {return matcher3.group();} else
        if (matcher4.find()) {return matcher4.group();} else
            return null;
    }
    public static String toLocalTime(String timetext, TimeZone tz, int year, int month, int day){

        OffsetDateTime parsed = null;


        if (String.valueOf(day).length()==1&&String.valueOf(month).length()==2) {
             parsed = LocalDateTime.parse(year + "-" + month + "-" + "0" + day + "T" + timetext)
                    .atOffset(ZoneOffset.ofHours(3));
        }

        if (String.valueOf(month).length()==1&&String.valueOf(day).length()==2) {
             parsed = LocalDateTime.parse(year + "-" + "0"+month + "-" + day + "T" + timetext)
                    .atOffset(ZoneOffset.ofHours(3));
        }
        if (String.valueOf(month).length()==1&&String.valueOf(day).length()==1) {
             parsed = LocalDateTime.parse(year + "-" + "0"+month + "-" + "0" + day + "T" + timetext)
                    .atOffset(ZoneOffset.ofHours(3));
        }


        if (String.valueOf(month).length()==2&&String.valueOf(day).length()==2) {
            parsed = LocalDateTime.parse(year+"-"+month+"-"+day+"T"+timetext)
                    // convert to UTC
                    .atOffset(ZoneOffset.ofHours(3));
        }


        ZoneId zone = ZoneId.of(tz.getID());
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm");

            return outputFormatter.format(parsed.atZoneSameInstant(zone));
    }
    //-----------------------------------------------
    public String dateformatUS(Date olddate){

        String pattern = "dd-MMM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(olddate.getTime());
return date;
    }



    //-------------------------------------------------------
    private static Elements Parser(String url){
        Elements li=null;
        Connection.Response res=null;
        Document doc = null;
        Element temp=null;
        final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";


       // enableSSLSocket();
        try {
            res = Jsoup.connect(url)
                    .ignoreContentType(true)
                    .userAgent(USER_AGENT)
                    .method(Connection.Method.POST)
                    .timeout(10000)
                    .execute();
        } catch (IOException e) {
            //Если не получилось считать
            System.out.println("error 1");
            return null;
        }
        try {
            if (res != null) {
                doc = res.parse();
            }

        } catch (IOException e) {
            System.out.println("error 2");
            e.printStackTrace();
            return null;

        }
        if (doc!=null) {
            temp = doc.body();

            li = doc.select("td.h1");
        }
        return li;
    }
    //-------------------------------------------------------




    //--------------------------------------------
    @Override
    protected Void doInBackground(Void... params) {


        test = Parser(MainActivity.URL);

        return null;
    }

    public String changedate(String date) {
        int limit;
        if (Integer.parseInt(date.substring(3,5))==1||Integer.parseInt(date.substring(3,5))==3||Integer.parseInt(date.substring(3,5))==5||Integer.parseInt(date.substring(3,5))==7||Integer.parseInt(date.substring(3,5))==8||Integer.parseInt(date.substring(3,5))==10||Integer.parseInt(date.substring(3,5))==12){
            limit=31;}
        else limit=30;
        if (Integer.parseInt(date.substring(3,5))==2) limit=29;
String resultdate = (Integer.parseInt(date.substring(0,2))+1)+date.substring(2);
if (resultdate.substring(0,2).contains(".")) resultdate="0"+resultdate;


if (Integer.parseInt(resultdate.substring(0,2))>limit&&Integer.parseInt(date.substring(3,5))==12){
            resultdate="01."+"01"+"."+(Integer.parseInt(date.substring(6))+1);
        }

        if (Integer.parseInt(resultdate.substring(0,2))>limit){
    resultdate="01."+(Integer.parseInt(date.substring(3,5))+1)+resultdate.substring(5);
}

        if (resultdate.substring(3,5).contains(".")) resultdate=resultdate.substring(0,3)+"0"+resultdate.substring(3,5)+resultdate.substring(5);
        return resultdate;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
        //MainActivity.alert1.setVisibility(View.VISIBLE);
        MainActivity.row1.setVisibility(View.GONE);
        MainActivity.row2.setVisibility(View.GONE);
        MainActivity.row3.setVisibility(View.GONE);
        MainActivity.row4.setVisibility(View.GONE);
        MainActivity.row5.setVisibility(View.GONE);
        MainActivity.row6.setVisibility(View.GONE);
        MainActivity.row7.setVisibility(View.GONE);
        MainActivity.row8.setVisibility(View.GONE);
        MainActivity.row9.setVisibility(View.GONE);
        MainActivity.row10.setVisibility(View.GONE);
        MainActivity.row11.setVisibility(View.GONE);
        MainActivity.row12.setVisibility(View.GONE);
        MainActivity.row13.setVisibility(View.GONE);
        MainActivity.row14.setVisibility(View.GONE);
        MainActivity.row15.setVisibility(View.GONE);

        MainActivity.scoreshome.clear();
MainActivity.scoresguest.clear();
        listEng.clear();
list.clear();
hometeam.clear();
for (int i=0;i<test.size();i++){
            if ((test.get(i).text().contains(".2019")||test.get(i).text().contains(".2020"))&&test.get(i).text().length()==10) {

                list.add(test.get(i).text());
                if (!test.get(i).nextElementSibling().text().equals(MainActivity.FavTeamP)){
                hometeam.add(test.get(i).nextElementSibling().text());
                String text = test.get(i).nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().text();
                    for (int j=0;j<text.length();j++){
                        if (text.charAt(j)==' ') {
                            text=text.substring(0,j);}
                    }
                for (int j=0;j<text.length();j++){
                    if (text.charAt(j)==':') {

                        MainActivity.scoreshome.add(Integer.parseInt(text.substring(j+1)));
                        MainActivity.scoresguest.add(Integer.parseInt(text.substring(0,j)));
                    }
                }


                }
                else guestteam.add("Yes");
                if (!test.get(i).nextElementSibling().nextElementSibling().text().equals(MainActivity.FavTeamP)){
               hometeam.add(test.get(i).nextElementSibling().nextElementSibling().text());
                    String text = test.get(i).nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().text();
                    for (int j=0;j<text.length();j++){
                        if (text.charAt(j)==' ') {
                            text=text.substring(0,j);}
                    }

                    for (int j=0;j<text.length();j++){
                        if (text.charAt(j)==':') {

                            MainActivity.scoresguest.add(Integer.parseInt(text.substring(j+1)));
                            MainActivity.scoreshome.add(Integer.parseInt(text.substring(0,j)));
                        }
                    }

                }
                else guestteam.add("No");
                timeM.add(test.get(i).nextElementSibling().nextElementSibling().nextElementSibling().nextElementSibling().text());
            }
        }
        for (int i=0;i<hometeam.size();i++){
            for(int j=1;j<onRusT.size();j++){
                if (hometeam.get(i).equals(onRusT.get(j))) {
                    listEng.add(onEngT.get(j));
                    break;
                }
            }

        }


int i=0;

     if (i<=listEng.size()-1) {  MainActivity.homet1.setText(listEng.get(0)); MainActivity.row1.setVisibility(View.VISIBLE); i++;}
        if (i<=listEng.size()-1) {  MainActivity.homet2.setText(listEng.get(1)); MainActivity.row2.setVisibility(View.VISIBLE);i++;}
            if (i<=listEng.size()-1) { MainActivity.homet3.setText(listEng.get(2));MainActivity.row3.setVisibility(View.VISIBLE);i++;}
                if (i<=listEng.size()-1) {  MainActivity.homet4.setText(listEng.get(3));MainActivity.row4.setVisibility(View.VISIBLE);i++;}
                    if (i<=listEng.size()-1) {  MainActivity.homet5.setText(listEng.get(4));MainActivity.row5.setVisibility(View.VISIBLE);i++;}
                        if (i<=listEng.size()-1) {  MainActivity.homet6.setText(listEng.get(5));MainActivity.row6.setVisibility(View.VISIBLE);i++;}
                            if (i<=listEng.size()-1) {   MainActivity.homet7.setText(listEng.get(6));MainActivity.row7.setVisibility(View.VISIBLE);i++;}
                                if (i<=listEng.size()-1) {  MainActivity.homet8.setText(listEng.get(7));MainActivity.row8.setVisibility(View.VISIBLE);i++;}
                                    if (i<=listEng.size()-1) {  MainActivity.homet9.setText(listEng.get(8));MainActivity.row9.setVisibility(View.VISIBLE);i++;}
                                        if (i<=listEng.size()-1) {   MainActivity.homet10.setText(listEng.get(9));MainActivity.row10.setVisibility(View.VISIBLE);i++;}
                                            if (i<=listEng.size()-1) {  MainActivity.homet11.setText(listEng.get(10));MainActivity.row11.setVisibility(View.VISIBLE);i++;}
                                                if (i<=listEng.size()-1) {  MainActivity.homet12.setText(listEng.get(11));MainActivity.row12.setVisibility(View.VISIBLE);i++;}
                                                    if (i<=listEng.size()-1) {   MainActivity.homet13.setText(listEng.get(12));MainActivity.row13.setVisibility(View.VISIBLE);i++;}
                                                        if (i<=listEng.size()-1) {  MainActivity.homet14.setText(listEng.get(13));MainActivity.row14.setVisibility(View.VISIBLE);i++;}
                                                            if (i<=listEng.size()-1) {  MainActivity.homet15.setText(listEng.get(14));MainActivity.row15.setVisibility(View.VISIBLE);}
i=0;
        if (i<=timeM.size()-1)  { MainActivity.time1.setText(toLocalTime(timeM.get(0),tz,year,month,day));
        if (Integer.parseInt(toLocalTime(timeM.get(0),tz,year,month,day).substring(0,2))<=8) {list.add(0,changedate(list.get(0))); list.remove(1);} i++;}
            if (i<=timeM.size()-1)  {  MainActivity.time2.setText(toLocalTime(timeM.get(1),tz,year,month,day));
                if (Integer.parseInt(toLocalTime(timeM.get(1),tz,year,month,day).substring(0,2))<=8) {list.add(1,changedate(list.get(1))); list.remove(2);}i++;}
                if (i<=timeM.size()-1)  { MainActivity.time3.setText(toLocalTime(timeM.get(2),tz,year,month,day));
                    if (Integer.parseInt(toLocalTime(timeM.get(2),tz,year,month,day).substring(0,2))<=8) {list.add(2,changedate(list.get(2))); list.remove(3);}i++;}
                    if (i<=timeM.size()-1)  { MainActivity.time4.setText(toLocalTime(timeM.get(3),tz,year,month,day));
                        if (Integer.parseInt(toLocalTime(timeM.get(3),tz,year,month,day).substring(0,2))<=8) {list.add(3,changedate(list.get(3))); list.remove(4);}i++;}
                        if (i<=timeM.size()-1)  { MainActivity.time5.setText(toLocalTime(timeM.get(4),tz,year,month,day));
                            if (Integer.parseInt(toLocalTime(timeM.get(4),tz,year,month,day).substring(0,2))<=8) {list.add(4,changedate(list.get(4))); list.remove(5);}i++;}
                            if (i<=timeM.size()-1)  { MainActivity.time6.setText(toLocalTime(timeM.get(5),tz,year,month,day));
                                if (Integer.parseInt(toLocalTime(timeM.get(5),tz,year,month,day).substring(0,2))<=8) {list.add(5,changedate(list.get(5))); list.remove(6);}i++;}
                              if (i<=timeM.size()-1)  { MainActivity.time7.setText(toLocalTime(timeM.get(6),tz,year,month,day));
                                  if (Integer.parseInt(toLocalTime(timeM.get(6),tz,year,month,day).substring(0,2))<=8) {list.add(6,changedate(list.get(6))); list.remove(7);}i++;}
                                 if (i<=timeM.size()-1)  {  MainActivity.time8.setText(toLocalTime(timeM.get(7),tz,year,month,day));
                                     if (Integer.parseInt(toLocalTime(timeM.get(7),tz,year,month,day).substring(0,2))<=8) {list.add(7,changedate(list.get(7))); list.remove(8);}i++;}
                                    if (i<=timeM.size()-1)  { MainActivity.time9.setText(toLocalTime(timeM.get(8),tz,year,month,day));
                                        if (Integer.parseInt(toLocalTime(timeM.get(8),tz,year,month,day).substring(0,2))<=8) {list.add(8,changedate(list.get(8))); list.remove(9);}i++;}
                                        if (i<=timeM.size()-1)  { MainActivity.time10.setText(toLocalTime(timeM.get(9),tz,year,month,day));
                                            if (Integer.parseInt(toLocalTime(timeM.get(9),tz,year,month,day).substring(0,2))<=8) {list.add(9,changedate(list.get(9))); list.remove(10);}i++;}
                                            if (i<=timeM.size()-1)  { MainActivity.time11.setText(toLocalTime(timeM.get(10),tz,year,month,day));
                                                if (Integer.parseInt(toLocalTime(timeM.get(10),tz,year,month,day).substring(0,2))<=8) {list.add(10,changedate(list.get(10))); list.remove(11);}i++;}
                                                if (i<=timeM.size()-1)  {  MainActivity.time12.setText(toLocalTime(timeM.get(11),tz,year,month,day));
                                                    if (Integer.parseInt(toLocalTime(timeM.get(11),tz,year,month,day).substring(0,2))<=8) {list.add(11,changedate(list.get(11))); list.remove(12);}i++;}
                                                    if (i<=timeM.size()-1)  { MainActivity.time13.setText(toLocalTime(timeM.get(12),tz,year,month,day));
                                                        if (Integer.parseInt(toLocalTime(timeM.get(12),tz,year,month,day).substring(0,2))<=8) {list.add(12,changedate(list.get(12))); list.remove(13);}i++;}
                                                        if (i<=timeM.size()-1)  { MainActivity.time14.setText(toLocalTime(timeM.get(13),tz,year,month,day));
                                                            if (Integer.parseInt(toLocalTime(timeM.get(13),tz,year,month,day).substring(0,2))<=8) {list.add(13,changedate(list.get(13))); list.remove(14);}i++;}
                                                            if (i<=timeM.size()-1)  { MainActivity.time15.setText(toLocalTime(timeM.get(14),tz,year,month,day));
                                                                if (Integer.parseInt(toLocalTime(timeM.get(14),tz,year,month,day).substring(0,2))<=8) {list.add(14,changedate(list.get(14))); list.remove(15);}}

        for (int j=0;j<guestteam.size();j++){
    if (j==0) {
         if (guestteam.get(j).equals("Yes"))  {   MainActivity.homeornot1.setImageResource(R.drawable.ic_home);
         System.out.println("ok1");
         }
        else {MainActivity.homeornot1.setImageResource(R.drawable.guests);         System.out.println("ok1");
         }
    }
    if (j==1) {
        if (guestteam.get(j).equals("Yes"))    { MainActivity.homeornot2.setImageResource(R.drawable.ic_home); System.out.println("ok2");}
        else {MainActivity.homeornot2.setImageResource(R.drawable.guests);          System.out.println("ok2");
        }
    }
    if (j==2) {
        if (guestteam.get(j).equals("Yes"))     MainActivity.homeornot3.setImageResource(R.drawable.ic_home);
        else MainActivity.homeornot3.setImageResource(R.drawable.guests);
    }
    if (j==3) {
        if (guestteam.get(j).equals("Yes"))     MainActivity.homeornot4.setImageResource(R.drawable.ic_home);
        else MainActivity.homeornot4.setImageResource(R.drawable.guests);
    }
    if (j==4) {
        if (guestteam.get(j).equals("Yes"))     MainActivity.homeornot5.setImageResource(R.drawable.ic_home);
        else MainActivity.homeornot5.setImageResource(R.drawable.guests);
    }
    if (j==5) {
        if (guestteam.get(j).equals("Yes"))     MainActivity.homeornot6.setImageResource(R.drawable.ic_home);
        else MainActivity.homeornot6.setImageResource(R.drawable.guests);
    }
    if (j==6) {
        if (guestteam.get(j).equals("Yes"))     MainActivity.homeornot7.setImageResource(R.drawable.ic_home);
        else MainActivity.homeornot7.setImageResource(R.drawable.guests);
    }
    if (j==7) {
        if (guestteam.get(j).equals("Yes"))     MainActivity.homeornot8.setImageResource(R.drawable.ic_home);
        else MainActivity.homeornot8.setImageResource(R.drawable.guests);
    }
    if (j==8) {
        if (guestteam.get(j).equals("Yes"))     MainActivity.homeornot9.setImageResource(R.drawable.ic_home);
        else MainActivity.homeornot9.setImageResource(R.drawable.guests);
    }
    if (j==9) {
        if (guestteam.get(j).equals("Yes"))     MainActivity.homeornot10.setImageResource(R.drawable.ic_home);
        else MainActivity.homeornot10.setImageResource(R.drawable.guests);
    }
    if (j==10) {
        if (guestteam.get(j).equals("Yes"))     MainActivity.homeornot11.setImageResource(R.drawable.ic_home);
        else MainActivity.homeornot11.setImageResource(R.drawable.guests);
    }
    if (j==11) {
        if (guestteam.get(j).equals("Yes"))     MainActivity.homeornot12.setImageResource(R.drawable.ic_home);
        else MainActivity.homeornot12.setImageResource(R.drawable.guests);
    }
    if (j==12) {
        if (guestteam.get(j).equals("Yes"))     MainActivity.homeornot13.setImageResource(R.drawable.ic_home);
        else MainActivity.homeornot13.setImageResource(R.drawable.guests);
    }
    if (j==13) {
        if (guestteam.get(j).equals("Yes"))     MainActivity.homeornot14.setImageResource(R.drawable.ic_home);
        else MainActivity.homeornot14.setImageResource(R.drawable.guests);
    }
    if (j==14) {
        if (guestteam.get(j).equals("Yes"))     MainActivity.homeornot15.setImageResource(R.drawable.ic_home);
        else MainActivity.homeornot15.setImageResource(R.drawable.guests);
    }


}

        java.util.Calendar c3 = java.util.Calendar.getInstance();
        long Timeontable;
        i=0;
        if (i<=list.size()-1) {
            MainActivity.date1.setText(list.get(0));

            c3.set(java.util.Calendar.YEAR, Integer.parseInt(list.get(0).substring(6)));

            c3.set(java.util.Calendar.MONTH, Integer.parseInt(list.get(0).substring(3, 5))-1);

            c3.set(java.util.Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(0).substring(0, 2)));

            c3.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(toLocalTime(timeM.get(0), tz, year, month, day).substring(0, 2)));
            MainActivity.date1.setText(dateformatUS(c3.getTime()));
           if (c3.before(c2)){
               MainActivity.row1.setBackgroundColor(R.color.colorPrimaryDark);
               MainActivity.alert1.setImageResource(R.drawable.find_black_24dp);
               MainActivity.alert1.setTag(R.drawable.find_black_24dp);

           }

           else MainActivity.row1.setBackgroundColor(Color.TRANSPARENT);
            i++;
        }
        if (i<=list.size()-1) {
            MainActivity.date2.setText(list.get(1));
            c3.set(java.util.Calendar.YEAR, Integer.parseInt(list.get(1).substring(6)));

            c3.set(java.util.Calendar.MONTH, Integer.parseInt(list.get(1).substring(3, 5))-1);

            c3.set(java.util.Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(1).substring(0, 2)));

            c3.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(toLocalTime(timeM.get(1), tz, year, month, day).substring(0, 2)));
            MainActivity.date2.setText(dateformatUS(c3.getTime()));

            if (c3.before(c2)){
                MainActivity.row2.setBackgroundColor(R.color.colorPrimaryDark);
                MainActivity.alert2.setImageResource(R.drawable.find_black_24dp);
                MainActivity.alert2.setTag(R.drawable.find_black_24dp);

            }
            else MainActivity.row2.setBackgroundColor(Color.TRANSPARENT);
            i++;}


        if (i<=list.size()-1) {
            MainActivity.date3.setText(list.get(2));
            c3.set(java.util.Calendar.YEAR, Integer.parseInt(list.get(2).substring(6)));

            c3.set(java.util.Calendar.MONTH, Integer.parseInt(list.get(2).substring(3, 5))-1);

            c3.set(java.util.Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(2).substring(0, 2)));

            c3.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(toLocalTime(timeM.get(2), tz, year, month, day).substring(0, 2)));
            MainActivity.date3.setText(dateformatUS(c3.getTime()));

            if (c3.before(c2)){
               MainActivity.row3.setBackgroundColor(R.color.colorPrimaryDark);
               MainActivity.alert3.setImageResource(R.drawable.find_black_24dp);
                MainActivity.alert3.setTag(R.drawable.find_black_24dp);

            }
            else MainActivity.row3.setBackgroundColor(Color.TRANSPARENT);
            i++;}

        if (i<=list.size()-1) {
            MainActivity.date4.setText(list.get(3));
            c3.set(java.util.Calendar.YEAR, Integer.parseInt(list.get(3).substring(6)));

            c3.set(java.util.Calendar.MONTH, Integer.parseInt(list.get(3).substring(3, 5))-1);

            c3.set(java.util.Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(3).substring(0, 2)));

            c3.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(toLocalTime(timeM.get(3), tz, year, month, day).substring(0, 2)));
            MainActivity.date4.setText(dateformatUS(c3.getTime()));

            if (c3.before(c2)){
                MainActivity.row4.setBackgroundColor(R.color.colorPrimaryDark);
                MainActivity.alert4.setImageResource(R.drawable.find_black_24dp);
                MainActivity.alert4.setTag(R.drawable.find_black_24dp);

            }
            else MainActivity.row4.setBackgroundColor(Color.TRANSPARENT);
            i++;}

        if (i<list.size()-1) {
            MainActivity.date5.setText(list.get(4));
            c3.set(java.util.Calendar.YEAR, Integer.parseInt(list.get(4).substring(6)));

            c3.set(java.util.Calendar.MONTH, Integer.parseInt(list.get(4).substring(3, 5))-1);

            c3.set(java.util.Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(4).substring(0, 2)));

            c3.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(toLocalTime(timeM.get(4), tz, year, month, day).substring(0, 2)));
            MainActivity.date5.setText(dateformatUS(c3.getTime()));

            if (c3.before(c2)){
                MainActivity.row5.setBackgroundColor(R.color.colorPrimaryDark);
                MainActivity.alert5.setImageResource(R.drawable.find_black_24dp);
                MainActivity.alert5.setTag(R.drawable.find_black_24dp);

            }
            else MainActivity.row5.setBackgroundColor(Color.TRANSPARENT);
            i++;}
        if (i<=list.size()-1) {
            MainActivity.date6.setText(list.get(5));
            c3.set(java.util.Calendar.YEAR, Integer.parseInt(list.get(5).substring(6)));

            c3.set(java.util.Calendar.MONTH, Integer.parseInt(list.get(5).substring(3, 5))-1);

            c3.set(java.util.Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(5).substring(0, 2)));

            c3.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(toLocalTime(timeM.get(5), tz, year, month, day).substring(0, 2)));
            MainActivity.date6.setText(dateformatUS(c3.getTime()));

            if (c3.before(c2)){
                MainActivity.row6.setBackgroundColor(R.color.colorPrimaryDark);
                MainActivity.alert6.setImageResource(R.drawable.find_black_24dp);
                MainActivity.alert6.setTag(R.drawable.find_black_24dp);

            }
            else MainActivity.row6.setBackgroundColor(Color.TRANSPARENT);
            i++;}
        if (i<=list.size()-1) {
            MainActivity.date7.setText(list.get(6));
            c3.set(java.util.Calendar.YEAR, Integer.parseInt(list.get(6).substring(6)));

            c3.set(java.util.Calendar.MONTH, Integer.parseInt(list.get(6).substring(3, 5))-1);

            c3.set(java.util.Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(6).substring(0, 2)));

            c3.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(toLocalTime(timeM.get(6), tz, year, month, day).substring(0, 2)));
            MainActivity.date7.setText(dateformatUS(c3.getTime()));

            if (c3.before(c2)){
                MainActivity.row7.setBackgroundColor(R.color.colorPrimaryDark);
                MainActivity.alert7.setImageResource(R.drawable.find_black_24dp);
                MainActivity.alert7.setTag(R.drawable.find_black_24dp);

            }
            else MainActivity.row7.setBackgroundColor(Color.TRANSPARENT);
            i++;}
        if (i<=list.size()-1) {
            MainActivity.date8.setText(list.get(7));
            c3.set(java.util.Calendar.YEAR, Integer.parseInt(list.get(7).substring(6)));

            c3.set(java.util.Calendar.MONTH, Integer.parseInt(list.get(7).substring(3, 5))-1);

            c3.set(java.util.Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(7).substring(0, 2)));

            c3.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(toLocalTime(timeM.get(7), tz, year, month, day).substring(0, 2)));
            MainActivity.date8.setText(dateformatUS(c3.getTime()));

            if (c3.before(c2)){
                MainActivity.row8.setBackgroundColor(R.color.colorPrimaryDark);
                MainActivity.alert8.setImageResource(R.drawable.find_black_24dp);
                MainActivity.alert8.setTag(R.drawable.find_black_24dp);

            }
            else MainActivity.row8.setBackgroundColor(Color.TRANSPARENT);
            i++;}
        if (i<=list.size()-1) {
            MainActivity.date9.setText(list.get(8));
            c3.set(java.util.Calendar.YEAR, Integer.parseInt(list.get(8).substring(6)));

            c3.set(java.util.Calendar.MONTH, Integer.parseInt(list.get(8).substring(3, 5))-1);

            c3.set(java.util.Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(8).substring(0, 2)));

            c3.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(toLocalTime(timeM.get(8), tz, year, month, day).substring(0, 2)));
            MainActivity.date9.setText(dateformatUS(c3.getTime()));

            if (c3.before(c2)){
                MainActivity.row9.setBackgroundColor(R.color.colorPrimaryDark);
                MainActivity.alert9.setImageResource(R.drawable.find_black_24dp);
                MainActivity.alert9.setTag(R.drawable.find_black_24dp);

            }
            else MainActivity.row9.setBackgroundColor(Color.TRANSPARENT);
            i++;}
        if (i<=list.size()-1) {
            MainActivity.date10.setText(list.get(9));
            c3.set(java.util.Calendar.YEAR, Integer.parseInt(list.get(9).substring(6)));

            c3.set(java.util.Calendar.MONTH, Integer.parseInt(list.get(9).substring(3, 5))-1);

            c3.set(java.util.Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(9).substring(0, 2)));

            c3.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(toLocalTime(timeM.get(9), tz, year, month, day).substring(0, 2)));
            MainActivity.date10.setText(dateformatUS(c3.getTime()));

            if (c3.before(c2)){
                MainActivity.row10.setBackgroundColor(R.color.colorPrimaryDark);
                MainActivity.alert10.setImageResource(R.drawable.find_black_24dp);
                MainActivity.alert10.setTag(R.drawable.find_black_24dp);

            }
            else MainActivity.row10.setBackgroundColor(Color.TRANSPARENT);
            i++;}
        if (i<=list.size()-1) {
            MainActivity.date11.setText(list.get(10));
            c3.set(java.util.Calendar.YEAR, Integer.parseInt(list.get(10).substring(6)));

            c3.set(java.util.Calendar.MONTH, Integer.parseInt(list.get(10).substring(3, 5))-1);

            c3.set(java.util.Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(10).substring(0, 2)));

            c3.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(toLocalTime(timeM.get(10), tz, year, month, day).substring(0, 2)));
            MainActivity.date11.setText(dateformatUS(c3.getTime()));

            if (c3.before(c2)){
                MainActivity.row11.setBackgroundColor(R.color.colorPrimaryDark);
                MainActivity.alert11.setImageResource(R.drawable.find_black_24dp);
                MainActivity.alert11.setTag(R.drawable.find_black_24dp);

            }
            else MainActivity.row11.setBackgroundColor(Color.TRANSPARENT);
            i++;}
        if (i<=list.size()-1) {
            MainActivity.date12.setText(list.get(11));
            c3.set(java.util.Calendar.YEAR, Integer.parseInt(list.get(11).substring(6)));

            c3.set(java.util.Calendar.MONTH, Integer.parseInt(list.get(11).substring(3, 5))-1);

            c3.set(java.util.Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(11).substring(0, 2)));

            c3.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(toLocalTime(timeM.get(11), tz, year, month, day).substring(0, 2)));
            MainActivity.date12.setText(dateformatUS(c3.getTime()));

            if (c3.before(c2)){
                MainActivity.row12.setBackgroundColor(R.color.colorPrimaryDark);
                MainActivity.alert12.setImageResource(R.drawable.find_black_24dp);
                MainActivity.alert12.setTag(R.drawable.find_black_24dp);

            }
            else MainActivity.row12.setBackgroundColor(Color.TRANSPARENT);
            i++;}
        if (i<=list.size()-1) {
            MainActivity.date13.setText(list.get(12));
            c3.set(java.util.Calendar.YEAR, Integer.parseInt(list.get(12).substring(6)));

            c3.set(java.util.Calendar.MONTH, Integer.parseInt(list.get(12).substring(3, 5))-1);

            c3.set(java.util.Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(12).substring(0, 2)));

            c3.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(toLocalTime(timeM.get(12), tz, year, month, day).substring(0, 2)));
            MainActivity.date13.setText(dateformatUS(c3.getTime()));

            if (c3.before(c2)){
                MainActivity.row13.setBackgroundColor(R.color.colorPrimaryDark);
                MainActivity.alert13.setImageResource(R.drawable.find_black_24dp);
                MainActivity.alert13.setTag(R.drawable.find_black_24dp);

            }
            else MainActivity.row13.setBackgroundColor(Color.TRANSPARENT);
            i++;
        }
        if (i <= list.size() - 1) {
            MainActivity.date14.setText(list.get(13));
            c3.set(java.util.Calendar.YEAR, Integer.parseInt(list.get(13).substring(6)));

            c3.set(java.util.Calendar.MONTH, Integer.parseInt(list.get(13).substring(3, 5))-1);

            c3.set(java.util.Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(13).substring(0, 2)));

            c3.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(toLocalTime(timeM.get(13), tz, year, month, day).substring(0, 2)));
            MainActivity.date14.setText(dateformatUS(c3.getTime()));

            if (c3.before(c2)){
                MainActivity.row14.setBackgroundColor(R.color.colorPrimaryDark);
                MainActivity.alert14.setImageResource(R.drawable.find_black_24dp);
                MainActivity.alert14.setTag(R.drawable.find_black_24dp);

            }
            else MainActivity.row14.setBackgroundColor(Color.TRANSPARENT);
             i++;
        }
        if (i <= list.size()-1) {
            MainActivity.date15.setText(list.get(14));
            c3.set(java.util.Calendar.YEAR, Integer.parseInt(list.get(14).substring(6)));

            c3.set(java.util.Calendar.MONTH, Integer.parseInt(list.get(14).substring(3, 5))-1);

            c3.set(java.util.Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(14).substring(0, 2)));

            c3.set(java.util.Calendar.HOUR_OF_DAY, Integer.parseInt(toLocalTime(timeM.get(14), tz, year, month, day).substring(0, 2)));
            MainActivity.date15.setText(dateformatUS(c3.getTime()));

            if (c3.before(c2)){
                MainActivity.row15.setBackgroundColor(R.color.colorPrimaryDark);
                MainActivity.alert15.setImageResource(R.drawable.find_black_24dp);
                MainActivity.alert15.setTag(R.drawable.find_black_24dp);

            }
            else MainActivity.row15.setBackgroundColor(Color.TRANSPARENT);
        }


        new MainActivity().CheckRows(mContext);



        MainActivity.date9.setText("23-Dec-2019");
        MainActivity.time9.setText("17:45");
        MainActivity.date10.setText("23-Dec-2019");
        MainActivity.time10.setText("17:50");
         MainActivity.date11.setText("23-Dec-2019");
         MainActivity.time11.setText("17:54");




    }



    @Override
    protected void onProgressUpdate(Integer... values) {
    }
}
