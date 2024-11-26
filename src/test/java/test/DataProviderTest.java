package test;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.UserPages;
import payload.User;
import utils.DataProviderClass;

public class DataProviderTest {

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

    @Test(priority = 1, dataProvider = "testData", dataProviderClass=DataProviderClass.class)
    public void createUser(String username, String password) {
        userPayload.setUsername(username);
        userPayload.setPassword(password);
        Response response = userPages.createUser(userPayload);
        Assert.assertEquals(response.statusCode(), 200);
    }

}
