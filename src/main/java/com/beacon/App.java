package com.beacon;

import static com.beacon.SummarizeBeacon.*;
import static com.beacon.ObtainBeaconValue.*;


public class App {
    private static String beaconHost = "https://beacon.nist.gov";

    public static void main(String [] args) {
        String beaconValue = getLastBeaconValue(beaconHost);
        prettyPrintCharMap(summarizeCharsBeaconValue(beaconValue));
    }
}
