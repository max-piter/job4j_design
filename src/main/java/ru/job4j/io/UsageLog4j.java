package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Max Korovkin, Spb";
        char sex = 'M';
        int age = 45;
        byte building = 10;
        short office = 173;
        long logNumber = 1;
        boolean isRealLog = false;
        double percent = 76.6;
        float rate = 6.6f;

        LOG.debug("User info name : {}, age : {}, sex: {}, isRealLog: {},"
                        + " building: {}, office: {}, logNumber: {}, rate: {}, percent: {}",
                name, age, sex, isRealLog, building, office, logNumber, rate, percent);
    }
}
