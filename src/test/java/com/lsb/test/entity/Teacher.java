package com.lsb.test.entity;

import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONStreamAware;

import java.io.IOException;

public class Teacher implements JSONStreamAware {
    //姓名
    private String name;
    //年龄
    private String age;
    //住址
    private String address;

    private static final String PRE = "\"LSB-";

    private static final String POST = "\"";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", address=" + address + "]";
    }

    @Override
    public void writeJSONString(Appendable out) throws IOException {
        System.out.println("ok");
    }
}