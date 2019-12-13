package createdmodel.abstractfactorymode;

import createdmodel.simplefactorymode.Vehicle;

/**
 * 描述:
 * 汽油车
 *
 * @author lars
 * @date 2019/6/18 15:00
 */
public class PetrolVehicle implements Vehicle {
    public PetrolVehicle() {
        info();
    }

    @Override
    public void info() {
        System.out.println("感谢您购买xx牌汽油车!!!");
    }

}
