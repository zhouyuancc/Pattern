package com.zy.weather;

import java.util.HashMap;

import com.zy.Native.NativeConcreteObserver;
import com.zy.Native.NativeConcreteSubject;
import com.zy.common.ConcreteObserver;
import com.zy.common.ConcreteSubject;
import com.zy.scene.WeatherConcreteSubject;
import com.zy.scene.WeatherConcreteObserver;

/**
 * 观察者模式
 * 处理update传递的参数, 分为推拉模型
    推模型: 目标对象知道观察者需要的数据 (推送具体某个数据)
    拉模型: 目标对象不知道观察者需要的数据 (传递目标Subject的全部数据，观察者按需取)
 * 
 * @author Zhou
 *
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 场景方法
		sceneMethod();
		
		// 原生方法
//		nativeMethod();
		
		// 自定义方法
//		customMethod();
	}
	
	/**
	 * 	场景方法
	 * 
	 * 下雨 下雪 通知 girl
	 * 下雨 通知 boy
	 */
	public static void sceneMethod() {
		
		// 1.创建目标
		WeatherConcreteSubject weatherConcreteSubject = new WeatherConcreteSubject();
		
		// 2.创建2个观察者
		WeatherConcreteObserver girl = new WeatherConcreteObserver();
		girl.setObserverName("girl");
		girl.setRemindThing("下雨 or 下雪");
		
		WeatherConcreteObserver boy = new WeatherConcreteObserver();
		boy.setObserverName("boy");
		boy.setRemindThing("下雨");
		
		// 3.注册观察者
		weatherConcreteSubject.attach(girl);
		weatherConcreteSubject.attach(boy);

		// 4.目标发布天气, 通知观察者
		weatherConcreteSubject.setWeatherContent("下雪");
//		girl 收到了 下雪 , 提醒 下雨 or 下雪
		
		weatherConcreteSubject.setWeatherContent("下雨");
//		girl 收到了 下雨 , 提醒 下雨 or 下雪
//		boy 收到了 下雨 , 提醒 下雨
		
	}
	
	/**
	 * 原生方法
	 */
	public static void nativeMethod() {
		// 1.创建天气作为目标
		NativeConcreteSubject subject = new NativeConcreteSubject();
		
		// 2.创建2个观察者
		NativeConcreteObserver girl = new NativeConcreteObserver();
		girl.setObserverName("girl");

		NativeConcreteObserver boy = new NativeConcreteObserver();
		boy.setObserverName("boy");
		
		// 3.注册观察者
		subject.addObserver(girl);
		subject.addObserver(boy);

		// 4.目标更新了内容
		subject.setContent("update");
		/**
		  boy收到信息, 目标推过来的是 update
		  boy收到信息, 主动到目标对象中去拉, 拉的内容是 update
		  girl收到信息, 目标推过来的是 update
		  girl收到信息, 主动到目标对象中去拉, 拉的内容是 update
		 */
	}
	
	/**
	 * 自定义方法
	 */
	public static void customMethod() {
		// 1.创建目标/被监听者
		ConcreteSubject weatherConcreteSubject = new ConcreteSubject();

		// 2.观察者/监听者
		// 2.1.创建观察者/监听者
		ConcreteObserver observerGirl = new ConcreteObserver();
		HashMap<String, String> girl = myMap("girl", "公园");
		observerGirl.setObserverDic(girl);

		ConcreteObserver observerBoy = new ConcreteObserver();
		HashMap<String, String> boy = myMap("boy", "球场");
		observerBoy.setObserverDic(boy);

		// 2.2.目标/被监听者-注册/添加-观察者/监听者
		weatherConcreteSubject.attach(observerGirl);
		weatherConcreteSubject.attach(observerBoy);

		// 3.目标/被监听者发布天气
		HashMap<String, String> weatherDic = myMap("weather", "good");
		weatherConcreteSubject.setConcreteSubjectDic(weatherDic);
		/**
		 监听者set-weatherDic {location=公园, observerName=girl}
		 被监听者发布的天气-update-weatherDic {location=good, observerName=weather}
		 监听者set-weatherDic {location=球场, observerName=boy}
		 被监听者发布的天气-update-weatherDic {location=good, observerName=weather}
		 */
	}

	public static HashMap<String, String> myMap(String observerName, String location) {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("observerName", observerName);
		map.put("location", location);

		return map;
	}

}
