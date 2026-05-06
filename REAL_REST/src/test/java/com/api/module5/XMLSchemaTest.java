package com.api.module5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import org.testng.annotations.Test;

public class XMLSchemaTest {

    @Test
    public void validateXMLSchema() {

        given()
                .when()
                .get("http://localhost:8081/api/users/xml/1")
                .then()
                .statusCode(200)
                .body(matchesXsdInClasspath("user.xsd"));
    }
}
