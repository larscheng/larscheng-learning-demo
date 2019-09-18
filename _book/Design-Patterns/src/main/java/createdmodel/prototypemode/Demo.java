package createdmodel.prototypemode;

/**
 * 描述:
 *
 *
 * @author lars
 * @date 2019/6/26 16:03
 */
public class Demo implements Cloneable {
    public Demo() {
        System.out.println("具体原型创建成功！");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return super.clone();
    }

}
