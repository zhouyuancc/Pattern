package com.zy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理
 * 
 * 事务处理器: InvocationHandler
 * @author Zhou
 *
 */
public class TimeHandler implements InvocationHandler {

	private Object target;
	
	public TimeHandler(Object target) {
		// TODO Auto-generated constructor stub
		
		super();
		this.target = target;
	}
	
	/**
	 * Object proxy : 被代理对象
	 * Method method : 被代理对象的方法
	 * Object[] args : 方法的参数
	 * 
	 * return Object 
	 * 
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		long startTime = System.currentTimeMillis();
		System.out.println("start TimeHandler invoke");
		
		method.invoke(target);
		
		long endTime = System.currentTimeMillis();
		System.out.println("end TimeHandler invoke");
		System.out.println("TimeHandler invoke " + (endTime - startTime) + " 毫秒");
		
		return null;
	}

}
