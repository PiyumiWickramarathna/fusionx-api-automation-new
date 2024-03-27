package api.endpoints;
import api.utilities.utility;
import config.factory.ApiConfigFactory;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;
public class AccountCreationRequest {


    public void casaAccountCustomerCreationForExistingCustomer(String tenantId,String accountCreationPath,String userName) throws IOException, ParseException {
    String endpoint = ApiConfigFactory.getConfig().accountCreation();
    endpoint = endpoint.replace("{tenantId}",tenantId);


    JSONObject accountCreationReq = (JSONObject) utility.jsonReader(accountCreationPath);
    System.out.println("jSon request :"+accountCreationReq);
    Response response = Routes.postRequest(  endpoint,accountCreationReq,userName);
    System.out.println("response for account Creation: "+response.prettyPrint());


}



   public void casaSearchCustomer(String accessToken,String tenantId,String searchCustomerPath) throws IOException, ParseException {
       String endpoint = ApiConfigFactory.getConfig().searchCustomer();
       endpoint = endpoint.replace("{tenantId}",tenantId);

       JSONObject searchCustomerReq = (JSONObject) utility.jsonReader(searchCustomerPath);
       System.out.println("jSon request :"+searchCustomerReq);
       Response response = Routes.getRequest(accessToken,searchCustomerReq, endpoint);
       System.out.println("response for account Creation: "+response.prettyPrint());


   }

    public void getCustomerById(String tenantId, String cusId) throws IOException, ParseException {
        String endpoint = ApiConfigFactory.getConfig().getCustomerById();
        endpoint = endpoint.replace("{tenantId}",tenantId).replace("{cusId}",cusId);;


        //JSONObject searchCustomerReq = (JSONObject) utility.jsonReader(searchCustomerById);
        //System.out.println("jSon request :"+searchCustomerReq);
        Response response = Routes.getCustomerById(endpoint);
       System.out.println("response for account Creation: "+response.prettyPrint());


    }
    public void getProductByAccountType(String tenantId,String accounttype){
        String endpoint = ApiConfigFactory.getConfig().getProductByAccountType();
        endpoint = endpoint.replace("{tenantId}",tenantId).replace("{accounttype}",accounttype);;


        //JSONObject searchCustomerReq = (JSONObject) utility.jsonReader(searchCustomerById);
        //System.out.println("jSon request :"+searchCustomerReq);
        Response response = Routes.getProductByAccountType( endpoint);
        System.out.println("response for account Creation: "+response.prettyPrint());

    }
    public void casaAccountGetSubProductByProductId(String tenantId,String productId){
        String endpoint = ApiConfigFactory.getConfig().getSubProductByProductId();
        endpoint = endpoint.replace("{tenantId}",tenantId).replace("{productId}",productId);;


        //JSONObject searchCustomerReq = (JSONObject) utility.jsonReader(searchCustomerById);
        //System.out.println("jSon request :"+searchCustomerReq);
        Response response = Routes.getSubProductByProductId( endpoint);
        System.out.println("response for account Creation: "+response.prettyPrint());

    }
    public void casaAccountGetAccountSchemeTypes(String tenantId){
        String endpoint = ApiConfigFactory.getConfig().getAccountScheme();
        endpoint = endpoint.replace("{tenantId}",tenantId);


        //JSONObject searchCustomerReq = (JSONObject) utility.jsonReader(searchCustomerById);
        //System.out.println("jSon request :"+searchCustomerReq);
        Response response = Routes.getAccountSchemeTypes(endpoint);
        System.out.println("response for account Creation: "+response.prettyPrint());
    }
    public void casaGetAccountPeriodByActiveStatus(String tenantId,String status1){
        String endpoint = ApiConfigFactory.getConfig().getPeriodByStatus();
        endpoint = endpoint.replace("{tenantId}",tenantId).replace("{status}",status1);;


        //JSONObject searchCustomerReq = (JSONObject) utility.jsonReader(searchCustomerById);
        //System.out.println("jSon request :"+searchCustomerReq);
        Response response = Routes.getPeriodByStatus( endpoint);
        System.out.println("response for account Creation: "+response.prettyPrint());

    }
    public void casaGetAccountPeriodByInActiveStatus(String tenantId,String status2){
        String endpoint = ApiConfigFactory.getConfig().getPeriodByStatus();
        endpoint = endpoint.replace("{tenantId}",tenantId).replace("{status}",status2);;


        //JSONObject searchCustomerReq = (JSONObject) utility.jsonReader(searchCustomerById);
        //System.out.println("jSon request :"+searchCustomerReq);
        Response response = Routes.getPeriodByStatus( endpoint);
        System.out.println("response for account Creation: "+response.prettyPrint());

    }
    public void casaAccountSearchSupplies(String tenantId, String suppliesType,String searchSuppliesType) throws IOException, ParseException {
        String endpoint = ApiConfigFactory.getConfig().getSearchSupplies();
        endpoint = endpoint.replace("{tenantId}",tenantId).replace("{suppliesType}",suppliesType);;


        JSONObject SuppliesType = (JSONObject) utility.jsonReader(searchSuppliesType);
        System.out.println("jSon request :"+SuppliesType);
        Response response = Routes.getRequestSearchSupplies( SuppliesType,endpoint);
        System.out.println("response for search SuppliesType: "+response.prettyPrint());

    }
    public void casaAccountCalculatedChargeDetails(String tenantId , String subProductId ,String AccountCalculateCharge  ) throws IOException, ParseException {
        String endpoint = ApiConfigFactory.getConfig().getCalculatedChargeDetails();
        endpoint = endpoint.replace("{tenantId}",tenantId).replace("{subProductId}",subProductId);;


        JSONObject ChargeDetails = (JSONObject) utility.jsonReader(AccountCalculateCharge);
        System.out.println("jSon request :"+ChargeDetails);
        Response response = Routes.getRequestAccountCalculatedChargeDetails( ChargeDetails,endpoint);
        System.out.println("response for calculationDetails: "+response.prettyPrint());


    }

    }


