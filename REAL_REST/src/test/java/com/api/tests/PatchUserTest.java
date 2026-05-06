package com.api.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PatchUserTest extends BaseTest {

    @Test
    public void patchUser() {

        given()
                .header("Content-Type", "application/json")
                .pathParam("id", 1)
                .body("{\"name\":\"PatchedName\"}")  // only updating one field
                .when()
                .patch("/api/users/{id}")
                .then()
                .log().all()
                .statusCode(200);
    }
}