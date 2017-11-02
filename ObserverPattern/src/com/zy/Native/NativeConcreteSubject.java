package com.zy.Native;

import java.util.Observable;

/**
 * 目标的具体实现类
 * 
 * @author Zhou
 *
 */
public class NativeConcreteSubject extends Observable {

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;

		// 天气情况变更, 通知所有的观察者

		// 注意: 在通知之前, 用Java中的Observer模式时, 必须写
		this.setChanged();

		// 通知, 推模型
		this.notifyObservers(content);

		// 通知, 拉模型//传递的是当前Subject
		// this.notifyObservers();
	}

}
