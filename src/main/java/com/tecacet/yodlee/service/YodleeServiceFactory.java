package com.tecacet.yodlee.service;

import com.tecacet.yodlee.credentials.CredentialsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class YodleeServiceFactory {

    @Autowired
    private CredentialsFactory credentialsFactory;

    public YodleeUserService getUserService(String loginName) {
        return new YodleeUserService(credentialsFactory.getUserCredentials(loginName));
    }
}
