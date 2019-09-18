package behavioralmodel.mementomode.demo;

/**
 * 描述:
 * 管理者
 *
 * @author lars
 * @date 2019/7/19 13:39
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
