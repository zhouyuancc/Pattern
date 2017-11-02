package com.zy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public interface MyInvocationHandler extends InvocationHandler {
	
	public void invoke(Object o, Method m);

}
