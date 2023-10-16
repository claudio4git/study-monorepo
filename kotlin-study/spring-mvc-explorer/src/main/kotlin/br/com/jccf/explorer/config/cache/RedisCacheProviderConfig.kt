package br.com.jccf.explorer.config.cache

import br.com.jccf.explorer.config.spring.SpringContext
import mu.KotlinLogging
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.cache.RedisCacheWriter
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory

private val logger = KotlinLogging.logger {}

@Configuration
@EnableCaching
@ConditionalOnProperty(value = [SpringContext.OPTS_CACHE], havingValue = "true")
class RedisCacheProviderConfig {

    @Bean
    @Primary
    @ConditionalOnProperty(value = [SpringContext.OPTS_CACHE_PROVIDER], havingValue = "redis")
    fun redisCacheManager(): CacheManager {
        logger.info { "Redis cache control" }

        val connection = JedisConnectionFactory(RedisStandaloneConfiguration("localhost", 6379))
        val cacheWriter = RedisCacheWriter.lockingRedisCacheWriter(connection)
        val configuration = RedisCacheConfiguration.defaultCacheConfig()

        return RedisCacheManager(cacheWriter, configuration)
    }
}
