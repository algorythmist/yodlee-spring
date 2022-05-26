package com.tecacet.yodlee.service;

import com.tecacet.yodlee.credentials.SecretsRepository;
import com.tecacet.yodlee.model.BearerToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class BearerTokenProvider {

    @Value("${yodlee.base.path}")
    private String baseUrl;

    private final RestTemplate restTemplate;
    private final SecretsRepository secretsRepository;

    public BearerToken getBearerToken(String loginName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Api-Version", "1.1");
        headers.set("loginName", loginName);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("clientId", secretsRepository.clientId());
        map.add("secret", secretsRepository.clientSecret());

        HttpEntity request = new HttpEntity(map, headers);
        String url = String.format("%s/auth/token", baseUrl);
        ResponseEntity<BearerToken> response = restTemplate.exchange(url, HttpMethod.POST,
                request, BearerToken.class);
        return response.getBody();
    }

}
