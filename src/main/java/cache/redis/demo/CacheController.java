package cache.redis.demo;

import io.micronaut.cache.annotation.CacheConfig;
import io.micronaut.cache.annotation.CacheInvalidate;
import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/cache")
@CacheConfig("mycache")
public class CacheController {

  @Get
  @Cacheable
  public String cacheable() throws InterruptedException {
    Thread.sleep(1000);
    return "hello";
  }
  
  @Get("/dos")
  @Cacheable(keyGenerator = RedisKeyGenerator.class)
  public String cacheable2() throws InterruptedException {
    Thread.sleep(1000);
    return "hello world";
  }

  @Get("/invalidate")
  @CacheInvalidate
  public String cacheInvalidate() {
    return "ok";
  }
}