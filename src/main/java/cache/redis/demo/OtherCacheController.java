package cache.redis.demo;

import io.micronaut.cache.annotation.CacheConfig;
import io.micronaut.cache.annotation.CacheInvalidate;
import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/othercache")
@CacheConfig("othercache")
public class OtherCacheController {

  @Get
  @Cacheable
  public String cacheable() throws InterruptedException {
    Thread.sleep(1000);
    return "hello";
  }

  @Get("/invalidate")
  @CacheInvalidate(all = true)
  public String cacheInvalidate() {
    return "ok";
  }
}