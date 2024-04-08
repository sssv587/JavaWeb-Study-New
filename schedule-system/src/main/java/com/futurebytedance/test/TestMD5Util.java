package com.futurebytedance.test;

import com.futurebytedance.uitl.MD5Util;
import org.junit.Test;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/4/9 - 0:01
 * @Description
 */
public class TestMD5Util {
    @Test
    public void testEncrypt() {
        System.out.println(MD5Util.encrypt("123456"));
    }
}
