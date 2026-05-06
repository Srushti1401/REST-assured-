package com.api.module5;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ValidationTest {

    @Test
    public void validateUsersAPI() {

        given()
                .when()
                .get("http://localhost:8081/api/users")
                .then()
                .statusCode(200)

                // 🔹 notNullValue → field should exist
                .body("[0].id", notNullValue())

                // 🔹 equalTo → exact match
                .body("[0].name", equalTo("Srushti"))

                // 🔹 containsString → partial match
                .body("[0].email", containsString("@gmail.com"))

                // 🔹 hasItems → check values inside list
                .body("name", hasItems("Srushti", "Rammmm"));
    }
}