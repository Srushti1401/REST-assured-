package com.api.responsehandling;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ExtractDifferentTypesTest {

    @Test
    public void extractDifferentTypes() {

        Response response = given()
                .baseUri("http://localhost:8081")
                .when()
                .get("/api/users/1");


        System.out.println(response.asString());


        int id = response.jsonPath().getInt("id");
        String name = response.jsonPath().getString("name");
        String email = response.jsonPath().getString("email");


        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}