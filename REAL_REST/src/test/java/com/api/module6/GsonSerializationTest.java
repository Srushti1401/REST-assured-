package com.api.module6;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.api.pojo.User;
import com.api.tests.BaseTest;
import com.google.gson.Gson;

public class GsonSerializationTest extends BaseTest {

    @Test
    public void createUserUsingGson() {

        User user = new User();
        user.setName("gsonUser");
        user.setEmail("gson@gmail.com");

        Gson gson = new Gson();
        String jsonBody = gson.toJson(user);

        given()
                .header("Content-Type", "application/json")
                .body(jsonBody)
                .when()
                .post("api/users")
                .then()
                .log().all()
                .statusCode(201);
    }
}