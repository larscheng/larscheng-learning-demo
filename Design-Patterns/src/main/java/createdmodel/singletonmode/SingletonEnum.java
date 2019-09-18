package createdmodel.singletonmode;

/**
 * 描述:
 *
 * @author lars
 * @date 2019/6/28 16:47
 */
public enum  SingletonEnum {
    /**
     *
     */
    INSTANCE;

    private Person person;
    SingletonEnum() {
        System.out.println("构造方法被调用");
        person = new Person();
    }

    public Person getInstance(){
        return person;
    }

    class Person{}
}
