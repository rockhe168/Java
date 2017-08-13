package com.rock.java8.lambda;

/**
 * Created by 何湘红[499233529@qq.com] on 2017/8/12 0012.
 */

@FunctionalInterface
public interface MyPredicate<T> {
    public boolean filter(T t);
}
