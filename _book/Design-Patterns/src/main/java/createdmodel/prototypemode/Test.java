package createdmodel.prototypemode;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/6/26 16:05
 */
public class Test {


    public static void main(String[] args) throws CloneNotSupportedException {
        Demo demo = new Demo();
        Demo demo1 = (Demo) demo.clone();
        System.out.println("demo==demo1:"+(demo==demo1));
    }
}
