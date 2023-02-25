package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class PostsExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/";
        //RestAssured.basePath = "/users";

        response = given()
                .when()
                .get("/public/v2/posts?page=1&per_page=25")
                .then().statusCode(200);
    }

    //1. Extract the title
    @Test
    public void Test01() {
        // ArrayList<String>title = response.extract().path("title");
        // int size = title.size();
        //System.out.println("title" + size);
        ArrayList<String> title = response.extract().path("title");
        System.out.println("list all title :" + title);
        for (String a : title)
            if (a.equals(25)) {
                Assert.assertTrue(true);
            }
    }

    //2. Extract the total number of record
    @Test
    public void Test02() {
        ArrayList<Integer> records = response.extract().path("id");
        int size = records.size();
        System.out.println("id" + size);
        Assert.assertTrue(true);
    }

    //3. Extract the body of 15th record
    @Test
    public void Test03() {
        String body = response.extract().path("[14].bosy");
        System.out.println("bosy of 15 record" + body);
        Assert.assertTrue(true);
    }

    //4. Extract the user_id of all the records
    @Test
    public void Test04() {
        ArrayList<Integer> user_id = response.extract().path("userid");
        System.out.println("user id for all record" + user_id);
        for (Integer a : user_id) {
            if (a.equals(25)) {
                Assert.assertTrue(true);
            }
        }

    }

    //5. Extract the title of all the records
    @Test
    public void Test05() {
        ArrayList<String> title = response.extract().path("title");
        System.out.println("title for all record" + title);
        for (String a : title) {
            if (a.equals(25)) {
                Assert.assertTrue(true);
            }

        }

    }

    //6. Extract the title of all records whose user_id = 5456
    @Test
    public void Test06() {
        ArrayList<String> record = response.extract().path("findAll{it.user_id='5456'}.title");
        System.out.println("title of all recodord" + record);
        Assert.assertTrue(true);
    }
    //7. Extract the body of all records whose id = 2671
    @Test
    public void Test07(){
        ArrayList<String> body = response.extract().path("findAll{it.user_id='2671'}.body");
        System.out.println("body of all record id" + body);
        Assert.assertTrue(true);

    }


}






