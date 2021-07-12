package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuthenticationUtil {
    public static String userId;

    public static void main(String[] args) {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();
        JSONObject params = new JSONObject();
        params.put("UserName", "Dexter-001");
        params.put("Password", "Test@123");
        Response response = request.body(params.toJSONString())
                .post("/Account/v1/User");
        System.out.println(response.getStatusCode());
        if(response.getStatusCode() == 200) {
            System.out.println(response);
            userId = response.getBody().jsonPath().getString("userID");
        }
        System.out.println(userId);
    }
}
