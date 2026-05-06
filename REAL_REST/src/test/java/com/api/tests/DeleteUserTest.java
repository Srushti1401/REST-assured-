package com.api.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DeleteUserTest extends BaseTest {

    @Test
    public void deleteUser() {

        given()
                .pathParam("id", 1)
                .when()
                .delete("/api/users/{id}")
                .then()
                .log().all()
                .statusCode(204);
    }
}