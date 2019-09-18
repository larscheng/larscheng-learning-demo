package behavioralmodel.observermode.demo;

/**
 * 描述:
 * 具体目标角色
 *
 * @author lars
 * @date 2019/7/16 15:48
 */
public class ConcreteSubject extends Subject {
    @Override
    public void notifyObserver() {
        System.out.println("发生变化了，快通知观察者们...");
        observers.forEach(Observer::updateself);
    }
}
