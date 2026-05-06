package com.api.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostUserTest extends BaseTest {

    @Test
    public void createUser() {

        given()
                .header("Content-Type", "application/json")
                .body("{\"name\":\"Srushtiii\",\"email\":\"srushti11@gmail.com\"}")
                .when()
                .post("/api/users")
                .then()
                .log().all()
                .statusCode(201);
    }
}