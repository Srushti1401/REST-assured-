package com.api.responsehandling;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class HeadersCookiesRealTest {

    @Test
    public void validateHeadersAndCookies() {

        Response response = given()
                .baseUri("http://localhost:8081")
                .when()
                .get("/api/users/1");


        Assert.assertEquals(response.getStatusCode(), 200);


        //  HEADERS VALIDATION


        // Validate Content-Type
        String contentType = response.getHeader("Content-Type");
        Assert.assertTrue(contentType.contains("application/json"));

        // Validate Date header exists
        String date = response.getHeader("Date");
        Assert.assertNotNull(date);

        // Print headers (for debugging)
        System.out.println("Headers: " + response.getHeaders());


        //  COOKIES VALIDATION


        Map<String, String> cookies = response.getCookies();
        System.out.println("Cookies: " + cookies);

        // Optional cookie check
        String sessionId = response.getCookie("JSESSIONID");

        if (sessionId != null) {
            System.out.println("Session ID: " + sessionId);
            Assert.assertFalse(sessionId.isEmpty());
        } else {
            System.out.println("No session cookie present ");
        }
    }
}