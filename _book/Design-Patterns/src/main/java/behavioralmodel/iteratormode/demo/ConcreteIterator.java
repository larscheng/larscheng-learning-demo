package behavioralmodel.iteratormode.demo;

import java.util.List;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/18 09:26
 */
public class ConcreteIterator implements MyIterator {

    private List<Object> list = null;
    private int index = -1;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public Object first() {
        return list.get(0);
    }

    @Override
    public Object next() {

        return this.hasNext()?list.get(++index):null;
    }

    @Override
    public boolean hasNext() {
        return index<list.size()-1;
    }
}
