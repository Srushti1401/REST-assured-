package com.api.module6;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.api.pojo.User;
import com.api.tests.BaseTest;

public class SerializationTest extends BaseTest {

    @Test
    public void createUser() {

        // Create Java object
        User user = new User();
        user.setName("newUser");
        user.setEmail("newuser@gmail.com");

        given()
                .header("Content-Type", "application/json")
                .body(user)   // object → JSON
                .when()
                .post("api/users")
                .then()
                .log().all()
                .statusCode(201);
    }
}