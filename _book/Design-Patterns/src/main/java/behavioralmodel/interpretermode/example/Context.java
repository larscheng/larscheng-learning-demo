package behavioralmodel.interpretermode.example;

/**
 * 描述:
 * 环境类
 *
 * @author lars
 * @date 2019/7/19 16:08
 */
public class Context {
    private String[] citys = {"A地区", "B地区"};
    private String[] persons = {"老人", "妇女", "儿童"};
    private Expression expression;

    public Context() {
        Expression city = new TerminalExpression(citys);
        Expression person = new TerminalExpression(persons);
        expression = new NonTerExpression(city, person);
    }

    public void freeRide(String info) {
        if (expression.interpret(info)) {
            System.out.println("您是" + info + "，您本次乘车免费！");
        } else {
            System.out.println(info + "，您不是免费人员，本次乘车扣费1元！");
        }
    }
}
