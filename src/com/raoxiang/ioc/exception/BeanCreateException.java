package com.raoxiang.ioc.exception;

/**
 * <p> Description:  </p>
 * <p> Copyright: Copyright (c) 2016 </p>
 * <p> Create Date: 2016-3-21 </p>
 * <p> Company: CITIC BANK </p>
 * @author raoxiang
 * @version $Id: BeanCreateException.java v 1.0 2016-3-21 下午02:34:18 raoxiang Exp $
 */
public class BeanCreateException extends IoCException {

	/** serialVersionUID*/
	private static final long serialVersionUID = 5865807099850218785L;

	public BeanCreateException(){
		super();
	}
	
	public BeanCreateException(String message){
		super(message);
	}
	
	public BeanCreateException(String message, Throwable cause){
		super(message, cause);
	}
}
