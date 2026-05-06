package com.api.reqhandling;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.filter.log.LogDetail;

public class RequestSpecBuilderUtil {

    public static RequestSpecification getRequestSpec() {

        return new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .log(LogDetail.ALL)
                .build();
    }
}