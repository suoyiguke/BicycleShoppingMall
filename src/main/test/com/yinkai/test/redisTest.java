package com.yinkai.test;

import com.yinkai.utils.jedis.JedisClient;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author ceshi
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/2017:49
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springmvc-redis.xml"})
public class redisTest {

    @Resource
    private JedisClient jedisClient;

    @org.junit.Test
    public void test()  {
        System.out.println(jedisClient);
        jedisClient.set("name","尹凯");
        String name = jedisClient.get("name");
        System.out.println("name====>"+name);


    }
}
