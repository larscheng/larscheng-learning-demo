package createdmodel.abstractfactorymode;

/**
 * 描述:
 * 电动车配件
 *
 * @author lars
 * @date 2019/6/26 11:27
 */
public class ElecFitting implements Fitting {
    public ElecFitting() {
        info();
    }

    public void info() {
        System.out.println("感谢购买电动车配件");
    }
}
