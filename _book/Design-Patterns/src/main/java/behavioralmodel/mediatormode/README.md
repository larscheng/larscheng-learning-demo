### 中介者模式

定义一个中介对象来封装一系列对象之间的交互，使原有对象之间的耦合松散，且可以独立地改变他们之间的交互。

又叫做 调停模式

eg

举个例子，在上世纪，人们之间要联络都是通过书信的方式，首先要知道对方的地址，然后确保邮局能送到。如果对方的地址发生改变就永远联系不上了

但是现在，我们相互联系都是通过聊天工具，比如qq、微信

每个人通过自己的终端连接到qq服务器，添加朋友为好友，相互之间无论在哪都可以联系

qq服务器就是一个中介者

### 优缺点

优点

- 降低对象间的耦合、是的对象独立且复用性高
- 将原本一对多的关联转变为一对一，提高系统灵活性

缺点：当同事类过多会导致系统庞大复杂

### 角色和实现

- 抽象中介者角色：中介者的接口、提供同时对象注册与转发同时对象信息的抽象方法
- 具体中介者角色：实现中介者接口，提供一个list来管理同事集合，协调各同事间的关系
- 抽象同事类角色：同事类接口，保存中介者对象依赖，他提供同时对象交互的抽象方法，可以实现所有相互影响的同事类的公共功能 
- 具体同事类角色：抽象同事的实现，当需要与其他同事交互是，通过中介者进行交互

![](http://c.biancheng.net/uploads/allimg/181116/3-1Q1161I532V0.gif)

```java

package mediator;
import java.util.*;
public class MediatorPattern
{
    public static void main(String[] args)
    {
        Mediator md=new ConcreteMediator();
        Colleague c1,c2;
        c1=new ConcreteColleague1();
        c2=new ConcreteColleague2();
        md.register(c1);
        md.register(c2);
        c1.send();
        System.out.println("-------------");
        c2.send();
    }
}
//抽象中介者
abstract class Mediator
{
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague cl); //转发
}
//具体中介者
class ConcreteMediator extends Mediator
{
    private List<Colleague> colleagues=new ArrayList<Colleague>();
    public void register(Colleague colleague)
    {
        if(!colleagues.contains(colleague))
        {
            colleagues.add(colleague);
            colleague.setMedium(this);
        }
    }
    public void relay(Colleague cl)
    {
        for(Colleague ob:colleagues)
        {
            if(!ob.equals(cl))
            {
                ((Colleague)ob).receive();
            }   
        }
    }
}
//抽象同事类
abstract class Colleague
{
    protected Mediator mediator;
    public void setMedium(Mediator mediator)
    {
        this.mediator=mediator;
    }   
    public abstract void receive();   
    public abstract void send();
}
//具体同事类
class ConcreteColleague1 extends Colleague
{
    public void receive()
    {
        System.out.println("具体同事类1收到请求。");
    }   
    public void send()
    {
        System.out.println("具体同事类1发出请求。");
        mediator.relay(this); //请中介者转发
    }
}
//具体同事类
class ConcreteColleague2 extends Colleague
{
    public void receive()
    {
        System.out.println("具体同事类2收到请求。");
    }   
    public void send()
    {
        System.out.println("具体同事类2发出请求。");
        mediator.relay(this); //请中介者转发
    }
}
```


### 场景模拟

就模拟qq聊天

我通过qq，可以随时和通讯录里的人聊天

- 抽象中介者：聊天工具
- 具体中介者：qq
- 抽象同事：qq用户
- 具体同时：张三、李四、王五


![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190717171358.png)
