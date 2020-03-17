package com.larscheng.www;

/**
 * 描述:
 *
 * @author zhengql
 * @date 2019/9/25 11:01
 */
public class JoinDemo {
    public static void main(String[] args) {
        John john1 = new John(500);
        John john2 = new John(1000);
        John john3 = new John(1000);

        try {
            john1.start();
            john2.start();
            john3.start();

            john1.join();//main等待,john1执行结束后唤醒main----->但是john2早已执行
            john2.join();
            john3.join();
        } catch (InterruptedException IE) {
            IE.printStackTrace();
        }
    }
}

class John extends Thread {
    private int time;
    John(int time){
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public John setTime(int time) {
        this.time = time;
        return this;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                Thread.sleep(time);
                System.out.println("Current Thread: "
                        + Thread.currentThread().getName()+" / "+time);
            } catch (Exception ex) {
                System.out.println("Exception has" +
                        " been caught" + ex);
            }
            System.out.println(i);
        }
    }


}