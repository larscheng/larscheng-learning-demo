package com.larscheng.www.part1_ticket_lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述:
 * 卖票，使用ReentrantLock
 *
 * @author larscheng
 * @date 2020/3/3 15:09
 */
public class SaleTicketJucLockDemo03 {


    public static void main(String[] args) {
        final Ticket ticket = new Ticket();
        new Thread(() -> { for (int i = 1; i < 50; i++) ticket.sale(); }, "A").start();
        new Thread(() -> { for (int i = 1; i < 50; i++) ticket.sale(); }, "B").start();
        new Thread(() -> { for (int i = 1; i < 50; i++) ticket.sale(); }, "C").start();
    }

    /***
     * Lock---ReentrantLock 可重入非公平锁
     */
    static class Ticket {
        //余票数量
        private int num = 30;

        ReentrantLock lock = new ReentrantLock();

        public void sale() {
            lock.lock();
            try {
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出第" + (num--) + "号票，剩余票数：" + num);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
