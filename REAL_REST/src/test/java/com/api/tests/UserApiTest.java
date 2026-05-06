package com.api.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserApiTest extends BaseTest {

    @Test
    public void getUsersTest() {

        given()
                .when()
                .get("/api/users")
                .then()
                .log().all()
                .statusCode(200);
    }
}