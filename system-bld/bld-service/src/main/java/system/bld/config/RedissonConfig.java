package system.bld.config;

import cn.hutool.core.util.StrUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author litao
 * @date 2020-11-10
 */

@Configuration
public class RedissonConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String password;
/* 如果使用redis时 放开此注释即可，同时放开父pom 下架包*/
   /* @Bean
    public RedissonClient getRedisson() {

        Config config = new Config();
        if(StrUtil.isBlank(password)){
            config.useSingleServer().setAddress("redis://" + host + ":" + port);
        }else{
            config.useSingleServer().setAddress("redis://" + host + ":" + port).setPassword(password);
        }

        //添加主从配置
        //        config.useMasterSlaveServers().setMasterAddress("").setPassword("").addSlaveAddress(new String[]{"",""});

        return Redisson.create(config);
    }*/
}
