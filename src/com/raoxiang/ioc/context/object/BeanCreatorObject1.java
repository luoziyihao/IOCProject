package com.raoxiang.ioc.context.object;

/**
 * <p> Description:  </p>
 * <p> Copyright: Copyright (c) 2016 </p>
 * <p> Create Date: 2016-3-21 </p>
 * <p> Company: CITIC BANK </p>
 * @author raoxiang
 * @version $Id: BeanCreatorObject1.java v 1.0 2016-3-21 下午04:09:24 raoxiang Exp $
 */
public class BeanCreatorObject1 {
	private String name;
	private String value;
	
	/**
	* @Title BeanCreatorObject1
	* @Description 
	* @author raoxiang
	*/
	public BeanCreatorObject1() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	* @Title BeanCreatorObject1
	* @Description
	* @param name
	* @param value 
	* @author raoxiang
	*/
	public  BeanCreatorObject1(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}
