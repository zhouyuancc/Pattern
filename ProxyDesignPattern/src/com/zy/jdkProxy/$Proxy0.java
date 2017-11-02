package com.zy.jdkProxy;
import java.lang.reflect.Method;
import com.zy.jdkProxy.MyInvocationHandler;

public class $Proxy0 implements com.zy.proxy.Moveable {

	public $Proxy0(MyInvocationHandler h) {
		super();
		this.h = h;
	}

  private MyInvocationHandler h; 

	@Override
  public void move() {
 		 try{
  			 Method md = com.zy.proxy.Moveable.class.getMethod("move");
  			 h.invoke(this,md);
   	 }catch(Exception e){ 
			 e.printStackTrace();
		 }
	}
}