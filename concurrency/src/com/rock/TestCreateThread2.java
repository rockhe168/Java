package com.rock;

/**
 * 创建线程的方式二： 实现Runnable 接口
 */

//1. 类实现 Runnable 接口
class PrintNumber2 implements Runnable{

    //2.重写 run 方法
    public void run() {
        //子线程执行的代码
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

public class TestCreateThread2 {
    public static void main(String args[]){

        //3.new 实现Runnable 的实现类
        PrintNumber2 p= new PrintNumber2();

        //4. 将此对象作为形参传递给Thread类的构造器中，创建Thread类的对象，此对象即为一个线程
        Thread thread1= new Thread(p);
        Thread thread2= new Thread(p);

        thread1.setName("线程1");
        thread2.setName("线程2");
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread2.setPriority(Thread.MAX_PRIORITY);

        //5.调用start 开启一个线程，线程里面会执行实现类的run 方法
        thread1.start();
        thread2.start();
    }
}
