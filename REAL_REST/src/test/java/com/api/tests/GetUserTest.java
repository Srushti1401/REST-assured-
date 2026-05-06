package com.api.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GetUserTest extends BaseTest {

    @Test
    public void getAllUsers() {

        given()
                //.pathParam("id", 1)
                .when()
                //.get("/api/users/{id}")
                .get("/api/users")
                .then()
                .log().all()
                .statusCode(200);
    }
}