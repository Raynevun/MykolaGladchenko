package com.beacon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import static com.beacon.AppSettings.*;
import static com.beacon.ObtainBeaconValue.getLastBeaconValue;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class AppSettingsTest {

    @Test
    public void extractIntDateListFromStringPositiveTest() {
        String dateString = "666 months 03 day 0 hour 2 minute ago";
        List<Integer> expectedIntDateList = new ArrayList<Integer>(4);
        expectedIntDateList.add(666);
        expectedIntDateList.add(03);
        expectedIntDateList.add(0);
        expectedIntDateList.add(2);

        assertEquals("Failed to extract Int date list from String", extractIntDateListFromString(dateString), expectedIntDateList);
    }


    @Test
    public void convertToEpochTest() {
        List<Integer> inputIntDateList = new ArrayList<Integer>(4);
        inputIntDateList.add(0);
        inputIntDateList.add(0);
        inputIntDateList.add(0);
        inputIntDateList.add(2);
        assertTrue(convertToEpoch(inputIntDateList) >0);
    }


}
