package demos;

import helpers.UsersServiceHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPatchUser {
    private UsersServiceHelper usersServiceHelper;

    @BeforeClass
    public void init() {
        usersServiceHelper = new UsersServiceHelper();
    }

    @Test
    public void testPatchUser() {
        int patchId = 3;
        String id = usersServiceHelper.patchUser(3).jsonPath().getString("id");
        Assert.assertNotNull(id);
        Assert.assertEquals(patchId, Integer.parseInt(id));
    }
}
