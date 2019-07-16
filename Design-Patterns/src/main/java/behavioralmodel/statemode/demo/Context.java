package behavioralmodel.statemode.demo;

/**
 * 描述:
 * 环境角色
 *
 * @author zhengql
 * @date 2019/7/16 13:55
 */
public class Context {
    private State state;

    public Context() {
        this.state = new ConcreteStateA();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void Handler(){
        state.Handle(this);
    }
}
