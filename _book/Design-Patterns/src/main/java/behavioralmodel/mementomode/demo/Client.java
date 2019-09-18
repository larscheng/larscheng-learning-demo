package behavioralmodel.mementomode.demo;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/19 13:49
 */
public class Client {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();
        //记录当前状态
        originator.setState("V1.0");
        System.out.println("初始状态："+originator.getState());
        //创建备忘录
        Memento memento = originator.createMemonto();
        //管理者保存备忘录
        caretaker.setMemento(memento);
        //当前状态变更
        originator.setState("V2.0");
        System.out.println("新的状态："+originator.getState());
        //恢复状态
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("当前状态："+originator.getState());
    }
}
