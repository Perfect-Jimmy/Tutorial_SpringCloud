### 如何解决Eureka Server不踢出已关停的节点的问题
在开发过程中常常希望Eureka Server能够迅速有效地踢出已关停的节点,但是由于Eureka自我保护模式以及心跳周期长的原因
常常会遇到Eureka Server不踢出已关停的节点的问题.解决方法如下:
1. Eureka Server端:配置关闭自我保护,并按需配置Eureka Server清理无效节点的时间间隔
```
eureka.server.enable-self-preservation          # 设为false,关闭自我保护  
eureka.server.eviction-interval-timer-in-ms     # 清理间隔(单位毫秒,默认是60*1000)  
```
2. 