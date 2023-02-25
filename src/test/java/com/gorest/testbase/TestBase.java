package com.gorest.testbase;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;

import static io.restassured.RestAssured.given;


public class TestBase {

    @BeforeClass
    public static void inIt() {
            RestAssured.baseURI = "https://gorest.co.in/public/";
            RestAssured.basePath = "/users";
        }
    }
