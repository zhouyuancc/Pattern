package com.zy.scene;

public class WeatherConcreteSubject extends WeatherSubject {

	// 晴天 下雨 下雪
	// 目标对象的状态
	private String weatherContent;

	@Override
	protected void notifyObservers() {
		// TODO Auto-generated method stub

		// 循环所有注册的观察者
		for (WeatherObserver observer : observers) {

			// girl 下雨 下雪
			// boy 下雨
			if ("下雨".equals(this.getWeatherContent())) {
				if ("girl".equals(observer.getObserverName())) {
					observer.update(this);
				}
				if ("boy".equals(observer.getObserverName())) {
					observer.update(this);
				}
			} else if ("下雪".equals(this.getWeatherContent())) {
				if ("girl".equals(observer.getObserverName())) {
					observer.update(this);
				}
			}

		}
	}

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;

		this.notifyObservers();
	}

}
