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

class Task4 extends AsyncTask<Void, Integer, ArrayList<String>> {

    ArrayList<String> test=null;
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


    Task4(Context mContext, String playerURL) {
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

    private static ArrayList ParserPlayer(String url){
        Elements td=null;
        Elements span=null;
        Elements a=null;

ArrayList<String> result = new ArrayList<String>();
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
            temp2 = doc.select("section.wisbb_content").first();
            te = temp2.select("div");



            for (int i=0;i<te.size();i++){
                if (te.get(i).text().contains("Scoring")) {
                    temp = te.get(i);
                }
            }
              //  System.out.println(temp);
          //  if (temp2 != null) {
          //      temp = temp2.select("div.wisbb_expandableTable.wisbb_teamFixed.wisbb_statsTable").first();
          //  }

            Elements t = temp.select("tr");

            for (int i=0;i<t.size();i++){
                if (t.get(i).text().contains("2019")) {
                    td = t.get(i).select("td");
                }
            }
            if (td != null) {
                for (int i=0;i<td.size();i++){
                    result.add(td.get(i).text());
                }
            }
            temp = doc.select("table[class=wisbb_playerData]").first();
            td = temp.select("td");

            for (Element element : td) {
                result.add(element.text());
            }
            temp = doc.select("div[class=wisbb_nameAndNumber]").first();
            td = temp.select("span");
           // System.out.println(td.text());

            for (Element element : td) {
                result.add(element.text());
            }
            temp = doc.select("div[class=wisbb_secondaryInfo]").first();
            td = temp.select("a");
            // System.out.println(td.text());

            for (Element element : td) {
                result.add(element.text());
            }
            td = temp.select("span");
            // System.out.println(td.text());

            for (Element element : td) {
                result.add(element.text());
            }
            temp = doc.select("tr[class=wisbb_bioSeasonStats]").first();
            td = temp.select("div");
          //  System.out.println(temp);

          //  System.out.println(td);

            for (Element element : td) {
                result.add(element.text());
            }


           for (int i=0;i<result.size();i++){
              System.out.println(i+"::"+result.get(i));
          }

        }
        return result;
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
            //temp = doc.select("div.col-xs-6").first();
            temp2= doc.body();
           // System.out.println(temp.text());
            h1 = temp2.select("span");
            li = temp2.select("a");
          //  for(int i=0;i<li.size();i++)
           //     System.out.println(i+" "+li.get(i).text());


        }
      //  li.add(h1.get(0));
        //for(int i=0;i<li.size();i++)
          //  System.out.println(i+" "+li.get(i).text());
        return h1;
    }
    //--------------------------------------------
    @Override
    protected ArrayList<String> doInBackground(Void... params) {
        test = ParserPlayer(playerURL);
        //test2 = ParserPlayerInfo(playerURL);

        list.add(test.get(29)); //team 0
        list.add(test.get(2)); //gp 1
        list.add(test.get(3)); //G 2
        list.add(test.get(4)); //A 3
        list.add(test.get(5)); //P 4
        list.add(test.get(6)); //+/- 5

        list.add(test.get(17)); // age 6
        list.add(test.get(21)); // country 7
        list.add(test.get(30)); // position 8
        list.add(test.get(19)); //height 9
        list.add(test.get(24)); //nr 10
        list.add(test.get(26)); //name 11
        list.add((test.get(33) + " SV%" + test.get(41))); //SV%

if (test.size()<20) return null;
else
        return list;
    }



    @Override
    protected void onPostExecute(ArrayList<String> result) {

}


    @Override
    protected void onProgressUpdate(Integer... values) {

    }
}
