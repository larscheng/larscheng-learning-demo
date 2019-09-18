package behavioralmodel.observermode.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/16 16:25
 */
public  abstract class Live {
    public List<Fans> fans = new ArrayList<>();

    public void add(Fans... fan){
        for (Fans f:fan){
            System.out.println(f.getClass().getSimpleName()+"关注成功");
            fans.add(f);
        }
    }


    public void remove(Fans... fan){
        for (Fans f:fan){
            System.out.println(f.getClass().getSimpleName()+"取关成功");
            fans.remove(f);
        }
    }

    public abstract void  openLive();
}
