package demos;

import helpers.UsersServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestDeleteUser {
    private UsersServiceHelper usersServiceHelper;

    @BeforeClass
    public void init() {
        usersServiceHelper = new UsersServiceHelper();
    }

    @Test
    public void testDeleteUser() {
        usersServiceHelper.deleteUser(7);
    }
}
