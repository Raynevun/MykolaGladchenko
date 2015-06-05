package com.beacon;

import static com.beacon.SummarizeBeacon.*;
import static com.beacon.ObtainBeaconValue.*;


public class App {

    public static void main(String [] args) {
        String beaconValue = getLastBeaconValue();
        //System.out.println(beaconValue);
        prettyPrintCharMap(summarizeCharsBeaconValue(beaconValue));
    }
}
