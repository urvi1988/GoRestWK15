package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/";
        //RestAssured.basePath = "/users";

        response = given()
                .when()
                .get("/public/v2/users")
                .then().statusCode(200);
    }

    //1. Extract the All Ids
    @Test
    public void test01() {
        ArrayList<Integer> ids = response.extract().path("id");
        int size = ids.size();
        System.out.println("id" + size);
    }

    //2. Extract the all Names
    @Test
    public void test02() {
        ArrayList<String> names = response.extract().path("name");
        int size = names.size();
        System.out.println("name" + size);
    }

    //3. Extract the name of 5th object
    @Test
    public void test03() {
        String name = response.extract().path("[4].name");
        System.out.println("name of object:" + name);
        Assert.assertTrue(true);
    }

    //4. Extract the names of all object whose status = inactive
    @Test
    public void test04() {
        ArrayList<String> status = response.extract().path("findAll{it.status='inactive'}.name");
        System.out.println("object status is inactive" + status);
        Assert.assertTrue(true);
    }

    //5. Extract the gender of all the object whose status = active
    @Test
    public void test05() {
        ArrayList<String> gender = response.extract().path("findAll{it.status='active'}.gender");
        System.out.println("object status is active" + gender);
        Assert.assertTrue(true);
    }

    //6. Print the names of the object whose gender = female
    @Test
    public void test06() {
        ArrayList<String> nameGenderFemale = response.extract().path("findAll{it.gender='female'}.name");
        System.out.println("name of the object whose Gender is female" + nameGenderFemale);
        Assert.assertTrue(true);
    }

    //7. Get all the emails of the object where status = inactive
    @Test
    public void test07() {
        ArrayList<String> emails = response.extract().path("findAll{it.status='inactive'}.email");
        System.out.println("get emails for inactive object" + emails);
        Assert.assertTrue(true);
    }

    //8. Get the ids of the object where gender = male
    @Test
    public void test08() {
        ArrayList<Integer> idGenderMale = response.extract().path("findAll{it.gender=='male'}.ids");
        System.out.println("get ids of male object" + idGenderMale);
        Assert.assertTrue(true);
    }
    // 9. Get all the status

    @Test
    public void test09() {
        List<HashMap<String, ?>> status = response.extract().path("status");
        System.out.println(status);
        Assert.assertTrue(true);
    }

    //10. Get email of the object where name = Karthik Dubashi IV
    @Test
    public void test010() {
        String email = response.extract().path("[4].email");
        System.out.println(email);
        Assert.assertTrue(true);
    }
    //11. Get gender of id = 5471
    @Test
    public void test011(){
        String gender = response.extract().path("[4].gender");
        System.out.println("gender of id:" + 5471);
        Assert.assertTrue(true);
    }


}




