package com.api.responsehandling;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ExtractListTest {

    @Test
    public void extractList() {

        Response response = given()
                .baseUri("http://localhost:8081")
                .when()
                .get("/api/users");


        System.out.println(response.asString());


        List<String> names = response.jsonPath().getList("name");


        List<String> emails = response.jsonPath().getList("email");

        System.out.println("Names: " + names);
        System.out.println("Emails: " + emails);
    }
}