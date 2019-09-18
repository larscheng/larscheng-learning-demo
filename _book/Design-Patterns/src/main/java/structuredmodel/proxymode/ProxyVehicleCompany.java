package structuredmodel.proxymode;

/**
 * 描述: 经销商：代理类(静态代理)
 *
 * @author lars
 * @date 2019/7/1 18:52
 */
public class ProxyVehicleCompany implements VehicleCompany {
    private XVehicleCompany xVehicleCompany;

    public ProxyVehicleCompany(XVehicleCompany xVehicleCompany) {
        this.xVehicleCompany = xVehicleCompany;
    }

    @Override
    public void buyVehicle() {
        beforeBuy();
        xVehicleCompany.buyVehicle();
        afterBuy();
    }

    private void beforeBuy() {
        System.out.println("经销商售前捆绑销售xxxx");
    }

    private void afterBuy() {
        System.out.println("承诺售后服务xxxx");
    }
}
