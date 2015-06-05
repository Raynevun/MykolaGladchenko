package com.beacon;

import com.jayway.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.xml.HasXPath.hasXPath;

public class GetLatestValueFromWebServieceTest {

    @BeforeClass
    public static void setBaseURI() {
        RestAssured.baseURI = "https://beacon.nist.gov";
    }

    @Test
    public void responseStatusCode() {
        given().get("/rest/record/last").then().statusCode(200);
    }

    @Test
    public void responseStatusLine() {
        given().get("/rest/record/last").then().statusLine("HTTP/1.1 200 OK");;
    }

    @Test
    public void responseHeaders() {
        given().get("/rest/record/last").then().header("Content-Type","text/xml");;
    }

    @Test
    public void responseBodyContainsOutPutValue() {
        given().get("/rest/record/last").then().body(hasXPath("//outputValue[text()]"));
    }

    //TODO: Test on XML schema matching

}
