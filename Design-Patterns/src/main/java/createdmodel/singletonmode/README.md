### 单例模式

为了节省系统资源、保证数据的一致性、或者一些其他的需求、某些类在系统中只能存在一个实例，实现这一场景的方式就称作单例模式


eg：windows任务管理器、多线程中的线程池、回收站、数据库连接池....


### 特点

单例类只有一个实例对象

单例对象必须由单例类自行创建

单例类对外提供一个访问该实例的全局访问点

### 要素

单例类、访问类


### 实现

- 懒汉式 : 类加载时没有生成单例，只有当第一次调用访问点时采取创建实例

- 饿汉式 : 类一旦加载就创建一个单例，保证在调用 getInstance 方法之前单例已经存在了

![](http://c.biancheng.net/uploads/allimg/181113/3-1Q1131K441K2.gif)



### 线程安全

懒汉式：线程非安全；

饿汉式：线程安全


### 懒汉式-线程安全的措施：

#### 双重判断加锁

```java
public class Singleton{
    private static volatile Singleton singleton = null;
    private Singleton(){}
    public static Singleton getInstance(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton=new Singleton();
                }
            }
            return singleton;
        }
    }
}
```


#### 静态内部类
Singleton 类被装载了，singleton 不一定被初始化。因为 SingletonHolder 类没有被主动使用，
只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 singleton。

```java
public class Singleton{
    private static class SingletonHolder{
        private static Singleton singleton = new Singleton();
    }
    private Singleton(){}
    public static Singleton getInstance(){
        return SingletonHolder.singleton;
    }
} 

```


### 反射机制破解单例模式

```java
public class Singleton {
    private static Singleton singleton= new Singleton();

    private singleton() {
    }

    public static Singleton newInstance() {
        return singleton;
    }
}

```
```java
public class BreakSingleton{
    public static void main(String[] args){
        Class aClass = Class.forName("Singleton");
        Constructor c = aClass.getDeclaredConstructor(null);
        c.setAccessible(true);
        Singleton singleton1 = c.newInstance();
        Singleton singleton2 = c.newInstance(); 
    }
}
```
预防反射

```java
public class Singleton {
    private static Singleton singleton= new Singleton();

    private singleton() {
        //防止通过反射创建对象
        if (singleton!=null){
            throw new RuntimeException();
        }
    }

    public static Singleton newInstance() {
        return singleton;
    }
}

```
### 反序列化机制破解单例模式

```java
public class BreakSingleton{
    public static void main(String[] args){
      Singleton singleton1 = Singleton.getInstance();
      Singleton singleton2 = Singleton.getInstance();
      
      FileOutputStream fos = new FileOutputStream("路径");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oss.writeObject(singleton1);
      oss.close();
      fos.close();
      
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream("路径"));
      Singleton singleton3 = (Singleton)ois.readObject();
      System.out.println("singleton1==singleton3:"+singleton1==singleton3);
    }
}


```

预防措施：

```java

public class Singleton implements Serializable{
    private static Singleton singleton= new Singleton();
    
        private singleton() {
        }
    
        public static Singleton newInstance() {
            return singleton;
        }
        //反序列化定义该方法，则不需要创建新对象
        private Object readResovle() throws ObjectStreamException{
            return singleton;
        }
}
```

### 枚举实现单例
https://blog.csdn.net/yy254117440/article/details/52305175

枚举本身就实现了单例，构造方法私有，并且线程安全，但是不能实现延迟加载

```java
public enum  SingletonEnum {
    /**
     * 单例的推荐用法
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

```