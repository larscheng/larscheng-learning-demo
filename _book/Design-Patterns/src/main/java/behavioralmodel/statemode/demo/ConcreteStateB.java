package behavioralmodel.statemode.demo;

/**
 * 描述:
 * 具体状态角色B
 *
 * @author lars
 * @date 2019/7/16 13:57
 */
public class ConcreteStateB implements State{
    @Override
    public void Handle(Context context) {
        System.out.println("当前状态B");
        context.setState(new ConcreteStateA());
    }
}
