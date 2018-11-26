package cache.redis.demo;

import io.micronaut.cache.annotation.CacheInvalidate;
import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

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