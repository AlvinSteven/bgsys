package com.vuetests.bgsys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StringUtils {

    /**
     * 获取随机字符串
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }

        // 单用随机字符串还是有可能重复, 再加上时间戳
        return sb.toString() + getTimeStamp("yyyyMMdd_HHmmss");
    }

    /**
     * 获取时间戳
     *
     * @param pattern 例如:"yyyyMMddHHmmss"
     * @return
     */
    public static String getTimeStamp(String pattern) {

        return new SimpleDateFormat(pattern).format(new Date());
    }

}