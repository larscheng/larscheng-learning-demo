package behavioralmodel.mediatormode.demo;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/16 17:47
 */
public abstract class Colleague {

    ConcreteMediator mediator;

    public void setMediator(ConcreteMediator mediator) {
        this.mediator = mediator;
    }

    public ConcreteMediator getMediator() {
        return mediator;
    }

    public abstract void receive();
    public abstract void send();
}
