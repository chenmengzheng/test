package com.test.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *<pre>
 * 简单的http服务器
 *</pre>
 * @author chen mengzheng
 * @version 创建时间：2017年4月11日 上午11:35:12
 */
public class HttpServer {
	
	 public static void main(String[] args) {
	        try {
	            @SuppressWarnings("resource")
				ServerSocket ss=new ServerSocket(8888);
	            
                System.out.println("服务已启动,端口8888...");

	            while(true){
	                Socket socket=ss.accept();
	                BufferedReader bd=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	                
	                //接受HTTP请求
	                String requestHeader = "";
	                String name = "";
	                while((requestHeader=bd.readLine())!=null&&!requestHeader.isEmpty()){
//	                    System.out.println(requestHeader);
	                    
	                    /**
	                     * 获得GET参数
	                     */
	                    if(requestHeader.startsWith("GET")){
	                        int begin = requestHeader.indexOf("/?name=")+7;
	                        int end = requestHeader.indexOf("HTTP/");
	                        name=requestHeader.substring(begin, end);
	                    }
	                }
	                
	                //返回
	                PrintWriter pw=new PrintWriter(socket.getOutputStream());
	                
	                pw.println("HTTP/1.1 200 OK");
	                pw.println("Content-type:text/html");
	                pw.println();
	                pw.println("<h2>Hello " +name+"</h2>");
	                
	                pw.flush();
	                socket.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

}
