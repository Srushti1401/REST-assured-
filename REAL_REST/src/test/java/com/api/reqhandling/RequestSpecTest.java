package com.api.reqhandling;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.api.tests.BaseTest;

import io.restassured.specification.RequestSpecification;

public class RequestSpecTest extends BaseTest {

    @Test
    public void createUserUsingRequestSpec() {

        // Get reusable request spec
        RequestSpecification requestSpec = RequestSpecBuilderUtil.getRequestSpec();

        String jsonBody = "{ \"name\": \"specUser11\", \"email\": \"spec11@gmail.com\" }";

        given()
                .spec(requestSpec)
                .body(jsonBody)
                .when()
                .post("api/users")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getUsersUsingRequestSpec() {

        RequestSpecification requestSpec = RequestSpecBuilderUtil.getRequestSpec();

        given()
                .spec(requestSpec)
                .when()
                .get("api/users")
                .then()
                .log().all()
                .statusCode(200);
    }
}