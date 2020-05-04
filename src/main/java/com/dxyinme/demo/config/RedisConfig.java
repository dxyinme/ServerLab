package com.dxyinme.demo.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
// 必须加，使配置生效
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

}