package com.jk.common.utils;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * web工具类
 *
 */
public class WebUtils {
	
	/**
	 * 是否为ajax请求
	 * @param request
	 * @return
	 */
	public static boolean isAjax(HttpServletRequest request){
		//如果是ajax请求响应头会有，x-requested-with
		 if (request.getHeader("x-requested-with") != null    
				 && request.getHeader("x-requested-with")    
				 .equalsIgnoreCase("XMLHttpRequest")) { 
			 return true;
		 }
		 return false;
	}
	
	/**
	 * 页面输出
	 * @param response
	 * @param o
	 */
	public static void write(HttpServletResponse response,Object o){
		try {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println(o.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
