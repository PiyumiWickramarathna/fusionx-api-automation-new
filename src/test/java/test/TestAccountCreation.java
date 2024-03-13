package test;

import api.endpoints.AccountCreationRequest;
import api.utilities.AccessTokenGenerator;
import config.factory.ApiConfigFactory;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestAccountCreation {

    @Getter @Setter
    public static String accessToken;

    AccessTokenGenerator accessTokenCreation = new AccessTokenGenerator();


   AccountCreationRequest accountCreation = new AccountCreationRequest();


    @BeforeClass(groups = {"regression", "CustomerRegistrationGroup", "test"})
    public static void accessToken() throws IOException, ParseException {
        AccessTokenGenerator accessTokenCreation = new AccessTokenGenerator();
        accessToken = accessTokenCreation.getAccessTokenCreation();
        System.out.println("access Token:"+accessToken);


    }

@Test
    public void createUser() throws IOException, ParseException {
        String tenantId = "cMwNb";
       String accessToken = accessTokenCreation.getAccessTokenCreation();
        String accountCreationPath = "src/test/resources/CASA/casa-account-creation-existingCustomer.json";
        accountCreation.casaAccountCustomerCreationForExistingCustomer(accessToken,tenantId,accountCreationPath);
    }
}
