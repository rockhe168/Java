package com.rock;

/**
 * 模拟买票窗口(用extends Thread 方式)
 * 缺点：有线程安全性问题（打印车票时，会出现重票、错票）
 */

class TicketWindow1 extends Thread{

    //一共100 张票  -->多个窗口共享count，有线程安全性问题
    static int count = 100;
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count>0){
                System.out.println(Thread.currentThread().getName()+"售票，票号:"+count--);
            }else {
                break;
            }
        }
    }

    public TicketWindow1(String name){
        super(name);
    }
}
public class TestSaleTicketWindow1 {

    public static void main(String args[]){
        TicketWindow1 ticketWindow1 = new TicketWindow1("售票窗口1");
        TicketWindow1 ticketWindow2 = new TicketWindow1("售票窗口2");
        TicketWindow1 ticketWindow3 = new TicketWindow1("售票窗口3");

        ticketWindow1.start();
        ticketWindow2.start();
        ticketWindow3.start();
    }
}
