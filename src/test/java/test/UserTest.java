package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.UserPages;
import payload.User;

public class UserTest {

    Faker faker;
    User userPayload;

    UserPages userPages = new UserPages();

    @BeforeClass
    public void beforeClass() {
        faker = new Faker();
        userPayload = new User();
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setPhone(faker.phoneNumber().cellPhone());
    }

    @Test(priority = 1)
    public void createUser() {
        Response response = userPages.createUser(userPayload);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 2)
    public void getUserByName() {
        Response response = userPages.getUser(userPayload.getUsername());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 3)
    public void updateUser() {
        userPayload.setFirstName(faker.name().firstName());
        Response response = userPages.updateUser(userPayload.getUsername(), userPayload);
        Assert.assertEquals(response.statusCode(), 200);

        // Verify update
        Response responseGet = userPages.getUser(userPayload.getUsername());
        Assert.assertEquals(responseGet.statusCode(), 200);
    }

}
