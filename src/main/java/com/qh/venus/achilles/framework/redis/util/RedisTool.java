package com.qh.venus.achilles.framework.redis.util;

import com.qh.venus.achilles.common.utils.security.Md5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * redicache 工具类
 * 在application.yml文件内的Spring-redis的run配置启动,true为启动;false为不启动;
 */
@SuppressWarnings("unchecked")
@Component
public class RedisTool {
    /**
     * 日志对象
     */
    private static Logger logger = LoggerFactory.getLogger(RedisTool.class);

    public static String GET_ID = ".get id=";
    public static String TOTAL_KEY = ".total key=";
    public static String FIND_LIST_KEY = ".findList key=";
    public static String FIND_LIST_FIRST_KEY = ".findListFirst key=";
    public static String FIND_PAGE_KEY = ".findPage key=";
    public static String FIND_LIST_KEY_PATTERN = ".findList key=*";
    public static String FIND_LIST_FIRST_KEY_PATTERN = ".findListFirst key=*";
    public static String FIND_PAGE_KEY_PATTERN = ".findPage key=*";
    public static String KEY_PREFIX = "achilles-pts_:";
    public static Long expireTime = 86400l;//24小时
    public static String RUN_MESSAGE = "请开启Redis服务,还有Redis密码配置是否有误，而且密码不能为空（为空时Redis服务会连接不上）。";
    public static String SPRING_REDIS_RUN = "true";
    public static String SPRING_REDIS_LIST_FLUSH = "true";
    @SuppressWarnings("rawtypes")
    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static String getExpire() {
        if (expireTime != null) {
            return String.valueOf(expireTime / 60) + "分钟";
        } else {
            return "0分钟";
        }
    }


    public static String getKey(String className, String keyName, String keyId) {
        if (className == null) {
            className = "";
        }
        if (keyId == null) {
            keyId = "";
        }
        return RedisTool.KEY_PREFIX + className + keyName + keyId;
    }

    public static String getIdKey(String className, String keyId) {
        if (className == null) {
            className = "";
        }
        if (keyId == null) {
            keyId = "";
        }
        return RedisTool.KEY_PREFIX + className + RedisTool.GET_ID + keyId;
    }

    public static String getTotalKey(String className, String keyId) {
        if (className == null) {
            className = "";
        }
        if (keyId == null) {
            keyId = "";
        }
        return RedisTool.KEY_PREFIX + className + RedisTool.TOTAL_KEY + Md5Utils.MD5(keyId).substring(0, 20);
    }

    public static String getFindListKey(String className, String keyId) {
        if (className == null) {
            className = "";
        }
        if (keyId == null) {
            keyId = "";
        }
        return RedisTool.KEY_PREFIX + className + RedisTool.FIND_LIST_KEY + Md5Utils.MD5(keyId).substring(0, 20);
    }

    public static String getFindListFirstKey(String className, String keyId) {
        if (className == null) {
            className = "";
        }
        if (keyId == null) {
            keyId = "";
        }
        return RedisTool.KEY_PREFIX + className + RedisTool.FIND_LIST_FIRST_KEY + Md5Utils.MD5(keyId).substring(0, 20);
    }

    public static String getFindPageKey(String className, String keyId) {
        if (className == null) {
            className = "";
        }
        if (keyId == null) {
            keyId = "";
        }
        return RedisTool.KEY_PREFIX + className + RedisTool.FIND_PAGE_KEY + Md5Utils.MD5(keyId).substring(0, 20);
    }

    public static String getFindListKeyPattern(String className) {
        if (className == null) {
            className = "";
        }
        return RedisTool.KEY_PREFIX + className + FIND_LIST_KEY_PATTERN;
    }

