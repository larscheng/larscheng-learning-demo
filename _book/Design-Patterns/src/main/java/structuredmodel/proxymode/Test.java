package structuredmodel.proxymode;

import java.lang.reflect.Proxy;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/1 18:53
 */
public class Test {
    public static void main(String[] args) {
//        ProxyVehicleCompany proxyVehicleCompany = new ProxyVehicleCompany(new XVehicleCompany());
//
//        proxyVehicleCompany.buyVehicle();


        VehicleCompanyHandler vehicleCompanyHandler = new VehicleCompanyHandler(new XVehicleCompany());

        VehicleCompany company = (VehicleCompany)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{VehicleCompany.class},vehicleCompanyHandler);

        company.buyVehicle();
    }
}
