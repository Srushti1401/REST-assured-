package com.api.module6;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.api.pojo.User;
import com.api.tests.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationWithJacksonTest extends BaseTest {

    @Test
    public void createUserUsingJackson() throws Exception {

        // Create Java object
        User user = new User();
        user.setName("jacksonUser");
        user.setEmail("jackson@gmail.com");

        // Create ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // Convert Java object → JSON string
        String jsonBody = mapper.writeValueAsString(user);

        System.out.println("Request JSON: " + jsonBody);

        // Send request
        given()
                .header("Content-Type", "application/json")
                .body(jsonBody)   // sending JSON manually
                .when()
                .post("api/users")
                .then()
                .statusCode(201);
    }
}