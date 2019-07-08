### 适配器模式

将一个类的接口转换为调用方希望的另一个接口，是的原本不兼容的接口变得可兼容共同工作

适配器模式分为两种：
- 类结构型模式 ：类之间耦合度较高，使用要求相对较薄，使用较少
- 对象结构型模式 ：普遍使用

eg：

typeC的充电线不能给普通安卓机充电，因为接口不兼容，此时需要一个转接头适配器，type转安卓，即可实现安卓手机充电

用直流电的电子设备在使用中都修要一个电源适配器将插座上的交流电转变为直流电

需要开发的具有某种业务功能的组件在现有的组件库中已经存在，但它们与当前系统的接口规范不兼容，
如果重新开发这些组件成本又很高，这时用适配器模式能很好地解决这些问题


### 优缺点

优点：

- 客户端通过适配器可以无障碍调用目标接口
- 复用现存的类，提高效率
- 目标类与适配者解耦

缺点：更换适配器过程复杂


### 角色

- 目标接口：当前系统业务所期待的接口，抽象类或者接口
- 适配者类：要被适配的类，原本不兼容的类
- 适配器类：一个转换器，通过继承或引用适配者对象，把适配者接口转换成目标接口，使得客户按照目标接口的格式访问适配者


![类适配器模式的结构图](http://c.biancheng.net/uploads/allimg/181115/3-1Q1151045351c.gif)

![对象适配器模式的结构图](http://c.biancheng.net/uploads/allimg/181115/3-1Q1151046105A.gif)


类适配器模式：
```java
/**
* 目标接口
*/
interface Target{
    public void request();
}

/**
* 适配者接口
*/
class Adapter{
    public void Job(){
        //调用执行实际的业务
        System.out.println("不兼容的业务功能在适配后被调用");
    }
}

class ClassAdapter extends Adapter implements Target{

    @Override
    public void request(){
        System.out.println("【类】适配器开始工作，进行兼容性适配....");
        super.Job();
    }
}



```
    【类】适配器开始工作，进行兼容性适配....
    不兼容的业务功能在适配后被调用



对象适配器


```java
/**
* 目标接口
*/
interface Target{
    public void request();
}

/**
* 适配者接口
*/
class Adapter{
    public void Job(){
        //调用执行实际的业务
        System.out.println("不兼容的业务功能在适配后被调用");
    }
}
/***
* 对象适配器
*/
class ObjectAdapter implements Target{

    private Adapter adapter;
    public ObjectAdapter(Adapter adapter){
        this.adapter = adapter;
    }
    
    @Override
    public void request(){
        System.out.println("【对象】适配器开始工作，进行兼容性适配....");
        adapter.Job();
    }
}
```
    【对象】适配器开始工作，进行兼容性适配....
    不兼容的业务功能在适配后被调用


### 模拟场景

现在的app都有多端入口,app端,小程序端
就以xx单车为例，一期只开发了app端,app有一个扫码开锁的接口，二期开发了小程序端，小程序端上同样也需要一个扫码开锁的接口

这时候想起来一期app中有一个功能相同的接口，但是却发现一期的参数格式和目前小程序上的参数格式不太一样，这时候适配器模式就可以用得上了。

而且随着开发往后，再有与一期类似的接口都可以通过适配器来兼容。

比如说现在有两个功能是相类似的，扫码租车，上锁还车

### 扩展---双向适配器

适配者即可以把适配者接口转换成目标接口，也可以把目标接口转换成适配者接口

![](http://c.biancheng.net/uploads/allimg/181115/3-1Q115104Q1604.gif)
