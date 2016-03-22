package com.raoxiang.ioc.xml;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.raoxiang.ioc.exception.IoCDocumentException;

/**
* @Title XmlDocumentHolder
* @Description 
* @Copyright Copyright (c) 2015
* @Company com.citic.bank
* @author raoxiang
* @date Mar 11, 2016 10:22:46 PM
* @version 1.0
*/
public class XmlDocumentHolder implements DocumentHolder {

    //新建一个Map对象,用于保存读取到的多分XML文件
	private Map<String, Document> docs = new HashMap<String, Document>();

	/*
	 * 
	* @Title getDocument
	* @Description: 根据文件的路径返回文档对象 
	* @param filePath
	* @return 
	* @see com.raoxiang.ioc.DocumentHolder#getDocument(java.lang.String)
	 */
	@Override
	public Document getDocument(String filePath) {
        Document doc = this.docs.get(filePath);
        if(doc == null){
            this.docs.put(filePath, readDocument(filePath));
        }
		return  this.docs.get(filePath);
	}
	
	/**
	 * 
	* @Title readDocument
	* @Description 根据文件路径读取Document  
	* @param filePath
	* @return
	 * @throws DocumentException 
	 */
    private Document readDocument(String filePath){
        try{
            //使用SAXReader 来读取xml文件
            SAXReader reader = new SAXReader(true);
//            使用自己的EntityResolver
            reader.setEntityResolver(new IoCEntityResolver());
            File xmlFile = new File(filePath);
            //副去文件并返回Document对象
            Document doc = reader.read(xmlFile);
            return doc;
        } catch(Exception e){
            e.printStackTrace();
            throw new IoCDocumentException(e.getMessage());
        }
    }

}
