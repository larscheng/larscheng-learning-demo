package createdmodel.simplefactorymode;

/**
 * 描述:
 * 助力车
 *
 * @author lars
 * @date 2019/6/18 14:53
 */
public class PowerVehicle implements Vehicle {

    public PowerVehicle() {
        info();
    }
    @Override
    public void info() {
        System.out.println("感谢您购买xx牌汽油车!!!");
    }

}
