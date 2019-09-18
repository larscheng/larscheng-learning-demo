package behavioralmodel.commandmode.demo;

/**
 * 描述:
 * 调用者/请求者角色
 *
 * @author lars
 * @date 2019/7/11 10:29
 */
public class Invoker {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public Invoker(Command command) {

        this.command = command;
    }

    public void call(){
        System.out.println("调用者执行命令。。。");
        command.execute();
    }
}
