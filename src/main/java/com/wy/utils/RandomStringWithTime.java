package com.wy.utils;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RandomStringWithTime {
    private static final String CHARACTERS = "ABCDFGIJKMNZPQRSTUWLOVEHXYabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int TOTAL_LENGTH = 18; // 总长度
    private static final String DATE_FORMAT = "yyyyMMddHHmmss"; // 时间格式

   /* public static void main(String[] args) {
        String randomStringWithTime = generateRandomStringWithTime();
        System.out.println(randomStringWithTime);
    }*/

    public static String generateRandomStringWithTime() {
        String currentTime = getCurrentTime();
        SecureRandom random = new SecureRandom();

        StringBuilder characters = new StringBuilder();

        int start = random.nextInt(CHARACTERS.length());

        String[] split = CHARACTERS.split(String.valueOf(CHARACTERS.charAt(start)));
        characters.append(split[0]);
        characters.append(currentTime);
        characters.append(split[1]);

        StringBuilder randomString = new StringBuilder(TOTAL_LENGTH);

        for (int i = 0; i < TOTAL_LENGTH; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }

    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(new Date()); // 返回格式化后的当前时间
    }
}
