package structuredmodel.facademode;

/**
 * 描述:外观模式demo
 *
 * @author lars
 * @date 2019/7/4 13:50
 */
public class FacadeModeTest {

    public static void main(String[] args) {
        //客户角色内容

        Facade facade = new Facade();
        facade.method();
    }

    /**
     * 外观角色
     */
    static class Facade{
        private SubSystem1  subSystem1 = new SubSystem1();
        private SubSystem2  subSystem2 = new SubSystem2();
        private SubSystem3  subSystem3 = new SubSystem3();
        public void method(){
            subSystem1.method1();
            subSystem2.method2();
            subSystem3.method3();
        }
    }

    /**
     * 子系统角色
     */
    static class SubSystem1{
        public void method1(){
            System.out.println("子系统1方法被调用");
        }
    }
    static class SubSystem2{
        public void method2(){
            System.out.println("子系统2方法被调用");
        }
    }
    static class SubSystem3{
        public void method3(){
            System.out.println("子系统3方法被调用");
        }
    }
}
