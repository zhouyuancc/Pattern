package com.zy.Native;

import java.util.Observable;
import java.util.Observer;

/**
 * 具体的观察者对象
 * @author Zhou
 *
 */
public class NativeConcreteObserver implements Observer {

	/**
	 * Observable o : 拉模型, 传递Subject
	 * Object arg : 推模型, 传递需要的参数
	 * 两者只能用一个
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

		//推的方式获取
		System.out.println(observerName+"收到信息, 目标推过来的是 "+arg);
		//拉的方式获取
		System.out.println(observerName+"收到信息, 主动到目标对象中去拉, 拉的内容是 "+((NativeConcreteSubject)o).getContent());
		
	}

	//观察者名称的变量
	private String observerName;
	
	public String getObserverName() {
		return observerName;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

}
