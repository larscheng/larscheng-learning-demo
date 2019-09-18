package behavioralmodel.mediatormode.demo;

/**
 * 描述:
 * 具体同事类
 *
 * @author lars
 * @date 2019/7/16 17:54
 */
public class ConcreteColleague1 extends Colleague {
    @Override
    public void receive() {
        System.out.println("具体同事类1收到请求");
    }

    @Override
    public void send() {
        System.out.println("具体同事类1发起请求");
        mediator.relay(this);
    }
}
