package com.tecacet.yodlee.service;

import com.yodlee.api.model.account.Account;
import com.yodlee.api.model.providers.Providers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class YodleeUserServiceTest {

    @Autowired
    private YodleeServiceFactory yodleeServiceFactory;

    @Test
    void testGetProvidersAsUser() {
        YodleeUserService yodleeUserService = yodleeServiceFactory.getUserService("sbMem623b8980dwbcf1");
        List<Providers> providersList = yodleeUserService.getAllProviders(0, 10);
        assertEquals(10, providersList.size());
    }


    @Test
    void testGetAccountsAsUser() {
        YodleeUserService yodleeUserService = yodleeServiceFactory.getUserService("sbMem623b8980dwbcf1");
        List<Account> accounts = yodleeUserService.getAccounts(null);
        assertEquals(5, accounts.size());
    }

}
