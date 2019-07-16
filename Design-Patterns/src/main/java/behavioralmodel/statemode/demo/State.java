package behavioralmodel.statemode.demo;

/**
 * @auther: zhengql
 * @date: 2019/7/16 13:55
 * @description:
 * 抽象状态角色
 */
public interface State {
    public void Handle(Context context);
}
