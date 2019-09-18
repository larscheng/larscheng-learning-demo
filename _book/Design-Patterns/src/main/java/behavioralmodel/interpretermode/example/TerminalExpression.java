package behavioralmodel.interpretermode.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述:
 * 终结符表达式类
 *
 * @author lars
 * @date 2019/7/19 15:58
 */
public class TerminalExpression implements Expression{

    /**
     * 保存满足免费乘车的条件
     */
    private Set<String> set = new HashSet<>();

    public TerminalExpression(String[] data) {
        set.addAll(Arrays.asList(data));
    }

    @Override
    public boolean interpret(String info) {
        return set.contains(info);
    }
}
