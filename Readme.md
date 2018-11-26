# Micronaut Redis Cache Demo
This is a demo project to test the Redis Cache functionallity of Micronaut framework.

## Redis cache configuration:
Redis server is up in a docker container running locally
```
docker run redis
```
application.yml:
``` yml
micronaut:
    application:
        name: cache-redis-demo
    redis:
        uri: redis://172.17.0.2:6379/12
        caches:
            mycache:
                maximumSize: 20
```
### Using mycache
``` java
@Controller("/cache")
public class CacheController {

    @Get
    @Cacheable("mycache")
    public String cacheable() throws InterruptedException {
        Thread.sleep(1000);
        return "hello";
    }

    @Get("/invalidate")
    @CacheInvalidate("mycache")
    public String cacheInvalidate() {
        return "ok";
    }
}
```