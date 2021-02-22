package com.dc.transactions;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class AppControllerTest {

    String url ="http://localhost:8080/transactions";

    @Test
    public void AllParameterTest(){
        given().contentType(ContentType.JSON).queryParam("accountType", "cos").queryParam("customerID", "all")
                .log().parameters().get(url).then().log().all();
    }

    @Test
    public void OneParameterTest(){
        given().contentType(ContentType.JSON).queryParam("accountType", "").queryParam("customerID", "1")
                .log().parameters().get(url).then().log().all();
    }

    @Test
    public void TwoParemetersTest(){
        given().contentType(ContentType.JSON).queryParam("accountType", "2").queryParam("customerID", "1")
                .log().parameters().get(url).then().log().all();
    }

    @Test
    public void TwoMultiParemetersTest(){
        given().contentType(ContentType.JSON).queryParam("accountType", "2", "1", "3").queryParam("customerID", "1", "2")
                .log().parameters().get(url).then().log().all();
    }

    @Test
    public void TwoParemetersTest2(){
        get(url+"?accountType=2,3&customerID=1").then().statusCode(200).assertThat();
    }
}
