package behavioralmodel.mementomode.demo;

/**
 * 描述:
 * 发起人
 *
 * @author lars
 * @date 2019/7/19 13:35
 */
public class Originator {
    //记录当前状态
    private String state;

    /**
     * 创建备忘录
     * @return
     */
    public Memento createMemonto(){
        return new Memento(state);
    }

    /**
     * 恢复备忘录
     * @param memento
     */
    public void restoreMemento(Memento memento){
        this.setState(memento.getState());
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
