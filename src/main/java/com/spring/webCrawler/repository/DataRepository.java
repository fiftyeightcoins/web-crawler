package com.spring.webCrawler.repository;

import com.spring.webCrawler.dataEntity.crawledData;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface DataRepository extends JpaRepository<crawledData, Integer> {

}
