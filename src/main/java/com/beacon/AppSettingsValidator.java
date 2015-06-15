package com.beacon;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import static com.beacon.AppSettings.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppSettingsValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        Pattern p = Pattern.compile("^\\d+\\smonths?\\s\\d+\\sdays?\\s\\d+\\shours?\\s\\d+\\sminutes?\\sago$");
        Matcher m = p.matcher(value);
        if (!m.find()) {
            System.out.println("Parameter " + name + " does not match following pattern: '3 month(s) 1 day(s) 1 hour(s) 24 minute(s) ago'");
            System.exit(1);
        }
        if (extractIntDateListFromString(value).size()!=4) {
            System.out.println("Parameter " + name + " has non-integer values. Please use only integer values for months/days/hours/minutes");
            System.exit(1);
        }
        if (convertToEpoch(extractIntDateListFromString(value))<1378395540) {
            System.out.println("Parameter " + name + " is less then Unix epoch 1378395540 (05 Sep 2013 15:39:00 GMT). Please set higher date.");
            System.exit(1);
        }
    }
}
