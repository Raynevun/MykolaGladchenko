package com.beacon;

import com.beust.jcommander.Parameter;

import java.util.*;

public class AppSettings {

    @Parameter(names = "-from", description = "From date in human readable format. Example: -from '3 months 1 day 1 hour 1 minute ago'", validateWith = AppSettingsValidator.class)
    protected String from;

    @Parameter(names = "-to", description = "To date in human readable format. Example: -to '1 months 1 day 1 hour 1 minute ago'", validateWith = AppSettingsValidator.class)
    protected String to;

    public static List<Integer> extractIntDateListFromString(String stringDate) {
        Scanner s = new Scanner(stringDate);

        List<Integer> arr = new ArrayList<Integer>(4);

        while (s.hasNext()) {
            if (s.hasNextInt()) {
                arr.add(s.nextInt());
            }
            s.next();
        }
        s.close();
        return arr;
    }

    public static long convertToEpoch(List<Integer> dateList) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal.add(Calendar.MONTH, -dateList.get(0));
        cal.add(Calendar.DATE, -dateList.get(1));
        cal.add(Calendar.HOUR, -dateList.get(2));
        cal.add(Calendar.MINUTE, -dateList.get(3));
        long epochDate = cal.getTimeInMillis() / 1000L;

        return epochDate;
    }


}
