package com.tecacet.yodlee.controller;

import com.tecacet.yodlee.model.AccountPayload;
import com.tecacet.yodlee.model.BearerToken;
import com.tecacet.yodlee.model.ClosePayload;
import com.tecacet.yodlee.service.BearerTokenProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class YodleeController {

    @Autowired
    private BearerTokenProvider bearerTokenProvider;

    @GetMapping("/link/{loginName}")
    public ModelAndView link(@PathVariable String loginName) {
        BearerToken token = bearerTokenProvider.getBearerToken(loginName);
        Map<String, String> model = new HashMap<>();
        model.put("token", token.getAccessToken());
        return new ModelAndView("fastlink", model);
    }

    @PostMapping(value = "/handle-success")
    public ResponseEntity handle(@RequestBody AccountPayload accountPayload) {
        log.info(accountPayload.toString());
        return ResponseEntity.ok("ok");
    }

    @PostMapping(value = "/handle-close", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity handle(@RequestBody ClosePayload closePayload) {
        log.info(closePayload.toString());
        return ResponseEntity.ok("ok");
    }

}
