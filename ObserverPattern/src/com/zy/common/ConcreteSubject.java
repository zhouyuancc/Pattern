package com.zy.common;

import java.util.HashMap;

/**
 * 被监听者
 * 
 * 具体的目标对象, 负责把有关状态存入到相应的观察者对象中
 * 
 * @author Zhou
 *
 */
public class ConcreteSubject extends Subject {
	
	//目标对象的状态
	private HashMap<String, String> concreteSubjectDic;

	public HashMap<String, String> getConcreteSubjectDic() {
		return concreteSubjectDic;
	}

	public void setConcreteSubjectDic(HashMap<String, String> concreteSubjectDic) {
		this.concreteSubjectDic = concreteSubjectDic;
		
		//状态改变, 则通知每个观察者
		this.notifyObservers();
	}
	
}
