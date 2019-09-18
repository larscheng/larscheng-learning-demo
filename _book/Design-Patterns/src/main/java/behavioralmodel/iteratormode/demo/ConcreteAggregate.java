package behavioralmodel.iteratormode.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 具体聚合角色
 *
 * @author lars
 * @date 2019/7/18 09:24
 */
public class ConcreteAggregate implements Aggregate {
    private List<Object> list = new ArrayList<>();

    @Override
    public void add(Object o) {
        list.add(o);
    }

    @Override
    public void remove(Object o) {
        list.remove(o);
    }

    @Override
    public MyIterator getIterator() {
        return new ConcreteIterator(list);
    }
}
