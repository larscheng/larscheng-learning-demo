package behavioralmodel.visitormode.example;

/**
 * 描述:
 * 抽象元素
 *
 * @author lars
 * @date 2019/7/18 14:21
 */
public interface Tool {
    void accept(Person person);
}
