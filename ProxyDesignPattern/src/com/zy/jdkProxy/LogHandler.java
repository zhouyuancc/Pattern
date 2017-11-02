package com.zy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.zy.proxy.Moveable;

public class LogHandler implements InvocationHandler {

	private Object target;
	
	public LogHandler(Moveable target) {
		// TODO Auto-generated constructor stub
		
		super();
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		long startTime = System.currentTimeMillis();
		System.out.println("start LogHandler invoke");
		
		method.invoke(target);
		
		long endTime = System.currentTimeMillis();
		System.out.println("end LogHandler invoke");
		System.out.println("LogHandler invoke " + (endTime - startTime) + " 毫秒");
		
		return null;
	}

}
