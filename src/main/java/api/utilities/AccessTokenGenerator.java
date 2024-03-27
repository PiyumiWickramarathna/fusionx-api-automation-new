package api.utilities;

import config.factory.ApiConfigFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class AccessTokenGenerator{


    public String getAccessTokenCreation() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonBody = (JSONObject) parser.parse(new FileReader(ApiConfigFactory.getConfig().pathAccessToken()));

        // Retrieve values from JSON object, handling null values gracefully
        String grantType = getStringOrNull(jsonBody, "grant_type");
        String username = getStringOrNull(jsonBody, "username");
        String password = getStringOrNull(jsonBody, "password");
        String clientId = getStringOrNull(jsonBody, "client_id");
        String clientSecret = getStringOrNull(jsonBody, "client_secret");
        String cookie = getStringOrNull(jsonBody, "cookie");

        // Check if any required value is null
//        if (grantType == null  || clientId == null || clientSecret == null) {
//            throw new IllegalArgumentException("One or more required values are missing or null");
//        }

        return given()
                //.contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", grantType)
                //.formParam("username", username)
                //.formParam("password", password)
                .formParam("client_id", clientId)
                .formParam("client_secret", clientSecret)
                .cookie("cookie", cookie)
                .when()
                // Replace this with the appropriate endpoint or method for your API
                .post("/searchUser") // Example endpoint for authentication
                .then()
                .log().all()
                .extract().body().jsonPath().getString("access_token");
    }

    // Helper method to handle null values gracefully
    private String getStringOrNull(JSONObject jsonObject, String key) {
        Object value = jsonObject.get(key);
        return value != null ? value.toString() : null;
    }
            }
