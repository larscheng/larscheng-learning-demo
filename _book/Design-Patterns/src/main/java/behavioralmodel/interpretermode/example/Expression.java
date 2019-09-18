package behavioralmodel.interpretermode.example;

/**
 * 描述:
 * 抽象表达式
 *
 * @author lars
 * @date 2019/7/19 15:57
 */
public interface Expression {
    public boolean interpret(String info);
}
