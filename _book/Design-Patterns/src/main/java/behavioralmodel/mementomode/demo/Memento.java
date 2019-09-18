package behavioralmodel.mementomode.demo;

/**
 * 描述:
 * 备忘录
 *
 * @author lars
 * @date 2019/7/19 13:34
 */
public class Memento {
    //存储状态
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
