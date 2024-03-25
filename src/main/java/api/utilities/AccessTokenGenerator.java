//package api.utilities;
//
//import config.factory.ApiConfigFactory;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import java.io.FileReader;
//import java.io.IOException;
//
//import static io.restassured.RestAssured.given;
//
//public class AccessTokenGenerator {
//
//    public String getAccessTokenCreation() throws IOException, ParseException {
//        JSONParser parser = new JSONParser();
//        JSONObject jsonBody;
//        try (FileReader reader = new FileReader(ApiConfigFactory.getConfig().pathAccessToken())) {
//            jsonBody = (JSONObject) parser.parse(reader);
//        }
//
//        return given()
//                .formParam("grant_type", jsonBody.get("grant_type"))
//                .formParam("client_id", jsonBody.get("client_id"))
//                .formParam("code_verifier", jsonBody.get("code_verifier"))
//                .cookie("cookie", jsonBody.get("cookie"))
//                .when()
//                .post(ApiConfigFactory.getConfig().tokenUrl())
//                .then()
//                .extract().jsonPath().getString("access_token");
//    }
//}
