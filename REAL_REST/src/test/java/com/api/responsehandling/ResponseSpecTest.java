package com.api.responsehandling;

import com.api.responsehandling.ResponseSpecBuilderUtil;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResponseSpecTest {

    @Test
    public void testWithResponseSpec() {

        given()
                .baseUri("http://localhost:8081")
                .when()
                .get("/api/users/1")
                .then()
                .spec(ResponseSpecBuilderUtil.getResponseSpec())
                .log().all();
    }
}