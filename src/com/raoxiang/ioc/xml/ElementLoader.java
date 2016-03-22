package com.raoxiang.ioc.xml;

import java.util.Collection;

import org.dom4j.Document;
import org.dom4j.Element;

/**
* @Title ElementLoader
* @Description 
* @Copyright Copyright (c) 2015
* @Company com.citic.bank
* @author raoxiang
* @date Mar 13, 2016 12:02:29 AM
* @version 1.0
*/
public interface ElementLoader {
	//加入一份Doc的所有Element
	void addElements(Document doc);
	//根据元素id获取Element对象
    Element getElement(String id);
    //返回全部的Element
    Collection<Element> getElements();
}
