package createdmodel.singletonmode;

/**
 * 描述:
 * 懒汉式
 * 类加载时没有生成单例，只有当第一次调用 getlnstance 方法时才去创建这个单例
 *
 * 线程不安全
 * 保证线程安全：volatile、synchronized,但是每次访问都会同步、耗性能
 *
 * @author lars
 * @date 2019/6/28 11:41
 */
public class LazySingleton {
    private static  LazySingleton lazySingleton = null;
//    private static volatile LazySingleton lazySingleton = null;
    private LazySingleton(){
        System.out.println("懒汉式-第一次调用getInstance时创建实例,只调用一次");
    }
//    public static synchronized LazySingleton getInstance(){
    public static  synchronized LazySingleton getInstance(){
        if (lazySingleton==null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
