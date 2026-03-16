package com.spring.webCrawler;

import com.spring.webCrawler.fetchURL.FetchURL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class WebCrawlerApplication {

	public static void main(String[] args) throws IOException {


		FetchURL fetchURL= new FetchURL();
		String temp = fetchURL.recLink("https://neon.com/postgresql/postgresql-tutorial/postgresql-server-and-database-objects");

		System.out.println(temp);

//		GetInLinks getInLinks= new GetInLinks();
//
//		getInLinks.getInnerLinks("https://neon.com/postgresql/postgresql-tutorial/postgresql-server-and-database-objects");
//
//
//		LinksObject linksObject= new LinksObject();
//		String temp2Links=linksObject.getHashSetAsString();
//		System.out.println(temp2Links);

		SpringApplication.run(WebCrawlerApplication.class, args);
	}

}
