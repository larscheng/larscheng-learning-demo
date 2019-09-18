package createdmodel.abstractfactorymode;

import createdmodel.simplefactorymode.Vehicle;

/**
 * 描述:
 * 抽象工厂方法
 *
 * @author lars
 * @date 2019/6/26 10:47
 */
public interface AbstractFactory {
    public Vehicle buyVehicle();

    public Fitting buyFitting();
}
