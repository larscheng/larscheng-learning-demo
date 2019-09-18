package behavioralmodel.templatemethodmode;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/10 10:56
 */
public abstract class SpringBackHome {

    public void templateMethod(){
        buyTickets();
        arrivideStation();
        checkTickets();
        setOff();
        arrivideHome();
    }


    /**
     * 买票：火车票、高铁票、机票
     */
    protected abstract void buyTickets();

    /**
     * 到达车站：火车站、高铁站、机场
     */
    protected abstract void arrivideStation();


    /***
     * 检票流程一致
     */
    private void checkTickets() {
        System.out.println("检票通过");
    }

    /**
     * 出发回家：火车出发、高铁出发、飞机起飞
     */
    protected abstract void setOff();

    /**
     * 到达
     */
    private void arrivideHome() {
        System.out.println("到家了");
    }
}
