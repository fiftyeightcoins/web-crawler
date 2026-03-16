package com.spring.webCrawler.dataEntity;
import jakarta.persistence.*;

@jakarta.persistence.Entity
public class crawledData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String paragraphs;

}
