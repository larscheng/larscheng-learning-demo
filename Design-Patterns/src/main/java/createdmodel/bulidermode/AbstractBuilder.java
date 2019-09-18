package createdmodel.bulidermode;

/**
 * 描述:
 * 抽象建造者
 * @author lars
 * @date 2019/6/26 14:47
 */
public  abstract class AbstractBuilder {
    protected Computer computer = new Computer();
    public abstract  void build1();
    public abstract  void build2();
    public abstract  void build3();
    public abstract  void build4();
    public abstract  void build5();
    public abstract  void build6();
    public abstract  void build7();

    public Computer getComputer(){
        return computer;
    }
}
