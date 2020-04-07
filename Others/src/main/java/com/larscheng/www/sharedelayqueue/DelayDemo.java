package com.larscheng.www.sharedelayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 *
 * @author larscheng
 * @date 2020/3/2 17:55
 */
public class DelayDemo implements Delayed {

    private static long currentTime = System.currentTimeMillis();

    public String taskName;

    //处理时长
    private int timeCost;
    //延时时长
    private long delayTime;

    protected static final AtomicInteger taskCount = new AtomicInteger(0);

    // 定时任务之间的启动时间间隔在1~2s之间，timeCost表示处理此任务需要的时间，本示例中为2s
    public DelayDemo(String taskName, int timeCost) {
        this.taskName = taskName;
        this.timeCost = timeCost;
        taskCount.incrementAndGet();
        currentTime += 1000 + (long) (Math.random() * 1000);
        delayTime = currentTime;
    }


    public void startTask(){
        long startTime  = System.currentTimeMillis();

        try {
            Thread.sleep(timeCost);
            System.out.println("Task " + taskName + ": schedule_start_time=" + delayTime + ",real start time="
                    + startTime + ",delay=" + (startTime - delayTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /***
     * 获取剩余时间
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        long expirationTime = delayTime - System.currentTimeMillis();
        return unit.convert(expirationTime,TimeUnit.MILLISECONDS);
    }

    /***
     * 元素排序规则
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        long time = this.delayTime - ((DelayDemo) o).delayTime;
        return (int) time;
    }
}
