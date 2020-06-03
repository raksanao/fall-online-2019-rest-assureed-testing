package com.automation.office_hour.marufjon.day2;

import org.junit.jupiter.api.Test;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class PathQueryParameters {

    @Test
    public void pathParamtest(){
      Response response=  given()
              .pathParams("date","latest").
        when().get("https://api.openrates.io/{date}");
      response.prettyPeek().then().statusCode(200);
      assertTrue(response.asString().contains("2020-01-02"));

    }
    /** given i craeted a request with wrong parameter 2020-30-02
     * when i send my request to
     * then status code should be 400
     */

    @Test
    public void pathParamNegative(){
        Response response=given().pathParam("date","2020-03-02").
                when().get("https://api.openrates.io/{date}");
            response.prettyPeek().then().statusCode(400);


    }
    /*given i created reuest with query parameter "base":"USD"
    * when i send my request to URL
    * then the responce should contain USD*/
    @Test
    public void queryParam(){
        Response response=given().queryParam("base","USD")
                .when().get("https://api.openrates.io/latest");
        response.prettyPeek();
        assertTrue(response.asString().contains("\"base\":\"USD\""));
    }

    /*given i create request with query parameter base=USD and symbol=MYR
    * when i send m request https://api.openrates.io/latest?base
    * and body should contain MYR
    * but shoul not contain EUR*/
    @Test
    public void test2QueryParams(){

        Response response=given().queryParam("base","USD")
                .queryParam("symbols","MYR").
                        when().get("https://api.openrates.io/latest");
        response.prettyPeek();


        String responStr=response.asString();
        assertTrue(responStr.contains("USD")&&responStr.contains("MYR"));
        assertFalse(responStr.contains("EUR"));
    }

    /*given i create request with query parameter base=USD and symbol=MYR
     * when i send m request https://api.openrates.io/{date}
     * and body should contain MYR
     * but should not contain EUR*/

    @Test
    public void testPathAndQueryParam() {
        Response response = given().
                pathParam("date", "2020-01-01").
                queryParam("base", "USD").
                queryParam("symbols", "MYR").when().get(" https://api.openrates.io/latest/{date}");
        response.prettyPeek();
        String respoceStr = response.asString();
        assertTrue(respoceStr.contains("2020-01-02") && respoceStr.contains("MYR"));
        assertFalse(respoceStr.contains("EUR"));


    }
    @Test
    public void testCity(){
        Response response=given().
                queryParam("query","Chicago")
                .when().get("https://www.metaweather.com/api/location/search");
        response.prettyPeek().then().statusCode(200);
        String responStr=response.asString();
        assertTrue(responStr.contains("Chicago"));

    }


}
