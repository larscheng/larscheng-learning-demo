package behavioralmodel.statemode.example;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/16 14:42
 */
public class Excited extends PersonMood {


    @Override
    public void mood() {
        System.out.println("此刻的心情：激动");
    }
}
