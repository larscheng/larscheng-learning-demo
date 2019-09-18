package behavioralmodel.visitormode.demo;

/**
 * 描述:具体访问者B
 *
 * @author lars
 * @date 2019/7/18 11:46
 */
public class ConcreteVisitorB implements Visitor {
    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("具体访问者B访问-->"+elementA.operationA());
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        System.out.println("具体访问者B访问-->"+elementB.operationB());
    }
}
