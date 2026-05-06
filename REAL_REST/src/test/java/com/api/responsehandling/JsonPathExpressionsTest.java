package com.api.responsehandling;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class JsonPathExpressionsTest {

    @Test
    public void jsonPathExamples() {

        Response response = given()
                .baseUri("http://localhost:8081")
                .when()
                .get("/api/users");

        System.out.println(response.asString());

        //  Get all names
        List<String> names = response.jsonPath().getList("name");
        System.out.println("All Names: " + names);

        //  Get first name
        String firstName = response.jsonPath().getString("[0].name");
        System.out.println("First Name: " + firstName);

        //  Find user with id = 2
        String user = response.jsonPath()
                .getString("find { it.id == 2 }.name");
        System.out.println("User with ID 2: " + user);

        //  Find users with id > 1
        List<String> filtered = response.jsonPath()
                .getList("findAll { it.id > 1 }.name");
        System.out.println("Filtered Users: " + filtered);
    }
}