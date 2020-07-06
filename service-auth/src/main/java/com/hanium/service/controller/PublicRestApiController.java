package com.hanium.service.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account")
public class PublicRestApiController {


    //All user access
    @GetMapping("test")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("management/reports")
    public String repports(){
        return "API Test 2";
    }


}
