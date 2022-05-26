package com.tecacet.yodlee.credentials;

import com.yodlee.sdk.context.ClientCredentialAdminContext;
import com.yodlee.sdk.context.ClientCredentialUserContext;
import com.yodlee.sdk.context.ContextType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CredentialsFactoryTest {

    @Autowired
    private CredentialsFactory credentialsFactory;

    @Test
    void getAdminCredentials() {
        ClientCredentialAdminContext adminContext = credentialsFactory.getAdminCredentials();
        assertEquals(ContextType.COBRAND, adminContext.getContextType());
    }

    @Test
    void getUserCredentials() {
        String loginName = "sbMem623b8980dwbcf1";
        ClientCredentialUserContext userContext = credentialsFactory.getUserCredentials(loginName);
        assertEquals(ContextType.USER, userContext.getContextType());
    }
}