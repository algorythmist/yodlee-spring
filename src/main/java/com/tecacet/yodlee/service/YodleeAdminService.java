package com.tecacet.yodlee.service;

import com.tecacet.yodlee.credentials.CredentialsFactory;
import com.yodlee.api.model.providers.Providers;
import com.yodlee.api.model.providers.response.ProviderResponse;
import com.yodlee.api.model.user.UserRegistration;
import com.yodlee.api.model.user.request.UserRequest;
import com.yodlee.sdk.api.ProvidersApi;
import com.yodlee.sdk.api.UserApi;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.context.ClientCredentialAdminContext;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YodleeAdminService {

    private final UserApi userApi;
    private final ProvidersApi providersApi;

    public YodleeAdminService(CredentialsFactory credentialsFactory) {
        ClientCredentialAdminContext credentials = credentialsFactory.getAdminCredentials();
        userApi = new UserApi(credentials);
        providersApi = new ProvidersApi(credentials);
    }

    @SneakyThrows
    public void registerUser(String loginName) {
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.setLoginName(loginName);
        UserRequest userRequest = new UserRequest();
        userRequest.setUser(userRegistration);
        userApi.registerUser(userRequest);
    }

    @SneakyThrows
    public List<Providers> getAllProviders(int start, int end) {
        ApiResponse<ProviderResponse> apiResponse =
                providersApi.getAllProviders(null, null, null, null,
                        start, end, null);
        ProviderResponse providerResponse = apiResponse.getData();
        return providerResponse.getProviders();
    }

}
