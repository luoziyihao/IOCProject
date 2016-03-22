package com.raoxiang.ioc.exception;

/**
* @Title IoCDocumentException
* @Description 
* @Copyright Copyright (c) 2015
* @Company com.citic.bank
* @author raoxiang
* @date Mar 11, 2016 10:59:48 PM
* @version 1.0
*/
public class IoCDocumentException extends IoCException {

	/** serialVersionUID*/
	private static final long serialVersionUID = -5014314380373257423L;
	
	public IoCDocumentException(){
		super();
	}
	
	public IoCDocumentException(String message){
		super(message);
	}
	
	public IoCDocumentException(String message, Throwable cause){
		super(message, cause);
	}

}
