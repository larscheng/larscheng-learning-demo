### 模板方法模式

定义一个操作中的算法骨架、而将算法的一些步骤延迟到子类中，
使得子类可以不改变算法结构的情况下重定义该算法的某些特定步骤。

他是一种类行为模式

eg：

一个人每天会经历起床、吃饭、工作、睡觉这几件事情，其中起床、吃饭、睡觉都是相同的，工作内容每个人却不一样

银行办业务：取号、排队、办理、评价，其中取号、排队、评价都相同，办理内容每个人都不同

这种情况下，可以将这些相同的流程定义为模板，而因人而异的部分留给实现者自由决定


### 优缺点

优点：

封装了不变的部分（封装在父类），扩展了可变部分（子类继承实现）

在父类中提取公共部分代码，代码复用性强

扩展性强

缺点：

每个不同的实现都需要一个子类，系统类数量增多


### 角色及实现

- 抽象类：负责给出一个算法的骨架，其中包含模板方法和基本方法
    - 模板方法：定义骨架，按照某种顺序调用其中的基本方法
    - 基本方法：整个算法骨架中的一个步骤，其中分为：
        - 抽象方法：在抽象类中声明，具体有子类实现
        - 具体方法：在抽象类中已经实现，在子类中可继承或者重写
        - 钩子方法：在抽象类中已经实现，包括用于判断的逻辑方法和需要子类重写的空方法两种
- 具体子类：实现抽象类中定义的抽象方法和钩子方法


![](http://c.biancheng.net/uploads/allimg/181116/3-1Q116095405308.gif)


```java
/**
 * 描述:模板方法模式
 *
 * @author lars
 * @date 2019/7/10 10:16
 */
public class TemplateModeTest {

    /***
     * 抽象类
     */
    abstract class AbstractClass{
        /***
         * 模板方法
         */
        public void templateMethod(){
            specificMethod();
            abstractMethodA();
            abstractMethodB();
        }

        /**
         * 具体方法
         */
        public void specificMethod() {
            System.out.println("抽象类中的具体方法被调用...");
        }

        /**
         * 抽象方法1
         */
        protected abstract void abstractMethodB();

        /**
         * 抽象方法2
         */
        protected abstract void abstractMethodA();

    }


    class ConcreteClass extends AbstractClass{
        @Override
        public void abstractMethodB() {
            System.out.println("抽象方法1的实现被调用..");
        }

        @Override
        public void abstractMethodA() {
            System.out.println("抽象方法2的实现被调用..");
        }
    }


    public static void main(String[] args) {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.templateMethod();
    }
}
```


### 模拟场景


 比如春运回家会经历：买票、到达车站、检票、上车、到达目的地

 其中整体的流程相同，但是每个人春运回家的交通工具是不同的

 其中 
 抽象类：春运回家，模板方法（买票、到达车站、检票、上车、到达目的地），抽象方法（买票、到达车站、上车）具体方法（检票、到达目的地）  
 坐火车回家：具体类  
 坐高铁回家：具体类 


![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190710110446.png)