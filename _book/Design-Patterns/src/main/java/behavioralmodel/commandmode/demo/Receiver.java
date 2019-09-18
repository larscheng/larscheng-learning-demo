package behavioralmodel.commandmode.demo;

/**
 * 描述:
 * 接收者/实现者，真正的命令实现
 *
 * @author lars
 * @date 2019/7/11 10:33
 */
public class Receiver {
    public void action(){
        System.out.println("接收者收到命令，并执行命令。。。");
    }
}
