package com.miaoshaproject.service.impl;

import com.google.common.cache.CacheBuilder;
import com.miaoshaproject.service.CacheService;
import com.google.common.cache.Cache;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Service
public class CacheServiceImpl implements CacheService {

    private Cache<String, Object> commonCache = null;

    @PostConstruct
    public void init(){
        commonCache = CacheBuilder.newBuilder()
                //设置初始容量为10
                .initialCapacity(10)
                //设置最大的KEY数量为100
                .maximumSize(100)
                //设置过期时间为60s 采用的是在写后开始算起，而不是访问后
                .expireAfterWrite(60, TimeUnit.MINUTES)
                .build();
    }
    @Override
    public void setCommonCache(String key, Object value) {
        commonCache.put(key, value);
    }

    @Override
    public Object getFromCommonCache(String key) {
        return commonCache.getIfPresent(key);
    }
}
