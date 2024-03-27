package test;

import api.endpoints.AccountCreationRequest;
import api.utilities.AccessTokenGenerator;
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


//    @BeforeClass(groups = {"regression", "CustomerRegistrationGroup", "test"})
//    public static void accessToken() throws IOException, ParseException {
//        AccessTokenGenerator accessTokenCreation = new AccessTokenGenerator();
//        accessToken = accessTokenCreation.getAccessTokenCreation();
//        System.out.println("access Token:"+accessToken);
//
//
//    }

@Test(priority = 1, testName = "Verify system behavior when create the casa Account.", groups = {"regression"})
    public void createUser() throws IOException, ParseException {
        String tenantId = "AnRkr";
        String userName = "nilmieg";
       // String accessToken = accessTokenCreation.getAccessTokenCreation();
        String accountCreationPath = "src/test/resources/CASA/casa-account-creation-existingCustomer.json";
        accountCreation.casaAccountCustomerCreationForExistingCustomer(tenantId,accountCreationPath,userName);
    }

    @Test(priority = 1, testName = "Verify system behavior when Search the user.", groups = {"regression"})
    public void searchUser() throws IOException, ParseException {
        String tenantId = "AnRkr";
        //String accessToken = accessTokenCreation.getAccessTokenCreation();
        String searchUserPath = "src/test/resources/CASA/customer-search.json";
        accountCreation.casaSearchCustomer(accessToken,tenantId,searchUserPath);
    }
    @Test(priority = 2, testName = "Verify system behavior when Get user By ID.", groups = {"regression"})
    public void getUserById() throws IOException, ParseException {
        String tenantId = "AnRkr";
        String cusId    = "238553";
        accountCreation.getCustomerById(tenantId,cusId);


    }
    @Test(priority = 3, testName = "Verify system behavior when Get user By ID.", groups = {"regression"})
    public void getProductByAccountType() throws IOException, ParseException {
        String tenantId = "AnRkr";
        String accounttype    = "SAVINGS";
        accountCreation.getProductByAccountType(tenantId,accounttype);

    }
    @Test(priority = 4, testName = "Verify system behavior when Get user By ID.", groups = {"regression"})
    public void getSubProductByProductId() throws IOException, ParseException {
        String tenantId = "AnRkr";
        String productId    = "142422668";
        accountCreation.casaAccountGetSubProductByProductId(tenantId,productId);

    }
    @Test(priority = 5, testName = "Verify system behavior when Get user By ID.", groups = {"regression"})
    public void getAccountSchemeTypes() throws IOException, ParseException {
        String tenantId = "AnRkr";
        accountCreation.casaAccountGetAccountSchemeTypes(tenantId);

    }
    @Test(priority = 6, testName = "Verify system behavior when Get Period By Status.", groups = {"regression"})
    public void getPeriodByStatus(){
        String tenantId = "AnRkr";
        String status1    = "ACTIVE";
        String status2    = "INACTIVE";

        System.out.println(" ***************** ACTIVE STATUS DETAILS *****************");
        accountCreation.casaGetAccountPeriodByActiveStatus(tenantId,status1);
        System.out.println(" ***************** INACTIVE STATUS DETAILS *****************");
        accountCreation.casaGetAccountPeriodByInActiveStatus(tenantId,status2);

    }
    @Test(priority = 7, testName = "Verify system behavior when Search Supplies.", groups = {"regression"})
    public void searchSupplies() throws IOException, ParseException {
        String tenantId = "AnRkr";
        String suppliesType = "INTRODUCER";
        String searchUserPath = "src/test/resources/CASA/get-search-Supplies.json";
        accountCreation.casaAccountSearchSupplies(tenantId, suppliesType  ,searchUserPath);
    }
//    @Test(priority = 7, testName = "Verify system behavior when Search Supplies.", groups = {"regression"})
//    public void searchSupplies() throws IOException, ParseException {
//        String tenantId = "AnRkr";
//        String suppliesType = "INTRODUCER";
//        String searchUserPath = "src/test/resources/CASA/get-search-Supplies.json";
//        accountCreation.casaAccountSearchSupplies(tenantId, suppliesType  ,searchUserPath);
//    }

    @Test(priority = 8, testName = "Verify system behavior when Search Supplies.", groups = {"regression"})
    public void getCalculatedChargeDetails() throws IOException, ParseException {
        String tenantId = "AnRkr";
        String subProductId = "142582668";
        String accountChargePath = "src/test/resources/CASA/get-acccount-charge-details.json";
        accountCreation.casaAccountCalculatedChargeDetails(tenantId, subProductId  ,accountChargePath);
    }



}
