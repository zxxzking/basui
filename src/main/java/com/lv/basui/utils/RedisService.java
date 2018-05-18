package com.lv.basui.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


// @Controller
public class RedisService {

    private int c = 1;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;



    // @RequestMapping(value = "/redis/{key}/{value}",method = RequestMethod.GET)
    // @ResponseBody
    public String redisTest(@PathVariable String key, @PathVariable String value) {
        String redisValue = stringRedisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(redisValue)) {
            stringRedisTemplate.opsForValue().set(key,value);
            return "操作成功！";
        }

        if (!redisValue.equals(value)) {
            stringRedisTemplate.opsForValue().set(key,value);
            return "操作成功！";
        }

        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);

        // lambda表达式不能修改外部变量或final修饰的变量
        numbers.forEach(number->{
            c=2;
            test();
        });

        return String.format("redis中已存在[key=%s,value=%s]的数据！",key,value);
    }


    public void test(){


    }

    public static void main(String[] args) {
        int x = 1;

        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);

        // lambda表达式不能修改外部变量或final修饰的变量
        numbers.forEach(number->{
            // c=2;
        });
        // ThreadLocal

        int i = 1;
        int len = 1;
        int index = 1;
        while (true){
            System.out.print(i);
            i++;
            len++;
            if((len-1) % 5 == 0){
                index+=1;
                i = index;
                System.out.println();
            }
            if(len > 25){
                break;
            }
        }

    }

}
