package com.spring.webCrawler.extractData;

import com.spring.webCrawler.data.DataFromUrl;
import com.spring.webCrawler.fetchURL.FetchLinks;
import com.spring.webCrawler.linkSetObj.LinkSetObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Configuration
public class ExtractDataFromLinks {

    @Autowired
    LinkSetObj linkSetObj;


    @Autowired
    DataFromUrl dataFromUrl;

    @Autowired
    List<List<String>> dataFromLinks;

    public List<List<String>> getDataFromLinks(String seedUrl){


        HashSet<String> hashSet= linkSetObj.getLinksSet(seedUrl);
        List<String> linkList;
        for(String link : hashSet){
            linkList=dataFromUrl.getDataFromLink(link);
            dataFromLinks.add(linkList);
        }

        return dataFromLinks;

    }



}
