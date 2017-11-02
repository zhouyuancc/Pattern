package com.zy.scene;


public interface WeatherObserver {
	
	public void update(WeatherSubject subject);

	// set观察者名称
	public void setObserverName(String observerName);
	
	// get观察者名称
	public String getObserverName();
}
