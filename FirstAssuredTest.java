package com.automation.office_hour.marufjon.day2;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
public class FirstAssuredTest {

    /*When i send request to http://api.openrates.io/latest
    * then status code must 200*/
    @Test
    public void verifyStatusCode(){
        Response response=when().get("http://api.openrates.io/latest");
response.then().statusCode(200);
response.prettyPeek();
    }
    //verify body conatains "base":"EUR"
    @Test
    public void verifyBodyConatains(){
        Response response=get("http://api.openrates.io/latest").prettyPeek();
        String bodyStr=response.toString();
        System.out.println(bodyStr);
        assertTrue(bodyStr.contains("\"base\": \"EUR\""));



    }

    /*When i send request to
    * then response should contain header application/json*/
    @Test
    public void verifyheder(){
        Response response=when().get("http://api.openrates.io/latest");
      String contentType=response.header("Content-Type");
      String date=response.header("date");
        System.out.println(contentType);
        System.out.println(date);
        assertEquals(contentType,"application/json");
        assertTrue(date.contains("2020"));

    }
    @Test
    public void contatnTyp(){
       Response response=when().get("http://api.openrates.io/latest") ;

       String contentType=response.getContentType();
        System.out.println(contentType);
        int statusCode=response.getStatusCode();
        System.out.println(statusCode);
        assertEquals("application/json",contentType);
        response.statusCode();

    }

    /** when i send request to http:/api.zippota.us/us/22031/
     * then status must 200
     * And verify that responce contains Fairefax
     */
    @Test
    public void verifyResponceFairfax(){
        Response response=when().get("http://api.zippopotam.us/us/22031");
       response.then().statusCode(200);
       String fairfax=response.toString();
       response.prettyPeek();
       assertTrue(response.asString().contains("Fairfax"));

    }
    /*when i send request to then status code must 404*/
    @Test
    public void verify(){
        Response response=when().get("http://api.zippopotam.us/us/2203167");
        int statuscode=response.statusCode();
        response.prettyPeek();
   //  assertEquals(statuscode,404);
response.then().statusCode(404);
    }
}
