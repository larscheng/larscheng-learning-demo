package createdmodel.bulidermode;

/**
 * 描述:
 * 指挥者-装机店老板
 *
 * @author lars
 * @date 2019/6/26 14:58
 */
public class Boss {

    private AbstractBuilder abstractBuilder;

    public Boss(AbstractBuilder abstractBuilder) {
        this.abstractBuilder = abstractBuilder;
    }

    public Computer build(){
        abstractBuilder.build1();
        abstractBuilder.build2();
        abstractBuilder.build3();
        abstractBuilder.build4();
        abstractBuilder.build5();
        abstractBuilder.build6();
        abstractBuilder.build7();
        return abstractBuilder.getComputer();
    }
}
