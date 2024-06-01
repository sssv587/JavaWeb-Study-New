package com.futurebytedance.headline.test;

import com.futurebytedance.headline.utils.JwtHelper;
import org.junit.Test;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/6/1 - 18:29
 * @Description
 */
public class TestJwtHelper {
    @Test
    public void testAllMethod() throws InterruptedException {
        String token = JwtHelper.createToken(1L);
        System.out.println(token);

        Long userId = JwtHelper.getUserId(token);
        System.out.println(userId);

        System.out.println(JwtHelper.isExpiration(token));

        Thread.sleep(6000);

        System.out.println(JwtHelper.isExpiration(token));
    }
}

