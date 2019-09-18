package behavioralmodel.commandmode.example;

/**
 * 描述:
 * 黄焖鸡：具体命令1
 *
 * @author lars
 * @date 2019/7/11 11:09
 */
public class BraisedChicken implements WaiMai {
    private BraisedChickenStore braisedChickenStore;

    public BraisedChicken() {
        this.braisedChickenStore = new BraisedChickenStore();
    }

    @Override
    public void order() {
        System.out.println("用户下单黄焖鸡成功，通知店铺备餐配送");
        braisedChickenStore.action();
    }
}
