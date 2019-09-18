package behavioralmodel.observermode.demo;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/16 15:55
 */
public class Client {
    public static void main(String[] args) {
        Subject subject  = new ConcreteSubject();

        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();

        subject.add(observer1);
        subject.add(observer2);

        subject.notifyObserver();

    }
}
