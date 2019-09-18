package behavioralmodel.interpretermode.example;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/19 16:15
 */
public class Client {
    public static void main(String[] args) {
        Context bus = new Context();
        bus.freeRide("A地区的儿童");
        bus.freeRide("B地区的老人");
        bus.freeRide("A地区的精壮汉子");
        bus.freeRide("B地区的妇女");
    }
}
