package com.raoxiang.ioc.xml;

import org.dom4j.Document;

/**
* @Title DocumentHolder
* @Description 
* @Copyright Copyright (c) 2015
* @Company com.citic.bank
* @author raoxiang
* @date Mar 11, 2016 10:17:55 PM
* @version 1.0
*/
public interface DocumentHolder {

    //根据文件的路径返回文档对象
    Document getDocument(String filePath);
}
