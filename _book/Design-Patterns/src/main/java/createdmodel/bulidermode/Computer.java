package createdmodel.bulidermode;

/**
 * 描述:
 * 电脑产品
 *
 * @author lars
 * @date 2019/6/26 14:41
 */
public class Computer {
    private String monitor;

    private String processor;

    private String graphics;

    private String ram;

    private String hardDisk;

    private String powerSupply;

    private String Motherboard;

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public void setRam(String Ram) {
        this.ram = Ram;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public void setMotherboard(String motherboard) {
        Motherboard = motherboard;
    }

    public void show(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Computer{" +
                "monitor='" + monitor + '\'' +
                ", processor='" + processor + '\'' +
                ", graphics='" + graphics + '\'' +
                ", ram='" + ram + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", powerSupply='" + powerSupply + '\'' +
                ", Motherboard='" + Motherboard + '\'' +
                '}';
    }
}
