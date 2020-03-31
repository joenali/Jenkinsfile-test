package com.docker.springboottest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gu Yuanhua
 * @date created time 2018/6/7 19:18
 */
@RestController
public class Hello {

    /**
     *
     */
    @RequestMapping("/")
    public String hello () {
        return "Springboottest!";
    }
}
