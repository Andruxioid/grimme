package com.duha.grimme.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.duha.grimme.utils.Reference;

public class Utils {

    private static Logger logger;

    public static Logger getLogger() {
        if(logger== null) {
            logger = LogManager.getFormatterLogger(Reference.MODID);
        }
        return logger;
    }
}
