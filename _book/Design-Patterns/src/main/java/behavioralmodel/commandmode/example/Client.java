package behavioralmodel.commandmode.example;

/**
 * 描述:
 * 用户点餐
 * @author lars
 * @date 2019/7/11 11:29
 */
public class Client {
    public static void main(String[] args) {
        App app = new App();
        //加载菜单
        app.setBraisedChicken(new BraisedChicken());
        app.setBraisedChicken(new BeefNoodles());


        //点一个黄焖鸡
        app.orderChicken();

        //新加一个菜品：砂锅
        app.setCasserole(new Casserole());
        //点一个砂锅
        app.orderCasserole();


    }
}
