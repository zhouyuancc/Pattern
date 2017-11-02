package com.zy.scene;

public class WeatherConcreteObserver implements WeatherObserver {

	//观察者的名称
	private String observerName;
	
	//天气情况
	private String weatherContent;
	
	//提醒的内容
	private String remindThing;
	
	@Override
	public void update(WeatherSubject subject) {
		// TODO Auto-generated method stub
		
		// 天气情况
		weatherContent = ((WeatherConcreteSubject)subject).getWeatherContent();
		
		System.out.println(observerName + " 收到了 "+weatherContent+" , 提醒 "+remindThing);
		
	}

	@Override
	public void setObserverName(String observerName) {
		// TODO Auto-generated method stub
		this.observerName = observerName;
	}

	@Override
	public String getObserverName() {
		// TODO Auto-generated method stub
		return observerName;
	}

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
	}

	public String getRemindThing() {
		return remindThing;
	}

	public void setRemindThing(String remindThing) {
		this.remindThing = remindThing;
	}

}
