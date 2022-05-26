package com.tecacet.yodlee.service;

import com.yodlee.api.model.providers.Providers;
import com.yodlee.sdk.api.exception.ApiException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class YodleeAdminServiceTest {

    @Autowired
    private YodleeAdminService yodleeAdminService;

    @Test
    void registerUser() {
        //Op not supported in Sandbox
        assertThrows(ApiException.class, () -> yodleeAdminService.registerUser("test"));
    }

    @Test
    void getAllProviders() {
        List<Providers> providersList = yodleeAdminService.getAllProviders(0, 10);
        assertEquals(10, providersList.size());
    }

}