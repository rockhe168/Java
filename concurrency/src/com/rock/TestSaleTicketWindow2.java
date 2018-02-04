package com.rock;

/**
 * 模拟买票窗口(implements Runnable 方式)
 * 缺点：有线程安全性问题（打印车票时，会出现重票、错票）
 */

class TicketWindow2 implements Runnable{

    //一共100 张票  -->多个窗口共享count，有线程安全性问题
    int count = 100;
    public void run() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true){
            if(count>0){
                System.out.println(Thread.currentThread().getName()+"售票，票号:"+count--);
            }else {
                break;
            }
        }
    }
}

public class TestSaleTicketWindow2 {

    public static void main(String args[]){
        TicketWindow2 ticketWindow = new TicketWindow2();

        Thread ticketWindow1 = new Thread(ticketWindow,"售票窗口1");
        Thread ticketWindow2 = new Thread(ticketWindow,"售票窗口2");
        Thread ticketWindow3 = new Thread(ticketWindow,"售票窗口3");

        ticketWindow1.start();
        ticketWindow2.start();
        ticketWindow3.start();
    }
}
