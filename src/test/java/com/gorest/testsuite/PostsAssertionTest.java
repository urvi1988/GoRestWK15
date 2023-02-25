package com.gorest.testsuite;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class PostsAssertionTest {
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
    //1. Verify the if the total record is 25
    @Test
    public void test01(){
        response.body("size",equalTo(25));
    }
    //2. Verify the if the title of id = 2730 is equal to ”Ad ipsa coruscus ipsam eos demitto centum.”
    @Test
    public void test02(){
        response.body("[0].title",equalTo("Subito tricesimus ut turba dolorem omnis et creber nihil ceno acquiro clementia."));
    }
    //3. Check the single user_id in the Array list (5522)
    @Test
    public void test03(){
        Arrays.asList("[0].id",equalTo("20967"));
    }
    //4. Check the multiple ids in the ArrayList (2693, 2684,2681)
    @Test
    public void test04(){
        Arrays.asList("[0].id",equalTo("20967"));
        Arrays.asList("[1].id",equalTo("20966"));
        Arrays.asList("[2].id",equalTo("20963"));
    }
    //5. Verify the body of userid = 2678 is equal //20967
    @Test
    public void test05(){
        response.body("[0].body",equalTo("Strenuus vulgo nisi. Argumentum acer tui. Apostolus aqua vita. Termes textor nam. Ex victoria natus. Utor aeger beatae. Spoliatio decretum apud. Eos conventus coniuratio. Corrumpo despecto atrocitas. Timor ait conservo. Tamquam quidem defero. Spiritus triumphus et. Molestiae sint qui. Aiunt tumultus aetas. Abundans curiositas congregatio. Nam ut causa. Odio utroque tergo. Compono sodalitas alo. Cervus comis caveo. Peior coaegresco quidem. Decet nobis cariosus."));

    }

}
