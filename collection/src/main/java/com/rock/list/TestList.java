package com.rock.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by 何湘红[499233529@qq.com] on 2018/3/17 0017.
 */
public class TestList {

    @Test
    public void testForeachHandler(){
        List<String> list =new ArrayList<>();

        list.add("1");
        list.add("2");
        //list.add("3");

        for (String item :list){
            if("2".equals(item)){
                list.remove(item);
            }
        }

        out.println(list);
    }
}
