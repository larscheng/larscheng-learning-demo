package createdmodel.singletonmode;

/**
 * 描述:
 * 饿汉式
 * 类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了
 * 创建好一个静态的对象供系统使用，以后不再改变，所以是线程安全的，可以直接用于多线程而不会出现问题
 * 无形中占用很多内存，没有延迟加载
 * @author lars
 * @date 2019/6/28 11:48
 */
public class HungrySingleton {
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
        System.out.println("饿汉式-类加载时调用，只调用一次");
    }
    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }
}
