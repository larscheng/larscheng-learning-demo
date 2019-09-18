package behavioralmodel.mediatormode.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 具体中介者
 *
 * @author lars
 * @date 2019/7/16 17:48
 */
public class ConcreteMediator extends Mediator {
    private List<Colleague> colleagues = new ArrayList<>();

    @Override
    public void register(Colleague colleague) {
        if (!colleagues.contains(colleague)){
            colleagues.add(colleague);
            colleague.setMediator(this);
        }
    }

    @Override
    public void relay(Colleague colleague) {
        colleagues.forEach(c->{
            if (!c.equals(colleague)){
                c.receive();
            }
        });
    }
}
