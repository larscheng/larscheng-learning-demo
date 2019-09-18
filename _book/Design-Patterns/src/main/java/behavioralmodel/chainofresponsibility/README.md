### 责任链模式（职责链模式）

为避免请求发送者与多个请求处理者耦合在一起，将所有的请求处理者通过前一对象记住下一个对象的引用而产生一条链，当有请求发生时，可将请求沿着这条链传递，直到有对象处理他为止


eg:



### 优缺点

在责任链模式中，客户只需要将请求发送到责任链上即可，无需关心请求的处理细节和请求的传递过程，所以责任链将请求的发送者和处理者解耦和


优点：

- 降低对象间的耦合度
- 增强系统的可扩展性、增强了给对象指派职责的灵活性
- 责任链简化对象之间的联系，每个对象只需要保持指向其后继者的引用，不用包其与其他处理者的所有引用
- 简化责任分担，各个处理类各司其职

缺点：

- 不能保证请求一定会被处理，因为请求不需指定处理者，可能走完责任链也没有被处理
- 过长的责任链会导致系统性能受到影响

### 结构和实现

- 抽象处理者角色：定义一个处理请求的接口，包含抽象处理方法和一个后继连接
- 具体处理者角色：实现抽象处理者的处理方法，判断能否处理本次请求，如果不能，则交给后继者
- 客户类角色：创建处理链。并向链头的具体处理者对象提交请求，他不关心处理细节和请求的传递过程


![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190712180111.png)

```java
/**
 * 描述:
 * 抽象处理者角色
 *
 * @author lars
 * @date 2019/7/12 17:52
 */
public abstract class Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }
    public abstract void handleRequest(String request);
}


/**
 * 描述:
 * 具体处理者角色A
 *
 * @author lars
 * @date 2019/7/12 17:54
 */
public class ConcreteHandlerA extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("A")){
            System.out.println("具体处理者角色A处理该请求");
        }else {
            if (Objects.isNull(super.getNextHandler())){
                System.out.println("孤儿请求，无人接收");
            }else {
                super.getNextHandler().handleRequest(request);
            }
        }
    }
}

/**
 * 描述:
 * 具体处理者角色B
 *
 * @author lars
 * @date 2019/7/12 17:54
 */
public class ConcreteHandlerB extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("B")){
            System.out.println("具体处理者角色B处理该请求");
        }else {
            if (Objects.isNull(super.getNextHandler())){
                System.out.println("孤儿请求，无人接收");
            }else {
                super.getNextHandler().handleRequest(request);
            }
        }
    }
}

/**
 * 描述: 客户端角色
 *
 * @author lars
 * @date 2019/7/12 17:58
 */
public class Client {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        handlerA.setNextHandler(handlerB);

        handlerA.handleRequest("B");
        handlerA.handleRequest("C");
    }
}
```

### 模拟场景

Dns解析过程，比如果输入域名www.baidu.com 

![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/DesignPatterns/20190712183905.png)