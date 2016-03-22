package com.raoxiang.ioc.exception;

/**
* @Title IoCException
* @Description 
* <li>框架本身的异常
* <li>继承runtime异常是为了在编译阶段不用显式处理
* <li>在框架底层对于由于健壮性考虑添加的异常捕获可以直接抛出在上层处理，而同时方法中不用声明抛出
* @Copyright Copyright (c) 2015
* @Company com.citic.bank
* @author raoxiang
* @date Mar 11, 2016 10:51:36 PM
* @version 1.0
*/
public class IoCException extends RuntimeException {

	/** serialVersionUID*/
	private static final long serialVersionUID = -5949351001026901214L;
	
	public IoCException(){
		super();
	}

	public IoCException(String message){
		super(message);
	}
	
	public IoCException(String message, Throwable cause){
		super(message, cause);
	}
}
