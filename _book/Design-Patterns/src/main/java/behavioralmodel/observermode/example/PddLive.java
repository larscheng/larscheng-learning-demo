package behavioralmodel.observermode.example;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/16 16:29
 */
public class PddLive extends Live {
    @Override
    public void openLive() {
        System.out.println("Pdd开直播了大家快来围观啊~~");
        fans.forEach(Fans::openApp);
    }
}
