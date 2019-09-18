package behavioralmodel.iteratormode.demo;

/**
 * @auther: lars
 * @date: 2019/7/18 09:22
 * @description:
 */
public interface Aggregate {

    public void add(Object o);
    public void remove(Object o);
    public MyIterator getIterator();

}
