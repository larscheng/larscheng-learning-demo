### 享元模式

运用共享技术来有效的支持大量细粒度对象的复用。

它通过共享已经存在的对象，来大幅度减少需要创建的对象数量、避免大量相似类的开销，从而提高系统资源利用率


在面向对象程序设计中，有时候会面临创建大量相似或相同的对象，这是会耗费大量的系统资源。那么能否将这些相同相似的部分进行共享，避免重复创建相同独享实例


享元模式分为两种状态

- 内部状态：不会随着环境的变化而改变可共享部分
- 外部状态：随环境改变而改变的不可以共享的部分。享元模式的实现要领就是区分两种状态并将外部状态外部化

### 优缺点

优点：

相同对象只保存一寸，减少对象数量，降低系统中细粒度对象给内存带来的压力


缺点：

增加程序复杂性  
程序启动时间变长，因为要读取外部状态


### 角色

- 抽象享元角色：是所有享元类的基类，为具体享元规范需要实现的公共接口，非享元的外部状态以参数的形式通过方法传入
- 具体享元角色：实现抽象享元角色
- 非享元角色：是不可以共享的外部状态，它以参数的形式注入具体享元的相关方法中
- 享元工厂角色：负责创建和管理享元角色。当客户对象请求一个享元对象时，享元工厂检查系统中是否存在符合要求的享元对象，如果存在则提供给客户，如果不存在创建一个新的享元对象



![](http://c.biancheng.net/uploads/allimg/181115/3-1Q115161342242.gif)


### 代码
```java

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
```

### 模拟场景

五子棋与围棋一样，包含多个"黑" 或者 "白" 色的棋子，那么五子棋的棋子即可以用来玩围棋也可以下五子棋用，享元模式就可以用上来描述这个场景

其中
棋子：抽象享元角色，包含落子下棋的方法  
白子、黑子：具体享元角色  
落子点：非享元角色（指定了棋子落下的位置）
享元工厂角色通过集合管理棋子，并提供获取白子、黑子的方法
客户角色就是通过享元工厂获取白子或黑子，并落子


