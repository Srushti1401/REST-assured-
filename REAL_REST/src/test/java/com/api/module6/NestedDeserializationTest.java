package com.api.module6;

import com.api.pojo.Department;
import com.api.tests.BaseTest;
import com.google.gson.Gson;

import org.testng.annotations.Test;

public class NestedDeserializationTest extends BaseTest {

    @Test
    public void handleNestedJson() {

        // Sample nested JSON (replace with API if needed)
        String json = "{ \"department\": \"IT\", \"users\": [" +
                "{ \"id\": 1, \"name\": \"Srushti\", \"email\": \"a@gmail.com\" }," +
                "{ \"id\": 2, \"name\": \"Ram\", \"email\": \"b@gmail.com\" } ] }";

        // Convert JSON → Java object
        Gson gson = new Gson();
        Department dept = gson.fromJson(json, Department.class);

        // Access nested data
        System.out.println("Department: " + dept.getDepartment());
        System.out.println("First User Name: " + dept.getUsers().get(0).getName());
        System.out.println("Second User Email: " + dept.getUsers().get(1).getEmail());
    }
}