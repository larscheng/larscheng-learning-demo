## Nacos（一）：Nacos介绍


### 前言

6月份阿里开源的Nacos出了1.0.1版本，从去年7月份第一个release版本到现在一直在默默关注

官方的版本规划为：Nacos从0.8.0开始支持生产可用，1.0版本可大规模生产可用，2.0版本接入k8s、SpringCloud、ServiceMesh、ServerLess

公司目前的项目都是Springcloud，由于eureka2.X的断更、以及Nacos面世，所以自然而然最近就进行了一次试水爬坑，虽然过程艰苦，但是最终效果似乎还不错。


本文主要从以下几点来带大家熟悉下Nacos

- Nacos是什么
- Nacos的发展历程
- Nacos能做什么
- Nacos无缝接入各大生态

### Nacos是什么

Nacos是什么？好像没听过，不要紧。那Eureka听说过吧，在SpringCloud中做服务注册中心组件，类似的还有Zookeeper、Consul。

所以Nacos也是一个注册中心组件咯，当然是，不过**它不仅仅是注册中心**。

**Nacos也是一个配置中心**，比如SpringCloud中的Config，将配置文件版本化管理。

那么Nacos到底是什么呢, 总结为官网一句话就是:

> Nacos 致力于帮助您发现、配置和管理微服务。Nacos 提供了一组简单易用的特性集，帮助您快速实现动态服务发现、服务配置、服务元数据及流量管理。




### Nacos的发展历程

首先要说Nacos的发展历程就要从阿里巴巴的内部产品ConfigServer说起了，因为**Nacos是ConfigServer 的开源实现**

早在2008年阿里就开始服务化的进程(那个时候我好像还在上初中啊)，在那个时候阿里内部自研的服务发现解决方案就叫做ConfigServer

ConfigServer经历了十年的发展从V1.0的单机版演变为目前对外公布的V4.0集群版。

2018年7月阿里巴巴高级技术专家许真恩（慕义）发布了Nacos首个开源版本V0.1.0，Nacos作为ConfigServer的开源实现截止目前已经更新到了V1.0.1的大版本，并且支持大规模生产版本。

### Nacos能做什么
虽然[官方文档](https://nacos.io/zh-cn/docs/what-is-nacos.html)也有介绍，但是语言比较官方，我就用大白话谈一点自己的使用感受。

- 服务注册发现和服务健康检测

    Nacos支持基于DNS和基于RPC的服务发现，服务端可以通过SDK或者Api进行服务注册，相应的服务消费者可以使用DNS或者Http查找的方式获取服务列表。Nacos同时提供对服务的实时健康检查，阻止想不健康的主机或服务发送请求，与Eureka类似Nacos也有友好的控制台界面。

![Nacos控制台](https://raw.githubusercontent.com/zhengqilong/myImg/master/blogImg/Nacos/20190705131509.png)

- 动态配置服务

    接触过SpringCloud应该对config有所了解，那么配置中心也就很好理解，Nacos支持动态的配置管理，将服务的配置信息分环境分类别外部管理，并且支持热更新。不过与Config不同Nacos的配置信息存储与数据库中，支持配置信息的监听和版本回滚。


![Nacos配置管理](https://raw.githubusercontent.com/zhengqilong/myImg/master/blogImg/Nacos/20190705131605.png)

- 动态DNS服务

    支持权重路由，更容易地实现中间层负载均衡、更灵活的路由策略、流量控制以及数据中心内网的简单DNS解析服务。不过这个特性目前版本还不支持

- 服务及元数据管理

    Nacos 能让您从微服务平台建设的视角管理数据中心的所有服务及元数据，包括管理服务的描述、生命周期、服务的静态依赖分析、服务的健康状态、服务的流量管理、路由及安全策略、服务的 SLA 以及最首要的 metrics 统计数据。



### Nacos无缝接入各大生态

首先先上一张官方的生态图

![Nacos 全景图](https://raw.githubusercontent.com/zhengqilong/myImg/master/blogImg/Nacos/20190705132338.png)


除了对于阿里开源生态体系如 Dubbo 等自身的支持，也非常强调融入其它的开源生态，这里就包括 Java 的微服务生态体系 Spring Cloud，Kubernetes/CNCF 云原生生态体系。

Nacos 无缝支持 Spring Cloud，为 Spring Cloud 用户其提供更简便的配置中心和注册中心的解决方案。

Nacos支持目前几乎所有主流的微服务生态体系。


### 总结

Nacos从官方的介绍上看，就像是SpringCloud中Eureka+Config+Bus+Git+MQ的一个结合体，当然也不能完全这么理解。Nacos是脱胎于阿里内部的ConfigServer，而ConfigServer早在3.0版本就解决了Eureka在1.0版本留下的隐患，所以从技术的更新和迭代角度来看，稳定版本的Nacos将更适合做为微服务体系中的服务注册发现组件，当然了他也不单单只是注册和发现。更多的特性和功能，不如一起搭建试试吧。


### 参考与感谢

[Nacos官方手册](https://nacos.io/zh-cn/docs/what-is-nacos.html)

[来看看阿里自研服务注册中心产品ConfigServer](https://www.cnblogs.com/lzmrex/articles/9303222.html)