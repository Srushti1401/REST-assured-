package com.api.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class UpdateUserTest extends BaseTest {

    @Test
    public void updateUser() {

        given()
                .header("Content-Type", "application/json")
                .pathParam("id", 1)
                .body("{\"name\":\"Updated\",\"email\":\"updated@gmail.com\"}")
                .when()
                .put("/api/users/{id}")
                .then()
                .log().all()
                .statusCode(200);
    }
}