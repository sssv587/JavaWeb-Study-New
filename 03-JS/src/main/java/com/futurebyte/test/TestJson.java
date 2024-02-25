package com.futurebyte.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.futurebyte.pojo.Dog;
import com.futurebyte.pojo.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/2/25 - 23:08
 * @Description
 */
public class TestJson {
    @Test
    public void testWriteJson() throws JsonProcessingException {
        // 实例化 Person 对象，将Person对象转换为JSON串
        Dog dog = new Dog("小黄");
        Person person = new Person("张三", 10, dog);
        // 将Person对象转换成一个字符串 Gson Jackson Fastjson

        ObjectMapper objectMapper = new ObjectMapper();
        String personStr = objectMapper.writeValueAsString(person);
        System.out.println(personStr);
    }

    @Test
    public void testReadJson() throws JsonProcessingException {
        String personStr = "{\"name\":\"张三\",\"age\":10,\"dog\":{\"name\":\"小黄\"}}";
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(personStr, Person.class);
        System.out.println(person);
    }

    // map
    @Test
    public void testMapToJson() throws JsonProcessingException {
        Map data = new HashMap();
        data.put("a", "valuea");
        data.put("b", "valueb");

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(data);
        System.out.println(s);
    }

    // list array
    @Test
    public void testListToJson() throws JsonProcessingException {
//        List data = new ArrayList();
//        data.add("a");
//        data.add("b");
//        data.add("c");

//        String[] data = {"a", "b", "c"};

        Dog dog = new Dog("小黄");
        Person person = new Person("张三", 10, dog);
        List data = new ArrayList();
        data.add(person);

        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(data);
        System.out.println(s);
    }
}
