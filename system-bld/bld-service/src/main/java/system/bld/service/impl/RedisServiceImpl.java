package system.bld.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bld.service.RedisService;

/**
 * @author litao
 * @date 2020-11-10
 * @Desc 可以用RedisService  也可以直接引用RedissonClient
 */
@Service
public class RedisServiceImpl implements RedisService {

   /*@Autowired
    private RedissonClient redissonClient;

    @Override
    public <V> RList<V> setStr(String key) {
        RList<V> rList = redissonClient.getList(key);
        return rList;
    }*/
}
