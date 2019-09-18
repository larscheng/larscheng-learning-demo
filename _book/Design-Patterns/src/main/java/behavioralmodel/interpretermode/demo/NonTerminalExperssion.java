package behavioralmodel.interpretermode.demo;

import java.util.Objects;

/**
 * 描述: 非终结符表达式类
 *
 * @author lars
 * @date 2019/7/19 15:31
 */
public class NonTerminalExperssion implements AbstractExpression{
    private AbstractExpression abstractExpression1;
    private AbstractExpression abstractExpression2;

    @Override
    public Objects interpret(String info) {
        return null;
    }
}
