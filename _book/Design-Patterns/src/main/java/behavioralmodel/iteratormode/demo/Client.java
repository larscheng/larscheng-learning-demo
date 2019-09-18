package behavioralmodel.iteratormode.demo;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/18 09:34
 */
public class Client {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("1");
        aggregate.add("2");
        aggregate.add("3");
        aggregate.add("4");

        System.out.println("遍历集合内容：");
        MyIterator iterator = aggregate.getIterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"\t");
        }
    }
}
