package com.tecacet.yodlee.credentials;

import com.yodlee.sdk.builder.ClientCredentialAdminContextBuilder;
import com.yodlee.sdk.builder.ClientCredentialUserContextBuilder;
import com.yodlee.sdk.builder.ContextBuilderFactory;
import com.yodlee.sdk.configuration.cobrand.ClientCredentialAdminConfiguration;
import com.yodlee.sdk.configuration.user.ClientCredentialUserConfiguration;
import com.yodlee.sdk.context.ClientCredentialAdminContext;
import com.yodlee.sdk.context.ClientCredentialUserContext;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CredentialsFactory {

    public static final String API_VERSION = "1.1";

    private final SecretsRepository secretsRepository;

    @Value("${yodlee.base.path}")
    private String baseUrl;

    @SneakyThrows
    public ClientCredentialAdminContext getAdminCredentials() {
        ClientCredentialAdminConfiguration configuration = new ClientCredentialAdminConfiguration();
        configuration.setClientId(secretsRepository.clientId());
        configuration.setSecret(secretsRepository.clientSecret());
        configuration.setLoginName(secretsRepository.adminLoginName());
        configuration.setApiVersion(API_VERSION);
        configuration.setBasePath(baseUrl);

        ClientCredentialAdminContextBuilder contextBuilder =
                ContextBuilderFactory.createClientCredentialAdminContextBuilder();
        return contextBuilder.build(configuration);
    }

    @SneakyThrows
    public ClientCredentialUserContext getUserCredentials(String loginName) {
        ClientCredentialUserConfiguration clientCredentialUserConfiguration =
                new ClientCredentialUserConfiguration();
        clientCredentialUserConfiguration.setClientId(secretsRepository.clientId());
        clientCredentialUserConfiguration.setSecret(secretsRepository.clientSecret());
        clientCredentialUserConfiguration.setLoginName(loginName);
        clientCredentialUserConfiguration.setApiVersion(API_VERSION);
        clientCredentialUserConfiguration.setBasePath(baseUrl);

        ClientCredentialUserContextBuilder clientCredentialContextBuilder =
                ContextBuilderFactory.createClientCredentialUserContextBuilder();
        return clientCredentialContextBuilder.build(clientCredentialUserConfiguration);
    }
}
