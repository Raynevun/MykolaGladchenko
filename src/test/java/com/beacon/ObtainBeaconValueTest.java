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

    @Test
    public void getBeaconValuesPositiveTest() {
        String expectedBeaconValue = "24B68CBBA5AB55BE977B2821C7D391452FCB3248AFDEF5950BF85BFA103DD41A1803F29BDE6E498444D422A5A866FD5CAACAA9B241604A77FA65BEFBDADA418192170A1DCC5588DE4824CB666E5A8B8B477D7755F29BF15698CFCD61F4FE2FA8ED69177541F2065D0411CDA9D7C24D7144836FC526D7B4C9652E4E5E5AE8C757";
        assertEquals("Obtained beacon value is not as expected", getBeaconValues(1434355500,1434355560), expectedBeaconValue);
    }


}
