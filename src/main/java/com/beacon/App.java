package com.beacon;

import com.beust.jcommander.JCommander;

import static com.beacon.AppSettings.*;

public class App {

    public static void main(String [] args) {
        AppSettings settings = new AppSettings();
        new JCommander(settings, args);
        application(settings.from, settings.to);
    }
}
