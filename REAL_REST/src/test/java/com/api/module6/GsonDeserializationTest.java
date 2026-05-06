package com.api.module6;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.api.pojo.User;
import com.api.tests.BaseTest;
import com.google.gson.Gson;

import io.restassured.response.Response;

import java.util.List;
import java.util.Arrays;

public class GsonDeserializationTest extends BaseTest {

    @Test
    public void getUsersUsingGson() {

        //  Hit API
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

        //  Create Gson instance
        Gson gson = new Gson();

        //  Convert JSON → Java array
        User[] userArray = gson.fromJson(jsonResponse, User[].class);

        //  Convert array → List (optional but useful)
        List<User> users = Arrays.asList(userArray);

        // Access data
        System.out.println("First User Name: " + users.get(0).getName());
        System.out.println("First User Email: " + users.get(0).getEmail());
    }
}