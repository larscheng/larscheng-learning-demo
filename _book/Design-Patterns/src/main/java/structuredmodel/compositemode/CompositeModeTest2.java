package structuredmodel.compositemode;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * 访问树形集合
 *              c0
 *      leaf1       c1
 *            leaf2   leaf3
 * 安全式组合模式
 *
 * @author lars
 * @date 2019/7/8 14:32
 */
public class CompositeModeTest2 {

    /***
     * 抽象构件角色
     */
    interface Compoent {
//        public void add(Compoent compoent);
//
//        public void remove(Compoent compoent);
//
//        public Compoent getChild(int i);

        public void operation();
    }

    /**
     * 树叶构件角色
     */
    static class Leaf implements Compoent {


        private String name;

        public Leaf(String name) {
            this.name = name;
        }
//
//        @Override
//        public void add(Compoent compoent) {
//
//        }
//
//        @Override
//        public void remove(Compoent compoent) {
//
//        }
//
//        @Override
//        public Compoent getChild(int i) {
//            return null;
//        }

        @Override
        public void operation() {
            System.out.println("树叶 " + name + " 被访问");
        }
    }


    /**
     * 树枝构件角色
     */
    static class Composite implements Compoent{

        private List<Compoent> compoents = new ArrayList<Compoent>();

        public void add(Compoent compoent) {
            compoents.add(compoent);
        }

        public void remove(Compoent compoent) {
            compoents.remove(compoent);
        }

        public Compoent getChild(int i) {
            return compoents.get(i);
        }

        @Override
        public void operation() {
            compoents.forEach(Compoent::operation);
        }
    }

    /**
     * 客户端角色
     */
    static class Client{
        public Client() {

            Composite c0 = new Composite();
            Composite c1 = new Composite();
            Compoent leaf1 = new Leaf("1");
            Compoent leaf2 = new Leaf("2");
            Compoent leaf3 = new Leaf("3");
            c0.add(leaf1);
            c0.add(c1);
            c1.add(leaf2);
            c1.add(leaf3);

            c0.operation();

            c1.operation();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
