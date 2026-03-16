package com.spring.webCrawler.fetchURL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;

@Deprecated
@Component
public class FetchURL {


    @Value("https://neon.com/postgresql/postgresql-tutorial/postgresql-server-and-database-objects")
    public String fetchUrl(String url) throws IOException {
        Document doc= Jsoup.connect(url).get();
        Elements para= doc.getElementsByTag("p");
        Elements links= doc.getElementsByTag("a");
        HashSet<String> ppp= new HashSet<>();

        for(Element link : links){
//            String linkText=link.text();
            ppp.add(link.toString());
        }
//        int i=0;
//        for(Element pp :para){
//            String paraText=pp.text();
//            ppp.add(paraText);
//            i++;
//        }
        return ppp.toString();
    }


    HashSet<String> recHashSetLinks= new HashSet<>();

    public  String  recLink(String url) throws IOException {

        if(recHashSetLinks.size()>300) return recHashSetLinks.toString();


        if(!recHashSetLinks.contains(url) && url.startsWith("https") ){
            Document docGlobal= Jsoup.connect(url).get();
            recHashSetLinks.add(url);
            Elements urlReclinks= docGlobal.select("a[href]");

            for(Element urlRecLink : urlReclinks){
                recLink(urlRecLink.attr("abs:href"));
            }

        }

        return recHashSetLinks.toString();

    }


    public FetchURL(){
        System.out.println("i m cALLED FTECH URL BTW");
    }

}
