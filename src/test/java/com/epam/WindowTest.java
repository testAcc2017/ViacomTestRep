package com.epam;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WindowTest {

    @Test(groups = {"smokeTest"})
    public void responseCodeTest() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users");
        RestAssured.given();
        Assert.assertEquals(response.getStatusCode(), 200, "Code is not matched");
        System.out.println(response.asString());
    }

    @Test(groups = {"smokeTest"}, dependsOnMethods = {"responseCodeTest"}, alwaysRun = true)
    public void headerTest() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users");
        String headerContentType = response.getHeader("content-type");
        Assert.assertTrue(headerContentType.contains("application/json; charset=utf-8"));
    }

    @Test(groups = {"trueGroup"})
    @Parameters("myName")
    public void alwaysPassTest(String name) {
        Assert.assertEquals(name, "Victor", "The name is not matched");
    }

    @Test(groups = {"trueGroup"})
    @Parameters("mySurName")
    public void anotherSuccessTest(String surName) {
        Assert.assertEquals(surName, "Ivanov", "The surname is not matched");
    }
}
