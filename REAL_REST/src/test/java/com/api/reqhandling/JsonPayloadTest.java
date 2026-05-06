package com.api.reqhandling;


import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.api.tests.BaseTest;

public class JsonPayloadTest extends BaseTest {

    @Test
    public void sendJsonPayload() {

        // JSON as String
        String jsonBody = "{ \"name\": \"jsonUser\", \"email\": \"json@gmail.com\" }";

        given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .post("api/users")
                .then()
                .log().all()
                .statusCode(201);
    }
}