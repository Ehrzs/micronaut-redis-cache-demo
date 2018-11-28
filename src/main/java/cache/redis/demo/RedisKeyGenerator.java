package cache.redis.demo;

import io.micronaut.cache.interceptor.CacheKeyGenerator;
import io.micronaut.core.annotation.AnnotationMetadata;

public class RedisKeyGenerator implements CacheKeyGenerator {

  public Object generateKey(AnnotationMetadata annotationMetadata, Object... params) {
    return "dos";
  }

}