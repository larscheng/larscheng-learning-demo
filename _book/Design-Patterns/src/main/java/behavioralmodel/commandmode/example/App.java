package behavioralmodel.commandmode.example;

/**
 * 描述:
 * 外卖app：调用者/接收者
 *
 * @author lars
 * @date 2019/7/11 11:04
 */
public class App {

    private WaiMai braisedChicken,beefNoodles,casserole;

    public void setBraisedChicken(WaiMai braisedChicken) {
        this.braisedChicken = braisedChicken;
    }

    public void setBeefNoodles(WaiMai beefNoodles) {
        this.beefNoodles = beefNoodles;
    }

    public void setCasserole(WaiMai casserole) {
        this.casserole = casserole;
    }

    public void orderChicken(){
        System.out.println("用户开始通过app下单黄焖鸡");
        braisedChicken.order();
    }
    public void orderNoodles(){
        System.out.println("用户开始通过app下单牛肉面");
        beefNoodles.order();
    }
    public void orderCasserole(){
        System.out.println("用户开始通过app下单砂锅");
        casserole.order();
    }
}
