package com.nhl;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.view.View;
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

class Task2 extends AsyncTask<Void, Integer, ArrayList> {

    Elements test=null;
    Elements test2=null;


    ArrayList<String> list = new ArrayList<String>();

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
    public static String URL;

    Task2(Context mContext) {
        this.mContext = mContext;
    }

    public static void setalarms(Context context){

    }




    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        URL="https://www.espn.com/nhl/team/stats/_/type/goalie/name/"+MainActivity.shortname2(MainActivity.FavTeam);
        System.out.println(URL);
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
            month = c.get(Calendar.MONTH);
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
//------------------------------------

    //------------------------------------------------------
    private static Elements Parser2(String url){
        Elements li=null;
        Connection.Response res=null;
        Document doc = null;
        Element temp=null;
        Elements temp2=null;

        final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";


        enableSSLSocket();
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
            //System.out.println(temp.text());
                for(int i=0;i<31;i++){
                   if (temp.select("tr[data-idx="+ i +"]").get(0).text().contains(MainActivity.FavTeam)){
                       temp2=temp.select("tr[data-idx="+i+"]");
                   }
                }

            //li = doc.select("li");
            System.out.println(temp2.text());
        }
        return temp2;
    }

    //-------------------------------------------------------
    private static Elements Parser(String url){
        Elements li=null;
        Connection.Response res=null;
        Document doc = null;
        Element temp=null;
        final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";


        enableSSLSocket();
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

            li = doc.select("li");
        }
        return li;
    }
    //-------------------------------------------------------




    //--------------------------------------------
    @Override
    protected ArrayList<String> doInBackground(Void... params) {
test = Parser(URL);
test2=Parser2("https://www.espn.com/nhl/standings/_/group/league");
        for (int i=0;i<test.size();i++){
            if ((test.get(i).text().contains("Division"))) {
                list.add(test.get(i).previousElementSibling().text());
                list.add(test.get(i).text());
                System.out.println(test.get(i).text());
                System.out.println(test.get(i).previousElementSibling().text());

            }
        }
        final String[] tokens = test2.get(1).text().split("\\s");
        // for(int i=0;i<tokens.length;i++)
        // System.out.println(tokens[i]);
        list.add("Points: "+tokens[4]);
        list.add("Streak: "+tokens[14]);
        System.out.println("task3 ready");

        return list;
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
    protected void onPostExecute(ArrayList result) {




    }

    @Override
    protected void onProgressUpdate(Integer... values) {

    }
}
