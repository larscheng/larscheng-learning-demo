package behavioralmodel.visitormode.example;

/**
 * 描述:
 * 具体访问者
 *
 * @author lars
 * @date 2019/7/18 14:20
 */
public class Lisi implements Person {
    @Override
    public void visit(Computer computer) {
        System.out.println(getClass().getSimpleName()+computer.useTool()+"写代码");
    }

    @Override
    public void visit(Phone phone) {
        System.out.println(getClass().getSimpleName()+phone.useTool()+"学英语");
    }
}
