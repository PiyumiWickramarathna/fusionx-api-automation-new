package api.endpoints;

import config.factory.ApiConfigFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.BDDAssertions.then;


public class Routes {

    private static final String BASE_URL = ApiConfigFactory.getConfig().apiBaseUrl();


    @Getter
    public static String accessToken;

    @Getter
    public static String loginAccessToken;




    @Scheduled
    public static  Response getRequest(Object jsonBody, String endpoint) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonBody)
                //.header("Authorization","Bearer "+accessToken)
                .when()
                   .get(BASE_URL+endpoint);

    }
    public static  Response getCustomerById( String endpoint) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                //.body(jsonBody)
                //.header("Authorization","Bearer "+accessToken)
                .when()
                  .get(BASE_URL+endpoint);

    }
    public static  Response getProductByAccountType( String endpoint) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                //.body(jsonBody)
                //.header("Authorization","Bearer "+accessToken)
                .when()
                .get(BASE_URL+endpoint);

    }

    public static  Response getRequestLogIn(String endpoint, String cusLoginAccess) {
        return given()
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+cusLoginAccess)
                .when()
                .get(BASE_URL+endpoint);
    }

    public static  Response geKycTypes(String endpoint, String loginAccessToken) {
        return given()
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+loginAccessToken)
                .when()
                .get(BASE_URL+endpoint);
    }

    public static  Response getPaymentSources(String endpoint, String loginAccessToken) {
        return given()
                .accept(ContentType.JSON)
                .header("Authorization","Bearer "+loginAccessToken)
                .when()
                .get(BASE_URL+endpoint);
    }

    public static Response putRequest(String id,Object jsonBodyPut,String endpoint){
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id", id)
                .body(jsonBodyPut)
                .when()
                .put(BASE_URL+endpoint);
    }

    public static Response deleteRequest(String id,String endpoint){
        return given()
                .pathParam("id",id)
                .accept(ContentType.JSON)
                .when()
                .delete(BASE_URL+endpoint);
    }
    public static  Response postRequest(Object jsonBody, String endpoint) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonBody)
                .then()
              // .header("Authorization","Bearer "+accessToken)
                .when()
                   .post(BASE_URL+endpoint);



    }
}

