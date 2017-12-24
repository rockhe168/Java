package com.rock;

/**
 * Created by xhhe on 2017/6/23.
 */
public class MySharedStaticCount {
    private static int count =0;

    public static int add()
    {
        return count++;
    }

    public static int getCount()
    {
        return count;
    }
}
