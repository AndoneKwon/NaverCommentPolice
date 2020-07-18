package com.hanium.gateway.security;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;


@Getter
@ToString
public class JwtAuthenticationConfig {


    private String url;


    private String header;


    private String prefix;


    private int expiration; // default 24 hours


    private String secret;
}