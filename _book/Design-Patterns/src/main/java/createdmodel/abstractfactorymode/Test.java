package createdmodel.abstractfactorymode;

import createdmodel.simplefactorymode.Vehicle;

/**
 * 描述:汽车公司不仅卖车（电动车，汽油车），同时还卖车的配件（电动车配件，汽油车配件），
 * 但是按照工厂方法模式，一个工厂只能产出一种产品，不太适合，此时可以选择抽象工厂模式
 * @author lars
 * @date 2019/6/18 16:47
 */
public class Test {


    public static void main(String[] args) {
        //客户1想买电动车配件
        AbstractFactory a1 = new ElecFactory();
        Fitting fitting =  a1.buyFitting();
        //客户2想买汽油车一辆
        AbstractFactory a2 = new PetrolFactory();
        Vehicle vehicle =  a2.buyVehicle();

    }

}
