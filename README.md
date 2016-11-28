# Apollo For Spring Cloud

快速搭建Spring Cloud环境的示例

## 使用方式（针对Eureka为例，Zookeeper方式同理）
1. 运行Spring Cloud的Eureka Server集群
   运行apollo-eureka-cluster下EurekaCluster1，EurekaCluster2，EurekaCluster3
   注意：对三个Spring Boot的启动程序，分别在VM arguments那里，加入-Dspring.profiles.active=cluster-1，-Dspring.profiles.active=cluster-2，-Dspring.profiles.active=cluster-3
   
2. 运行Spring Cloud的Service集群
   运行apollo-eureka-service下EurekaService1，EurekaService2
   注意：对两个Spring Boot的启动程序，分别在VM arguments那里，加入-Dspring.profiles.active=service-1，-Dspring.profiles.active=service-2
   
3. 运行Spring Cloud的Reference
   运行apollo-eureka-reference下EurekaReference1，EurekaReference2
   第一种是基于Ribbon的运行方式，第二种是基于Feign的运行方式（对apollo-service服务的绑定和关联，达到以本地接口方式调用远程接口的目的），这两种方式不能同时运行。
   
4. 打开http://localhost:1111，查看Eureka Server集群运行状况
   当基于Ribbon的运行方式的时候，打开http://localhost:3333/add1，http://localhost:3333/getUser1，查看远程调用结果
   当基于Feign的运行方式的时候，打开http://localhost:3333/add2，http://localhost:3333/getUser2，查看远程调用结果

5. Spring Cloud的Reference，还有另外一种运行方式，即apollo-eureka-reference-hystrix，断路器模式，方式和3.一致