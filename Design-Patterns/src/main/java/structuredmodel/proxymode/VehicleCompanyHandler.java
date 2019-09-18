package structuredmodel.proxymode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 描述:
 * 动态代理处理器
 *
 * @author lars
 * @date 2019/7/2 09:15
 */
public class VehicleCompanyHandler implements InvocationHandler {
    private XVehicleCompany xVehicleCompany;

    public VehicleCompanyHandler(XVehicleCompany xVehicleCompany) {
        this.xVehicleCompany = xVehicleCompany;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        beforeBuy();
        object = method.invoke(xVehicleCompany,args);
        afterBuy();
        return object;
    }


    private void beforeBuy() {
        System.out.println("经销商售前捆绑销售xxxx");
    }

    private void afterBuy() {
        System.out.println("承诺售后服务xxxx");
    }
}
