package co.integrapps.services.application.service;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ClearCacheService {
    @Autowired
    private CacheManager cacheManager;
    private static final Logger LOGGER = LogManager.getLogger(ClearCacheService.class);

    public void evictAllCaches() {
        cacheManager.getCacheNames()
                .forEach(cacheName -> cacheManager.getCache(cacheName).clear());
    }

    @Scheduled(fixedRate = 900000)
    public void evictAllcachesAtIntervals() {
        LOGGER.info("clear cache schedule");
        evictAllCaches();
    }
}
