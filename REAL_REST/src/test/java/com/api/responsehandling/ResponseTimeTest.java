package com.api.responsehandling;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseTimeTest {

    @Test
    public void validateResponseTimeInline() {

        long time = given()
                .baseUri("http://localhost:8081")
                .when()
                .get("/api/users/1")
                .then()
                .extract()
                .time();

        System.out.println("Response Time: " + time + " ms");

        // assertion
        org.testng.Assert.assertTrue(time < 2000);
    }
}