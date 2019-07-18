### 迭代器模式

定义： 提供一个对象来顺序访问聚合对象中的一系列数据，而不暴露聚合对象的内部表示。


是对象行为型模式， 通过将聚合对象的遍历行为分离出来，抽象成迭代器类来实现，其目的是在不暴露聚合对象的内部结构情况下，让外部代码透明的访问聚合对象的内部数据

其主要优点如下：

- 访问聚合对象内容无需暴露内部表示
- 遍历工作交给迭代器，简化聚合类
- 支持以不同方式遍历一个集合，或者自定义迭代器
- 新增聚合类和迭代器十分便捷，无需修改原有代码
- 封装性良好，为遍历不同的聚合结构提供一个统一的接口

缺点： 增加了类的个数，在一定程度上增加系统的复杂性

### 角色和实现

- 抽象聚合角色：定义存储、提娜佳、删除聚合对象以及创建迭代器对象的接口
- 具体聚合角色：实现抽象聚合类，返回一个具体迭代器的实例
- 抽象迭代器角色：定义访问和遍历聚合元素的接口，通常包含hasNext()、first()、next()等方法
- 具体迭代器角色：实现抽象迭代器的方法，完成对聚合对象的遍历，记录遍历的当前位置

![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190718094533.png)

```java
package iterator;
import java.util.*;
public class IteratorPattern
{
    public static void main(String[] args)
    {
        Aggregate ag=new ConcreteAggregate(); 
        ag.add("中山大学"); 
        ag.add("华南理工"); 
        ag.add("韶关学院");
        System.out.print("聚合的内容有：");
        Iterator it=ag.getIterator(); 
        while(it.hasNext())
        { 
            Object ob=it.next(); 
            System.out.print(ob.toString()+"\t"); 
        }
        Object ob=it.first();
        System.out.println("\nFirst："+ob.toString());
    }
}
//抽象聚合
interface Aggregate
{ 
    public void add(Object obj); 
    public void remove(Object obj); 
    public Iterator getIterator(); 
}
//具体聚合
class ConcreteAggregate implements Aggregate
{ 
    private List<Object> list=new ArrayList<Object>(); 
    public void add(Object obj)
    { 
        list.add(obj); 
    }
    public void remove(Object obj)
    { 
        list.remove(obj); 
    }
    public Iterator getIterator()
    { 
        return(new ConcreteIterator(list)); 
    }     
}
//抽象迭代器
interface Iterator
{
    Object first();
    Object next();
    boolean hasNext();
}
//具体迭代器
class ConcreteIterator implements Iterator
{ 
    private List<Object> list=null; 
    private int index=-1; 
    public ConcreteIterator(List<Object> list)
    { 
        this.list=list; 
    } 
    public boolean hasNext()
    { 
        if(index<list.size()-1)
        { 
            return true;
        }
        else
        {
            return false;
        }
    }
    public Object first()
    {
        index=0;
        Object obj=list.get(index);;
        return obj;
    }
    public Object next()
    { 
        Object obj=null; 
        if(this.hasNext())
        { 
            obj=list.get(++index); 
        } 
        return obj; 
    }   
}
```


迭代器模式，常用集合类的同学应该都不陌生，java中的集合类都提供了迭代器类，上面的例子也是参考ArrayList写的


### 应用场景

1. 当需要为聚合对象提供多种遍历方式时
2. 当需要为遍历不同的聚合结构提供统一的接口时
3. 当访问同一个聚合对象的内容而无需暴露其内部实现细节时


