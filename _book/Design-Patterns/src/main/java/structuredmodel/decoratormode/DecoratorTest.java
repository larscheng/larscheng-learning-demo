package structuredmodel.decoratormode;

/**
 * 描述:
 * 装饰模式
 *
 * @author lars
 * @date 2019/7/3 17:43
 */
public class DecoratorTest {

    /**
     * 抽象构件角色
     */
    interface Component{
        public void operation();
    }

    /**
     * 具体构件角色
     */
    static class ConcreateComponent implements  Component{

        public ConcreateComponent() {
            System.out.println("创建具体构件角色");
        }

        @Override
        public void operation() {
            System.out.println("具体构件角色方法被调用。。");
        }
    }

    /**
     * 抽象装饰角色
     */
    static class Decorator implements Component{

        private Component component;

        public Decorator(Component component) {
            this.component = component;
        }

        @Override
        public void operation() {
            component.operation();
        }
    }

    /**
     * 具体装饰角色
     */
    static class ConcreateDecorator extends Decorator{

        public ConcreateDecorator(Component component) {
            super(component);
        }

        @Override
        public void operation(){
            super.operation();
            //add something
            System.out.println("执行额外职责添加");
        }
    }


    public static void main(String[] args) {
        Component component = new ConcreateComponent();
        component.operation();
        System.out.println("-----------------");
        Component component1 = new ConcreateDecorator(component);
        component1.operation();

    }
}
