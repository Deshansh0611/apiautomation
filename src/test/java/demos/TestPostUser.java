package demos;

import helpers.UsersServiceHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPostUser {
    private UsersServiceHelper usersServiceHelper;

    @BeforeClass
    public void init() {
        usersServiceHelper = new UsersServiceHelper();
    }

    @Test
    public void testPostCreateUser() {
        String id = usersServiceHelper.createUser().jsonPath().getString("id");
        Assert.assertNotNull(id);
    }
}
