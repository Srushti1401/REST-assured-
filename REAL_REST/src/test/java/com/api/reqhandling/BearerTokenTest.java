package com.api.reqhandling;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.api.tests.BaseTest;

public class BearerTokenTest extends BaseTest {

    @Test
    public void bearerTokenExample() {

        String token = "ABCD_123";  // replace with real token

        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("api/users")
                .then()
                .statusCode(200);
    }
}