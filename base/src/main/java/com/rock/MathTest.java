package com.rock;


import org.junit.Test;

import java.util.Random;

import static java.lang.System.out;

/**
 * Created by 何湘红[499233529@qq.com] on 2018/3/17 0017.
 */
public class MathTest {

    @Test
    public void testRandom(){
        out.println(Math.random());

        out.println(new Random().nextInt());
    }

}
