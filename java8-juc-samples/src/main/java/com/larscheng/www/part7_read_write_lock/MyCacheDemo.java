package com.larscheng.www.part7_read_write_lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 描述:
 * 使用读写锁，模拟自定义缓存
 * <p>
 * 写入的时候只能有一个在写入
 * 读取时可以有多个线程进行读取
 *
 *
 *
 * 读读   可共存
 * 读写   不可共存
 * 写写   不可共存
 *
 *
 * 排他锁----------> 写锁
 * 共享锁----------> 读锁
 * @author larscheng
 * @date 2020/3/11 15:26
 */
public class MyCacheDemo {

    public static void main(String[] args) {

        MyCacheLock myCacheLock = new MyCacheLock();

        //并发写
        for (int i = 0; i <10 ; i++) {
            int finalI = i;
            new Thread(()->{
                myCacheLock.put(String.valueOf(finalI),finalI);
            },String.valueOf(i)).start();
        }
        //并发读
        for (int i = 0; i <10 ; i++) {
            int finalI = i;
            new Thread(()->{
                myCacheLock.get(String.valueOf(finalI));
            },String.valueOf(i)).start();
        }
    }




}
class MyCacheLock {

    private volatile Map<String, Object> map = new HashMap<>();
    //juc普通锁
    private Lock lock = new ReentrantLock();
    //更加细粒度读写锁
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public void put (String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" 写入 "+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+" 写入成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }


    public void get (String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" 读取 "+key);
            map.get(key);
            System.out.println(Thread.currentThread().getName()+" 读取成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}