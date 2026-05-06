package com.api.responsehandling;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public class ResponseSpecBuilderUtil {

    public static ResponseSpecification getResponseSpec() {

        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectHeader("Content-Type", "application/json")
                .expectResponseTime(lessThan(2000L))
                .build();
    }
}