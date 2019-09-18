package structuredmodel.bridgemode;

/**
 * 描述:
 * 桥接模式
 *
 * @author lars
 * @date 2019/7/3 15:05
 */
public class BridgeTest {
    /***
     * 实现化角色
     */
    interface Implementor{
        public void OperationImpl();
    }

    /**
     * 具体实现化角色
     */
    static class ConcreateImplementorA implements Implementor{

        @Override
        public void OperationImpl() {
            System.out.println("具体实现化角色被访问。。。。。。。。。");
        }
    }

    /***
     * 抽象化角色
     */
    static abstract class Abstraction{
        protected Implementor implementor;

        protected Abstraction(Implementor implementor) {
            this.implementor = implementor;
        }

        public abstract void Operation();
    }

    /***
     * 扩展抽象化角色
     */
    static class RefinedAbstraction extends Abstraction{

        protected RefinedAbstraction(Implementor implementor) {
            super(implementor);
        }

        @Override
        public void Operation() {
            System.out.println("扩展抽象化角色被访问....");
            implementor.OperationImpl();
        }
    }

    public static void main(String[] args) {
        Implementor implementor = new ConcreateImplementorA();
        Abstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.Operation();
    }
}
