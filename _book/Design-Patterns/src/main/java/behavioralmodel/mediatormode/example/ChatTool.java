package behavioralmodel.mediatormode.example;

/**
 * 描述:
 * 聊天工具：抽象中介者
 *
 * @author lars
 * @date 2019/7/17 11:01
 */
public abstract class ChatTool {
    abstract void login(User user);
    abstract void chat(User from,String to,String msg);
}
