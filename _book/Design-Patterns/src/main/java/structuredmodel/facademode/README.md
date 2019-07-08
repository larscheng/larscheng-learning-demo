### 外观模式

通过为多个复杂的子系统提供一个一致的接口，而使这些子系统更加容易被访问的模式

对外有一个统一的接口，外部应用无需关心内部实现细节，降低程序复杂度，提高可用性


### 优缺点

优点：

降低耦合度、客户无需了解内部实现细节，降低大型软件系统中编译的依赖性，

缺点：

不能很好的限制客户使用子系统类

增加新的子系统可能要修改外观类代码


### 角色

- 外观角色：为多个子系统对外提供一个共同的接口
- 子系统角色：实现系统 的部分共功能，客户可以通过外观角色访问他
- 客户角色：通过外观角色访问各个子系统的功能


![](http://c.biancheng.net/uploads/allimg/181115/3-1Q115152143509.gif)

```java

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

```

### 模拟场景

