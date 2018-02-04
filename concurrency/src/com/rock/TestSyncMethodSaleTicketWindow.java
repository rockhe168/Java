package com.rock;

//使用实现Runnable接口的方式，售票
/**
 * 此程序存在线程的安全问题：打印车票时，会出现重票、错票
 * 1.线程安全问题存在的原因？
 *   由于一个线程在操作共享数据过程中，未执行完毕的情况下，另外的线程参与进来，导致共享数据存在了安全问题。
 *
 * 2.如何来解决线程的安全问题？
 * 	 必须让一个线程操作共享数据完毕以后，其它线程才有机会参与共享数据的操作。
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
 * 		注：在实现的方式中，考虑同步的话，可以使用this来充当锁。但是在继承的方式中，慎用this!
 *
 * 		方式二：同步方法
 * 		将操作共享数据的方法声明为synchronized。即此方法为同步方法，能够保证当其中一个线程执行
 * 		此方法时，其它线程在外等待直至此线程执行完此方法。
 * 		>同步方法的锁：this
 *
 * 4.线程的同步的弊端：由于同一个时间只能有一个线程访问共享数据，效率变低了。
 *
 */
class TicketWindow5 implements Runnable{
    //一共100 张票  -->多个窗口共享count，有线程安全性问题
    int count = 100;
    public void run() {
        while (true){
            printTicket();
        }
    }
    public synchronized void printTicket(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + "售票，票号:" + count--);
        }
    }
}

public class TestSyncMethodSaleTicketWindow {
   public static void main(String args[]){
       TicketWindow5 ticketWindow = new TicketWindow5();

       Thread ticketWindow1 = new Thread(ticketWindow,"售票窗口1");
       Thread ticketWindow2 = new Thread(ticketWindow,"售票窗口2");
       Thread ticketWindow3 = new Thread(ticketWindow,"售票窗口3");

       ticketWindow1.start();
       ticketWindow2.start();
       ticketWindow3.start();
   }
}
