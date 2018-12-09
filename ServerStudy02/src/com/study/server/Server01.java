package com.study.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：使用ServerSocket建立与浏览器的连接，获取请求协议
 * @author Administrator
 *
 */
public class Server01 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		Server01 server=new Server01();
		server.start();
	}
	//启动服务
	public void start(){
		try {
			serverSocket=new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			System.out.println("服务器启动失败");
		}
	}
	//接受连接处理
	public void receive(){
		try {
			Socket client=serverSocket.accept();
			System.out.println("一个客户端建立了连接...");
			//获取请求协议
			InputStream is=client.getInputStream();
			byte[] datas=new byte[1024*1024];
			int len=is.read(datas);
			String requestInfo=new String(datas,0,len);
			System.out.println(requestInfo);
 		} catch (IOException e) {
			System.out.println("客户端错误");
		}
	}
	//停止服务
	public void stop(){
		
	}
}
