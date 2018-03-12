package com.rock.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xhhe on 2018/3/12.
 */
public class IntegerCompare {

    @Test
    public void testIntegerCompare(){
        Integer a=3;
        Integer b=3;
        System.out.println(a==b);
        Assert.assertEquals(a,b);
    }

    @Test
    public void testIntegerCompareV2(){
        Integer a = 273;
        Integer b = 273;

        System.out.println(a==b);
        Assert.assertEquals(a,b);
    }
}
