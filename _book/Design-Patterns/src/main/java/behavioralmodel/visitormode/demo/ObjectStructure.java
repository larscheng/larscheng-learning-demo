package behavioralmodel.visitormode.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 描述:
 * 对象结构角色
 *
 * @author lars
 * @date 2019/7/18 11:55
 */
public class ObjectStructure {
    private List<Element> list = new ArrayList<>();
    public void accept(Visitor visitor){
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            ((Element)iterator.next()).accept(visitor);
        }
    }

    public void add(Element element){
        list.add(element);
    }
    public void remove(Element element){
        list.remove(element);
    }
}
