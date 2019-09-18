package createdmodel.abstractfactorymode;

/**
 * 描述:
 * 汽油车配件
 *
 * @author lars
 * @date 2019/6/26 11:27
 */
public class PetrolFitting implements Fitting {
    public PetrolFitting() {
        info();
    }

    public void info() {
        System.out.println("感谢购买汽油车配件");
    }
}
