package com.api.module6;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.api.pojo.User;
import com.api.tests.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

import java.util.List;
import java.util.Arrays;

public class DeserializationWithJacksonTest extends BaseTest {

    @Test
    public void getUsersUsingJackson() throws Exception {

        // Get response
        Response response =
                given()
                        .when()
                        .get("api/users")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        // Convert response → JSON string
        String jsonResponse = response.asString();

        System.out.println("Response JSON: " + jsonResponse);

        // Create ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // Convert JSON → Array of User objects
        User[] usersArray = mapper.readValue(jsonResponse, User[].class);

        // Convert array → List (optional)
        List<User> users = Arrays.asList(usersArray);

        // Access values
        System.out.println("First user name: " + users.get(0).getName());
        System.out.println("First user email: " + users.get(0).getEmail());
    }
}