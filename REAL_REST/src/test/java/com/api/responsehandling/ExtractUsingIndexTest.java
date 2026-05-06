package com.api.responsehandling;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ExtractUsingIndexTest {

    @Test
    public void extractUsingIndex() {

        Response response = given()
                .baseUri("http://localhost:8081")
                .when()
                .get("/api/users");


        System.out.println(response.asString());


        String firstName = response.jsonPath().getString("[0].name");


        String secondEmail = response.jsonPath().getString("[1].email");

        System.out.println("First User Name: " + firstName);
        System.out.println("Second User Email: " + secondEmail);
    }
}