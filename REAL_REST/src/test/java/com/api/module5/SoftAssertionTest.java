package com.api.module5;

import static io.restassured.RestAssured.*;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import com.api.tests.BaseTest;

import io.restassured.response.Response;

public class SoftAssertionTest extends BaseTest {

    @Test
    public void validateUsersWithSoftAssertions() {


        Response response =
                given()
                        .when()
                        .get("api/users");

        // Create soft assertion object
        SoftAssertions soft = new SoftAssertions();

        // Validate status
        soft.assertThat(response.getStatusCode())
                .as("Status Code Check")
                .isEqualTo(200);

        // Extract values
        String firstName = response.jsonPath().getString("[0].name");
        String firstEmail = response.jsonPath().getString("[0].email");
        int size = response.jsonPath().getList("$").size();

        // Multiple validations (all will run)
        soft.assertThat(firstName)
                .as("First user name should not be null")
                .isNotNull();

        soft.assertThat(firstEmail)
                .as("Email should contain @")
                .contains("@");

        soft.assertThat(size)
                .as("Users count should be > 4")
                .isGreaterThan(4);

        // triggers all checks
        soft.assertAll();
    }
}