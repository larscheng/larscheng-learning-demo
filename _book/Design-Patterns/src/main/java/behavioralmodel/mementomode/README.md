### 备忘录模式

备忘录模式：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，以便以后当需要时能将该对象恢复到之前保存的状态
所以又叫`快照模式`

最常见的例子就比如说ctrl+z、虚拟机的快照功能


### 优缺点

优点：

- 提供后悔药功能
- 封装性好
- 符合单一职责原则：创建备份的类只管创建，备份交给备忘录管理

缺点: 消耗资源

### 结构和实现

- 发起人角色：记录当前时刻的内部状态信息，提供创建和恢复备忘录的功能，实现其他业务功能，可以访问备忘录中的信息
- 备忘录角色：负责存储发起人的内部状态，在需要的时候将提供内部状态给发起人
- 管理者角色：对备忘录进行管理，提供保存、获取备忘录的功能，但不能修改和访问备忘录信息

![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190719135435.png)

```java

package memento;
public class MementoPattern
{
    public static void main(String[] args)
    {
        Originator or=new Originator();
        Caretaker cr=new Caretaker();       
        or.setState("S0"); 
        System.out.println("初始状态:"+or.getState());           
        cr.setMemento(or.createMemento()); //保存状态      
        or.setState("S1"); 
        System.out.println("新的状态:"+or.getState());        
        or.restoreMemento(cr.getMemento()); //恢复状态
        System.out.println("恢复状态:"+or.getState());
    }
}
//备忘录
class Memento
{ 
    private String state; 
    public Memento(String state)
    { 
        this.state=state; 
    }     
    public void setState(String state)
    { 
        this.state=state; 
    }
    public String getState()
    { 
        return state; 
    }
}
//发起人
class Originator
{ 
    private String state;     
    public void setState(String state)
    { 
        this.state=state; 
    }
    public String getState()
    { 
        return state; 
    }
    public Memento createMemento()
    { 
        return new Memento(state); 
    } 
    public void restoreMemento(Memento m)
    { 
        this.setState(m.getState()); 
    } 
}
//管理者
class Caretaker
{ 
    private Memento memento;       
    public void setMemento(Memento m)
    { 
        memento=m; 
    }
    public Memento getMemento()
    { 
        return memento; 
    }
}
```


### 模拟场景

用备忘录模式来描述，word写文档时的撤回功能

- 发起人角色：用户
- 备忘录角色：word内部备忘录
- 管理者角色：word2016


![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190719144626.png)