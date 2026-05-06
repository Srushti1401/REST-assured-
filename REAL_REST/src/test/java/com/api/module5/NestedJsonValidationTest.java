package com.api.module5;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.api.tests.BaseTest;

public class NestedJsonValidationTest extends BaseTest {

    @Test
    public void validateUsersResponse() {

        given()
                .when()
                .get("api/users")
                .then()
                .statusCode(200)

                // Validate that expected IDs are present in the response array
                .body("id", hasItems(1, 2, 3, 4, 5))

                // Validate that specific user names exist in the list
                .body("name", hasItems("sruuuu", "prati", "ram"))

                // Validate that all email values contain "@gmail.com"
                .body("email", everyItem(containsString("@gmail.com")))

                // Validate the first user's name and email
                .body("[0].name", equalTo("sruuuu"))
                .body("[0].email", equalTo("sruuu@gmail.com"))

                // Validate the last user's name
                .body("[4].name", equalTo("kuks"))

                // Validate total number of users returned
                .body("size()", equalTo(5))

                // Find a user by name and validate the corresponding email
                .body("find { it.name == 'ram' }.email",
                        equalTo("ram@gmail.com"))

                // Validate that all createdAt fields are not null
                .body("createdAt", everyItem(notNullValue()));
    }
}