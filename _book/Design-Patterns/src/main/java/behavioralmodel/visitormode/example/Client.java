package behavioralmodel.visitormode.example;

/**
 * 描述:
 * 客户端
 *
 * @author lars
 * @date 2019/7/18 14:33
 */
public class Client {
    public static void main(String[] args) {
        Tools tools = new Tools();
        Computer computer = new Computer();
        Phone phone = new Phone();
        tools.add(computer);
        tools.add(phone);


        tools.accept(new Zhangsan());
        System.out.println("------------------");
        tools.accept(new Lisi());
    }
}
