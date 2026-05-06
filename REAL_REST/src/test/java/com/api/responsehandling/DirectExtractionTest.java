package com.api.responsehandling;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DirectExtractionTest {

    @Test
    public void directExtraction() {


        String name = given()
                .baseUri("http://localhost:8081")
                .when()
                .get("/api/users/1")
                .then()
                .extract()
                .path("name");

        System.out.println("Name: " + name);
    }
}