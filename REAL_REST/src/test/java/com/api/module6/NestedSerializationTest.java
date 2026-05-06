package com.api.module6;

import com.api.pojo.Department;
import com.api.pojo.User;
import com.api.tests.BaseTest;
import com.google.gson.Gson;

import org.testng.annotations.Test;

import java.util.List;
import java.util.ArrayList;

public class NestedSerializationTest extends BaseTest {

    @Test
    public void createNestedJson() {

        // Create users
        User u1 = new User();
        u1.setName("Srushti");
        u1.setEmail("a@gmail.com");

        User u2 = new User();
        u2.setName("Ram");
        u2.setEmail("b@gmail.com");

        // Create list
        List<User> userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);

        // Create parent object
        Department dept = new Department();
        dept.setDepartment("IT");
        dept.setUsers(userList);

        // Convert to JSON
        Gson gson = new Gson();
        String json = gson.toJson(dept);

        System.out.println("Nested JSON: " + json);
    }
}