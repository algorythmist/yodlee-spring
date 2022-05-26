package com.tecacet.yodlee.credentials;

import org.springframework.stereotype.Component;

@Component
public class EnvironmentSecretsRepository implements SecretsRepository {

    String YODLEE_CLIENT_ID = "YODLEE_CLIENT_ID";

    String YODLEE_SECRET = "YODLEE_SECRET";

    String YODLEE_ADMIN = "YODLEE_ADMIN";

    @Override
    public String clientId() {
        return System.getenv(YODLEE_CLIENT_ID);
    }

    @Override
    public String clientSecret() {
        return System.getenv(YODLEE_SECRET);
    }

    @Override
    public String adminLoginName() { return System.getenv(YODLEE_ADMIN); }

}
