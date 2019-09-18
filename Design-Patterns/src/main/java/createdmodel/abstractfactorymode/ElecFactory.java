package createdmodel.abstractfactorymode;

import createdmodel.simplefactorymode.ElectricVehicle;
import createdmodel.simplefactorymode.Vehicle;

/**
 * 描述:
 * 电动车厂
 *
 * @author lars
 * @date 2019/6/26 11:20
 */
public class ElecFactory implements AbstractFactory {
    public Vehicle buyVehicle() {
        return new ElectricVehicle();
    }

    public Fitting buyFitting() {
        return new ElecFitting();
    }
}
