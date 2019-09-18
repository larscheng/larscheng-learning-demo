package behavioralmodel.visitormode.example;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/18 14:21
 */
public class Phone  implements Tool{
    @Override
    public void accept(Person person) {
        person.visit(this);
    }

    public String useTool(){
        return "使用手机";
    }
}
