package behavioralmodel.visitormode.demo;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/18 11:51
 */
public class ConcreteElementA implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "具体元素A的操作";
    }
}
