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
