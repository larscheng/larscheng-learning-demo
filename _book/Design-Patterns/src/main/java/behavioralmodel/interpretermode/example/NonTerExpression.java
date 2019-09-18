package behavioralmodel.interpretermode.example;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/19 16:06
 */
public class NonTerExpression implements Expression {

    /***
     * 可免费乘车的city终结符表达式
     */
    private Expression city = null;
    /***
     * 可免费乘车的person终结符表达式
     */
    private Expression person = null;

    public NonTerExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    @Override
    public boolean interpret(String info) {
        String[] data = info.split("的");
        //同时满足时才可免费乘车
        return city.interpret(data[0])&&person.interpret(data[1]);
    }
}
