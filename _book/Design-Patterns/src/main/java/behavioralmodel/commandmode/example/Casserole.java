package behavioralmodel.commandmode.example;

/**
 * 描述:
 * 砂锅：具体命令3
 * @author lars
 * @date 2019/7/11 11:25
 */
public class Casserole implements WaiMai{
    private CasseroleStore casseroleStore;

    public Casserole() {
        this.casseroleStore = new CasseroleStore();
    }

    @Override
    public void order() {
        System.out.println("用户下单三鲜砂锅成功，通知店铺备餐配送");
        casseroleStore.action();
    }
}
