package api.endpoints;
import api.utilities.utility;
import config.factory.ApiConfigFactory;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;



public class AccountCreationRequest {

public void casaAccountCustomerCreationForExistingCustomer(String tenantId,String accountCreationPath,String accessToken) throws IOException, ParseException {
    String endpoint = ApiConfigFactory.getConfig().accountCreation();
    endpoint = endpoint.replace("{tenantId}",tenantId);

    JSONObject accountCreationReq = (JSONObject) utility.jsonReader(accountCreationPath);
    System.out.println("jSon request :"+accountCreationReq);
    Response response = Routes.postRequest(accountCreationReq, endpoint,accessToken);
    System.out.println("response for account Creation: "+response.prettyPrint());

}
}
