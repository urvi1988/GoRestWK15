package com.gorest.Crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {
    static ValidatableResponse response;
    int idNumber;

    @Test // post
    public void test01() {
        UserPojo pojo = new UserPojo();
        pojo.setName("lotus");
        pojo.setEmail("ST@gmail.com");
        pojo.setGender("female");
        pojo.setStatus("active");

        Response response = given()
                .basePath("/v2/users")
                .log().all()
                .header("Authorization", "Bearer d02b41f2fd97d144f38d073702a2180235c022f2d1ce857f04ac019affd15985")
                .header("Content-Type", "application/json")
                .body(pojo)
                .when()
                .post();
        response.then().statusCode(200);
        int idNumber = response.then().extract().path("id");
        System.out.println(idNumber);
    }

    public void test02() { // patch
        UserPojo pojo = new UserPojo();
        pojo.setName("rose");
        pojo.setEmail("rose@gmail.com");
        pojo.setGender("male");
        pojo.setStatus("inactive");

        Response response = given()
                .basePath("/v2/users")
                .log().all()
                .header("Authorization", "Bearer d02b41f2fd97d144f38d073702a2180235c022f2d1ce857f04ac019affd15985")
                .header("Content-Type", "application/json")
                .body(pojo)
                .pathParam()
                .patch("/{id}");
        response.then().statusCode(201);
        // System.out.println(idNumber);
    }
    @Test
    public void test03(){ // delete
        Response response = given()
                .basePath("/v2/users")
                .log().all()
                .header("Authorization", "Bearer d02b41f2fd97d144f38d073702a2180235c022f2d1ce857f04ac019affd15985")
                .header("Content-Type", "application/json")
                .pathParam()
                .delete("/{id}");
        response.then().statusCode(204);
    }
    @Test
    public void test04(){ // retrive
        Response response = given()
                .basePath("/v2/users")
                .log().all()
                .header("Authorization", "Bearer d02b41f2fd97d144f38d073702a2180235c022f2d1ce857f04ac019affd15985")
                .header("Content-Type", "application/json")
                .pathParam()
                .when()
                .get("/{id}");
        response.then().statusCode(404);
    }

    }
















