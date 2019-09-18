package behavioralmodel.visitormode.example;

import behavioralmodel.statemode.example.PersonContext;

/**
 * 描述:
 * 具体访问者1
 *
 * @author lars
 * @date 2019/7/18 14:19
 */
public class Zhangsan implements Person {
    @Override
    public void visit(Computer computer) {
        System.out.println(getClass().getSimpleName()+computer.useTool()+"看电视");
    }

    @Override
    public void visit(Phone phone) {
        System.out.println(getClass().getSimpleName()+phone.useTool()+"听音乐");
    }
}
