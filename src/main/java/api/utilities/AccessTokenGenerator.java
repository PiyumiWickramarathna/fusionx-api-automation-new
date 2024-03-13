package api.utilities;

import config.factory.ApiConfigFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class AccessTokenGenerator {

    public String getAccessTokenCreation() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonBody = (JSONObject) parser.parse(new FileReader(ApiConfigFactory.getConfig().pathAccessToken()));

        return given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", jsonBody.get("grant_type"))
                .formParam("username",jsonBody.get("username"))
                .formParam("password",jsonBody.get("password"))
                .formParam("client_id",jsonBody.get("client_id"))
               // .formParam("client_secret",jsonBody.get("client_secret"))
                .cookie("cookie",jsonBody.get("cookie"))
                .when()
                .post(ApiConfigFactory.getConfig().tokenUrl())
                .then()
                .log().all()
                .extract().body().jsonPath().getString("access_token");
    }


}
