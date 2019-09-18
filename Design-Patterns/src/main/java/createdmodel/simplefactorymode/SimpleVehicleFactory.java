package createdmodel.simplefactorymode;

/**
 * 描述:
 * 简单工厂模式
 * <p>
 * 模拟场景：在一个汽车公司里，他们有一个车辆制造工厂，可以根据客户不同的需求来生产助力车、电瓶车
 * 作为客户他只知道他想要买的车辆的编号，他不用管怎么生产，他告诉车公司编号，工厂就会为它生产好
 *
 * @author lars
 * @date 2019/6/18 14:05
 */
public class SimpleVehicleFactory {

    /***
     * 根据客户的需求进行造车
     * @param type
     * @return
     */
    public Vehicle VehicleFactory(int type) {
        Vehicle vehicle = null;
        if (type == 1) {
            vehicle = new PowerVehicle();
        }else if (type==2){
            vehicle = new ElectricVehicle();
        }
        //.....客户的其他要求，生产其他的车型

        return vehicle;
    }
}
