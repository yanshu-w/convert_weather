package com.wy.utils;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@Slf4j
public class PrintErrorUtil {


    /*public static String print(Exception e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String errorStr = stringWriter.toString();

        printWriter.close();
        try {
            stringWriter.close();
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
        return errorStr;
    }*/

    public static String print(Throwable e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String errorStr = stringWriter.toString();

        printWriter.close();
        try {
            stringWriter.close();
        } catch (IOException ex) {
            log.error(ex.getMessage());
        }
        return errorStr;
    }

}
