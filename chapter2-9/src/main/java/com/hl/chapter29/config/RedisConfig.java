package com.hl.chapter29.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

/**
 * 配置类的注解
 */
@Configuration
@EnableCaching
public class RedisConfig {

    // 如果 spring.redis.host 不存在，则会默认为127.0.0.1.
    @Value("${spring.redis.host:'127.0.0.1'}")
    private String hostName;
    @Value("${spring.redis.port:#{6379}}")
    private int port;

    @Value("${spring.redis.password:#{123456}}")
    private String password;

    @Value("${spring.redis.timeout:#{3000}}")
    private int timeout;

    @Value("${spring.redis.lettuce.pool.max-idle:#{16}}")
    private int maxIdle;

    @Value("${spring.redis.lettuce.pool.min-idle:#{1}}")
    private int minIdle;

    @Value("${spring.redis.lettuce.pool.max-wait:#{16}}")
    private long maxWaitMillis;

    @Value("${spring.redis.lettuce.pool.max-active:#{16}}")
    private int maxActive;

    @Value("${spring.redis.database:#{0}}")
    private int databaseId;

    // 配置lettuceConnectionFactory连接池
    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {
        RedisConfiguration redisConfiguration = new RedisStandaloneConfiguration(hostName, port);

        // 设置选用的数据库号码
        ((RedisStandaloneConfiguration) redisConfiguration).setDatabase(databaseId);

        // 设置 redis 数据库密码
//        ((RedisStandaloneConfiguration) redisConfiguration).setPassword(password);

        // 连接池配置
        GenericObjectPoolConfig<Object> poolConfig = new GenericObjectPoolConfig<>();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMaxWaitMillis(maxWaitMillis);

        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder
                = LettucePoolingClientConfiguration.builder()
                .commandTimeout(Duration.ofMillis(timeout));

        LettucePoolingClientConfiguration lettucePoolingClientConfiguration = builder.build();

        builder.poolConfig(poolConfig);

        // 根据配置和客户端配置创建连接
        LettuceConnectionFactory factory = new LettuceConnectionFactory(redisConfiguration,
                lettucePoolingClientConfiguration);
        return factory;

    }

//    /**
//     * 这是一个通用的keyGenerator，可以解决分布式的命名问题。
//     *
//     * @return
//     */
//    @Bean
//    public KeyGenerator wiselyKeyGenerator() {
//        return (target, method, params) -> {
//            StringBuilder builder = new StringBuilder();
//            builder.append(target.getClass().getName());
//            builder.append(method.getName());
//            for (Object obj : params) {
//                builder.append(obj.toString());
//            }
//            return builder.toString();
//        };
//    }

    /**
     * 配置redisTemplate
     *
     * @return
     */
    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory);

        // 使用 FastJsonRedisSerializer 来序列化和反序列化redis 的 value的值
        FastJsonRedisSerializer<Object> serializer = new FastJsonRedisSerializer<>(Object.class);
        ParserConfig.getGlobalInstance().addAccept("com.hl.chapter29");
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
//        serializer.setFastJsonConfig(fastJsonConfig);

        // key 的 String 序列化采用 StringRedisSerializer
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);

        // value 的值序列化采用 fastJsonRedisSerializer
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setHashValueSerializer(serializer);

        redisTemplate.afterPropertiesSet();

        System.out.println(redisTemplate.getDefaultSerializer());
        System.out.println(redisTemplate.getValueSerializer());

        return redisTemplate;

    }

    /**
     * 这是更严格的 redisTemplate，网络上大佬写的。
     *
     * @param lettuceConnectionFactory
     * @return
     */
    @Bean
//    @ConditionalOnMissingBean(StringRedisTemplate.class)
    public StringRedisTemplate stringRedisTemplate(
            LettuceConnectionFactory lettuceConnectionFactory
    ) {

        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(lettuceConnectionFactory);
        return stringRedisTemplate;
    }


}
