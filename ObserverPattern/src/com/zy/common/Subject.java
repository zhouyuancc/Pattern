package com.zy.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * 处理update传递的参数, 分为推拉模型
    推模型: 目标对象知道观察者需要的数据 (推送具体某个数据)
    拉模型: 目标对象不知道观察者需要的数据, 传递目标对象本身 (传递目标Subject的全部数据，观察者按需取)
 */
/**
 * 被监听者 继承 该类
 * 
 * 目标类: 目标对象,
 * 它知道观察它的观察者, 
 * 并提供注册(添加)和删除观察者的接口
 * 
 * @author Zhou
 *
 */
public class Subject {

	//用来保存注册的观察着对象
	private List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * 添加观察者
	 * @param observer
	 */
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	/**
	 * 删除集合中的指定观察者
	 * @param observer
	 */
	public void detach(Observer observer) {
		observers.remove(observer);
	}
	
	/**
	 * 向所有观察者发送通知
	 * 通知所有注册的观察者对象
	 */
	protected void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
	
}
