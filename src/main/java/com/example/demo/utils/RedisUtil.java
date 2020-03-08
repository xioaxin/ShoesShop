package com.example.demo.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @Description:Redis工具类支持支持缓存
 * @author: ZPX
 * @createDate: 2020/3/8 17:48
 * @version: 1.0
 */
@Component
public class RedisUtil<T> {
    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 保存缓存信息
     *
     * @param keyName
     * @param object
     * @param timeoutForMills
     * @deprecated timeoutForMills 单位毫秒(-1表示没有时间限制)
     */
    public void saveMessage(String keyName, T object, int timeoutForMills) {
        try {
            ValueOperations<String, T> ops = redisTemplate.opsForValue();

            if (timeoutForMills < 0) {
                ops.set(keyName, object);
            } else {
                ops.set(keyName, object, TimeoutUtils.toSeconds(timeoutForMills, TimeUnit.MILLISECONDS));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询缓存信息
     *
     * @param keyName
     * @return
     */
    public T getMessage(String keyName) {
        ValueOperations<String, T> ops = redisTemplate.opsForValue();
        return ops.get(keyName);
    }

    /**
     * 通过keyName删除缓存中的信息
     *
     * @param keyName
     * @return
     */
    public boolean deleteMessage(String keyName) {
        return redisTemplate.delete(keyName);
    }

    /**
     * 更新缓存中的信息
     *
     * @param keyName
     * @param object
     * @return
     */
    public boolean updateMessage(String keyName, T object) {
        try {
            ValueOperations<String, T> ops = redisTemplate.opsForValue();
            ops.set(keyName, object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

}




