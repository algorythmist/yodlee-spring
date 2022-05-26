package com.tecacet.yodlee.model;

import lombok.Data;

import java.util.List;


@Data
public class ClosePayload {

    private String action;
    private String fnToCall;
    private List<AccountPayload> sites;

}
