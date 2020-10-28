package com.nhl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunnyCrawler2 {
    private static Pattern patternDomainName;
    private Matcher matcher;
    private static final String DOMAIN_NAME_PATTERN
            = "([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}";
    static {
        patternDomainName = Pattern.compile(DOMAIN_NAME_PATTERN);
    }
    public String getDomainName(String url){

        String domainName = "";
        matcher = patternDomainName.matcher(url);
        if (matcher.find()) {
            domainName = matcher.group(0).toLowerCase().trim();
        }
        return domainName;

    }

    public ArrayList<String> getDataFromGoogle(String query) {

        ArrayList<String> result = new ArrayList<String>();
       // String request = "https://www.google.com/search?q=" + query + "&num=20";
       // String request = "https://puckpedia.com/players/search/"+query;
        String request = "https://www.foxsports.com//nhl/players?teamId=0&season=2019&position=0&playerName="+query+"&page=1&country=0&grouping=0&weightclass=0";


        System.out.println("Sending request..." + request);

        try {

            // need http protocol, set this as a Google bot agent :)
            Document doc = Jsoup
                    .connect(request)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
                    .timeout(5000).get();

            // get all links
            Elements links = doc.select("a[href]");
            for (Element link : links) {

                String temp = link.attr("href");
                if(temp.contains(query+"-player")){
                    //use regex to get domain name
                    result.add(temp); break;
                    //System.out.println("URLS "+temp);

                }


            }
            //System.out.println("URLS "+links);




        } catch (IOException e) {
            System.out.println("sending request error");
            e.printStackTrace();
        }

        if (result.size()==0) return null;
        else
        return result;
    }
}
