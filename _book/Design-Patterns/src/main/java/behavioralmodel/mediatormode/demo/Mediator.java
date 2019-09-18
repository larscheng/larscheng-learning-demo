package behavioralmodel.mediatormode.demo;

/**
 * 描述:
 * 抽象中介者
 *
 * @author lars
 * @date 2019/7/16 17:46
 */
public abstract class Mediator {
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague colleague);

}
