# cloudify


## 服务治理
### 注册中心

#### eureka-server   
```yaml
spring:
  application:
    name: eureka-server

server:
  port: 11111

eureka:
  instance:
    hostname: localhost
  client:
    registerWithEureka: false
    fetchRegistry: false
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/

```


#### eureka-client

```yaml
eureka:
  instance:
    hostname: localhost
  client:
    serviceUrl:
      eureka-server-port: 11111

```

```yaml
spring:
  application:
    name: eureka-client

server:
  port: 21111

eureka:
  client:
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${eureka.client.serviceUrl.eureka-server-port}/eureka/
```


#### eureka-consumer
```yaml
eureka:
  instance:
    hostname: localhost
  client:
    serviceUrl:
      eureka-server-port: 11111

```

```yaml
spring:
  application:
    name: eureka-consumer

server:
  port: 3x111

eureka:
  client:
    serviceUrl:
      defaultZone: http://${eureka.instance.hostname}:${eureka.client.serviceUrl.eureka-server-port}/eureka/

```
## 分布式配置中心

### 配置仓库

### 配置中心

```yaml
spring:
  application:
    name: config-server
  cloud:
    config:
      server:
        git:
          uri: git@github.com:SpringCloudify/config-repo-demo.git
server:
  port: 1201

```

### 客户端
___application.yaml___
```yaml
spring:
  application:
    name: config-client

server:
  port: 22001
```

___bootstrap.yaml___
```yaml
spring:
  cloud:
    config:
      name: config-client
      uri: http://localhost:1201/
      profile: defualt
      label: master
```

- `spring.application.name`：对应配置文件规则中的`{application}`部分
- `spring.cloud.config.profile`：对应配置文件规则中的`{profile}`部分
- `spring.cloud.config.label`：对应配置文件规则中的`{label}`部分
- `spring.cloud.config.uri`：配置中心`config-server`的地址