package com.tecacet.yodlee.service;

import com.tecacet.yodlee.model.BearerToken;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BearerTokenProviderTest {

    @Resource
    private BearerTokenProvider bearerTokenProvider;

    @Test
    void getBearerToken() {
        BearerToken token = bearerTokenProvider.getBearerToken("sbMem623b8980dwbcf1");
        assertNotNull(token.getAccessToken());
        assertTrue(token.getExpiresIn() > 0);
        assertNotNull(token.getIssuedAt());


    }
}