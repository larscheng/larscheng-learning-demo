package createdmodel.simplefactorymode;

/**
 * 描述:
 * 电动车
 *
 * @author lars
 * @date 2019/6/18 15:00
 */
public class ElectricVehicle implements Vehicle {

    public ElectricVehicle() {
        info();
    }

    @Override
    public void info() {
        System.out.println("感谢您购买xx牌电动车!!!");
    }

}
