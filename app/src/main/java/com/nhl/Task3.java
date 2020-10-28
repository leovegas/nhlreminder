package com.nhl;


import android.app.PendingIntent;
import android.content.Context;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.os.AsyncTask;
import android.os.StrictMode;
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
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task3 extends AsyncTask<Void, Integer, ArrayList<String>> {

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
    public static String playerURL;


    Task3(Context mContext,String playerURL) {
        this.mContext = mContext;
        this.playerURL = playerURL;
    }

    public static void setalarms(Context context){

    }




    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        URL="https://www.espn.com/nhl/team/stats/_/type/goalie/name/"+MainActivity.shortname2(MainActivity.FavTeam);

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

    private static Elements ParserPlayer(String url){
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
            temp = doc.select("table[class=pp-table table table-striped table-hover]").first();
            //System.out.println(temp.text());

            li = temp.select("td");
            for(int i=0;i<li.size();i++)
                System.out.println(i+" "+li.get(i).text());
        }
        return li;
    }

    //----------------------
    private static Elements ParserPlayerInfo(String url){
        Elements li=null;
        Elements h1=null;
        Connection.Response res=null;
        Document doc = null;
        Element temp=null;
        Element temp2=null;

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
            temp = doc.select("div.col-xs-6").first();
            temp2= doc.body();
           // System.out.println(temp.text());
            h1 = temp2.select("h1");
            li = temp.select("div");

        }
        li.add(h1.get(0));
        //for(int i=0;i<li.size();i++)
          //  System.out.println(i+" "+li.get(i).text());
        return li;
    }
    //--------------------------------------------
    @Override
    protected ArrayList<String> doInBackground(Void... params) {
        test = ParserPlayer(playerURL);
        test2 = ParserPlayerInfo(playerURL);


        list.add(test.get(0).text()); //team 0
        list.add(test.get(1).text()); //gp 1
        list.add(test.get(2).text()); //G 2
        list.add(test.get(3).text()); //A 3
        list.add(test.get(4).text()); //P 4
        list.add(test.get(5).text()); //+/- 5

        list.add(test2.get(1).text()); // age 6
        list.add(test2.get(2).text()); // country 7
        list.add(test2.get(3).text()); // position 8
        list.add(test2.get(4).text()); //height 9
        list.add(test2.get(5).text()); //weight 10
        list.add(test2.get(9).text()); //name 11


        return list;
    }



    @Override
    protected void onPostExecute(ArrayList<String> result) {

}


    @Override
    protected void onProgressUpdate(Integer... values) {

    }
}
