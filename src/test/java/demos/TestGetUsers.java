package demos;

import dto.User;
import helpers.UsersServiceHelper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import java.util.List;

public class TestGetUsers {
    private UsersServiceHelper usersServiceHelper;

    @BeforeClass
    public void init() {
        usersServiceHelper = new UsersServiceHelper();
    }

    @Test
    public void testGetAllUsers() {
        List<User> userList = usersServiceHelper.getAllUsers();
        assertNotNull(userList, "Users list is not null!");
        assertNotNull(userList.isEmpty(), "Users list is not empty!");

    }
}
