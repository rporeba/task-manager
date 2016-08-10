package com.rporeba.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by rporeba on 29.07.2016.
 */

@Configuration
@Profile("dev")
public class CacheConfigDevEnv {

    private static final Logger log = LoggerFactory.getLogger(CacheConfigDevEnv.class);

    @Bean
    public CacheManager concurrentMapCacheManager() {

        log.debug("Cache manager is concurrentMapCacheManager");

        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("tasks");
        return cacheManager;
    }
}
