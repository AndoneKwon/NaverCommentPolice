package com.hanium.gateway.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContorller {


    @GetMapping(value = "/test/1")
    public String test1(){

        return "test1";
    }

}