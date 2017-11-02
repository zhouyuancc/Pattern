package com.zy.scene;

import java.util.ArrayList;
import java.util.List;

public abstract class WeatherSubject {

	//用来保存注册的观察着对象
		protected List<WeatherObserver> observers = new ArrayList<WeatherObserver>();
		
		/**
		 * 添加观察者
		 * @param observer
		 */
		public void attach(WeatherObserver observer) {
			observers.add(observer);
		}
		
		/**
		 * 删除集合中的指定观察者
		 * @param observer
		 */
		public void detach(WeatherObserver observer) {
			observers.remove(observer);
		}
		
		/**
		 * 向所有观察者发送通知
		 * 通知所有注册的观察者对象
		 */
		protected abstract void notifyObservers();
	
}
