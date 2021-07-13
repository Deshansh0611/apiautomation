package helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import constants.Endpoints;
import dto.Users;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ConfigManager;

import java.lang.reflect.Type;
import java.util.List;

public class UsersServiceHelper {
    private static final String BASE_URL = ConfigManager.getInstance().getString("base_url");
    private static final String PORT = ConfigManager.getInstance().getString("port");

    public UsersServiceHelper() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();;
    }

    public List<Users> getAllUsers() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(Endpoints.GET_ALL_USERS)
                .andReturn();
        Type type = new TypeReference<List<Users>>(){}.getType();
        List<Users> userList = response.as(type);
        return userList;
    }
}
