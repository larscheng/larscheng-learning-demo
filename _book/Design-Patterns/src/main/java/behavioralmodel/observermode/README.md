### 观察者模式

很多对象不是独立存在的，一个对象发生变化会导致其他几个对象的行为也发生相应变化。

比如，今天的饭很便宜顾客很多，明天的饭很贵顾客会相应减少；红绿灯为绿灯，车辆会直接通过，为红灯，车辆会停止

观察者模式就是用来处理这种场景

定义：多个对象间存在一对多的依赖关系时，当一个对象状态发生改变，所有依赖的对象都会得到通知并自动更新。

又称作发布-订阅模式、模型-视图模式，属于对象行为型模式

### 优缺点

优点：

降低了对象间的耦合、目标与观察者之间有变化后的触发机制

缺点：观察者数量过多，通知发布耗时长，影响效率

### 角色和实现

- 抽象主题角色：抽象目标类，提供一个用于保存观察者对象的聚集类和用于关系观者者对象的基本方法，以及通知观察者的抽象方法
- 具体主题角色：具体目标类，实现抽象目标中的通知方法，当具体的内部状态发生变化时没通知所有的观察者
- 抽象观察者角色：包含更新自身的抽象方法
- 具体观察者角色：实现抽象观察者中的抽象方法


![](http://c.biancheng.net/uploads/allimg/181116/3-1Q1161A6221S.gif)

```java
package observer;
import java.util.*;
public class ObserverPattern
{
    public static void main(String[] args)
    {
        Subject subject=new ConcreteSubject();
        Observer obs1=new ConcreteObserver1();
        Observer obs2=new ConcreteObserver2();
        subject.add(obs1);
        subject.add(obs2);
        subject.notifyObserver();
    }
}
//抽象目标
abstract class Subject
{
    protected List<Observer> observers=new ArrayList<Observer>();   
    //增加观察者方法
    public void add(Observer observer)
    {
        observers.add(observer);
    }    
    //删除观察者方法
    public void remove(Observer observer)
    {
        observers.remove(observer);
    }   
    public abstract void notifyObserver(); //通知观察者方法
}
//具体目标
class ConcreteSubject extends Subject
{
    public void notifyObserver()
    {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");       
       
        for(Object obs:observers)
        {
            ((Observer)obs).response();
        }
       
    }          
}
//抽象观察者
interface Observer
{
    void response(); //反应
}
//具体观察者1
class ConcreteObserver1 implements Observer
{
    public void response()
    {
        System.out.println("具体观察者1作出反应！");
    }
}
//具体观察者1
class ConcreteObserver2 implements Observer
{
    public void response()
    {
        System.out.println("具体观察者2作出反应！");
    }
}
```



### 模拟场景

平时看直播有这样一个场景

你喜欢看pdd直播，在pdd直播间点了关注，并开启的开播通知

有一天pdd开直播了，直播平台就向关注他的用户发通知，然后观众们都打开app来看直播

其中：
- 抽象主题角色：直播
- 具体主题角色：pdd直播
- 抽象观察者：粉丝们
- 具体观察者：粉丝小王、粉丝小李

这个场景用观察者模式描述下

![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190716164327.png)