package com.rock;

import org.junit.Test;

import java.time.Instant;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.out;

/**
 * Created by 何湘红[499233529@qq.com] on 2018/3/17 0017.
 */
public class TimeTest {

    @Test
    public void currentTimeTest(){
        out.println("当前毫秒数-->"+System.currentTimeMillis());
        out.println("当前纳秒数-->"+System.nanoTime());

        out.println(Instant.now().getNano());
    }
}
