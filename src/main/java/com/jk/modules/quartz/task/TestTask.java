package com.jk.modules.quartz.task;

import org.springframework.stereotype.Component;

/**
 * 测试任务
 *
 */
@Component("testTask")
public class TestTask {

	/**
	 * 测试方法
	 */
	public void test() {
		System.out.println("线程测试的方法：蛮王（5秒真男人）一次测试，测试时间:" + System.currentTimeMillis());
	}
	
}
