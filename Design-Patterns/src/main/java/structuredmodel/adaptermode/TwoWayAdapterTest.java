package structuredmodel.adaptermode;

/**
 * 描述: 双向适配器
 *
 * @author lars
 * @date 2019/7/3 11:43
 */
public class TwoWayAdapterTest {
    interface TwoWayTarget{
        public void request();
    }

    static class TargetRealize implements TwoWayTarget{

        @Override
        public void request() {
            System.out.println("目标业务实现被调用。。。");
        }
    }

    interface TwoWayAdapters{
        public void myRequest();
    }

    static class AdapterRealize implements TwoWayAdapters{

        @Override
        public void myRequest() {
            System.out.println("适配者接口业务实现被调用。。。");
        }
    }

    static class TwoWayAdapter implements TwoWayTarget,TwoWayAdapters{

        private TwoWayAdapters adapters;
        private TwoWayTarget target;

        public TwoWayAdapter() {
            this.adapters = new AdapterRealize();
            this.target = new TargetRealize();
        }

        @Override
        public void request() {
            adapters.myRequest();
        }

        @Override
        public void myRequest() {
            target.request();
        }
    }

    public static void main(String[] args) {
        System.out.println("目标通过双向适配器访问适配者：");
        TwoWayAdapter adapter=new TwoWayAdapter();
        adapter.request();
        System.out.println("-------------------");
        System.out.println("适配者通过双向适配器访问目标：");
        adapter.myRequest();
    }
}
