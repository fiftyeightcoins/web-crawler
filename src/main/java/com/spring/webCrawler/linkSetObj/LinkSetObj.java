package com.spring.webCrawler.linkSetObj;

import com.spring.webCrawler.fetchURL.FetchLinks;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class LinkSetObj {


    FetchLinks fetchLinks= new FetchLinks();

    public HashSet<String> getLinksSet(String seedUrl){

        return fetchLinks.fetchAllLinks(seedUrl);

    }




}
