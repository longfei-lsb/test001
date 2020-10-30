package com.lsb.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lsb.test.entity.Student;
import com.lsb.test.entity.Teacher;
import org.junit.Test;

import java.io.*;

public class JSONTest {
    @Test
    public void testConvertObject() throws Exception {
        Student stu = new Student();
        stu.setName("JSON");
        stu.setAge("23");
        stu.setAddress("北京市西城区");
        //1、使用JSONObject
        String stu1 = JSONObject.toJSONString(stu);
        System.out.println("strJson:" + stu1);
    }

    @Test
    public void jsonStrToJava() throws Exception {
        String stuStr = "{\"address\":\"北京市西城区\",\"age\":\"23\",\"name\":\"JSON\"}";
        Student student = JSONObject.parseObject(stuStr, Student.class);
        System.out.println(student);
    }
    @Test
    public void jsonStrToBaseType() throws Exception {
        String stuStr = "{\"address\":\"北京市西城区\",\"age\":\"23\",\"name\":\"JSON\"}";
        String url = "\"http://m.pplmc.test.rmxc.tech/preview?id=8759d6840e694dce8b3d88097c5e3447\"";
        Integer integer = 3;
        Integer student = JSONObject.parseObject(String.valueOf(integer), Integer.class);
        System.out.println(student);
        String urlStr = JSONObject.parseObject(url, String.class);
        System.out.println(urlStr);
    }

    /**
     * Bean: 自定义json输出格式
     *
     * 实现JSONAware即可
     */
    @Test
    public void testCustomJSONAware(){
        Student student = new Student();
        student.setAddress("北京市西城区");
        student.setAge("23");
        student.setName("JSONStudent");
        System.out.println(JSONObject.toJSONString(student));
    }
    /**
     * 支持json
     *
     */
    @Test
    public void testCustomJSONOutStream() throws IOException {

    }
}
