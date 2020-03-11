package com.larscheng.www.part1_ticket_lock;

/**
 * 描述:
 * 卖票，加synchronized同步锁
 *
 * @author larscheng
 * @date 2020/3/3 15:09
 */
public class SaleTicketSynchronizedDemo02 {


    public static void main(String[] args) {


        final Ticket ticket = new Ticket();


        new Thread(() -> {
            for (int i = 1; i < 50; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 50; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i < 50; i++) {
                ticket.sale();
            }
        }, "C").start();
    }

    static class Ticket {
        //余票数量
        private int num=30;

        public synchronized void sale() {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + (num--) + "号票，剩余票数：" + num );
            }
        }
    }
}
