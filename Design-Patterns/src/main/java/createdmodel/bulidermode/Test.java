package createdmodel.bulidermode;

/**
 * 描述:
 * 电脑城买组装台式机。
 *
 * 从选机到下单到装机到提货流程繁多步骤复杂，
 *
 * 实际的流程是客户提出机器需求，装机店老板给出配置A和B两个套餐和价位，客户下单，老板根据配置单A/B指挥装机员A/B进行装机，装机员装好机器之后，由装机店老板转交客户
 *
 * 其中电脑为产品、装机店老板为指挥者、装机员为具体建造者。
 * @author lars
 * @date 2019/6/26 15:09
 */
public class Test {
    public static void main(String[] args) {

        //客户A选择A配置
        ComputerInstallerA A = new ComputerInstallerA();
        Boss bossA = new Boss(A);
        Computer computerA = bossA.build();
        computerA.show();


        //客户A选择A配置
        ComputerInstallerB B = new ComputerInstallerB();
        Boss bossB = new Boss(B);
        Computer computerB = bossB.build();
        computerB.show();
    }
}
