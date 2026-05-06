package com.api.tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PutUserTest extends BaseTest {

    @Test
    public void updateUser() {

        // Full object (PUT usually expects full resource)
        String jsonBody = "{ " +
                "\"name\": \"UpdatedName\", " +
                "\"email\": \"updated@gmail.com\" " +
                "}";

        given()
                .header("Content-Type", "application/json")
                .pathParam("id", 1)
                .body(jsonBody)
                .when()
                .put("api/users/{id}")
                .then()
                .log().all()
                .statusCode(200);
    }
}