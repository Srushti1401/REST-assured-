package com.api.module5;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import org.testng.annotations.Test;

public class SchemaTest{

    @Test
    public void validateUserSchema() {

        given()
                .when()
                .get("http://localhost:8081/api/users/1")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("user-schema.json"));
    }
}