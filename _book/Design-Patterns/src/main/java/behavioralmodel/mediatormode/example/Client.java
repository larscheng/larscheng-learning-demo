package behavioralmodel.mediatormode.example;

import java.util.Scanner;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/17 11:30
 */
public class Client {
    public static void main(String[] args) {
        ChatTool tool = new QQ();

        QQPalyer zhangsan = new QQPalyer("zhangsan");
        QQPalyer lisi = new QQPalyer("lisi");
        tool.login(zhangsan);
        tool.login(lisi);

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入要发送的用户名：");
            String username = scanner.nextLine();
            System.out.println("请输入要发送的消息：");
            String msg = scanner.nextLine();
            zhangsan.send(username,msg);
        }
    }
}
