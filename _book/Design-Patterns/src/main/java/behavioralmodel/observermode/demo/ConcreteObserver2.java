package behavioralmodel.observermode.demo;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/16 15:52
 */
public class ConcreteObserver2 extends Observer{

    @Override
    void updateself() {
        System.out.println("观察者2号更新完毕");
    }
}
