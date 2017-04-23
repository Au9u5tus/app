package com.yuhao.other.listener;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class myHttpSessionListener implements HttpSessionListener{
	private static int  count;
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		count++;
		System.out.println("session被创建了");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		count--;
		System.out.println("session被销毁了");
	}

	public static int getCount() {
		return count;
	}
	
}
