package com.rock;

/**
 * 同步代码块
 *
 * 使用实现Runnable接口的方式，售票
 * 此程序存在线程的安全问题：打印车票时，会出现重票、错票
 *
 * 1. 线程安全存在安全的原因？
 *      由于一个线程在操作共享数据过程中，未执行完毕的情况下，另外的线程参与进来，导致共享数据存在了安全问题。
 * 2. 如果保证数据的安全性呢？
 *      加锁（如洗手间加门一样、只有里面的人方便完了，后面的人才能进去享用）
 *
 * 3.java如何实现线程的安全：线程的同步机制
 *
 * 		方式一：同步代码块
 * 		synchronized(同步监视器){
 * 			//需要被同步的代码块（即为操作共享数据的代码）
 * 		}
 * 		1.共享数据：多个线程共同操作的同一个数据(变量)
 * 		2.同步监视器：由一个类的对象来充当。哪个线程获取此监视器，谁就执行大括号里被同步的代码。俗称：锁
 * 		要求：所有的线程必须共用同一把锁！
 * 		注：在实现的方式中，考虑同步的话，可以使用this来充当锁。但是在继承的方式中，慎用this!  如：要确认是否同一间洗手间、是否指的同一扇门
 *
 * 		方式二：同步方法
 *
 *
 */
class TicketWindow4 extends Thread{
    //一共100 张票  -->多个窗口共享count，有线程安全性问题
    static int count = 100;
    static Object obj = new Object(); //象征着厕所的那一扇门
    public void run() {
        while (true){
            //synchronized (this) { //this表示当前对象，本题中即为ticketWindow1,ticketWindow2,ticketWindow3、所以不能用this
            synchronized (obj) { //obj 要是同一间厕所同一间门、才能锁的住 ，所以Object还必须是static
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票，票号:" + count--);
                } else {
                    break;
                }
            }
        }
    }

    public  TicketWindow4(String name){
        super(name);
    }
}

public class TestSyncSaleTicketWindow2 {
   public static void main(String args[]){
       TicketWindow4 ticketWindow1 = new TicketWindow4("售票窗口1");
       TicketWindow4 ticketWindow2 = new TicketWindow4("售票窗口2");
       TicketWindow4 ticketWindow3 = new TicketWindow4("售票窗口3");
       ticketWindow1.start();
       ticketWindow2.start();
       ticketWindow3.start();
   }
}
