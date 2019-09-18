package createdmodel.simplefactorymode;

/**
 * 描述:
 * 汽车公司
 *
 * @author lars
 * @date 2019/6/18 14:47
 */
public class VehicleCompany {



    /**
     * 对外提供买车服务
     * @param type
     * @return
     */
    public Vehicle buyVehicle(int type){
        SimpleVehicleFactory simpleVehicleFactory = new SimpleVehicleFactory();
        //根据客户需求，车厂造车
        Vehicle vehicle = simpleVehicleFactory.VehicleFactory(type);
        vehicle.info();
        return vehicle;
    }


    public static void main(String[] args) {
        new VehicleCompany().buyVehicle(1);
    }
}
