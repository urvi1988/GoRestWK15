package com.gorest.testsuite;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UserAssertionTest {
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
    //1. Verify if the total record is 20
    @Test
    public void test01(){ // if we do not have variable name we use size
        response.body("size",equalTo(10));
    }
    //2. Verify the if the name of id = 597269 is equal to ”Triloki Nath Mukhopadhyay”
    @Test
    public void test02(){
        response.body("[1].name",equalTo("Sarisha Somayaji"));
    }

    //3.Check the single ‘Name’ in the Array list (Subhashini Talwar)
    @Test
    public void tes03(){
        response.body("[0].name",equalTo("Nanda Pandey"));
    }

    //4. Check the multiple ‘Names’ in the ArrayList
    @Test
    public void test04(){
        response.body("[8].name",equalTo("Miss Manikya Deshpande"));
        response.body("[9].name",equalTo("Chanakya Agarwal"));
        response.body("[7].name",equalTo("Karthik Kaniyar"));
    }
    //5. Verify the emai of userid = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    @Test
    public void test05(){
        response.body("[1].email",equalTo("somayaji_sarisha@bosco-parker.co"));
    }
    //6. Verify the status is “Active” of user name is “Shanti Bhat V”
    @Test
    public void test06(){
        response.body("[1].status",equalTo("active"));
    }
    //7. Verify the Gender = male of user name is “Niro Prajapat”
    @Test
    public void test07(){
        response.body("[1].gender",equalTo("male"));
    }






}