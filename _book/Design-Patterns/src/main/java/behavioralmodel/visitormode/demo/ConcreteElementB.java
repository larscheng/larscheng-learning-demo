package behavioralmodel.visitormode.demo;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/18 11:51
 */
public class ConcreteElementB implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return "具体元素B的操作";
    }
}
