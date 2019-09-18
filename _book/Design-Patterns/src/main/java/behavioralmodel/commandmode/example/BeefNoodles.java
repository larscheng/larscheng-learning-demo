package behavioralmodel.commandmode.example;

/**
 * 描述:
 * 牛肉面：具体命令2
 *
 * @author lars
 * @date 2019/7/11 11:16
 */
public class BeefNoodles implements WaiMai {
    private BeefNoodlesStore beefNoodlesStore;

    public BeefNoodles() {
        beefNoodlesStore = new BeefNoodlesStore();
    }

    @Override
    public void order() {
        System.out.println("用户下单牛肉拉面成功，通知店铺备餐配送");
        beefNoodlesStore.action();
    }
}
