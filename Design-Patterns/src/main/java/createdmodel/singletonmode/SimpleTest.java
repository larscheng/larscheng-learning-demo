package createdmodel.singletonmode;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/6/28 11:53
 */
public class SimpleTest {
    public static void main(String[] args) {
        //懒汉式-第一次调用getInstance时创建实例,只调用一次
        LazySingleton lazySingleton1 = LazySingleton.getInstance();
        LazySingleton lazySingleton2 = LazySingleton.getInstance();
        LazySingleton lazySingleton3 = LazySingleton.getInstance();

        //饿汉式-类加载时调用，只调用一次
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
        HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();
        HungrySingleton hungrySingleton3 = HungrySingleton.getInstance();

        SingletonEnum.Person person1 = SingletonEnum.INSTANCE.getInstance();
        SingletonEnum.Person person2 = SingletonEnum.INSTANCE.getInstance();

        System.out.println("person1==person2:"+(person1==person2));

    }

}
