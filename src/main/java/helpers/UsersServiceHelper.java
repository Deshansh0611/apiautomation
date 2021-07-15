package helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import constants.Endpoints;
import dto.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
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

    public List<User> getAllUsers() {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .get(Endpoints.GET_ALL_USERS)
                .andReturn();
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Status code is 200");
        Type type = new TypeReference<List<User>>(){}.getType();
        List<User> userList = response.as(type);
        return userList;
    }

    public Response createUser() {
        User user = new User();
        user.setId(7);
        user.setAge(19);
        user.setFirstName("Ghan");
        user.setLastName("Shyam");
        user.setCompanyId("Google");
        user.setEmail("ghan.shyam@gmail.com");

        Response response = RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .body(user)
                .post(Endpoints.CREATE_USER)
                .andReturn();
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
        return response;
    }

    public Response patchUser(Integer id) {
        User user = new User();
        user.setId(1);
        user.setEmail("kurt.cobain@gmail.com");
        user.setCompanyId("Postman");
        user.setFirstName("Kurt");
        user.setLastName("Cobain");
        user.setAge(27);
        Response response = RestAssured.given()
                .when()
                .contentType(ContentType.JSON)
                .body(user)
                .pathParam("id", id)
                .patch(Endpoints.UPDATE_USER)
                .andReturn();
        Assert.assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
        return response;
    }

    public Response deleteUser(Integer id) {
        Response response = RestAssured.given()
                .pathParam("id", id)
                .log().all()
                .contentType(ContentType.JSON)
                .delete(Endpoints.DELETE_USER)
                .andReturn();
        Assert.assertTrue(response.getStatusCode() == HttpStatus.SC_OK);
        return response;
    }
}
