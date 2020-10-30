package com.lsb.test.entity;

import java.io.IOException;
import java.io.PipedInputStream;

//发送字符串
public class Receiver extends Thread{
	
	private static PipedInputStream in=new PipedInputStream();
	
	public static PipedInputStream getin(){
		return in;
	}
	public void run(){
		
		byte[] buff=new byte[1024];
		try {
			int len=in.read(buff);//从输入流中读取内容到缓冲区中
			System.out.println("the follwing stirng come from the sender:\n"+
					new String(buff,0,len));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

