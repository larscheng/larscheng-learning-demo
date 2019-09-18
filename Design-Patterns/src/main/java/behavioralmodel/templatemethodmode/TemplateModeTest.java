package behavioralmodel.templatemethodmode;

/**
 * 描述:模板方法模式
 *
 * @author lars
 * @date 2019/7/10 10:16
 */
public class TemplateModeTest {

    /***
     * 抽象类
     */
    abstract class AbstractClass{
        /***
         * 模板方法
         */
        public void templateMethod(){
            specificMethod();
            abstractMethodA();
            abstractMethodB();
        }

        /**
         * 具体方法
         */
        public void specificMethod() {
            System.out.println("抽象类中的具体方法被调用...");
        }

        /**
         * 抽象方法1
         */
        protected abstract void abstractMethodB();

        /**
         * 抽象方法2
         */
        protected abstract void abstractMethodA();

    }


    class ConcreteClass extends AbstractClass{
        @Override
        public void abstractMethodB() {
            System.out.println("抽象方法1的实现被调用..");
        }

        @Override
        public void abstractMethodA() {
            System.out.println("抽象方法2的实现被调用..");
        }
    }


    public static void main(String[] args) {
//        AbstractClass abstractClass = new ConcreteClass();
//        abstractClass.templateMethod();
    }
}

