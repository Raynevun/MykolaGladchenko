package com.beacon;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.get;

public class ObtainBeaconValue {

    protected static String getLastBeaconValue(String host){
        if (host == null) {
            throw new IllegalArgumentException("Parameter 'host' is null");
        }
        RestAssured.baseURI = host;
        Response xml = get("/rest/record/last");
        String beaconValue = xml.xmlPath().get("record.outputValue");

        return beaconValue;
    }

}
