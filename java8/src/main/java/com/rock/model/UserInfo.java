package com.rock.model;

/**
 * Created by rock on 2017/7/16.
 */
public class UserInfo {



    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "name:"+name+"--->age:"+age;
    }
}
