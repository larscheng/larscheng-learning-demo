package behavioralmodel.observermode.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 抽象目标
 *
 * @author lars
 * @date 2019/7/16 15:41
 */
public abstract class Subject {

    /**
     * 用于保存观察者对象的集合
     * */
    protected List<Observer> observers = new ArrayList<Observer>();

    public boolean add(Observer observer){
       return observers.add(observer);
    }
    public boolean remove(Observer observer){
        return observers.remove(observer);
    }

    /**
     * 通知方法
     */
    public abstract void notifyObserver();
}
