package createdmodel.factorymethodmode;

import createdmodel.simplefactorymode.ElectricVehicle;
import createdmodel.simplefactorymode.PowerVehicle;
import createdmodel.simplefactorymode.Vehicle;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/6/18 16:46
 */
public class NewVehicelFactory implements VehicleCenterCompany {
    @Override
    public Vehicle buyVehicle(int type) {
        Vehicle vehicle = null;
        if (type == 1) {
            vehicle = new PowerVehicle();
        }else if (type==2){
            vehicle = new ElectricVehicle();
        }
        vehicle.info();
        return vehicle;
    }
}
