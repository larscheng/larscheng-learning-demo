package com.larscheng.www.part13_single;

/**
 * 描述:
 * 饿汉式
 *
 * @author larscheng
 * @date 2020/3/16 10:26
 */
public class HungrySingleton {

    /**上来就加载，不管你用不用-----------》会造成资源浪费*/
    private static final HungrySingleton singleton = new HungrySingleton();

    private HungrySingleton(){};


    private static HungrySingleton getInstance(){
        return singleton;
    }
}
