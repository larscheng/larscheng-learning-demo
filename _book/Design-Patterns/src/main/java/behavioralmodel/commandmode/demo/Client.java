package behavioralmodel.commandmode.demo;

/**
 * 描述:
 * 客户端
 *
 * @author lars
 * @date 2019/7/11 10:37
 */
public class Client {

    public static void main(String[] args) {

        Command command = new ConcreteCommand();
        Invoker invoker = new Invoker(command);

        System.out.println("客户端访问调用者的call方法,去完成A指令");
        invoker.call();


        System.out.println("---------------------------");
        System.out.println("客户端访问调用者的call方法,去完成B指令");
        invoker = new Invoker(new ConcreteCommandB());
        invoker.call();
    }
}
