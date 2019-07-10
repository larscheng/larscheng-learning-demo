## Nacos（三）：Nacos与OpenFeign的对接使用


### 前言

上篇文章中，简单介绍了`如何在SpringCloud项目中接入Nacos作为注册中心`，其中服务消费者是通过RestTemplate+Ribbon的方式来进行服务调用的。

实际上在日常项目中服务间调用大都用的是`OpenFeign`, OpenFeign自身整合了Ribbon和Hystrix，为服务调用提供了更优雅的方式

那么接入了Nacos之后，服务调用还能用这一套吗？

通过我在公司项目上的试水，这个大胆的设想是完全没问题的

***本文在上一篇文章中的项目工程基础上*，进行测试和演示，文章地址：[在SpringCloud项目中接入Nacos作为注册中心](http://larscheng.coding.me/Nacos%EF%BC%88%E4%BA%8C%EF%BC%89%EF%BC%9ASpringCloud-Nacos%E6%B3%A8%E5%86%8C%E4%B8%AD%E5%BF%83/)**

### 创建项目

打开之前创建的工程Nacos，目前已经有两个子工程：

- nacos-provide：服务提供者
- nacos-consumer：服务消费者（RestTemplate+Ribbon服务调用）

同样的操作，在Nacos项目下继续创建一个Springboot项目名为nacos-feign，创建时添加OpenFeign的依赖，如图：

nacos-fegin的pom.xml文件如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <artifactId>Nacos</artifactId>
        <groupId>com.study.www</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <groupId>com.larscheng.www</groupId>
    <artifactId>nacos-fegin</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>nacos-fegin</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>

```

### 定义远程接口

创建RemoteClient接口，来定义OpenFeign要调用的远程服务接口。

同时通过@FeginClient注解指定被调用方的服务名，通过fallback属性指定RemoteHystrix类，来进行远程调用的熔断和降级处理。

RemoteClient.java代码如下

```Java
@FeignClient(name = "nacos-provide",fallback = RemoteHystrix.class)
public interface RemoteClient {

    @GetMapping("/helloNacos")
    String helloNacos();
}
```

RemoteHystrix.java代码如下

```Java
@Component
public class RemoteHystrix implements RemoteClient {
    @Override
    public String helloNacos() {
        return "请求超时了";
    }
}
```

### 通过OpenFeign调用远程服务

在启动类NacosFeignApplication.java中添加注解@EnableDiscoveryClient开启服务注册、添加注解@EnableFeignClients开启OpenFeign，启动类通过OpenFeign调用服务代码如下

```java
@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class NacosFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosFeginApplication.class, args);
    }

    @Autowired
    private RemoteClient remoteClient;

    @GetMapping("/feign")
    public String test() {
        return remoteClient.helloNacos();
    }
}

```

### 添加项目配置文件

在resourse目录下，添加application.yml配置

```yaml
server:
  port: 9529

spring:
  application:
    name: nacos-feign
  cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848
```

### 启动测试

1. 启动Nacos-server
2. 启动项目nacos-provide
3. 启动项目nacos-feign

完成以上三步后，访问Nacos控制台，检查服务注册情况，如果启动都成功，你看到的应该是如下图：

![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/Nacos/20190710164425.png)


浏览器访问 http://127.0.0.1:9529/feign， 可以看到返回结果与RestTemplate结果无异，但对于编码和操作方式都更加优雅。

访问nacos-feign的接口 http://127.0.0.1:9529/feign， 可以通过OpenFeign远程调用nacos-provide的接口，返回结果：

    你好，nacos！
    
### 总结

OpenFegin整合Ribbon和Hystrix，为微服务中远程调用提供了一种更优雅的调用方式，它支持负载均衡和容错熔断机制。通过上面的例子，在SpringCloud中接入Nacos做注册中心后，并不会影响我们继续使用其他SpringCloud组件。

***本文源码*：https://github.com/larscheng/larscheng-learning-demo/tree/master/Nacos**


