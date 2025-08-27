package com.ruoyi.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class RedisService {

    @Autowired
    public RedisTemplate<String, String> redisTemplate;

    // 获取用户水量
    public String getUserWater(String userId) {
        try {
            String waterStr = redisTemplate.opsForValue().get(getWaterKey(userId));
            String s = new BigDecimal(waterStr).toString();
            return waterStr != null ? s : "0";
        }catch (Exception e){
            return "0";
        }

    }

    // 更新用户水量
    public void updateUserWater(String userId, String water) {
        redisTemplate.opsForValue().set(getWaterKey(userId), water);
    }

    // 获取用户涨幅
    public String getUserIncrement(String userId) {
        String incrementStr = redisTemplate.opsForValue().get(getIncrementKey(userId));
        try {


            String s = new BigDecimal(incrementStr).toString();
            System.out.println(s);
            return incrementStr != null ? s : "0.000001";
        }catch (Exception e){
           return "0";
        }

    }

    // 更新用户涨幅
    public void updateUserIncrement(String userId, String increment) {
        redisTemplate.opsForValue().set(getIncrementKey(userId), String.valueOf(increment));
    }

    private String getWaterKey(String userId) {
        return "user:water:" + userId;
    }

    private String getIncrementKey(String userId) {
        return "user:increment:" + userId;
    }
}