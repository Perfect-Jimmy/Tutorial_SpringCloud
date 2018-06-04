### 网关 gateway
1. 引入依赖
```

```

2. 添加配置
```
spring:
  cloud:
    gateway:
      discovery:
        locator:
          enabled: true
      routes:
      - id: book-server
        uri: lb://book-server
        predicates:
        - Path=/**
        filters:
        - RewritePath=/**/(?<path>.*), /$\{path}
      - id: people-server
        uri: lb://people-server
        predicates:
        - Path=/**
        filters:
        - RewritePath=/department/(?<path>.*), /$\{path}
      - id: organization-service
        uri: lb://organization-service
        predicates:
        - Path=/organization/**
        filters:
        - RewritePath=/organization/(?<path>.*), /$\{path}
```