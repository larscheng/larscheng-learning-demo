package behavioralmodel.visitormode.demo;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/18 11:59
 */
public class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new ConcreteElementA());
        objectStructure.add(new ConcreteElementB());
        objectStructure.accept(new ConcreteVisitorA());

        System.out.println("-------------------------");

        objectStructure.accept(new ConcreteVisitorB());

    }
}
