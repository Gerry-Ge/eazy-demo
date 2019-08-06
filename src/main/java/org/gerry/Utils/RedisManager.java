package org.gerry.Utils;

import com.sun.corba.se.spi.ior.ObjectKey;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisManager {

    @Autowired
    private RedisTemplate redisTemplate;

    public boolean set(final String key, Object value) {
        boolean flag = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean set(final String key, Object value, long time) {
        boolean flag = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    public void remove(final String key) {
        if (redisTemplate.hasKey(key)) {
            redisTemplate.delete(key);
        }
    }

    public void removePattern(final String pattern) {
        Set<Serializable> sets = redisTemplate.keys(pattern);
        if (sets.size() > 0) {
            redisTemplate.delete(sets);
        }
    }


    public Object get(final String key) {
        Object obj = null;
        ValueOperations<Serializable, Object> values = redisTemplate.opsForValue();
        obj = values.get(key);
        return obj;
    }

    public void hmPut(String key, Object hashKey, Object value) {
        HashOperations<String, Object, Object> hashs = redisTemplate.opsForHash();
        hashs.put(key, hashKey, value);
    }

    public Object hmGet(String key, Object hashKey) {
        Object obj = null;
        HashOperations<Serializable, Object, Object> hashs = redisTemplate.opsForHash();
        obj = hashs.get(key, hashKey);
        return obj;
    }

    public void listRPush(String key,Object value) {
        ListOperations<Serializable, Object> lists = redisTemplate.opsForList();
        lists.rightPush(key, value);
    }

    public List<Object> listRange(String key,long start,long end){
        ListOperations<Serializable,Object> lists=redisTemplate.opsForList();
        return lists.range(key,start,end);
    }

    public void setAdd(String key,Object value){
        SetOperations<Serializable,Object> sets=redisTemplate.opsForSet();
        sets.add(key,value);
    }

    public Set<Object> setMem(String key){
        SetOperations<Serializable,Object> sets=redisTemplate.opsForSet();
        return sets.members(key);
    }

    public void ZsetAdd(String key,Object value,double source){
        ZSetOperations<Serializable,Object> zSets=redisTemplate.opsForZSet();
        zSets.add(key,value,source);
    }

    public Set<Object> ZsetRange(String key,double source ,double source1){
        ZSetOperations<Serializable,Object> sets=redisTemplate.opsForZSet();
        return sets.rangeByScore(key,source,source1);
    }

}
