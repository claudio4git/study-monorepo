package br.com.jccf.explorer.config.cache

import br.com.jccf.explorer.config.spring.SpringContext
import mu.KotlinLogging
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Lazy

private val logger = KotlinLogging.logger {}

@Configuration
@EnableCaching
@ConditionalOnProperty(value = [SpringContext.OPTS_CACHE], havingValue = "true")
class DefaultCacheConfig {

    @Bean
    @Lazy
    fun defaultCacheManager(): CacheManager {
        logger.info { "Default cache control" }

        val simpleCacheManager = SimpleCacheManager()
        simpleCacheManager.setCaches(listOf(ConcurrentMapCache("books")))
        return simpleCacheManager
    }
}
