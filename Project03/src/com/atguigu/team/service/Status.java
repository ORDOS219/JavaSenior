package com.atguigu.team.service;

/**
 * 
 * @Description 表示员工的状态
 * @author yangyang Email:ordos219@gmail.com
 * @version
 * @data Oct 31, 20206:02:40 PM
 */

public enum Status{//通过枚举类定义状态
	FREE,BUSY,VOVATION;
}

/*
public class Status {

	private final String NAME;

	private Status(String name) {
		this.NAME = name;
	};

	public static final Status FREE = new Status("FREE");
	public static final Status BUSY = new Status("BUSY");
	public static final Status VOVATION = new Status("VOVATION");

	public String getNAME() {
		return NAME;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return NAME;
	}
}
*/
