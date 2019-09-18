package createdmodel.factorymethodmode;

import createdmodel.simplefactorymode.Vehicle;

/**
 * 描述:
 * 模拟场景：汽车公司之前的车推出了新款，但是旧款也依旧在售
 * 如果继续用简单工厂模式，则需要至少两个工厂，并且需要修改工厂逻辑，如果后期要再加新款式，就得继续修改逻辑
 * 此时可以用另一种方案：工厂方法模式
 * 汽车公司下属两个子公司，一个生产旧款车，一个生产新款车。总店只接收客户订单,当有客户来订车，告知他想要的款式和车型号码后，下属的子公司开始生产。
 *
 * @author lars
 * @date 2019/6/18 16:47
 */
public class Test {


    public static void main(String[] args) {
        //客户1想买新款1号车型
        VehicleCenterCompany vehicleCenterCompany = new NewVehicelFactory();
        Vehicle vehicle =  vehicleCenterCompany.buyVehicle(1);
        //客户2想买老款2号车型
        VehicleCenterCompany vehicleCenterCompany2 = new OldVehicelFactory();
        Vehicle vehicle2 =  vehicleCenterCompany.buyVehicle(2);

    }
}
