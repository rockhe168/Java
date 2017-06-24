package com.rock;

/**
 * Created by xhhe on 2017/6/23.
 */
public class MySingletonCount {

    private int count =0;

    public void add(int num)
    {
        count += num;
    }

    public int getCount()
    {
        return  count;
    }


}
