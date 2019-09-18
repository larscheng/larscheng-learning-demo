package behavioralmodel.chainofresponsibility.demo;

/**
 * 描述:
 * 抽象处理者角色
 *
 * @author lars
 * @date 2019/7/12 17:52
 */
public abstract class Handler {
    private Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }
    public abstract void handleRequest(String request);
}
