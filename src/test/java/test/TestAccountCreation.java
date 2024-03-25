package test;

import api.endpoints.AccountCreationRequest;
//import api.utilities.AccessTokenGenerator;
import lombok.Getter;
import lombok.Setter;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
 import io.restassured.RestAssured.*;
 import io.restassured.matcher.RestAssuredMatchers.*;
 import org.hamcrest.Matchers.*;

import java.io.IOException;

public class TestAccountCreation {

    @Getter @Setter
    public static String accessToken;

  //AccessTokenGenerator accessTokenCreation = new AccessTokenGenerator();


   AccountCreationRequest accountCreation = new AccountCreationRequest();


//    @BeforeClass(groups = {"regression", "CustomerRegistrationGroup", "test"})
//    public static void accessToken() throws IOException, ParseException {
//        AccessTokenGenerator accessTokenCreation = new AccessTokenGenerator();
//        accessToken = accessTokenCreation.getAccessTokenCreation();
//        System.out.println("access Token:"+accessToken);
//
//
//    }

@Test(priority = 1, testName = "Verify system behavior when create the casa Account.", groups = {"regression", "created history"})
    public void createUser() throws IOException, ParseException {
        String tenantId = "AnRkr";
        //String accessToken = accessTokenCreation.getAccessTokenCreation();
        String accountCreationPath = "src/test/resources/CASA/casa-account-creation-existingCustomer.json";
        accountCreation.casaAccountCustomerCreationForExistingCustomer(tenantId,accountCreationPath);
    }

    @Test
    public void searchUser() throws IOException, ParseException {
        String tenantId = "AnRkr";
      //  String accessToken = accessTokenCreation.getAccessTokenCreation();
        String searchUserPath = "src/test/resources/CASA/customer-search.json";
        accountCreation.casaSearchCustomer(tenantId,searchUserPath);
    }
    @Test
    public void getUserById() throws IOException, ParseException {
        String tenantId = "AnRkr";
        String cusId    = "238553";

       // String getUserById = "src/test/resources/CASA/get-customer-id.json";
        accountCreation.getCustomerById(tenantId,cusId);


    }
    @Test
    public void getProductByAccountType() throws IOException, ParseException {
        String tenantId = "AnRkr";
        String accounttype    = "SAVINGS";

        // String getUserById = "src/test/resources/CASA/get-customer-id.json";
        accountCreation.getProductByAccountType(tenantId,accounttype);

    }



}
