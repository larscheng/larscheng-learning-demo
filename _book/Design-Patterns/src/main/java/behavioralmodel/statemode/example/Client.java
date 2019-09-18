package behavioralmodel.statemode.example;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/16 14:53
 */
public class Client {
    public static void main(String[] args) {
        PersonContext personContext = new PersonContext();

        personContext.eatThings();

        personContext.lostMoney();

        personContext.pickMoney();
    }
}
