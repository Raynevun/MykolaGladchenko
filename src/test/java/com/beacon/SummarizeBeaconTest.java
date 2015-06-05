package com.beacon;

import org.junit.Test;

public class SummarizeBeaconTest {
    @Test(expected = IllegalArgumentException.class)
    public void summarizeCharsBeaconValueNullValueTest() {
        SummarizeBeacon.summarizeCharsBeaconValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void prettyPrintCharMapNullValueTest() {
        SummarizeBeacon.prettyPrintCharMap(null);
    }

}
