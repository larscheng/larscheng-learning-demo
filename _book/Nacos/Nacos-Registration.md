## nacos（二）：springcloud+nacos注册中心

### 前言

通过上一篇文章：[Nacos介绍 ](Nacos-Introduction.md)简单了解了Nacos的发展历程和现状，本文我们开始Nacos试水的第一步: **使用Nacos做注册中心**

> 上周末（7.6）Nacos发布了V1.1.0版本，这次更新支持灰度配置、地址服务器模式、配置文件导入导出等其他功能。感觉社区的老哥们都很高产呐....

本文主要通过两个项目来完成演示：

- nacos-provide：服务提供者
- nacos-consumer：服务消费者

![](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/Nacos/20190709155600.png)

    将nacos-provide和nacos-consumer注册到Nacos-server，
    
    服务消费者nacos-consumer通过主动轮询获取他所订阅消费的服务信息列表
    
    nacos-consumer根据获取到的服务信息列表，进行服务调用。

熟悉SpringCloud+Eureka的同学阅读完本文后可以无缝切换Nacos做注册中心

### 我的环境

- Windows10
- JDK8
- SpringCloud：Finchley.RELEASE
- SpringBoot：2.0.4.RELEASE
- spring-cloud-alibaba-dependencies：0.2.2.RELEASE
- Nacos-server：1.0.1

***注：Nacos针对不同版本的SpingCloud提供不同的依赖，各个版本的对应关系请参考官方文档给出的说明：[版本说明](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E)***

### 启动Nacos-server

![Nacos部分版本预览](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/Nacos/20190709141938.png)

Nacos-server可以直接从github上下载安装包，当然你也可以拉取代码后自行打包

本文我直接从官网下载Nacos-server：V1.0.1(**为避免新版本V1.1.0有其他问题，我这里还是用V1.0.1**)

下载地址： https://github.com/alibaba/nacos/releases



下载解压后进入`bin`文件夹（目录：nacos-server-1.0.1\nacos\bin），直接双击执行startup.cmd文件，启动成功如下图：


![Nacos单机模式启动成功](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/Nacos/20190709142512.png)


启动成功后，此时Nacos控制台就可以访问了，浏览器访问：http://127.0.0.1:8848/nacos/index.html ，默认的账号密码为[nacos/nacos]()，控制台页面如下：

![nacos控制台界面](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/Nacos/20190709143113.png)

### 创建服务提供者

IDEA中创建聚合工程Nacos作为父工程，其pom.xml如下（重点关注`dependencyManagement`配置）：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>larscheng-learning-demo</artifactId>
        <groupId>com.study.www</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>

    <version>0.0.1-SNAPSHOT</version>
    <modelVersion>4.0.0</modelVersion>

    <modules>
        <module>nacos-provide</module>
    </modules>

    <artifactId>Nacos</artifactId>

    <properties>
        <java.version>1.8</java.version>
        <spring-boot.version>2.0.4.RELEASE</spring-boot.version>
        <spring-cloud.version>Finchley.RELEASE</spring-cloud.version>
        <nacos.version>0.2.2.RELEASE</nacos.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version>${nacos.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

</project>

```

在父工程Nacos下创建springboot子工程nacos-provide，其pom.xml文件为：

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
    <artifactId>nacos-provide</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>nacos-provide</name>
    <description>Demo project for Spring Boot</description>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
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

在NacosProvideApplication.java中提供一个对外接口，并添加注解` @EnableDiscoveryClient` 开启服务注册发现功能：

```java
@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class NacosProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosProvideApplication.class, args);
    }
    
    @GetMapping("/helloNacos")
    public String helloNacos(){
        return "你好，nacos！";
    }
}
```

配置文件application.yml进行如下配置

```yaml
server:
  port: 9527
spring:
  application:
    name: nacos-provide
  cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848
```

ok，服务提供者的创建和配置已经完成

### 创建服务消费者

仍然在Nacos工程下创建一个SpringBoot项目子工程命名为nacos-consumer，其pom文件与nacos-provide相同。

同样为nacos-consumer增加配置文件，内容如下

```yaml
server:
  port: 9528
spring:
  application:
    name: nacos-consumer
  cloud:
    nacos:
      discovery:
        server-addr: 127.0.0.1:8848
```

服务消费者这里按照官方文档中的方式通过 RestTemplate+Ribbon进行服务调用,

NacosConsumerApplication.java代码如下：
```java
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class NacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class, args);
    }
    
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/consumer")
    public String test1() {
        String result = restTemplate.getForObject("http://nacos-provide/helloNacos",String.class);
        return "Return : " + result;
    }
}
```

ok，服务消费者的创建工作也已完成，下面启动两个项目，进行测试

### 调用测试

启动完成后，在日志中应该可以看到如下两条信息

    o.s.c.a.n.registry.NacosServiceRegistry  : nacos registry, nacos-provide 192.168.200.1:9527 register finished
        
    o.s.c.a.n.registry.NacosServiceRegistry  : nacos registry, nacos-consumer 192.168.200.1:9528 register finished


现在登录Nacos控制台，你会发现服务列表中，已经显示了我们刚才创建的两个项目，并可以对其进行简单的监控和管理。

![服务列表](https://raw.githubusercontent.com/larscheng/myImg/master/blogImg/Nacos/20190709163402.png)

浏览器中访问服务消费者的接口 http://127.0.0.1:9528/consumer， 可以看到成功返回结果

    Return : 你好，nacos！
    
    
### 总结

完成上面的服务发现和注册的测试后，我的第一感觉是，`好像只用修改配置就可以替换Eureka，好像无缝支持SpringCloud` ,   
带着这个内心的冲击感，我到公司的项目中简单试了下水，居然直接注册成功，并且各个服务之间正常使用，虽然只是单独的服务注册发现功能。但这能够说明Nacos天生就无缝衔接SpringCloud生态（当然他也有很多坑）

看Nacos控制台中的几大分类，明显Nacos的能力绝不仅仅是注册中心这么简单，更多Nacos的使用姿势和坑点，我们未完待续~

### 参考感谢

[Nacos官方手册](https://nacos.io/zh-cn/docs/what-is-nacos.html)
