package behavioralmodel.visitormode.example;

/**
 * 描述:
 * 抽象访问者
 *
 * @author lars
 * @date 2019/7/18 14:17
 */
public interface Person {
    void visit(Computer computer);
    void visit(Phone phone);
}
