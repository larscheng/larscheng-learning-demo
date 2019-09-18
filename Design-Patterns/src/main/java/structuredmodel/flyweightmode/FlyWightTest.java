package structuredmodel.flyweightmode;

import java.util.HashMap;

/**
 * 描述: 享元模式
 *
 * @author lars
 * @date 2019/7/5 15:40
 */
public class FlyWightTest {

    /**
     * 非享元角色：包含非共享的外部状态信息info，
     */
    static class UnsharedConcreteFlyweight{
        private String info;

        public UnsharedConcreteFlyweight(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    /**
     * 抽象享元角色，非享元的外部状态一参数的形式通过该方法传入
     */
    interface FlyWeight{
        public void operation(UnsharedConcreteFlyweight state);
    }

    /**
     * 具体享元角色，包含关键字key，
     */
    static class ConcreteFlyweight implements FlyWeight{

        private String key;

        public ConcreteFlyweight(String key) {
            this.key = key;
            System.out.println("具体享元"+key+"被创建！");
        }

        @Override
        public void operation(UnsharedConcreteFlyweight state) {
            System.out.print("具体享元"+key+"被创建！");
            System.out.println("非享元信息是："+state.getInfo());
        }


    }
    /**
     * 享元工厂角色，使用关键字key管理具体享元角色，有则返回，无则创建
     */
    static class FlyweightFactory{
        private HashMap<String,FlyWeight> flyWeightHashMap = new HashMap<String, FlyWeight>();

        public FlyWeight getFlyWeight(String key){
            FlyWeight flyWeight = (FlyWeight)flyWeightHashMap.get(key);
            if (flyWeight!=null){
                System.out.println("具体享元"+key+"已存在，被成功获取");
            }else {
                flyWeight = new ConcreteFlyweight(key);
                flyWeightHashMap.put(key,flyWeight);
            }
            return flyWeight;
        }
    }

    /**
     * 客户角色：通过享元工厂获取具体享元，并访问具体享元的相关方法
     * @param args
     */
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        FlyWeight flyWeight1 = factory.getFlyWeight("a");
        FlyWeight flyWeight2 = factory.getFlyWeight("b");
        FlyWeight flyWeight3 = factory.getFlyWeight("c");
        FlyWeight flyWeight4 = factory.getFlyWeight("a");
        FlyWeight flyWeight5 = factory.getFlyWeight("b");

        System.out.println("----------------------------------------------");

        flyWeight1.operation(new UnsharedConcreteFlyweight("1-a"));
        flyWeight2.operation(new UnsharedConcreteFlyweight("1-b"));
        flyWeight3.operation(new UnsharedConcreteFlyweight("1-c"));
        flyWeight4.operation(new UnsharedConcreteFlyweight("2-a"));
        flyWeight5.operation(new UnsharedConcreteFlyweight("2-b"));
    }
}
