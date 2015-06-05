package com.beacon;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.get;

public class ObtainBeaconValue {

    private static String host = "https://beacon.nist.gov";

    protected static String getLastBeaconValue(){
        RestAssured.baseURI = host;
        Response xml = get("/rest/record/last");
        String beaconValue = xml.xmlPath().get("record.outputValue");

        return beaconValue;
    }

}
