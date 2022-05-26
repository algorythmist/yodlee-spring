package com.tecacet.yodlee.model;

import lombok.Data;

@Data
public class AccountPayload {

    private String requestId;
    private String providerId;
    private String providerName;
    private String providerAccountId;
    private String status;
}
