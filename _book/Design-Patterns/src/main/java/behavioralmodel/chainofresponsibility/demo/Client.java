package behavioralmodel.chainofresponsibility.demo;

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
