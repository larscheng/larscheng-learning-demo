package structuredmodel.adaptermode;

/**
 * 描述: 2期租车功能适配器
 *
 * @author lars
 * @date 2019/7/3 11:20
 */
public class VehicleAdapter implements Vehicle1to2{
    private RentBusiness rentBusiness;
    private ReturnBusiness returnBusiness;

    public VehicleAdapter() {
        this.rentBusiness = new RentBusiness();
        this.returnBusiness = new ReturnBusiness();
    }

    @Override
    public void rentVehicle() {
        System.out.println("对象适配器适配完成");
        rentBusiness.rentVeh();
    }

    @Override
    public void returnVehicle() {
        System.out.println("对象适配器适配完成");
        returnBusiness.returnVeh();
    }
}
