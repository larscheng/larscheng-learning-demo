package behavioralmodel.mediatormode.example;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/17 11:11
 */
public class QQPalyer extends User {
    public QQPalyer(String name) {
        super(name);
    }

    @Override
    public void send(String name,String msg) {
        tool.chat(this,name,msg);
    }

    @Override
    public void receive(User from,  String msg) {
        System.out.println(name+"收到来自："+from.getName()+" 的消息："+msg);
        System.out.println("--------------");
    }

}
