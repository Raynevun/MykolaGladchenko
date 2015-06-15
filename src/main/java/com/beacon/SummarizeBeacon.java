package com.beacon;

import java.util.HashMap;
import java.util.Map;

public class SummarizeBeacon {

    protected static Map summarizeCharsBeaconValue(String beaconValue){
        if (beaconValue == null) {
            throw new IllegalArgumentException("Parameter 'beaconValue' is null");
        }
        int len = beaconValue.length();
        Map<Character, Integer> numChars = new HashMap<Character, Integer>();

        for (int i = 0; i < len; ++i)
        {
            char charAt = beaconValue.charAt(i);

            if (!numChars.containsKey(charAt))
            {
                numChars.put(charAt, 1);
            }
            else
            {
                numChars.put(charAt, numChars.get(charAt) + 1);
            }
        }

        return numChars;
    }

    protected static boolean prettyPrintCharMap(Map<Character, Integer> numChars){
        if (numChars == null) {
            throw new IllegalArgumentException("Parameter 'numChars' is null");
        }
        for (Character c:numChars.keySet()){
            System.out.println(c+","+ numChars.get(c)+"");
            return true;
        }
        return false;
    }

}