    public static String getFinPageKeyPattern(String className) {
        if (className == null) {
            className = "";
        }
        return RedisTool.KEY_PREFIX + className + FIND_PAGE_KEY_PATTERN;
    }


    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        if (!run()) {
            return;
        }
        try {
            for (String key : keys) {
                remove(key);
            }
        } catch (Exception e) {
            logger.error("RedisUtils remove:" + RUN_MESSAGE + e.getMessage(), RUN_MESSAGE + e.getMessage());
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(String pattern) {
        if (!run()) {
            return;
        }
        if (!listFlush()) {
            return;
        }
        try {
            if (pattern == null) {
                pattern = "";
            }
            Set<String> keys = getKyes(pattern);
            if (keys.size() > 0) {
                redisTemplate.delete(keys);
            }
        } catch (Exception e) {
            logger.error("RedisUtils removePattern:" + RUN_MESSAGE + e.getMessage(), RUN_MESSAGE + e.getMessage());
        }
    }


    /**
     * 获取keys
     *
     * @param pattern
     */
    public Set<String> getKyes(String pattern) {
        if (!run()) {
            return null;
        }
        try {
            if (pattern == null) {
                pattern = "";
            }
            Set<String> keys = stringRedisTemplate.keys("*" + pattern);
            Set<String> keysnew = new HashSet<String>();
            Iterator<String> it = keys.iterator();
            while (it.hasNext()) {
                keysnew.add(it.next());
            }
            return keysnew;
        } catch (Exception e) {
            logger.error("RedisUtils getKyes:" + RUN_MESSAGE + e.getMessage(), e.getMessage());
            return null;
        }
    }


    public Set<String> getKyesAll() {
        if (!run()) {
            return null;
        }
        try {
            Set<String> keys = stringRedisTemplate.keys("*");
            Set<String> keysnew = new HashSet<String>();
            Iterator<String> it = keys.iterator();
            while (it.hasNext()) {
                keysnew.add(it.next());
            }
            return keysnew;
        } catch (Exception e) {
            logger.error("RedisUtils getKyes:" + RUN_MESSAGE + e.getMessage(), e.getMessage());
            return null;
        }
    }

    /**
     * 获取Count
     */
    public int getCount() {
        if (!run()) {
            return 0;
        }
        try {
            Set<String> keys = stringRedisTemplate.keys("*");
            return keys.size();
        } catch (Exception e) {
            logger.error("RedisUtils getCount:" + RUN_MESSAGE + e.getMessage(), e.getMessage());
            return 0;
        }
    }


    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (!run()) {
            return;
        }
        try {
            redisTemplate.delete(key);
        } catch (Exception e) {
            logger.error("RedisUtils exists:" + RUN_MESSAGE + e.getMessage(), RUN_MESSAGE + e.getMessage());
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        if (!run()) {
            return false;
        }
        boolean retuslt = false;
        try {
            retuslt = redisTemplate.hasKey(key);
        } catch (Exception e) {
            logger.error("RedisUtils exists:" + RUN_MESSAGE + e.getMessage(), RUN_MESSAGE + e.getMessage());
        }
        return retuslt;
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        if (!run()) {
            return null;
        }
        Object result = null;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            result = operations.get(key);
            return result;
        } catch (Exception e) {
            logger.error("RedisUtils get:" + RUN_MESSAGE + e.getMessage(), RUN_MESSAGE + e.getMessage());
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        if (!run()) {
            return false;
        }
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            logger.error("RedisUtils set:" + RUN_MESSAGE + e.getMessage(), RUN_MESSAGE + e.getMessage());
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        if (!run()) {
            return false;
        }
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            logger.error("RedisUtils set:" + RUN_MESSAGE + e.getMessage(), RUN_MESSAGE + e.getMessage());
        }
        return result;
    }

    public boolean set(final String key, Object value, Long expireTime, TimeUnit unit) {
        if (!run()) {
            return false;
        }
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, unit);
            result = true;
        } catch (Exception e) {
            logger.error("RedisUtils set:" + RUN_MESSAGE + e.getMessage(), RUN_MESSAGE + e.getMessage());
        }
        return result;
    }

    private boolean run() {
        if (RedisTool.SPRING_REDIS_RUN == "true") {
            return true;
        }
        return false;
    }

    public static boolean isRun() {
        if (RedisTool.SPRING_REDIS_RUN == "true") {
            return true;
        }
        return false;
    }


    private boolean listFlush() {
        if (RedisTool.SPRING_REDIS_LIST_FLUSH == "true") {
            return true;
        }
        return false;
    }

    /**
     * 添加一个元素, zset
     *
     * @param key
     * @param value
     * @param score
     */
    public boolean zSet(String key, Object value, double score) {
        if (!run()) {
            return false;
        }
        boolean result = false;
        try {
            ZSetOperations<Serializable, Object> operations = redisTemplate.opsForZSet();
            operations.add(key, value, score);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            logger.error("RedisUtils zSet:" + RUN_MESSAGE + e.getMessage(), RUN_MESSAGE + e.getMessage());
        }
        return result;
    }
    /**
     * 添加一个元素, zset 并设定过期时间（单位/秒）
     *
     * @param key
     * @param value
     * @param score
     */
    public boolean zSet(String key, Object value, double score,Long expireTime) {
        if (!run()) {
            return false;
        }
        boolean result = false;
        try {
            ZSetOperations<Serializable, Object> operations = redisTemplate.opsForZSet();
            operations.add(key, value, score);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            logger.error("RedisUtils zSet:" + RUN_MESSAGE + e.getMessage(), RUN_MESSAGE + e.getMessage());
        }
        return result;
    }
    /**
     * 查询集合中指定顺序的值和score，0, -1 表示获取全部的集合内容
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<ZSetOperations.TypedTuple<Object>> rangeWithScore(String key, long start, long end) {
        return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
    }

    /**
     * 返回集合的长度
     *
     * @param key
     * @return
     */
    public Long size(String key) {
        return redisTemplate.opsForZSet().zCard(key);
    }

    /**
     * 根据索引值移除区间元素
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public long removeRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().removeRange(key, start, end);
    }

    /**
     * 保留top
     *
     * @param key
     * @param top
     * @return
     */
    public long topRange(String key, long top) {
        long size = this.size(key);
        if (size <= top) {
            return 0;
        }
        return redisTemplate.opsForZSet().removeRange(key, top, size);
    }

    public List<?> buildZSetToBiz(Set<ZSetOperations.TypedTuple<Object>> zSet) {
        List<Object> list = new ArrayList<>(zSet.size());
        for (ZSetOperations.TypedTuple<Object> sub : zSet) {
            list.add(sub.getValue());
        }
        return list;
    }
}