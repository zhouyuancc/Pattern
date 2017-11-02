package com.zy.jdkProxy;

import java.lang.reflect.Method;

public class MyTimeHandler implements MyInvocationHandler {

	private Object target;
	
	public MyTimeHandler(Object target) {
		// TODO Auto-generated constructor stub
		
		super();
		this.target = target;
	}
	
	@Override
	public void invoke(Object o, Method m) {
		
		try {
			
			long starttime = System.currentTimeMillis();
			System.out.println("MyTimeHandler start");
			
			m.invoke(target);
			
			long endtime = System.currentTimeMillis();
			System.out.println("during " + (endtime - starttime) + " time");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}


}
