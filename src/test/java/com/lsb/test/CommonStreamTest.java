package com.lsb.test;

import com.lsb.test.entity.Receiver;
import com.lsb.test.entity.Sender;
import org.junit.Test;

import java.io.*;

public class CommonStreamTest {
    /**
     * pipe的管道成对儿连接
     * 连接方式：
     * 构造函数传入
     * 调用connect(pipeStream)
     * <p>
     * ps:  请记得，两个相关联的管道流时，务必将它们分配给不同的线程。
     * read()方法和write()方法调用时会导致流阻塞，这意味着如果你尝试在一个线程中同时进行读和写，可能会导致线程死锁。
     *
     * @throws IOException
     */
    @Test
    public void testPipeStream() throws IOException {
        PipedInputStream input = Receiver.getin();
        PipedOutputStream output = Sender.getout();

        input.connect(output);//管道相连接，也可以反过来使用；
        Sender sender = new Sender();
        Receiver receiver = new Receiver();

        sender.start();
        receiver.start();
        System.out.println(input.available());// 获取流的大小
    }

    /**
     * write() and append()
     * 1、append参数可以为null，为null时，以null的文本形式写入文件中
     * 2、write没有返回值
     *
     * @throws IOException
     */
    @Test
    public void testFileWriter() throws IOException {

        FileWriter fw = new FileWriter("/Users/edz/workspace/test001.txt", true);
        fw.write("--：使用append()后的效果\n");
        fw.append("--：使用append()后的效果\n").append(null); // 当缓冲区输出时，需要刷新出去。
        fw.close();
        FileReader fr = new FileReader("/Users/edz/workspace/test001.txt");
        int ch;
        StringBuilder stringBuilder = new StringBuilder();
        /*
        ·法一：
         */

//        while ((ch = fr.read()) != -1) { // 一次只读取一个字符，自动往下读，-1时表明读完
//            stringBuilder.append((char) ch);
//        }
        /*
         ·法二：
         */
        char[] chars = new char[123];
        while ((ch = fr.read(chars)) != -1) {
            stringBuilder.append(new String(chars, 0, ch));
        }
        System.out.println("stringBuilder :" + stringBuilder.toString());
        fr.close();
    }

    /**
     * BufferedWriter (Writer out) 使用默认大小
     * BufferedWriter (Writer out, int sz) 使用给定大小的输出缓冲区
     */
    @Test
    public void testBufferedWriter() throws IOException {
        //创建一个字符写入流对象。
        FileWriter fw = new FileWriter("/Users/edz/workspace/test002.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        FileReader fileReader = new FileReader("/Users/edz/workspace/test002.txt");
        BufferedReader br = new BufferedReader(fileReader);

        char[] c = {'a', 'b', 'c', 'd', 'e'};
        bw.write(c, 0, 4);// 起始位置 偏移量

        //换行
        bw.newLine();
        //再次写入
        bw.write(c, 2, 2);// 起始位置 偏移量
        //刷新流
        bw.flush();
        /*
            获取数据，法一：（与文本中数据一致）
        */
//        br.lines().forEach(line ->{
//            System.out.println(new String(line.getBytes()));
//        });
         /*
            获取数据，法二：（一行输出）
        */
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        while ((temp = br.readLine()) != null) {
            stringBuilder.append(temp);
        }

        System.out.println(stringBuilder);
        br.close();
        bw.close();
    }

}