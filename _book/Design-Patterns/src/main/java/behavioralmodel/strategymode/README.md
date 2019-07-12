### 策略模式

定义了一系列算法，将每个算法封装起来，使得他们可以互相替换，且算法的变化不会影响使用算法的客户


属于对象行为模式，通过算法的防撞，把使用算法的责任和算法实现分隔开来，并委派给不同的对象对这些算法进行管理

eg：
现实生活中，完成一项任务有多种解决策略，比如

春运回家可以坐汽车、坐火车、坐高铁、坐飞机等

淘宝买东西可以微信、支付宝、朋友代付、花呗等支付

这种情况下就可以使用策略模式


### 优缺点

优点：

避免过量使用多重条件判断语句  
提供一系列的可供重用的算法族，恰当使用继承可以把算法族的公共代码转移到父类里面，避免重复的代码  
提供相同功能不同实现  
完美实现开闭原则，添加新算法灵活  

缺点：

客户端需要了解所有策略的区别，以便知道何时调用指定某算法  
系统代码复杂度增加


### 角色和实现

抽象策略类：定义了一个公共接口，各种不同算法以不同的方式实现这个接口  
具体策略类：实现了抽象策略类定义的接口，提供具体算法的实现  
环境类：持有一个策略类引用，最终交给客户端调用



![](http://c.biancheng.net/uploads/allimg/181116/3-1Q116103K1205.gif)



![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190710135942.png)



```java
public class StrategyModeTest {


    interface Strategy {
        public void strategyMethod();
    }

    static class ConcreteStrategyA implements Strategy {
        @Override
        public void strategyMethod() {
            System.out.println("具体策略A的策略方法被访问！");
        }
    }

    static class ConcreteStrategyB implements Strategy {
        @Override
        public void strategyMethod() {
            System.out.println("具体策略B的策略方法被访问！");
        }
    }

    static class Context {
        private Strategy strategy;

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        public void strategyMethod() {
            strategy.strategyMethod();
        }
    }


    static class Client {
        public Client() {
            Strategy strategyA = new ConcreteStrategyA();
            Context context = new Context(strategyA);
            context.strategyMethod();

            System.out.println("----------------------------");
            Strategy strategyB = new ConcreteStrategyB();
            context = new Context(strategyB);
            context.strategyMethod();
        }
    }


    public static void main(String[] args) {
        new Client();
    }
}

```