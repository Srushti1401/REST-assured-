package com.api.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class QueryParamTest extends BaseTest {

    @Test
    public void getUsersWithQueryParams() {

        given()
                .queryParam("page", 0)
                .queryParam("size", 5)
                .queryParam("sortBy", "name")
                .when()
                .get("/api/users/paginated")
                .then()
                .log().all()
                .statusCode(200);
    }
}