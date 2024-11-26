package utils;

import org.testng.annotations.DataProvider;

public class DataProviderClass {


    @DataProvider(name = "testData")
    public Object[][] data() {
        return new Object[][] {
                { "user1", "password1" },
                { "user2", "password2" },
        };
    }

}
