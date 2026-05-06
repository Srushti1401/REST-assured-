package com.api.reqhandling;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.api.tests.BaseTest;

public class XmlPayloadTest extends BaseTest {

    @Test
    public void sendXmlPayload() {

        String xmlBody =
                "<user>" +
                        "<name>xmlUser</name>" +
                        "<email>xml@gmail.com</email>" +
                        "</user>";

        given()
                .header("Content-Type", "application/xml")
                .body(xmlBody)
                .when()
                .post("api/users")
                .then()
                .statusCode(201);
    }
}