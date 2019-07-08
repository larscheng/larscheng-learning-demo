### 代理模式

由于某些原因需要给某对象提供一个`代理`以控制该对象的访问，此时，访问对象不合适或者无法直接引用目标对象，代理对象作为`访问对象`和`目标对象`之间的中介


eg：找房子，通过中介公司找到合适的房子、买海外化妆品，通过海外代购买到手，其中中介、代购就是代理对象这一角色

### 优点

- 代理模式是在客户端与目标对象之间起到一个中介作用，保护目标对象
- 代理对象可以扩展目标对象的功能
- 代理模式能将客户端与目标对象分离，一定程度上降低了系统的耦合度

### 缺点

- 请求速度变慢
- 增加系统的复杂度

### 角色

抽象主题、真实主题、代理类

![](http://c.biancheng.net/uploads/allimg/181115/3-1Q115093011523.gif)


```java

package proxy;
public class ProxyTest
{
    public static void main(String[] args)
    {
        Proxy proxy=new Proxy();
        proxy.Request();
    }
}
//抽象主题
interface Subject
{
    void Request();
}
//真实主题
class RealSubject implements Subject
{
    public void Request()
    {
        System.out.println("访问真实主题方法...");
    }
}
//代理
class Proxy implements Subject
{
    private RealSubject realSubject;
    public void Request()
    {
        if (realSubject==null)
        {
            realSubject=new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }
    public void preRequest()
    {
        System.out.println("访问真实主题之前的预处理。");
    }
    public void postRequest()
    {
        System.out.println("访问真实主题之后的后续处理。");
    }
}
```
### 模拟场景

汽车公司生产出售多种汽车、助力车、电动车、汽车  
客户买车不可能直接到汽车厂下单购买，汽车公司在全国各地设立代理经销商，  
代理经销商可以对外提供车辆出售，同时代理经销商在汽车厂原有的出厂价格上会涨价，客户买车后，经销商也会提供汽车的保修等

其中汽车厂为抽象主题提供出售车辆的接口、汽车公司为具体主题，代理经销商为代理类，客户通过代理类进行车辆的购买


### 实现方式

- 静态代理：手动定义代理类
- 动态代理：运行时程序动态生成代理类（JDK自带的动态代理、CGLIB、ASM）