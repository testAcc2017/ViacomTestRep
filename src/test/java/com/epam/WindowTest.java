package com.epam;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowTest {

    @Test
    public void responseCodeTest() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users");
        RestAssured.given();
        Assert.assertEquals(response.getStatusCode(), 200, "Code is not matched");
        System.out.println(response.asString());
    }

    @Test
    public void headerTest() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users");
        String headerContentType = response.getHeader("content-type");
        Assert.assertTrue(headerContentType.contains("application/json; charset=utf-8"));
    }

}
