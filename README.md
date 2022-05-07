# spring-boot-redis-cluster-sample
## About
This is sample of spring boot connected to ElastiCache redis cluster for spring session.

## CODE
### pom.xml
```xml
<dependency>
    <groupId>org.springframework.session</groupId>
    <artifactId>spring-session-data-redis</artifactId>
</dependency>
<dependency>
    <groupId>io.lettuce</groupId>
    <artifactId>lettuce-core</artifactId>
</dependency>
```

### application.yml
```yaml
spring:
  session:
    store-type: redis
    redis:
      configure-action: none # ConfigureRedisAction.NO_OP
  redis:
    host: test-cluster.xxxxxx.clustercfg.apne1.cache.amazonaws.com
    port: 6379
    cluster:
      nodes: test-cluster-0001-001.xxxxxx.0001.apne1.cache.amazonaws.com:6379,test-cluster-0001-002.xxxxxx.0001.apne1.cache.amazonaws.com:6379,test-cluster-0002-001.xxxxxx.0001.apne1.cache.amazonaws.com:6379,test-cluster-0002-002.xxxxxx.0001.apne1.cache.amazonaws.com:6379
    ssl: false # If ElastiCache configuration "in-transit encryption" is enabled, this is true
  data:
    redis:
      repositories:
        enabled: false
```