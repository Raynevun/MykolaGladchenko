package com.beacon;

import org.junit.Test;

import static com.beacon.ObtainBeaconValue.getLastBeaconValue;

public class ObtainBeaconValueTest {
    //TODO: here should be also unit tests on mocked REST web service. For now using real REST web service.
    @Test(expected = IllegalArgumentException.class)
    public void getLastBeaconValueNullValueTest() {
        getLastBeaconValue(null);
    }
}
