package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Max, Spb";

        try {
            throw new Exception("Not supported code");
        } catch (Exception e) {
            LOG.error("Exception in log example, user info name, name: {}",  name, e);
        }
    }
}
