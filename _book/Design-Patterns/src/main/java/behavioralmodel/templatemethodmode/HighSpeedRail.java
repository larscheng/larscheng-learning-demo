package behavioralmodel.templatemethodmode;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/10 10:57
 */
public class HighSpeedRail extends SpringBackHome {
    @Override
    protected void buyTickets() {
        System.out.println("买高铁票");
    }

    @Override
    protected void arrivideStation() {
        System.out.println("到达高铁站");
    }

    @Override
    protected void setOff() {
        System.out.println("上高铁、列车出发");
    }
}
