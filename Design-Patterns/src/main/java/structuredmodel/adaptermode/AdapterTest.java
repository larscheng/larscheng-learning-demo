package structuredmodel.adaptermode;

/**
 * 描述: 类适配器
 *
 * @author lars
 * @date 2019/7/3 10:41
 */
public class AdapterTest {
    /**
     * 目标接口
     */
    interface Target {
        public void request();
    }

    /**
     * 适配者接口
     */
    static class Adapter {
        public void Job() {
            //调用执行实际的业务
            System.out.println("不兼容的业务功能在适配后被调用");
        }
    }

    /**
     * 类适配器
     */
    static class ClassAdapter extends Adapter implements Target {

        @Override
        public void request() {
            System.out.println("适配器开始工作，进行兼容性适配....");
            super.Job();
        }
    }

    /***
     * 对象适配器
     */
    static class ObjectAdapter implements Target{

        private Adapter adapter;
        public ObjectAdapter(Adapter adapter){
            this.adapter = adapter;
        }

        @Override
        public void request(){
            System.out.println("适配器开始工作，进行兼容性适配....");
            adapter.Job();
        }
    }

    public static void main(String[] args) {
        //类适配器
        Target t = new ClassAdapter();
        t.request();

        Target target = new ObjectAdapter(new Adapter());
        target.request();
    }
}
