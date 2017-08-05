package com.rock;

import com.rock.java8.model.UserInfo;

import static java.lang.System.out;

/**
 *
 * 用于测试多线程里面，线程对象压栈进去多只是对象多引用、还非本身副本
 *
 * Created by rock on 2017/7/16.
 */
public class ModelDemo {


    public static void main(String args[]){

        final UserInfo userInfo = new UserInfo();

        userInfo.setAge(1);
        userInfo.setName("doudou");

        out.println(userInfo.toString());

        final Thread thread1 =new Thread(){
            @Override
            public void run() {
                for(int i=0;i<80000;i++)
                {
                    userInfo.setAge(i);
                }
            }
        };
        thread1.start();

        out.println(userInfo.toString());

        final Thread thread2 = new Thread(){
            @Override
            public void run() {
                userInfo.setName("beibei");
            }
        };
        thread2.start();

        try {
            Thread.sleep(50);
            out.println(userInfo.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
