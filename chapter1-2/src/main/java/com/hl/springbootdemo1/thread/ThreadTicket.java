package com.hl.springbootdemo1.thread;

import java.util.HashMap;
import java.util.Map;

/**
 * 线程相关
 */
public class ThreadTicket {
    final static Object object1 = new Object();
    final static Object object2 = new Object();

    public static void main(String[] args) {
//        new Ticket("窗口1").start();
//        new Ticket("窗口2").start();
//        new Ticket("窗口3").start();

//        new TicketStatic("窗口1").start();
//        new TicketStatic("窗口2").start();
//        new TicketStatic("窗口3").start();

        new TicketSynchronized("窗口1").start();
        new TicketSynchronized("窗口2").start();
        new TicketSynchronized("窗口3").start();
    }

    // 售票代码，分别使用一个线程
    static class Ticket extends Thread {
        // 非static共享变量
        public int ticketCount = 5;

        public Ticket(String name) {
            super();
            this.setName(name);
        }

        @Override
        public void run() {
            super.run();
            while (ticketCount > 0) {
                System.out.println(this.getName() + "正在出售" + (5 - ticketCount + 1) + "张票");
                ticketCount--;
            }
        }
    }

    // 售票代码，共享静态变量
    static class TicketStatic extends Thread {
        // static共享变量
        public static int ticketCount = 5;

        public TicketStatic(String name) {
            super();
            this.setName(name);
        }

        @Override
        public void run() {
            super.run();
            while (ticketCount > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.getName() + "正在出售" + (5 - ticketCount + 1) + "张票");
                ticketCount--;
            }
        }
    }

    // 使用同步锁代码块
    static class TicketSynchronized extends Thread {
        // static共享变量
        public static int ticketCount = 10;

        public TicketSynchronized(String name) {
            super();
            this.setName(name);
        }

        @Override
        public void run() {
            super.run();

            while (ticketCount > 0) {
                // TicketSynchronized.class字节码保证了所有线程使用的是同一把锁
                synchronized (object1) {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    System.out.println(this.getName() + "正在出售第" + (10 - ticketCount + 1) + "张票");
                    ticketCount--;
                    try {
                        System.out.println(Thread.currentThread().getName() + "唤醒其他线程");
                        object1.notify();
                        System.out.println(Thread.currentThread().getName() + "等待");
                        object1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
