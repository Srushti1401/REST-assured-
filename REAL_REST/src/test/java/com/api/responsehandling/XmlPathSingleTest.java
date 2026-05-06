package com.api.responsehandling;

import io.restassured.path.xml.XmlPath;
import org.testng.annotations.Test;

import java.util.List;

public class XmlPathSingleTest {

    @Test
    public void xmlPathAllExamples() {

        String xmlResponse =
                "<users>" +
                        "<user>" +
                        "<id>1</id>" +
                        "<name>Srushti</name>" +
                        "<email>a@gmail.com</email>" +
                        "</user>" +
                        "<user>" +
                        "<id>2</id>" +
                        "<name>Rahul</name>" +
                        "<email>b@gmail.com</email>" +
                        "</user>" +
                        "</users>";

        XmlPath xml = new XmlPath(xmlResponse);

        String name = xml.getString("users.user[0].name");
        System.out.println("First User Name: " + name);

        int id = xml.getInt("users.user[0].id");
        String email = xml.getString("users.user[0].email");

        System.out.println("ID: " + id);
        System.out.println("Email: " + email);

        List<String> names = xml.getList("users.user.name");
        System.out.println("All Names: " + names);

        String secondUser = xml.getString("users.user[1].name");
        System.out.println("Second User: " + secondUser);

        String userWithId2 =
                xml.getString("users.user.find { it.id.text() == '2' }.name");
        System.out.println("User with ID 2: " + userWithId2);

        List<String> usersGreaterThan1 =
                xml.getList("users.user.findAll { it.id.text().toInteger() > 1 }.name");
        System.out.println("Users with ID > 1: " + usersGreaterThan1);

        int size = xml.getList("users.user").size();
        System.out.println("Total Users: " + size);
    }
}