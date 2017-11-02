package com.zy.common;

import java.util.HashMap;

import com.zy.common.ConcreteSubject;

/**
 * 监听者/观察者
 * 
 * 具体的观察者对象, 实现更新的方法, 是自身的状态和目标的状态保持一致
 * 
 * @author Zhou
 *
 */
public class ConcreteObserver implements Observer {

	// // 观察者的状态
	// private String observerState;

	/**
	 * 获取 目标类的状态 同步到 观察者的状态中
	 */
	// @Override
	// public void update(Subject subject) {
	// // TODO Auto-generated method stub
	//
	// observerState = ((ConcreteSubject) subject).getSubjectState();
	//
	// }
	////////////////////////////////////////////////////////////////////////

	// 观察者的状态
	private HashMap<String, String> observerDic;

	// get
	public HashMap<String, String> getObserverDic() {
		return observerDic;
	}

	// set
	public void setObserverDic(HashMap<String, String> observerDic) {
		this.observerDic = observerDic;
	}

	/**
	 * 获取 目标类的状态 同步到 观察者的状态中
	 */
	@Override
	public void update(Subject subject) {
		// TODO Auto-generated method stub

		System.out.println("监听者set-weatherDic " + observerDic);

		// 监听到发布的天气
		observerDic = ((ConcreteSubject) subject).getConcreteSubjectDic();

		System.out.println("被监听者发布的天气-update-weatherDic " + observerDic);
	}

}
