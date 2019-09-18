package behavioralmodel.strategymode;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/7/10 11:50
 */
public class StrategyModeTest {


    interface Strategy {
        public void strategyMethod();
    }

    static class ConcreteStrategyA implements Strategy {
        @Override
        public void strategyMethod() {
            System.out.println("具体策略A的策略方法被访问！");
        }
    }

    static class ConcreteStrategyB implements Strategy {
        @Override
        public void strategyMethod() {
            System.out.println("具体策略B的策略方法被访问！");
        }
    }

    static class Context {
        private Strategy strategy;

        public Context(Strategy strategy) {
            this.strategy = strategy;
        }

        public void strategyMethod() {
            strategy.strategyMethod();
        }
    }


    static class Client {
        public Client() {
            Strategy strategyA = new ConcreteStrategyA();
            Context context = new Context(strategyA);
            context.strategyMethod();

            System.out.println("----------------------------");
            Strategy strategyB = new ConcreteStrategyB();
            context = new Context(strategyB);
            context.strategyMethod();
        }
    }


    public static void main(String[] args) {
        new Client();
    }
}
