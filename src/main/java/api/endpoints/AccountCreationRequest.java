package api.endpoints;
import api.utilities.utility;
import config.factory.ApiConfigFactory;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.logging.Logger;


//@Component
//@Configuration
//@EnableScheduling
public class AccountCreationRequest {


   // public static  Logger logger = (Logger) LoggerFactory.getLogger(AccountCreationRequest.class);



    public void casaAccountCustomerCreationForExistingCustomer(String tenantId,String accountCreationPath) throws IOException, ParseException {
    String endpoint = ApiConfigFactory.getConfig().accountCreation();
    endpoint = endpoint.replace("{tenantId}",tenantId);


    JSONObject accountCreationReq = (JSONObject) utility.jsonReader(accountCreationPath);
    System.out.println("jSon request :"+accountCreationReq);
    Response response = Routes.postRequest( accountCreationReq, endpoint);
    System.out.println("response for account Creation: "+response.prettyPrint());


}



   public void casaSearchCustomer(String tenantId,String searchCustomerPath) throws IOException, ParseException {
       String endpoint = ApiConfigFactory.getConfig().searchCustomer();
       endpoint = endpoint.replace("{tenantId}",tenantId);

       JSONObject searchCustomerReq = (JSONObject) utility.jsonReader(searchCustomerPath);
       System.out.println("jSon request :"+searchCustomerReq);
       Response response = Routes.getRequest(searchCustomerReq, endpoint);
       System.out.println("response for account Creation: "+response.prettyPrint());


   }
//   public void getCustomerById(String tenantId,String searchCustomerPath){
//        String
//   }

    public void getCustomerById(String tenantId, String cusId) throws IOException, ParseException {
        String endpoint = ApiConfigFactory.getConfig().getCustomerById();
        endpoint = endpoint.replace("{tenantId}",tenantId).replace("{cusId}",cusId);;


        //JSONObject searchCustomerReq = (JSONObject) utility.jsonReader(searchCustomerById);
        //System.out.println("jSon request :"+searchCustomerReq);
        Response response = Routes.getCustomerById( endpoint);
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

}
