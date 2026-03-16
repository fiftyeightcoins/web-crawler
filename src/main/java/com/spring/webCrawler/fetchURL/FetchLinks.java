package com.spring.webCrawler.fetchURL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashSet;

@Configuration
public class FetchLinks {

    @Autowired
    HashSet<String> hashSet;



    public HashSet<String> fetchAllLinks(String seedUrl){

        if(hashSet.size()>=300) return hashSet;

        if(!hashSet.contains(seedUrl) && seedUrl.startsWith("https") ){

            try{

                Document docGlobal= Jsoup.connect(seedUrl).get();

                hashSet.add(seedUrl);

                Elements urlReclinks= docGlobal.select("a[href]");


                for(Element urlRecLink : urlReclinks){
                    fetchAllLinks(urlRecLink.attr("abs:href"));
                }

            } catch (IOException e) {
                throw new RuntimeException("io exception duing fetching the urls");
            }


        }

        return hashSet;


    }




}
