package behavioralmodel.statemode.demo;

/**
 * 描述:
 * 具体状态角色A
 *
 * @author lars
 * @date 2019/7/16 13:57
 */
public class ConcreteStateA implements State{
    @Override
    public void Handle(Context context) {
        System.out.println("当前状态A");
        context.setState(new ConcreteStateB());
    }
}
