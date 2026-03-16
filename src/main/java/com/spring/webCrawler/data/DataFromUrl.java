package com.spring.webCrawler.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Configuration
public class DataFromUrl {

//    HashMap<String, List<String>> hashMap= new HashMap<>();
    @Autowired
    List<String> dataInLink;

    public List<String> getDataFromLink(String link){

        try {
            Document doc= Jsoup.connect(link).get();
            Elements paras= doc.getElementsByTag("p");

            for(Element para : paras){
                dataInLink.add(para.toString());
            }

        } catch (IOException e) {
            throw new RuntimeException("the fetchinf data form a link fialed " + e);
        }
    return dataInLink;

    }


}
