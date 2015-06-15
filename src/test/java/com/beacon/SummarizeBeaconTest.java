package com.beacon;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.beacon.SummarizeBeacon.*;
import static com.beacon.SummarizeBeacon.summarizeCharsBeaconValue;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class SummarizeBeaconTest {
    @Test(expected = IllegalArgumentException.class)
    public void summarizeCharsBeaconValueNullValueTest() {
        summarizeCharsBeaconValue(null);
    }

    @Test
    public void summarizeCharsBeaconValueReturnTypeTest() {
        assertTrue(summarizeCharsBeaconValue("0A").getClass()==HashMap.class );
    }

    @Test
    public void summarizeCharsBeaconValuePositiveTest() {
        Map<Character, Integer> numChars = new HashMap<Character, Integer>();
        numChars.put('A', 1);
        numChars.put('0', 1);
        assertEquals("Chars at beacon Value are calculated wrong", summarizeCharsBeaconValue("0A"), numChars);
    }

    @Test(expected = IllegalArgumentException.class)
    public void prettyPrintCharMapNullValueTest() {
        prettyPrintCharMap(null);
    }

    @Test
    public void prettyPrintCharMapPositiveTest() {
        Map<Character, Integer> numChars = new HashMap<Character, Integer>();
        numChars.put('X', 666);
        assertTrue("Failed to print beacon values CharMap", prettyPrintCharMap(numChars));
    }

}
