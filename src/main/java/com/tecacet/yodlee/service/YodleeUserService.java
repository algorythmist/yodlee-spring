package com.tecacet.yodlee.service;

import com.yodlee.api.model.account.Account;
import com.yodlee.api.model.account.response.AccountResponse;
import com.yodlee.api.model.providers.Providers;
import com.yodlee.api.model.providers.response.ProviderResponse;
import com.yodlee.sdk.api.AccountsApi;
import com.yodlee.sdk.api.ProvidersApi;
import com.yodlee.sdk.client.ApiResponse;
import com.yodlee.sdk.context.ClientCredentialUserContext;
import lombok.SneakyThrows;

import java.util.List;

public class YodleeUserService {

    private final ProvidersApi providersApi;
    private final AccountsApi accountsApi;

    YodleeUserService(ClientCredentialUserContext credentials) {
        providersApi = new ProvidersApi(credentials);
        accountsApi = new AccountsApi(credentials);
    }

    @SneakyThrows
    public List<Providers> getAllProviders(int start, int end) {
        ApiResponse<ProviderResponse> apiResponse =
                providersApi.getAllProviders(null, null, null, null,
                        start, end, null);
        int status = apiResponse.getStatusCode();
        ProviderResponse providerResponse = apiResponse.getData();
        return providerResponse.getProviders();
    }

    @SneakyThrows
    public List<Account> getAccounts(Long[] accountIds) {
        ApiResponse<AccountResponse> apiResponse =
                accountsApi.getAllAccounts(accountIds, null, null, null, null, null);
        int status = apiResponse.getStatusCode();
        System.out.println("Status: " + status);
        AccountResponse accountResponse = apiResponse.getData();
        return accountResponse.getAccount();
    }

}
