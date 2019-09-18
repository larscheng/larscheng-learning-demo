package behavioralmodel.interpretermode.demo;

import java.util.Objects;

/**
 * @auther: lars
 * @date: 2019/7/19 15:29
 * @description:
 */
public interface AbstractExpression {
    //解释方法
    public Objects interpret(String info);
}
