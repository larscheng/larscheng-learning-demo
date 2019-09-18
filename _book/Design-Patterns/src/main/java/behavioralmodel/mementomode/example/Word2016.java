package behavioralmodel.mementomode.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 描述:
 * 管理者
 *
 * @author lars
 * @date 2019/7/19 14:12
 */
public class Word2016 {
    private List<WordMemento> list = new ArrayList<>();
    private int index = 0;

    public boolean add(WordMemento memento) {
        if (index!=0){
            list=list.subList(0,index-1);
        }
        index = 0;
        return list.add(memento);

    }

    public WordMemento get() {
        int top = list.size()-2;

        if (index>top){
            System.out.println("暂无可恢复的记录");
        }
        WordMemento wordMemento = list.get(top-index);

        index++;

        return wordMemento;
    }


}
