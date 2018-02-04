package com.rock;

/**
 * Created by 何湘红[499233529@qq.com] on 2018/2/4 0004.
 *
 * 1.创建线程方式一：通过extends Thread
 */

class PrintNumber extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
public class TestCreateThread1{

    public static void main(String args[]){
        PrintNumber p1= new PrintNumber();
        PrintNumber p2 = new PrintNumber();
        p1.setName("线程1");
        p2.setName("线程2");
        p1.setPriority(Thread.MAX_PRIORITY);
        p2.setPriority(Thread.MIN_PRIORITY);
        p1.start();
        p2.start();
    }

}


