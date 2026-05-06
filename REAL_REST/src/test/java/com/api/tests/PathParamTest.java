package com.api.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class PathParamTest extends BaseTest {

    @Test
    public void getUserByPathParam() {

        given()
                .pathParam("id", 3)
                .when()
                .get("/api/users/{id}")
                .then()
                .log().all()
                .statusCode(200);
    }
}
