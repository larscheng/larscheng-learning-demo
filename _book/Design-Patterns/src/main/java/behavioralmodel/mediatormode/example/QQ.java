package behavioralmodel.mediatormode.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 具体中介者:qq
 *
 * @author lars
 * @date 2019/7/17 11:05
 */
public class QQ extends ChatTool {

    private List<User> users = new ArrayList<>();


    @Override
    void login(User user) {
        if (!users.contains(user)) {
            users.add(user);
            user.setTool(this);
            System.out.println(user.name + "登录成功");
        }
    }

    @Override
    void chat(User from, String name, String msg) {

        boolean flag = false;
        for (User user : users) {
            if (user.getName().equals(name)) {
                flag = true;
                System.out.println(from.name + "向:" + user.name + "发送消息");
                user.receive(from, msg);
            }
        }
        if (!flag) {
            System.err.println(name + "现在不在线哦~");
            System.out.println("--------------");
        }
    }
}
