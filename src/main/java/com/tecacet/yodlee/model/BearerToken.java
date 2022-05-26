package com.tecacet.yodlee.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@JsonRootName(value = "token")
@Data
public class BearerToken {

    private String accessToken;
    private String issuedAt;
    private int expiresIn;

}
