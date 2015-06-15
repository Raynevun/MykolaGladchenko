package com.beacon;

import org.junit.Test;

import static com.beacon.ObtainBeaconValue.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ObtainBeaconValueTest {
    //TODO: here should be also unit tests on mocked REST web service. For now using real REST web service.

    @Test
    public void getLastBeaconValueReturnTypeTest() {
        assertTrue(getLastBeaconValue().getClass()==String.class );
    }

    @Test
    public void getNextTimeStampPositiveTest() {
        assertEquals("Failed to get next epoch timeStamp", getNextTimeStamp(1434345961), 1434346020);
    }

    @Test
    public void getPreviousTimeStampPositiveTest() {
        assertEquals("Failed to get previous epoch timeStamp", getPreviousTimeStamp(1434346021), 1434346020);
    }


}
