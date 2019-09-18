### 访问者模式

生活中，有很多几何对象存在多种不同元素，且每种元素会有不同的访问者和不同的处理方式。

eg：

医生开的处方单，査看它的划价员和药房工作人员对它的处理方式也不同，划价员根据处方单上面的药品名和数量进行划价，药房工作人员根据处方单的内容进行抓药。

访问者模式就是处理这种场景的。

定义：将作用于某种数据结构中的各种元素的`操作`分离出来封装成`独立的类`，
使其在不改变数据结构的前提下可以添加作用于这些元素的新的操作，为数据结构中每个元素提供多种访问方式。

将数据的操作与数据结构进行分离，是行为类模式中最复杂的一种


### 优缺点

- 扩展性好：能够在不修改对象结构中元素的情况下，为对象结构中元素添加新功能
- 复用性好：可以通过访问者来定义整个对象结构通用的功能，从而提高系统的复用程度
- 灵活性好：访问者模式将数据结构与作用于结构上的操作解耦合，使得操作集合可以相对自由的演化而不影响系统的数据结构
- 符合单一职责原则：访问者模式吧相关的行为封装在一起构成访问者




缺点：

- 增加新的元素不方便，每增加一个新的元素类，都要在具体访问者中增加相应具体操作
- 破坏封装，访问者模式中具体元素对访问者公布细节
- 违反依赖倒置原则，访问者模式依赖具体类，而非抽象类


### 角色和实现

- 抽象访问者角色：定义一个访问具体元素的接口，为每个具体元素类对应一个访问操作visit(),该操作中的参数类型标识了被访问的具体元素
- 具体访问者角色：实现抽象访问者中的访问操作，确定访问者访问每一个元素该做的操作
- 抽象元素角色：声明一个包含接收操作的接口，被接受的访问者对象作为该方法的参数
- 具体元素角色：实现抽象元素角色提供的accept()方法，同事包含业务本身逻辑
- 对象结构角色：包含元素角色的容器，提供让访问者对象遍历容器中所有元素的方法，通常由List、Set、Map等聚合类实现

![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190718134613.png)

```java
package visitor;
import java.util.*;
public class VisitorPattern
{
    public static void main(String[] args)
    {
        ObjectStructure os=new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        Visitor visitor=new ConcreteVisitorA();
        os.accept(visitor);
        System.out.println("------------------------");
        visitor=new ConcreteVisitorB();
        os.accept(visitor);
    }
}
//抽象访问者
interface Visitor
{
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}
//具体访问者A类
class ConcreteVisitorA implements Visitor
{
    public void visit(ConcreteElementA element)
    {
        System.out.println("具体访问者A访问-->"+element.operationA());
    }
    public void visit(ConcreteElementB element)
    {
        System.out.println("具体访问者A访问-->"+element.operationB());
    }
}
//具体访问者B类
class ConcreteVisitorB implements Visitor
{
    public void visit(ConcreteElementA element)
    {
        System.out.println("具体访问者B访问-->"+element.operationA());
    }
    public void visit(ConcreteElementB element)
    {
        System.out.println("具体访问者B访问-->"+element.operationB());
    }
}
//抽象元素类
interface Element
{
    void accept(Visitor visitor);
}
//具体元素A类
class ConcreteElementA implements Element
{
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
    public String operationA()
    {
        return "具体元素A的操作。";
    }
}
//具体元素B类
class ConcreteElementB implements Element
{
    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }
    public String operationB()
    {
        return "具体元素B的操作。";
    }
}
//对象结构角色
class ObjectStructure
{   
    private List<Element> list=new ArrayList<Element>();   
    public void accept(Visitor visitor)
    {
        Iterator<Element> i=list.iterator();
        while(i.hasNext())
        {
            ((Element) i.next()).accept(visitor);
        }      
    }
    public void add(Element element)
    {
        list.add(element);
    }
    public void remove(Element element)
    {
        list.remove(element);
    }
}
```


### 场景模拟

张三通过电脑看电视，李四通过电脑做软件开发。
张三通过手机听歌，李四通过手机学英语

两个人对于电脑、手机这两个物品，使用方式不同，达到的用途也就不同，这一情况用访问者模式描述

其中角色如下

- 抽象访问者：人，定义访问具体元素的方法（电脑、手机）
- 具体访问者：张三、李四，实现抽象方法，
- 抽象元素角色：工具tool，声明一个接收操作的方法（接收访问者调用的方法），方法参数为具体访问者
- 具体元素角色：电脑、手机，实现接口方法，通过访问者访问具体元素中的业务逻辑方法
- 对象结构角色：工具集tools

实现如下：
![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190718143612.png)