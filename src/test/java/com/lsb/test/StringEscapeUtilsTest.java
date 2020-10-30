package com.lsb.test;

import org.apache.commons.lang.StringEscapeUtils;
import org.junit.Test;

public class StringEscapeUtilsTest {
    @Test
    public void run() {
        String str = "this is a test 这是一个测试";
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                + "<persons>\n" + " <person id=\"23\">\n"
                + " <name>张 三</name>\n" + " <age>26</age>\n" + "</person>\n"
                + " <person id=\"22\">\n" + " <name>李四</name>\n"
                + " <age>25</age>\n" + " </person>\n" + "</persons>";
        System.out.println("-----------------------------unicode编码------------------------------------");
        System.out.println("escapeJava转义成Unicode编码 : " + StringEscapeUtils.escapeJava(str));
        System.out.println("escapeJavaScript转义js脚本 : " + StringEscapeUtils.escapeJavaScript(str));
        System.out.println();
        System.out.println("-----------------------------unicode编码(非unicode码则文字不变)------------------------------------");
        System.out.println("unescapeJava反转义成Unicode编码 : " + StringEscapeUtils.unescapeJava(str));
        System.out.println("unescapeJavaScript反转义js脚本 : " + StringEscapeUtils.unescapeJavaScript(StringEscapeUtils.unescapeJavaScript(str)));
        System.out.println();
        System.out.println("-----------------------------html编码------------------------------------");
        System.out.println("escapeHtml转义html脚本 : " + StringEscapeUtils.escapeHtml(str));
        System.out.println();
        System.out.println("-----------------------------html编码(非html码则文字不变)------------------------------------");
        System.out.println("unescapeHtml反转义html脚本 : " + StringEscapeUtils.unescapeHtml(str));
        System.out.println();
        System.out.println("-----------------------------xml编码------------------------------------");
        System.out.println("用escapeXml转义xml脚本 : " + StringEscapeUtils.escapeXml(xml));
        System.out.println();
        System.out.println("-----------------------------xml编码(非xml码则文字不变)------------------------------------");
        System.out.println("用unescapeXml()😡反转义xml脚本 : " + StringEscapeUtils.unescapeXml(StringEscapeUtils.escapeXml(xml)));
    }
}
