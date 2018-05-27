### Eureka的自我保护模式
```
EMERGENCY! EUREKA MAY BE INCORRECTLY CLAIMING INSTANCES ARE UP WHEN THEY'RE NOT. RENEWALS ARE LESSER THAN THRESHOLD AND HENCE THE INSTANCES ARE NOT BEING EXPIRED JUST TO BE SAFE.
```

Eurake有一个配置参数eureka.server.renewalPercentThreshold,定义了renews和renews threshold的比值,默认值为0.85.
当server在15分钟内,比值低于percent,即少了15%的微服务心跳server会进入自我保护状态,Self-Preservation.在此状态下,
server不会删除注册信息,这就有可能导致在调用微服务时,实际上服务并不存在. 
这种保护状态实际上是考虑了client和server之间的心跳是因为网络问题而非服务本身问题,不能简单的删除注册信息.

#### 解决方案
1. 在生产上可以开自注册,部署两个server 
2. 在本机器上测试的时候,可以把比值调低,比如0.49 
3. 或者简单粗暴把自我保护模式关闭 eureka.server.enableSelfPreservation=false 