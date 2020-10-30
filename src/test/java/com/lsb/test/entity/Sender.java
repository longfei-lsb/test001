package com.lsb.test.entity;

import java.io.IOException;
import java.io.PipedOutputStream;

//发送字符串
public class Sender extends Thread {

    private static PipedOutputStream out = new PipedOutputStream();

    public static PipedOutputStream getout() {
        return out;
    }

    public void run() {
        String str = "hello receiver";
        byte[] buff = new byte[1024];
        buff = str.getBytes();
        try {
            out.write(buff);//将字节数组中的内容写入到输出流中
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}