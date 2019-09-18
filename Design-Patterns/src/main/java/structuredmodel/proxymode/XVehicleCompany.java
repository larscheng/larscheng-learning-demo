package structuredmodel.proxymode;

/**
 * 描述:
 * X牌汽车公司：具体类
 *
 * @author lars
 * @date 2019/7/1 18:51
 */
public class XVehicleCompany implements VehicleCompany {
    @Override
    public void buyVehicle() {
        System.out.println("感谢你的购买");
    }
}
