package com.nhl;


import android.app.PendingIntent;
import android.content.Context;
import android.icu.util.TimeZone;
import android.os.AsyncTask;
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
import java.util.ArrayList;
import java.util.Date;

class Task5 extends AsyncTask<Void, Integer, ArrayList<Element>> {

    ArrayList<Element> test=null;
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
    public static String standingsURL;



    Task5(Context mContext, String standingsURL) {
        this.mContext = mContext;
        this.standingsURL = standingsURL;

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

    private static ArrayList<Element> ParserPlayer(String url){
        Elements td=null;
        Elements tr=null;
        Elements a=null;

ArrayList<String> result = new ArrayList<String>();

        ArrayList<Element> allteams = new ArrayList<Element>();

Connection.Response res=null;
        Document doc = null;
        Element temp=null;
        Element temp2=null;
        Elements te=null;


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
            temp2 = doc.select("table.wisbb_standardTable").first();
            tr = temp2.select("tr");
           // System.out.println("1 "+tr.text());

            if (tr != null) {
                for (int i=0;i<tr.size();i++){
                    allteams.add(tr.get(i));
                }
            }



           // System.out.println("2 "+temp.text());




       //    for (int i=0;i<result.size();i++){
        //      System.out.println(i+"::"+result.get(i));
       //   }

        }
        return allteams;
    }

    //----------------------

    @Override
    protected ArrayList<Element> doInBackground(Void... params) {
        //String url = "https://www.foxsports.com/nhl/standings?season=2019&seasonType=1&grouping=4";

        test = ParserPlayer(standingsURL);
        //test2 = ParserPlayerInfo(playerURL);


if (test.size()<20) return null;
else
        return test;
    }



    @Override
    protected void onPostExecute(ArrayList<Element> result) {

}


    @Override
    protected void onProgressUpdate(Integer... values) {

    }
}
