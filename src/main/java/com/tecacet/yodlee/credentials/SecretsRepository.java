package com.tecacet.yodlee.credentials;

/**
 * A method for obtaining YODLEE credentials
 */
public interface SecretsRepository {

    String clientId();

    String clientSecret();

    String adminLoginName();
}
