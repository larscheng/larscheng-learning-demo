package createdmodel.bulidermode;

/**
 * 描述:
 * 具体建造者装机员B
 *
 * @author lars
 * @date 2019/6/26 14:51
 */
public class ComputerInstallerB extends AbstractBuilder{

    @Override
    public void build1() {
        computer.setMonitor("24寸曲面屏显示器");
    }

    @Override
    public void build2() {
        computer.setProcessor("intel-i7-8700k");
    }

    @Override
    public void build3() {
        computer.setGraphics("英伟达RTX2070");
    }

    @Override
    public void build4() {
        computer.setRam("16GB*2");
    }

    @Override
    public void build5() {
        computer.setHardDisk("SSD-1T");
    }

    @Override
    public void build6() {
        computer.setPowerSupply("600W金牌电源");
    }

    @Override
    public void build7() {
        computer.setMotherboard("Z370主板");
    }
}
