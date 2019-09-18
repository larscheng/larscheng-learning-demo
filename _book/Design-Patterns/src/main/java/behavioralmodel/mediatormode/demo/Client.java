package behavioralmodel.mediatormode.demo;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/16 17:57
 */
public class Client {
    public static void main(String[] args) {

        Mediator md = new ConcreteMediator();
        Colleague colleague1 = new ConcreteColleague1();
        Colleague colleague2 = new ConcreteColleague2();

        md.register(colleague1);
        md.register(colleague2);
        colleague1.send();
        System.out.println("----------------");
        colleague2.send();

    }
}
