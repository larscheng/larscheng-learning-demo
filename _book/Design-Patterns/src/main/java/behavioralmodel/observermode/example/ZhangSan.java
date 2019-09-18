package behavioralmodel.observermode.example;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/16 16:31
 */
public class ZhangSan extends Fans {
    @Override
    void openApp() {
        System.out.println("粉丝"+getClass().getSimpleName()+"-----收到通知，打开app，进入直播间");
    }
}
