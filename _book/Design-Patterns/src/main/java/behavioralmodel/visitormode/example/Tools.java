package behavioralmodel.visitormode.example;

import behavioralmodel.visitormode.demo.Element;
import behavioralmodel.visitormode.demo.Visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 描述:
 * 对象结构角色：工具集
 *
 * @author lars
 * @date 2019/7/18 14:31
 */
public class Tools {
    private List<Tool> list = new ArrayList<>();
    public void accept(Person person){
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            ((Tool)iterator.next()).accept(person);
        }
    }

    public void add(Tool tool){
        list.add(tool);
    }
    public void remove(Tool tool){
        list.remove(tool);
    }
}
