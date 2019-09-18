package behavioralmodel.visitormode.demo;

/**
 * @auther: lars
 * @date: 2019/7/18 11:45
 * @description: 抽象访问者
 */
public interface Visitor {
    void visit(ConcreteElementA elementA);
    void visit(ConcreteElementB elementA);
}
