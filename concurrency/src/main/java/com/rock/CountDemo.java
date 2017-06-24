package com.rock;

/**
 * Created by xhhe on 2017/6/23.
 */
public class CountDemo {

    public static void handler() {


        //静态共享
        final Thread thread1= new Thread(){
            @Override
            public void run() {
                for (int i= 1 ;i<1000000;i++)
                {
                    MySharedStaticCount.add();
                }
            }
        };
        thread1.start();

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                for (int i= 1 ;i<1000000;i++)
                {
                    MySharedStaticCount.add();
                }

            }
        };

        thread2.start();

        try {

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(thread1.getState()== Thread.State.TERMINATED && thread2.getState() == Thread.State.TERMINATED) {
            System.out.println("MySharedStaticCount 执行完成 i--->=" + MySharedStaticCount.getCount()+"--->并发次数:"+(2000000-MySharedStaticCount.getCount()));
        }else{
            System.out.println("MySharedStaticCount 执行未完成 i--->=" + MySharedStaticCount.getCount()+"--->并发次数:"+(2000000-MySharedStaticCount.getCount()));
        }

        //实例共享
        final MySingletonCount singletonCount = new MySingletonCount();
        Thread thread3 =new Thread(){
            @Override
            public void run() {
                for (int i=1;i<1000000;i++) {
                    singletonCount.add(1);
                }
            }
        };
        thread3.start();

        Thread thread4 = new Thread() {
            @Override
            public void run() {
                for (int i=1;i<1000000;i++){
                    singletonCount.add(2);
                }
            }
        };
        thread4.start();
        try {

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(thread3.getState()== Thread.State.TERMINATED && thread4.getState() == Thread.State.TERMINATED) {
            System.out.println("MySingletonCount 执行完成 i--->=" + singletonCount.getCount()+"--->并发导致结果相差:"+(3000000-singletonCount.getCount()));
        }else{
            System.out.println("MySingletonCount 执行未完成 i--->=" + singletonCount.getCount()+"--->并发导致结果相差:"+(3000000-singletonCount.getCount()));
        }
    }
}
