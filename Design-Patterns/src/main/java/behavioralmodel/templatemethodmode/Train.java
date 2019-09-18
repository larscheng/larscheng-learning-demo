package behavioralmodel.templatemethodmode;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/10 10:55
 */
public class Train  extends SpringBackHome {
    @Override
    protected void buyTickets() {
        System.out.println("买火车票");
    }

    @Override
    protected void arrivideStation() {
        System.out.println("到达火车站");
    }

    @Override
    protected void setOff() {
        System.out.println("上火车、列车出发");
    }
}
