package com.beacon;

import org.junit.Test;

import static com.beacon.SummarizeBeacon.*;

public class SummarizeBeaconTest {
    @Test(expected = IllegalArgumentException.class)
    public void summarizeCharsBeaconValueNullValueTest() {
        summarizeCharsBeaconValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void prettyPrintCharMapNullValueTest() {
        prettyPrintCharMap(null);
    }

}
