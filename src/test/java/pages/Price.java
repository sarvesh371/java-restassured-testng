package pages;

import endpoints.Endpoints;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Price {

    public Response getPrice() {
        return given()
                .contentType("application/json")
                .when()
                .get(Endpoints.priceApi);

    }
}
