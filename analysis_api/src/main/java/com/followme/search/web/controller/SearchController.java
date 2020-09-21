package com.followme.search.web.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.JsonNode;
import com.followme.search.service.SearchService;
import com.followme.search.web.dto.SearchRequestDto;
import com.followme.search.web.dto.SearchResponseDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Key;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
public class SearchController {
    private final SearchService searchService;


    @PostMapping("/search")
    public @ResponseBody List<SearchResponseDto> search(@RequestBody SearchRequestDto searchRequestDto) throws IOException {
        return searchService.SearchDoc(searchRequestDto.getFrom(),searchRequestDto.getQuery());
    }
}
