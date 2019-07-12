### 命令模式


软件开发中常常出现“方法请求者”与“方法实现者”之间存在密切关系的情形，相对行为进行撤销、重做、记录等处理时很不方便，

> 命令模式就是实现，命令发送者与实现者之间的解耦合。


命令模式的定义如下：

将一个请求封装成为一个对象，使发出请求的责任和执行请求的责任分割开。

这样两者之间通过命令对象进行沟通，方便将命令对象进行存储、传递、调用、增加、与管理

eg：

电视机遥控器（命令发送者）通过按钮（具体命令）来控制电视机（命令接收者）

### 优缺点

优点：

- 降低系统的耦合度
- 增加、删除命令方便，满足开闭原则，扩展灵活
- 可以和其他设计模式结合使用（组合模式、备忘录模式）

缺点：产生大量具体命令类，增加系统复杂性

### 角色和实现

- 抽象命令类角色：声明执行命令的接口，拥有执行命令的抽象方法execute()
- 具体命令角色：是抽象命令类的具体实现类，它拥有接收者对象，并通过接收者的功能来完成命令要执行的操作
- 实现者/接收者角色：执行命令功能的相关操作，是具体命令角色的实现者
- 调用者/请求者角色：是请求的发送者，拥有很多命令对象，通过访问命令对象来执行相关请求，他不直接访问接收者


![](http://c.biancheng.net/uploads/allimg/181116/3-1Q11611335E44.gif)





![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190711104722.png)

```java
package command;
public class CommandPattern
{
    public static void main(String[] args)
    {
        Command cmd=new ConcreteCommand();
        Invoker ir=new Invoker(cmd);
        System.out.println("客户访问调用者的call()方法...");
        ir.call();
    }
}
//调用者
class Invoker
{
    private Command command;
    public Invoker(Command command)
    {
        this.command=command;
    }
    public void setCommand(Command command)
    {
        this.command=command;
    }
    public void call()
    {
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}
//抽象命令
interface Command
{
    public abstract void execute();
}
//具体命令
class ConcreteCommand implements Command
{
    private Receiver receiver;
    ConcreteCommand()
    {
        receiver=new Receiver();
    }
    public void execute()
    {
        receiver.action();
    }
}
//接收者
class Receiver
{
    public void action()
    {
        System.out.println("接收者的action()方法被调用...");
    }
}

```

### 模拟场景

比如说点外卖

我要点外卖，外卖app上的吃的和店铺有很多很多，选了好久之后，我在app上下单点了一家名叫黄焖鸡米饭店内的黄焖鸡

这其中

- 外卖：抽象命令类，它包含抽象方法点外卖
- 黄焖鸡、牛肉面、砂锅等：具体命令类，都属于外卖，如果你点他，他会告诉接收者开始准备外卖
- 黄焖鸡店、拉面店、砂锅店等：实现者/接收者
- app：调用者/请求者，app中有很多具体命令对象，具体的外卖


![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190711113521.png)