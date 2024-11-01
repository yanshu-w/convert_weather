package com.wy.utils;


import lombok.SneakyThrows;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class PrintErrorUtil {


    @SneakyThrows
    public static String print(Exception e)   {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        String errorStr = new String(stringWriter.toString());

        printWriter.close();
        stringWriter.close();
        return errorStr;
    }


}
