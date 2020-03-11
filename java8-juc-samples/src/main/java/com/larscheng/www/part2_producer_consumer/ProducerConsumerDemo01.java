package com.larscheng.www.part2_producer_consumer;

/**
 * 描述:
 * 生产者消费者demo
 * 多个线程操作同一个资源===> synchronized
 * 线程A和线程B操作Data资源
 *
 * 坑点：一旦2个以上线程就会出问题 虚假唤醒-------因为是if判断
 *
 *
 * @author larscheng
 * @date 2020/3/3 15:09
 */
public class ProducerConsumerDemo01 {


    public static void main(String[] args) {


        final Data data = new Data();


        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    data.product();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i < 10; i++) {
                try {
                    data.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
//        new Thread(() -> {
//            for (int i = 1; i < 10; i++) {
//                try {
//                    data.product();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "C").start();
//        new Thread(() -> {
//            for (int i = 1; i < 10; i++) {
//                try {
//                    data.consume();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, "D").start();
    }

    static class Data {
        //库存数量
        private int num = 0;

        public synchronized void product() throws InterruptedException {
            if (num != 0) {
                //等待: 库存还有不用生产
                this.wait();
            }
            //业务: 生产1个产品
            num++;
            System.out.println(Thread.currentThread().getName()+" => "+num);
            //通知: 消费者可以来消费了
            this.notifyAll();
        }


        public synchronized void consume() throws InterruptedException {
            if (num == 0) {
                //等待: 库存为0
                this.wait();
            }
            //业务: 消费1个产品
            num--;
            System.out.println(Thread.currentThread().getName()+" => "+num);
            //通知: 生产者快来生产
            this.notifyAll();
        }
    }
}
