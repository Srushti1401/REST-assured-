package com.api.module6;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import com.api.pojo.User;
import com.api.tests.BaseTest;

import io.restassured.common.mapper.TypeRef;

public class DeserializationTest extends BaseTest {

    @Test
    public void getUsers() {

        // Convert JSON array → List<User>
        List<User> users =
                given()
                        .when()
                        .get("api/users")
                        .then()
                        //.log().all()
                        .statusCode(200)
                        .extract()
                        .as(new TypeRef<List<User>>() {});

        // Use data like normal Java
        System.out.println(users.get(3).getName());
        System.out.println(users.get(3).getEmail());
    }
}