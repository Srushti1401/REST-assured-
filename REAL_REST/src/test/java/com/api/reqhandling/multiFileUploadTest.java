/*package com.api.reqhandling;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.api.tests.BaseTest;

import java.io.File;

public class multiFileUploadTest extends BaseTest {

    @Test
    public void uploadFile() {

        File file = new File("src/test/resources/sample.txt");

        given()
                .multiPart("file", file)
                .when()
                .post("api/upload")   // your upload endpoint
                .then()
                .statusCode(200);
    }
}*/

package com.api.module7;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import java.io.File;

public class multiFileUploadTest {

    @Test
    public void uploadFileDummy() {

        File file = new File("src/test/resources/sample.txt");

        given()
                .baseUri("https://httpbin.org")   // dummy API
                .multiPart("file", file)
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200);
    }
}