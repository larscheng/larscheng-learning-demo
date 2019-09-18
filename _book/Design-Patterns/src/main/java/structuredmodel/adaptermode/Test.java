package structuredmodel.adaptermode;

/**
 * 描述:现在的app都有多端入口,app端,小程序端
 * 就以xx单车为例，一期只开发了app端,app有一个扫码开锁的接口，二期开发了小程序端，小程序端上同样也需要一个扫码开锁的接口
 *
 * 这时候想起来一期app中有一个功能相同的接口，但是却发现一期的参数格式和目前小程序上的参数格式不太一样，这时候适配器模式就可以用得上了。
 *
 * 而且随着开发往后，再有与一期类似的接口都可以通过适配器来兼容。
 *
 * 比如说现在有两个功能是相类似的，扫码租车，上锁还车
 *
 * @author lars
 * @date 2019/7/3 11:24
 */
public class Test {
    public static void main(String[] args) {
        Vehicle1to2 vehicle = new VehicleAdapter();

        vehicle.rentVehicle();
        vehicle.returnVehicle();
    }
}
