package com.admin.utils;

import org.springframework.util.DigestUtils;

public class MD5Util {
    private static final String slat = "sblxf";
    public static String md5(String text){
        text = text + "/" + slat;
        String encodeStr = DigestUtils.md5DigestAsHex(text.getBytes());

        return encodeStr;
    }
}
