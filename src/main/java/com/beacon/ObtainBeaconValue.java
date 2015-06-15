package com.beacon;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.get;

public class ObtainBeaconValue {

    private static String beaconHost = "https://beacon.nist.gov";

    protected static String getLastBeaconValue(){
        RestAssured.baseURI = beaconHost;
        Response xml = get("/rest/record/last");
        String beaconValue = xml.xmlPath().get("record.outputValue");

        return beaconValue;
    }

    protected static long getNextTimeStamp(long epochDate){
        RestAssured.baseURI = beaconHost;
        Response xml = get("/rest/record/next/"+epochDate);
        String nextTimeStampString = xml.xmlPath().get("record.timeStamp");

        return Long.parseLong(nextTimeStampString);
    }

    protected static long getPreviousTimeStamp(long epochDate){
        RestAssured.baseURI = beaconHost;
        Response xml = get("/rest/record/previous/"+epochDate);
        String previousTimeStampString = xml.xmlPath().get("record.timeStamp");

        return Long.parseLong(previousTimeStampString);
    }

    protected static String getBeaconValues (long epochDateStart, long epochDateEnd) {
        StringBuilder res = new StringBuilder();
        System.out.println("About to obtain "+((epochDateEnd-epochDateStart)/60+1)+" beacon values from WebService. This may take some time.");
        for (long i = epochDateStart; i <= epochDateEnd; i = i + 60) {
            System.out.println("Obtaining beacon value for Epoch: " + i);
            RestAssured.baseURI = beaconHost;
            Response xml = get("/rest/record/"+i);
            String beaconValue = xml.xmlPath().get("record.outputValue");
            res.append(beaconValue);
        }
        return String.valueOf(res);
    }

}
