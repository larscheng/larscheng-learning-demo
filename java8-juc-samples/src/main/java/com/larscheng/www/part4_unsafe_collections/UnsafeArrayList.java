package com.larscheng.www.part4_unsafe_collections;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 描述:
 * 线程不安全的ArrayList
 * java.util.ConcurrentModificationException
 *
 * @author larscheng
 * @date 2020/3/5 14:56
 */
public class UnsafeArrayList {

    /***
     * 解决方案1：        List<String> list = new Vector<>();
     * 解决方案2：        List<String> list = Collections.synchronizedList(new ArrayList<>());
     *
     * @param args
     */


    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());

        List<String> list = new CopyOnWriteArrayList<>();
        //CopyOnWriteArrayList 写入时复制，优化策略：读写分离，在写入时必变覆盖造成数据问题！内部使用Locks
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }).start();
        }
    }


}
