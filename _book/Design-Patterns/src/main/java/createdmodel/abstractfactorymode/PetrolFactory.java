package createdmodel.abstractfactorymode;

import createdmodel.simplefactorymode.PowerVehicle;
import createdmodel.simplefactorymode.Vehicle;

/**
 * 描述:
 * 汽油车厂
 * @author lars
 * @date 2019/6/26 11:36
 */
public class PetrolFactory implements AbstractFactory{
    public Vehicle buyVehicle() {
        return new PowerVehicle();
    }

    public Fitting buyFitting() {
        return new PetrolFitting();
    }
}
