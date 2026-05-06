package com.api.reqhandling;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.api.tests.BaseTest;

public class BasicAuthTest extends BaseTest {

    @Test
    public void basicAuthExample() {

        given()
                .auth()
                .basic("Srushti", "Srushti123")   // replace with real creds
                .when()
                .get("api/users")
                .then()
                .statusCode(200);
    }
}
