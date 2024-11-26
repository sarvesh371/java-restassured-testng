package pages;


import endpoints.Endpoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;

import static io.restassured.RestAssured.given;

public class UserPages {

    public Response createUser(User payload) {

        return given()
        .contentType(ContentType.JSON)
        .body(payload)
        .when()
            .post(Endpoints.createUser);


    }

    public Response getUser(String username) {

        return given()
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .when()
                .get(Endpoints.getUser);


    }

    public Response updateUser(String username, User payload) {

        return given()
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .body(payload)
                .when()
                .put(Endpoints.updateUser);
    }
}
