package structuredmodel.decoratormode;

/**
 * 描述:
 * 72变
 *
 * @author lars
 * @date 2019/7/4 10:27
 */
public class Monkey72Test {


    public static void main(String[] args) {
        Monkey monkey = new SunWuKong();
        monkey.display();

        System.out.println("---------------------------");

        Monkey monkey1 = new TaiShangLaoJun(monkey);
        monkey1.display();

        Monkey monkey2 = new YinJiaoDaWang(monkey);
        monkey2.display();
    }


    /**
     * 抽象构件角色：猴子
     */
    interface Monkey {
        public void display();
    }

    /**
     * 具体构件角色：孙悟空
     */
    static class SunWuKong implements Monkey{

        @Override
        public void display() {
            System.out.println("吾乃齐天大圣是也");
        }
    }


    /***
     * 抽象装饰角色：七十二变
     */
    static class Monkey72Change implements Monkey{
        private Monkey monkey;

        public Monkey72Change(Monkey monkey) {
            this.monkey = monkey;
        }

        @Override
        public void display() {
            monkey.display();
        }
    }

    /***
     * 具体装饰角色1
     */
    static class TaiShangLaoJun extends Monkey72Change{
        public TaiShangLaoJun(Monkey monkey) {
            super(monkey);
        }

        @Override
        public void display() {
            System.out.println("我是太上老君（其实是孙悟空变的）");
        }
    }

    /***
     * 具体装饰角色2
     */
    static class YinJiaoDaWang extends Monkey72Change{
        public YinJiaoDaWang(Monkey monkey) {
            super(monkey);
        }

        @Override
        public void display() {
            System.out.println("我叫你一声你敢答应吗？（其实是孙悟空变的）");
        }
    }
}
