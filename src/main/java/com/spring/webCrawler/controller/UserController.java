package com.spring.webCrawler.controller;

import com.spring.webCrawler.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping("seedurl")
    public String GetSeedUrl(@PathVariable String SeedUrl){
        return SeedUrl;
    }

    @GetMapping("")
    public String home(){
        return "home";
    }

}
