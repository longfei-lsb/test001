package com.lsb.test;

import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlTest {
    /**
     * 基础部分
     *
     * @throws MalformedURLException
     */
    @Test
    public void test() throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:20214/mc/synergy/doc/preview/url?corpId=rmxc&docId=100235");
        System.out.println("协议部分：--" + url.getProtocol());
        System.out.println("主机部分：--" + url.getHost());
        System.out.println("端口号部分：--" + url.getPort());
        System.out.println("该协议默认端口：--" + url.getDefaultPort());
        System.out.println("路径部分：--" + url.getPath());
        System.out.println("查询部分：--" + url.getQuery());
        System.out.println("锚点（#后面页面指向路径）--：" + url.getRef());
        System.out.println("文件名部分：--" + url.getFile());
        System.out.println("url授权部分：--" + url.getAuthority());
    }

    /**
     * 基础部分
     *
     * @throws IOException
     */
    @Test
    public void testUrlConnect() throws IOException {
        URL url = new URL("http://127.0.0.1:20214/mc/synergy/doc/preview/url?corpId=rmxc&docId=100235");
        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
        String content = httpURLConnection.getContent().toString();
        System.out.println(content);
    }
}
