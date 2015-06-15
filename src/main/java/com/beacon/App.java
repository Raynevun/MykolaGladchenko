package com.beacon;

import com.beust.jcommander.JCommander;

import static com.beacon.AppSettings.*;
import static com.beacon.SummarizeBeacon.*;
import static com.beacon.ObtainBeaconValue.*;

public class App {

    public static void main(String [] args) {
        AppSettings settings = new AppSettings();
        new JCommander(settings, args);

        if (settings.from!=null && settings.to!=null) {
            long fromDateEpoch = convertToEpoch(extractIntDateListFromString(settings.from));
            long toDateEpoch = convertToEpoch(extractIntDateListFromString(settings.to));
            if (fromDateEpoch>=toDateEpoch) {
                System.out.println("From date should be less then To date. Please enter correct values.");
                System.exit(1);
            }
            //System.out.println(fromDateEpoch);
            //System.out.println(toDateEpoch);
            long startEpochDate = getNextTimeStamp(fromDateEpoch);
            long endEpochDate = getPreviousTimeStamp(toDateEpoch);
            //System.out.println(startEpochDate);
            //System.out.println(endEpochDate);
            String beaconValues = getBeaconValues(startEpochDate, endEpochDate);
            prettyPrintCharMap(summarizeCharsBeaconValue(beaconValues));
        }
        else {
            String beaconValue = getLastBeaconValue();
            prettyPrintCharMap(summarizeCharsBeaconValue(beaconValue));
        }
    }
}
