### 状态模式

在开发过程中，一些对象会针对不同情况做出不同行为，这种对象被称作有状态的对象，把影响对象行为的一个或多个动态变化的属性称为状态，
当有状态的对象与外部事物产生互动时，其内部会发生改变，从而使得其行为也随之发生改变

eg：

比如一个人，面对不同的人会有不同的情绪，做出相应的行为

面对女神的时候，就会高兴激动，行为举止上就会彬彬有礼，面对情敌的时候，就会厌恶生气，行为上就会出现攻击性或者抵触性

面对这种清创，开发时可以用条件判断解决，但是如果情况变多，即对象的状态很多的时候，这时候就可以采用`状态模式`



状态模式：对有状态的对象，把复杂的“逻辑判断”提取到不同状态的对象中，允许状态对象在其内部状态发生改变时改变其行为

### 优缺点

优点：

将不同状态的对象分割开来，满足单一原则
降低对象间的依赖
易于扩展

缺点：

增加类的数量和系统复杂度


### 角色和实现

- 环境角色：上下文，定义客户感兴趣的接口，维护一个当前状态，并将与状态相关操作较给当前状态对象来处理
- 抽象状态角色：用于封装环境对象中的特定状态所对应的行为的接口,其中包含环境角色的引用
- 具体状态角色：实现抽象状态所对应的行为


![](http://c.biancheng.net/uploads/allimg/181116/3-1Q11615412U55.gif)

![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190716151523.png)
```java
package state;
public class StatePatternClient
{
    public static void main(String[] args)
    {       
        Context context=new Context();    //创建环境       
        context.Handle();    //处理请求
        context.Handle();
        context.Handle();
        context.Handle();
    }
}
//环境类
class Context
{
    private State state;
    //定义环境类的初始状态
    public Context()
    {
        this.state=new ConcreteStateA();
    }
    //设置新状态
    public void setState(State state)
    {
        this.state=state;
    }
    //读取状态
    public State getState()
    {
        return(state);
    }
    //对请求做处理
    public void Handle()
    {
        state.Handle(this);
    }
}
//抽象状态类
abstract class State
{
    public abstract void Handle(Context context);
}
//具体状态A类
class ConcreteStateA extends State
{
    public void Handle(Context context)
    {
        System.out.println("当前状态是 A.");
        context.setState(new ConcreteStateB());
    }
}
//具体状态B类
class ConcreteStateB extends State
{
    public void Handle(Context context)
    {
        System.out.println("当前状态是 B.");
        context.setState(new ConcreteStateA());
    }
}
```


### 模拟场景

人的情绪就是最多变的一个状态，用状态模式来描述一个人面对各种情况下的情绪变化


其中

- 环境角色：中彩票、丢手机、吃大餐.....等等（你会遇到的多种情况）
- 抽象状态角色：你的情绪（你会出现的所有情绪的抽象）
- 具体状态角色：高兴、激动、难过、痛苦、兴奋....等等（你的具体情绪）

![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190716151403.png)

