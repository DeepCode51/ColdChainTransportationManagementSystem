package com.se.util;

import java.util.UUID;

/**
 * @author baoweiwei
 * @date 2021/11/18 - 15:15
 */
public class UUIDGenerator {
    /**
     * 生成指定位数的UUID
     *
     * @param num
     * @return
     */
    public static String getUUId(int num) {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").substring(0, num);
        return uuid;
    }
}
