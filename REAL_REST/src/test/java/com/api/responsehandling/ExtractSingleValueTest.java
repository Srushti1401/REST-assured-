package com.api.responsehandling;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ExtractSingleValueTest {

    @Test
    public void extractSingleValue() {

        Response response = given()
                .baseUri("http://localhost:8081")
                .when()
                .get("/api/users/1");


        //System.out.println(response.asString());


        String name = response.jsonPath().getString("name");

        System.out.println("Name: " + name);
    }
}